/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.web;

import fr.sport.trot.base.BaseObject;

/**
 *
 * @author stagjava
 */
public class WCourseRang extends BaseObject {
    // Attributes
    private String rangC;
    private int rang;
    private String dossardC;
    private int dossard;
    private String type;
    private String distanceC;
    private int distance;
    private String temps;
    private String jockey;
    private String entraineur;
    private String proprietaire;

    @Override
    public String toString() {
        return "WCourseRang{" + "name=" + name + ", rangC=" + rangC + ", rang=" + rang + ", dossardC=" + dossardC + ", dossard=" + dossard + ", type=" + type + ", distanceC=" + distanceC + ", distance=" + distance + ", temps=" + temps + ", jockey=" + jockey + ", entraineur=" + entraineur + ", proprietaire=" + proprietaire + '}';
    }

    public WCourseRang clone() {
        WCourseRang unRang = new WCourseRang();
        unRang.name = name;
        unRang.rangC = rangC;
        unRang.rang = rang;
        unRang.dossardC = dossardC;
        unRang.dossard = dossard;
        unRang.type = type;
        unRang.distanceC = distanceC;
        unRang.distance = distance;
        unRang.temps = temps;
        unRang.jockey = jockey;
        unRang.entraineur = entraineur;
        unRang.proprietaire = proprietaire;
        return unRang;
    }
    public String getRangC() {
        return rangC;
    }

    public void setRangC(String rangC) {
        this.rangC = rangC;
        setRang();
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public void setRang() {
        if (rangC.equals("D"))
            rang = 0;
        else 
            this.rang = Integer.parseInt(rangC);
    }

    public String getDossardC() {
        return dossardC;
    }

    public void setDossardC(String dossardC) {
        this.dossardC = dossardC;
        if (!dossardC.equals(""))
            setDossard();
    }

    public int getDossard() {
        return dossard;
    }

    public void setDossard(int dossard) {
        this.dossard = dossard;
    }
    public void setDossard() {
        this.dossard = Integer.parseInt(dossardC);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        String s = temps.replace("'", ":");
        String s1 = s.replace("\"", ":");
        this.temps = s1;
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        String s = jockey.replace("'", ":");
        this.jockey = s;
    }

    public String getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(String entraineur) {
        String s = entraineur.replace("'", ":");
        this.entraineur = s;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        String s = proprietaire.replace("'", ":");
        this.proprietaire = s;
    }
    
}
