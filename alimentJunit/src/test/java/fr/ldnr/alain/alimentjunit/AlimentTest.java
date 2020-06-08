/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.alain.alimentjunit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author stagjava
 */
public class AlimentTest {
    
    public AlimentTest() {
    }
    
    @Test
    public void testGetEau() {
        Aliment a = new Aliment(60, 11, 5, 12, 6, 13);
        int res = a.getEau();
        assertEquals(60, res);
    }
    @Test
    public void testGetFibres() {
        Aliment a = new Aliment(60, 11, 5, 12, 6, 13);
        int res = a.getFibres();
        assertEquals(11, res);
    }
    public void testGetSel() {
        Aliment a = new Aliment(60, 11, 5, 12, 6, 13);
        int res = a.getSel();
        assertEquals(5, res);
    }
    public void testGetGlucides() {
        Aliment a = new Aliment(60, 11, 5, 12, 6, 13);
        int res = a.getGlucides();
        assertEquals(12, res);
    }
    public void testGetProteines() {
        Aliment a = new Aliment(60, 11, 5, 12, 6, 13);
        int res = a.getProteines();
        assertEquals(6, res);
    }
    public void testGetLipides() {
        Aliment a = new Aliment(60, 11, 5, 12, 6, 13);
        int res = a.getLipides();
        assertEquals(13, res);
    }
        @Test
    public void testConstructorSansParametres() {
        Aliment a = new Aliment();
        assertEquals(0, a.getEau());
        assertEquals(0, a.getFibres());
        assertEquals(0, a.getSel());
        assertEquals(0, a.getGlucides());
        assertEquals(0, a.getProteines());
        assertEquals(0, a.getLipides());
    }
    @Test
    public void testConstructorAvecParametres() {
        Aliment a = new Aliment(60, 11, 5, 12, 6, 13);
        assertEquals(60, a.getEau());
        assertEquals(11, a.getFibres());
        assertEquals(5, a.getSel());
        assertEquals(12, a.getGlucides());
        assertEquals(6, a.getProteines());
        assertEquals(13, a.getLipides());
    }
    @Test
    public void testConstructorAvecTableau() {
        Aliment[] tab = new Aliment[2];
        tab[0] = new Aliment(50, 10, 2, 7, 3, 10);
        tab[1] = new Aliment(10, 1, 3 , 5, 3, 3);
        Aliment a = new Aliment(tab);
        assertEquals(60, a.getEau());
        assertEquals(11, a.getFibres());
        assertEquals(5, a.getSel());
        assertEquals(12, a.getGlucides());
        assertEquals(6, a.getProteines());
        assertEquals(13, a.getLipides());
    }
    @Test
    public void testConstructorAvecListe() {
        Aliment[] tab = new Aliment[2];
        tab[0] = new Aliment(50, 10, 2, 7, 3, 10);
        tab[1] = new Aliment(10, 1, 3 , 5, 3, 3);
        List<Aliment> liste = new ArrayList<>();
        liste.add(tab[0]);
        liste.add(tab[1]);
        Aliment a = new Aliment(liste);
        assertEquals(60, a.getEau());
        assertEquals(5, a.getSel());
        assertEquals(12, a.getGlucides());
        assertEquals(6, a.getProteines());
        assertEquals(13, a.getLipides());
        assertEquals(11, a.getFibres());
    }
    @Test
    public void testSetEau() {
        Aliment a = new Aliment();
        a.setEau(60);
        int res = a.getEau();
        assertEquals(60, res);
    }
    @Test
    public void testSetFibres() {
        Aliment a = new Aliment();
        a.setFibres(11);
        int res = a.getFibres();
        assertEquals(11, res);
    }
    public void testSetSel() {
         Aliment a = new Aliment();
        a.setSel(5);
       int res = a.getSel();
        assertEquals(5, res);
    }
    public void testSetGlucides() {
        Aliment a = new Aliment();
        a.setGlucides(12);
        int res = a.getGlucides();
        assertEquals(12, res);
    }
    public void testSetProteines() {
        Aliment a = new Aliment();
        a.setProteines(6);
        int res = a.getProteines();
        assertEquals(6, res);
    }
    public void testSetLipides() {
        Aliment a = new Aliment();
        a.setLipides(13);
        int res = a.getLipides();
        assertEquals(13, res);
    }
    public void testToString() {
        Aliment a = new Aliment(60, 11, 5, 12, 6, 13);
        String unString = "Aliment{" + "eau=" + 60 + ", fibres=" + 11 + ", sel=" + 5 + ", glucides=" + 12 
                + ", proteines=" + 6 + ", lipides=" + 13 + '}';
        String res = a.toString();
        assertEquals(unString, res);
    }
    public void testGetCalories() {
        Aliment a = new Aliment(5, 3, 1, 17, 19, 55);
        int res = a.getCalories();
        assertEquals(639000, res);
    }
    public void testARJ() {
        Aliment a = new Aliment(5, 3, 1, 17, 19, 55);
        int res = a.getARJ("proteine");
        assertEquals(19, res);
        res = a.getARJ("glucide");
        assertEquals(17, res);
        res = a.getARJ("lipide");
        assertEquals(55, res);
        res = a.getARJ("sel");
        assertEquals(1, res);
        res = a.getARJ("toto");
        assertEquals(-1, res);
    }
    public void testGetMorceaux() {
        Aliment x = new Aliment(12, 12, 4, 16, 20, 60);
        List<Aliment> liste = x.getMorceaux(4);
        Iterator it = liste.iterator();
        Aliment a;
        while (it.hasNext()) {
            a = (Aliment) (it.next());

            assertEquals(3, a.getEau());
            assertEquals(3, a.getFibres());
            assertEquals(1, a.getSel());
            assertEquals(4, a.getGlucides());
            assertEquals(5, a.getProteines());
            assertEquals(15, a.getLipides());
        }
    }

}
