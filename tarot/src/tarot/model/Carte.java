/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarot.model;

import tarot.BaseObj;

/**
 *
 * @author stagjava
 */
public class Carte  extends BaseObj {
    // Attributs
    private int rang;
    private int rangCouleur;
    private Double valeur;
    private String couleur;
    private String libelle;
    private String abbr;
    private String image;
    private Boolean estFigure;
    private Boolean estBout;
     
    public Carte () {
        super();
        rang = 0;
        rangCouleur = 0;
        valeur = 0.5;
        libelle = "";
        couleur = "";
        abbr = "";
        image = "";
        estFigure = false;
        estBout = false;
    }

    public Carte (String nom, String couleur) {
        super();
        this.couleur = couleur;
        libelle = nom;
        
        if (couleur.equals("Atout")) {
            initialiserAtout(nom);            
        } else {
            initialiserCouleur(nom, couleur);            
            
        }
    }
    public void init (String nom, String couleur) {
        this.couleur = couleur;
        libelle = nom;
        
        if (couleur.equals("Atout")) {
            initialiserAtout(nom);            
        } else {
            initialiserCouleur(nom, couleur);            
            
        }
    }
    
    public Carte clone () {
        Carte uneCarte = new Carte();
        
        uneCarte.setRang(rang);
        uneCarte.setRangCouleur(rangCouleur);
        uneCarte.setCouleur(couleur);
        uneCarte.setLibelle(libelle);
        uneCarte.setAbbr(abbr);
        uneCarte.setValeur(valeur);
        uneCarte.setEstFigure(estFigure);
        uneCarte.setEstBout(estBout);
        uneCarte.setImage(image);
        
        return uneCarte;
    }


    private void initialiserAtout (String nom) {
    
        switch (nom) {
            case "21":
                rang = 77;
                rangCouleur = 21;
                valeur = 4.5;
                abbr = "A21";
                estFigure = false;
                estBout   = true;
                break;
            case "20":
                rang = 76;
                rangCouleur = 20;
                valeur = 0.5;
                abbr = "A20";
                estFigure = false;
                estBout   = false;
                break;
            case "19":
                rang = 75;
                rangCouleur = 19;
                valeur = 0.5;
                abbr = "A19";
                estFigure = false;
                estBout   = false;
                break;
            case "18":
                rang = 74;
                rangCouleur = 18;
                valeur = 0.5;
                abbr = "A18";
                estFigure = false;
                estBout   = false;
                break;
            case "17":
                rang = 73;
                rangCouleur = 17;
                valeur = 0.5;
                abbr = "A17";
                estFigure = false;
                estBout   = false;
                break;
            case "16":
                rang = 72;
                rangCouleur = 16;
                valeur = 0.5;
                abbr = "A16";
                estFigure = false;
                estBout   = false;
                break;
            case "15":
                rang = 71;
                rangCouleur = 15;
                valeur = 0.5;
                abbr = "A15";
                estFigure = false;
                estBout   = false;
                break;
            case "14":
                rang = 70;
                rangCouleur = 14;
                valeur = 0.5;
                abbr = "A14";
                estFigure = false;
                estBout   = false;
                break;
            case "13":
                rang = 69;
                rangCouleur = 13;
                valeur = 0.5;
                abbr = "A13";
                estFigure = false;
                estBout   = false;
                break;
            case "12":
                rang = 68;
                rangCouleur = 12;
                valeur = 0.5;
                abbr = "A12";
                estFigure = false;
                estBout   = false;
                break;
            case "11":
                rang = 67;
                rangCouleur = 11;
                valeur = 0.5;
                abbr = "A11";
                estFigure = false;
                estBout   = false;
                break;
            case "10":
                rang = 66;
                rangCouleur = 10;
                valeur = 0.5;
                abbr = "A10";
                estFigure = false;
                estBout   = false;
                break;
            case "9":
                rang = 65;
                rangCouleur = 9;
                valeur = 0.5;
                abbr = "A9";
                estFigure = false;
                estBout   = false;
                break;
            case "8":
                rang = 64;
                rangCouleur = 8;
                valeur = 0.5;
                abbr = "A8";
                estFigure = false;
                estBout   = false;
                break;
            case "7":
                rang = 63;
                rangCouleur = 7;
                valeur = 0.5;
                abbr = "A7";
                estFigure = false;
                estBout   = false;
                break;
            case "6":
                rang = 62;
                rangCouleur = 6;
                valeur = 0.5;
                abbr = "A6";
                estFigure = false;
                estBout   = false;
                break;
            case "5":
                rang = 61;
                rangCouleur = 5;
                valeur = 0.5;
                abbr = "A5";
                estFigure = false;
                estBout   = false;
                break;
            case "4":
                rang = 60;
                rangCouleur = 4;
                valeur = 0.5;
                abbr = "A4";
                estFigure = false;
                estBout   = false;
                break;
            case "3":
                rang = 59;
                rangCouleur = 3;
                valeur = 0.5;
                abbr = "A3";
                estFigure = false;
                estBout   = false;
                break;
            case "2":
                rang = 58;
                rangCouleur = 2;
                valeur = 0.5;
                abbr = "A2";
                estFigure = false;
                estBout   = false;
                break;
            case "1":
                rang = 57;
                rangCouleur = 1;
                valeur = 4.5;
                abbr = "A1";
                estFigure = false;
                estBout   = true;
                break;
            case "Excuse":
                rang = 0;
                rangCouleur = 0;
                valeur = 4.5;
                abbr = "EX";
                estFigure = false;
                estBout   = true;
                break;
        }
    }

    private void initialiserCouleur (String nom, String couleur) {
        char abbrCouleur;
        String abbrCarte;
        int debutRang = 0;
        
        if (couleur.equals("Carreau")) {
            abbrCouleur = 'R';
        } else {
            abbrCouleur = couleur.charAt(0);
        }
        
        if (nom.equals("Roi") || nom.equals("Dame") || nom.equals("Cavalier") || nom.equals("Valet")) {
            abbrCarte = nom.substring(0, 2);
        } else {
            abbrCarte = nom;
        }
        abbr = abbrCouleur + abbrCarte;
        
        switch (couleur) {
            case "Pique" : debutRang = 0;
            break;
            case "Trèfle" : debutRang = 14;
            break;
            case "Carreau" : debutRang = 28;
            break;
            case "Coeur" : debutRang = 42;
            break;
        }

        switch (nom) {
            case "1" :
                rangCouleur = 1;
                rang = debutRang + rangCouleur;
                valeur = 0.5;
                estFigure = false;
                estBout   = false;
                break;
            case "2" :
                rangCouleur = 2;
                rang = debutRang + rangCouleur;
                valeur = 0.5;
                estFigure = false;
                estBout   = false;
                break;
            case "3" :
                rangCouleur = 3;
                rang = debutRang + rangCouleur;
                valeur = 0.5;
                estFigure = false;
                estBout   = false;
                break;
            case "4" :
                rangCouleur = 4;
                rang = debutRang + rangCouleur;
                valeur = 0.5;
                estFigure = false;
                estBout   = false;
                break;
            case "5" :
                rangCouleur = 5;
                rang = debutRang + rangCouleur;
                valeur = 0.5;
                estFigure = false;
                estBout   = false;
                break;
            case "6" :
                rangCouleur = 6;
                rang = debutRang + rangCouleur;
                valeur = 0.5;
                estFigure = false;
                estBout   = false;
                break;
            case "7" :
                rangCouleur = 7;
                rang = debutRang + rangCouleur;
                valeur = 0.5;
                estFigure = false;
                estBout   = false;
                break;
            case "8" :
                rangCouleur = 8;
                rang = debutRang + rangCouleur;
                valeur = 0.5;
                estFigure = false;
                estBout   = false;
                break;
            case "9" :
                rangCouleur = 9;
                rang = debutRang + rangCouleur;
                valeur = 0.5;
                estFigure = false;
                estBout   = false;
                break;
            case "10" :
                rangCouleur = 10;
                rang = debutRang + rangCouleur;
                valeur = 0.5;
                estFigure = false;
                estBout   = false;
                break;
            case "Valet" :
                rangCouleur = 11;
                rang = debutRang + rangCouleur;
                valeur = 1.5;
                estFigure = true;
                estBout   = false;
                break;
            case "Cavalier" :
                rangCouleur = 12;
                rang = debutRang + rangCouleur;
                valeur = 2.5;
                estFigure = true;
                estBout   = false;
                break;
            case "Dame" :
                rangCouleur = 13;
                rang = debutRang + rangCouleur;
                valeur = 3.5;
                estFigure = true;
                estBout   = false;
                break;
            case "Roi" :
                rangCouleur = 14;
                rang = debutRang + rangCouleur;
                valeur = 4.5;
                estFigure = true;
                estBout   = false;
                break;
            
        }
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public int getRangCouleur() {
        return rangCouleur;
    }

    public void setRangCouleur(int rangCouleur) {
        this.rangCouleur = rangCouleur;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        if (couleur.equals("Coeur") || couleur.equals("Carreau") 
                || couleur.equals("Pique") || couleur.equals("Trèfle")
                || couleur.equals("Atout")) {
        this.couleur = couleur;            
        } else {
            this.couleur = "erreur";
        }
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getEstFigure() {
        return estFigure;
    }

    public void setEstFigure(Boolean estFigure) {
        this.estFigure = estFigure;
    }

    public Boolean getEstBout() {
        return estBout;
    }

    public void setEstBout(Boolean estBout) {
        this.estBout = estBout;
    }
    
}
