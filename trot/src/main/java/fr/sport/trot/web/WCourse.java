/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.web;

import fr.sport.trot.base.BaseObject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author stagjava
 */
public class WCourse extends BaseObject{
    // Attributes
    private String dateC;
    private LocalDateTime date;
    private String dotationC;
    private int dotation;
    private String type;
    private String chevaux;
    private String age;
    private String distanceC;
    private int distance;
    private String piste;
    private String corde;

    private ArrayList<WCourseRang> rangs;

    public WCourse() {
    }

    @Override
    public String toString() {
        return "WCourse{" + "dateC=" + dateC + ", date=" + date + ", dotationC=" + dotationC + ", dotation=" + dotation + ", type=" + type + ", chevaux=" + chevaux + ", age=" + age + ", distanceC=" + distanceC + ", distance=" + distance + ", piste=" + piste + ", corde=" + corde + '}';
    }

    public String getDateC() {
        return dateC;
    }

    public void setDateC(String dateC) {
        this.dateC = dateC;
        setDate();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setDate() {
        // To do convert string to date
        LocalDateTime uneDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        uneDate = LocalDate.parse(dateC, formatter).atStartOfDay();
        date = uneDate;
    }

    public String getDotationC() {
        return dotationC;
    }

    public void setDotationC(String dotationC) {
        this.dotationC = dotationC;
        setDotation();
    }

    public int getDotation() {
        return dotation;
    }

    public void setDotation(int dotation) {
        this.dotation = dotation;
    }
    public void setDotation() {
        this.dotation = Integer.parseInt(dotationC);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChevaux() {
        return chevaux;
    }

    public void setChevaux(String chevaux) {
    String s = chevaux.replace("'", ":");
    this.chevaux = s;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDistanceC() {
        return distanceC;
    }

    public void setDistanceC(String distanceC) {
        this.distanceC = distanceC;
        setDistance();
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setDistance() {
        this.distance = Integer.parseInt(distanceC);
    }

    public String getPiste() {
        return piste;
    }

    public void setPiste(String piste) {
        String s = piste.replace("'", ":");
        this.piste = s;
    }

    public String getCorde() {
        return corde;
    }

    public void setCorde(String corde) {
        String s = corde.replace("'", ":");        
        this.corde = s;
    }

    public ArrayList<WCourseRang> getRangs() {
        return rangs;
    }

    public void setRangs(ArrayList<WCourseRang> rangs) {
        this.rangs = rangs;
    }
    
}
