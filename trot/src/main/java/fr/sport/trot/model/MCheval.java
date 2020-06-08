/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.model;

import fr.sport.trot.error.TrotException;
import java.sql.Connection;
import java.util.TreeMap;

/**
 *
 * @author stagjava
 */
public class MCheval extends MBase {
    // Attributes
    private String type;
    private int age;
    private int gains;
    private int gainsG;
    private int gainsP;
    private int idProp;
    private int idEntraineur;
    
    public MCheval(Connection db) throws TrotException {
        super(db, "cheval");
        buildMapping();
    }   
    
    public void setGains (int rang, int dotation) {
        switch (rang) {
            case 1 : 
                gains(gains(null) + (int) (dotation * 0.5));
                gainsG(gainsG(null) + (int) (dotation * 0.5));
                gainsP(gainsP(null) + (int) (dotation * 0.5));
                break;
            case 2 : 
                gains(gains(null) + (int) (dotation * 0.25));
                gainsP(gainsP(null) + (int) (dotation * 0.25));
                break;
            case 3 : 
                gains(gains(null) + (int) (dotation * 0.13));
                gainsP(gainsP(null) + (int) (dotation * 0.13));
                break;
            case 4 : 
                gains(gains(null) + (int) (dotation * 0.06));
                break;
            case 5 : 
                gains(gains(null) + (int) (dotation * 0.03));
                break;
            case 6 : 
                gains(gains(null) + (int) (dotation * 0.02));
                break;
            case 7 : 
                gains(gains(null) + (int) (dotation * 0.01));
                break;
        }
    }
    @Override
    public MCheval clone() {
        try {
            MCheval unCheval = new MCheval(this.getDb());
            unCheval.id(this.id(null));
            unCheval.name(this.name(null));
            unCheval.type(this.type(null));
            unCheval.gains(this.gains(null));
            unCheval.age(this.age(null));
            unCheval.gainsG(this.gainsG(null));
            unCheval.gainsP(this.gainsP(null));
            unCheval.idProp(this.idProp(null));
            unCheval.idEntraineur(this.idEntraineur(null));
            return unCheval;
        } catch (TrotException e) {
            return null;
        }
            
    } 

    @Override
    public String toString() {
        return "MCheval{" + "id=" + id + ", name=" + name + "type=" + type + ", age=" + age + ", gains=" + gains + ", gainsG=" + gainsG + ", gainsP=" + gainsP + ", idProp=" + idProp + ", idEntraineur=" + idEntraineur + '}';
    }
    @Override
    protected void buildMapping () {
        super.buildMapping();
        mapping.put("type", "type");
        mapTypes.put("type", "String");
        mapping.put("age", "age");
        mapTypes.put("age", "int");
        mapping.put("gains", "gains");
        mapTypes.put("gains", "int");
        mapping.put("gainsG", "gainG");
        mapTypes.put("gainsG", "int");
        mapping.put("gainsP", "gainP");
        mapTypes.put("gainsP", "int");
        mapping.put("idProp", "idProp");
        mapTypes.put("idProp", "int");
        mapping.put("idEntraineur", "idEntraineur");
        mapTypes.put("idEntraineur", "int");
    }     
    
    // Get/Setters

    public String type(String type) {
        if (type == null)
            return this.type;
        else {
            this.type = type;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer age(Integer value) {
        if (value == null)
            return this.age;
        else {
            this.age = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer gains(Integer value) {
        if (value == null)
            return this.gains;
        else {
            this.gains = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer gainsG(Integer value) {
        if (value == null)
            return this.gainsG;
        else {
            this.gainsG = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer gainsP(Integer value) {
        if (value == null)
            return this.gainsP;
        else {
            this.gainsP = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer idProp(Integer value) {
        if (value == null)
            return this.idProp;
        else {
            this.idProp = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer idEntraineur(Integer value) {
        if (value == null)
            return this.idEntraineur;
        else {
            this.idEntraineur = value;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }
}
