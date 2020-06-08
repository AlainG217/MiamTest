/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.alimentjunit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author stagjava
 */
public class Aliment {
    // Attribut
    int eau;
    int fibres;
    int sel;
    int glucides;
    int proteines;
    int lipides;

    public Aliment() {
        this(0,0,0,0,0,0);
    }

    public Aliment(int eau, int fibres, int sel, int glucides, int proteines, int lipides) {
        this.eau = eau;
        this.fibres = fibres;
        this.sel = sel;
        this.glucides = glucides;
        this.proteines = proteines;
        this.lipides = lipides;
    }
    
    public Aliment(Aliment[] aliments) {
        this.eau = aliments[0].eau + aliments[1].eau;
        this.fibres = aliments[0].fibres + aliments[1].fibres;
        this.sel = aliments[0].sel + aliments[1].sel;
        this.glucides = aliments[0].glucides + aliments[1].glucides;
        this.proteines = aliments[0].proteines + aliments[1].proteines;
        this.lipides = aliments[0].lipides + aliments[1].lipides;
    }
    public Aliment(List<Aliment> aliments) {
        Iterator it = aliments.iterator();
        Aliment unAliment;
        while (it.hasNext()) {
            unAliment = (Aliment) (it.next());
            this.eau += unAliment.eau;
            this.fibres += unAliment.fibres;
            this.sel += unAliment.sel;
            this.glucides += unAliment.glucides;
            this.proteines += unAliment.proteines;
            this.lipides += unAliment.lipides;
        }
    }
    
    public int getCalories (){
        int somme = proteines + glucides + lipides + eau + fibres + sel;
        int calories = (((proteines*100)/somme) * 4000) 
                + (((glucides*100)/somme) * 4000) 
                + (((lipides*100)/somme) * 9000);
        return calories;
    }
    public int getARJ (String nut){
        int somme = proteines + glucides + lipides + eau + fibres + sel;
        
        switch (nut) {
            case "proteine" :
                return (proteines*100)/somme;
            case "lipide" :
                return (lipides*100)/somme;
            case "glucide" :
                return (glucides*100)/somme;
            case "sel" :
                return (sel*100)/somme;
            default :
                return -1;
        }
    }
    public List<Aliment> getMorceaux (int nb){
        List<Aliment> liste = new ArrayList<>();

        if (nb > 0) {
            Aliment a =  new Aliment(eau/nb,fibres/nb,sel/nb, glucides/nb, 
                proteines/nb, lipides/nb);
            for (int i=1; i <= nb; i++)
                liste.add(a);
            return liste;
        } else
            return null;
            
    }

    @Override
    public String toString() {
        return "Aliment{" + "eau=" + eau + ", fibres=" + fibres + ", sel=" + sel + ", glucides=" + glucides + ", proteines=" + proteines + ", lipides=" + lipides + '}';
    }

    public int getEau() {
        return eau;
    }

    public void setEau(int eau) {
        this.eau = eau;
    }

    public int getFibres() {
        return fibres;
    }

    public void setFibres(int fibres) {
        this.fibres = fibres;
    }

    public int getSel() {
        return sel;
    }

    public void setSel(int sel) {
        this.sel = sel;
    }

    public int getGlucides() {
        return glucides;
    }

    public void setGlucides(int glucides) {
        this.glucides = glucides;
    }

    public int getProteines() {
        return proteines;
    }

    public void setProteines(int proteines) {
        this.proteines = proteines;
    }

    public int getLipides() {
        return lipides;
    }

    public void setLipides(int lipides) {
        this.lipides = lipides;
    }
    
    
}
