/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarot.model;

import java.util.ArrayList;
import java.util.TreeMap;
import tarot.BaseObj;

/**
 * 
 * @author stagjava
 */
public class Joueur extends BaseObj {
    // Attributs
    private int rang;
    private String nom;
    private int ptsMene;
    private int ptsTotal;
    private Boolean aPris;
    private Boolean estAppele;
    private String[] annonces;
    private TreeMap<Integer, Carte> cartes;
    private ArrayList chien;
    private ArrayList plis;
/**
 * ==========================
 * METHODES
 * ==========================
 */  
/**
 * Constructeur
 * @param rang No de joueur
 *        nom  Nom du joueur
 */
    public Joueur() {
        super();
        cartes = new TreeMap<Integer, Carte>();
        chien = new ArrayList<Carte>();
        plis = new ArrayList<Carte>();
    }
    
    public void Joueur (int rang, String nom) {
        this.rang       = rang;
        this.nom        = nom;
        this.ptsMene    = 0;
        this.ptsTotal   = 0;
        this.aPris      = false;
        this.estAppele  = false;
        
        cartes = new TreeMap<Integer, Carte>();
        chien = new ArrayList<Carte>();
        plis = new ArrayList<Carte>();
    }
    
    public Joueur clone () {
        Joueur unJoueur = new Joueur();
        
        unJoueur.setRang(rang);
        unJoueur.setNom(nom);
        unJoueur.setptsMene(0);
        unJoueur.setptsTotal(0);
        unJoueur.setAPris(false);
        unJoueur.setEstAppele(false);
        
        return unJoueur;
    }

 /**
 * ==========================
 * getters
 * ==========================
 */  
    public int getRang(){
        return this.rang;
    }
    public String getNom(){
        return this.nom;
    }
    public int getptsMene(){
        return this.ptsMene;
    }
    public int getptsTotal(){
        return this.ptsTotal;
    }
    public Boolean getAPris(){
        return this.aPris;
    }
    public Boolean getEstAppele(){
        return this.estAppele;
    }

    public String[] getAnnonces() {
        return annonces;
    }

    public Boolean getaPris() {
        return aPris;
    }

    public int getPtsTotal() {
        return ptsTotal;
    }
 
    public int getPtsMene() {
        return ptsMene;
    }

    public TreeMap<Integer, Carte> getCartes() {
        return cartes;
    }

    public ArrayList getChien() {
        return chien;
    }

    public ArrayList getPlis() {
        return plis;
    }
    
/**
 * ==========================
 * setters
 * ==========================
 */  
    public void setRang(int rang){
        this.rang = rang;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setptsMene(int ptsMene){
        this.ptsMene = ptsMene;
    }
    public void setptsTotal(int ptsTotal){
        this.ptsTotal = ptsTotal;
    }
    public void setAPris(Boolean aPris){
        this.aPris = aPris;
    }
    public void setEstAppele(Boolean estAppele){
        this.estAppele = estAppele;
    }    

    public void setPtsMene(int ptsMene) {
        this.ptsMene = ptsMene;
    }

    public void setPtsTotal(int ptsTotal) {
        this.ptsTotal = ptsTotal;
    }

    public void setaPris(Boolean aPris) {
        this.aPris = aPris;
    }

    public void setAnnonces(String[] annonces) {
        this.annonces = annonces;
    }

    public void setCartes(TreeMap<Integer, Carte> cartes) {
        this.cartes = cartes;
    }

    public void setChien(ArrayList chien) {
        this.chien = chien;
    }

    public void setPlis(ArrayList plis) {
        this.plis = plis;
    }
    
}
