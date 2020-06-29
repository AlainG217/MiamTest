/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.web;

import fr.sport.trot.base.BaseObject;
import java.io.*; 
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author stagjava
 */
public class WebPage extends BaseObject {
    // Attributes
    BufferedReader input;
    BufferedWriter output;
    ArrayList<String> lines;
    String urlName;
    URL url;

    Boolean spanFound = false;
    Boolean processingRang = false;
    Boolean processingCheval = false;
    Boolean isComplete = false;
    
    WCourse course;
    WCourseRang rang;
    ArrayList<WCourseRang> rangs;

    public WebPage(String urlName) {
        this.urlName = urlName;
        lines = new ArrayList<>();
        course = new WCourse();
        rang = new WCourseRang();
        rangs = new ArrayList<>();
        try {
            url = new URL(urlName);
            input = new BufferedReader(new InputStreamReader(url.openStream()));
            output = new BufferedWriter(new FileWriter("Download.html"));
            
            String line;
            while ((line = input.readLine()) != null) {
//                System.out.println(line);
                lines.add(line);
                output.write(line + "\n");
            }
            System.out.println("Nombre de lignes " + lines.size());
            input.close();
            output.close();
        }
        // Exceptions 
        catch (MalformedURLException mue) { 
            System.out.println("Malformed URL Exception raised" + mue); 
        } 
        catch (IOException ie) { 
            System.out.println("IOException raised" + ie); 
        }     
    }

    public WebPage() {
        // For test only
        this.urlName = "";
        lines = new ArrayList<>();
        course = new WCourse();
        rang = new WCourseRang();
        rangs = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader("Download.html");
            input = new BufferedReader(fr);
            
            String line;
            while ((line = input.readLine()) != null) {
                lines.add(line);
            }
            System.out.println("Nombre de lignes " + lines.size());
            input.close();
        }
        // Exceptions 
        catch (IOException ie) { 
            System.out.println("IOException raised" + ie); 
        }     
    }
    
    public void analyzePage(String type) {
        
        Iterator<String> it = lines.iterator();
        boolean skip = true;
        String line;
        
        while (it.hasNext()) {
            line = it.next();
            if (line.equals("<div class=\"bloc data inner-bloc programme\">"))
                skip = false;
            
            if (line.equals("<div id=\"programmes\" class=\"hidden-smallDevice\">"))
                skip = true;
            
            if (skip == false)
                analyzeLine(line);
            
            if (isComplete)
                break;
        }

        course.setRangs(rangs);
        
        // Vérif résultats
        System.out.println(course.toString());
        System.out.println("Nombre de rangs " + rangs.size());
        Iterator<WCourseRang> it2 = rangs.iterator();
        while (it2.hasNext()) {
            rang = it2.next();
            System.out.println(rang.toString());
        }
    }
    
    public void analyzeLine(String line) {
        // 1er caractère significatif
        int fp = line.indexOf("<");
        int lp = line.indexOf(">");
        String signifiant = line.substring(fp, lp);
//        System.out.println("analyzeLine " + signifiant);
        
        // Date de la course
        if (signifiant.equals("<div class=\"title title-border hidden-smallDevice\"")) {
            findDateInTittle(line);
        }
        
        // Nom de la course: on trouve d'abord le span. Le titre est sur la ligne suivante
        // Puis la ligne suivante contient les infos de la course
        if (spanFound) {
           if (signifiant.equals("<h3 class=\"hidden-smallDevice\"")) {
                findNom(line);
           }
           
           if (signifiant.equals("<p class=\"fl hidden-smallDevice\"")) {
                getInfoCourse(line);
                spanFound = false;
           }
           
        }
        if (processingRang) {
           if (signifiant.equals("<td")) {
                findRang(line);
           }
           if (signifiant.equals("<td class=\"tc\"")) {
                findDossardOuTemps(line);
           }
           if (processingCheval) {
                findNomCheval(line);
                processingCheval = false;
           }
           if (signifiant.equals("<span class=\"desc\"")) {
               processingCheval = true;
           }
           if (signifiant.equals("<td class=\"tc hidden-smallDevice\"")) {
                findTypeCheval(line);
           }
           if (signifiant.equals("<td class=\"hidden-smallDevice\"")) {
               getOtherRangAttr(line);
               }
            
        }
        if (signifiant.equals("<span class=\"hidden-smallDevice\"")) {
            spanFound = true;
        }
        if (signifiant.equals("</table")) {
            isComplete = true;
        }
        if (signifiant.equals("<tr")) {
            processingRang = true;
        }
                
    }
 
    public void findDateInTittle (String line) {
        String signifiant = findTerm(line, "<h2", "</h2>");        
        String dateC = signifiant.substring(25, 35);
        course.setDateC(dateC);        
    }
    
    public void findNom (String line) {
        String signifiant = findTerm(line, "<h3", "</h3>");        
        int pNom = signifiant.indexOf("</strong>") + 10;
        String nom = signifiant.substring(pNom);
        course.name(nom);        
    }
    public void findNomCheval (String line) {
        String signifiant = findTerm(line, ">", "</strong>");   
        rang.name(signifiant);        
    }
    
    public void findDistance (String line) {
        String signifiant = findTerm(line, ">", "</td>");        
        String[] arr1 = signifiant.split("&nbsp;"); 
        rang.setDistanceC(arr1[0]+arr1[1].substring(0, 3));        
    }
    
    public void findDossardOuTemps (String line) {
        String signifiant = findTerm(line, "\">", "</td>");
        int mnp = signifiant.indexOf("'");
        if (mnp == -1)
            rang.setDossardC(signifiant);
        else
            rang.setTemps(signifiant);
            
    }
    
    public void findRang (String line) {
        String signifiant = findTerm(line, "h\">", "</str");        
        rang.setRangC(signifiant);        
    }

    public void findTypeCheval (String line) {
        String signifiant = findTerm(line, ">", "</td>");
        rang.setType(signifiant);        
    }

    public String findTerm(String line, String deb, String fin) {
        // 1er caractère significatif
//        System.out.println("findTerm " + deb + " " + fin);
//        System.out.println("deb " + line.indexOf(deb));
        int lg = deb.length();
        int fp = line.indexOf(deb) +lg;
        int lp = line.indexOf(fin);
        String signifiant = line.substring(fp, lp);
//        System.out.println(signifiant);
        return signifiant;
        
    }
    public void getInfoCourse (String line) {
        // 1er caractère significatif
        String[] arr1 = line.split(">");
        String[] arr2 = arr1[1].split("-");
        int lp = arr2[0].indexOf("&nbsp");
        
        course.setDotationC(arr2[0].substring(0, lp) + "000");
        course.setType(arr2[1].substring(1));
        course.setChevaux(arr2[2].substring(1));
        course.setAge(arr2[3].substring(1));
        course.setDistanceC(arr2[4].substring(1, 5));
        course.setPiste(arr2[5].substring(1));
        int fc = arr2[6].indexOf("<");
        course.setCorde(arr2[6].substring(1, fc));

        
    }
    
    public void getOtherRangAttr (String line) {
        int fp = line.indexOf(">") +1;
        String signifiant = line.substring(fp);
//        System.out.println("getOtherRangAttr " + line);
//        System.out.println("getOtherRangAttr " + signifiant.substring(0, 1));
        if (signifiant.substring(0, 1).equals("<")) {
            String typePersonne;
            String nomPersonne = "";
            int tfp = line.indexOf("/") +1;
            int nfp = line.indexOf("k\">") + 3;
            int nlp = line.indexOf("</a");
//        System.out.println("getOtherRangAttr tfp" + tfp + " nfp " + nfp + " nlp " + nlp);
            if (nfp == -1 || nlp == -1) {
                typePersonne = "fin";
            } else {
                typePersonne = line.substring(tfp, tfp + 1);
                nomPersonne = line.substring(nfp, nlp);
            }
            switch (typePersonne) {
                case "j" : rang.setJockey(nomPersonne);
                break;
                case "e" : rang.setEntraineur(nomPersonne);
                break;
                case "p" : rang.setProprietaire(nomPersonne);
                break;
                case "fin" : rangs.add(rang.clone());
//                    System.out.println(rang.toString());
                break;
            }
        } else {
            findDistance(line);
        }
        
    }

    public WCourse getCourse() {
        return course;
    }

    public void setCourse(WCourse course) {
        this.course = course;
    }

}
