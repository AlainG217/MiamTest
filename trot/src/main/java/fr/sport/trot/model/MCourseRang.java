/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.model;

import fr.sport.trot.error.TrotException;
import fr.sport.trot.web.WCourseRang;
import java.sql.Connection;
import java.util.TreeMap;

/**
 *
 * @author stagjava
 */
public class MCourseRang extends MBase {
    // Attributes
    private int rang;
    private int dossard;
    private String temps;
    private int idCourse;
    private int idCheval;
    private int idJockey;
    
    public MCourseRang(Connection db) throws TrotException {
        super(db, "courseRang");
        buildMapping();
    } 

    public void populateFromWeb(WCourseRang webRang) {
        rang = webRang.getRang();
        dossard = webRang.getDossard();
        temps = webRang.getTemps();
        setObjectState(1);
    } 
    
    @Override
    public MCourseRang clone() {
        try {
            MCourseRang unRang = new MCourseRang(this.getDb());
            unRang.id(this.id(null));
            unRang.rang(this.rang(null));
            unRang.dossard(this.dossard(null));
            unRang.temps(this.temps(null));
            unRang.idCourse(this.idCourse(null));
            unRang.idCheval(this.idCheval(null));
            unRang.idJockey(this.idJockey(null));
            return unRang;
        } catch (TrotException e) {
            return null;
        }
            
    } 

    @Override
    public String toString() {
        return "MCourseRang{" + "id=" + id + ", name=" + name + "rang=" + rang + ", dossard=" + dossard + ", temps=" + temps + ", idCourse=" + idCourse + ", idCheval=" + idCheval + ", idJockey=" + idJockey + '}';
    }

    @Override
    protected void buildMapping () {
        mapping = new TreeMap<>();
        mapTypes = new TreeMap<>();
        mapping.put("id", "id");
        mapTypes.put("id", "int");
        mapping.put("rang", "rang");
        mapTypes.put("rang", "int");
        mapping.put("dossard", "dossard");
        mapTypes.put("dossard", "int");
        mapping.put("temps", "temps");
        mapTypes.put("temps", "String");
        mapping.put("idCourse", "idcourse");
        mapTypes.put("idCourse", "int");
        mapping.put("idCheval", "idCheval");
        mapTypes.put("idCheval", "int");
        mapping.put("idJockey", "idJockey");
        mapTypes.put("idJockey", "int");
    }     
    
    // Get/Setters

    public Integer rang(Integer value) {
        if (value == null)
            return this.rang;
        else {
            this.rang = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer dossard(Integer value) {
        if (value == null)
            return this.dossard;
        else {
            this.dossard = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public String temps(String value) {
        if (value == null)
            return this.temps;
        else {
            this.temps = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer idCourse(Integer value) {
        if (value == null)
            return this.idCourse;
        else {
            this.idCourse = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer idCheval(Integer value) {
        if (value == null)
            return this.idCheval;
        else {
            this.idCheval = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer idJockey(Integer value) {
        if (value == null)
            return this.idJockey;
        else {
            this.idJockey = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }
    
}
