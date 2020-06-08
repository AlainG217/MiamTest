/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.model;

import fr.sport.trot.error.TrotException;
import fr.sport.trot.web.WCourse;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.TreeMap;

/**
 *
 * @author stagjava
 */
public class MCourse extends MBase {
    // Attributes
    private LocalDateTime dateCourse;
    private int dotation;
    private String type;
    private String typeChevaux;
    private String age;
    private int distance;
    private String piste;
    private String corde;
    
    public MCourse(Connection db) throws TrotException {
        super(db, "course");
        buildMapping();
    }    
    @Override
    public MCourse clone() {
        try {
            MCourse uneCourse = new MCourse(this.getDb());
            uneCourse.id(this.id(null));
            uneCourse.name(this.name(null));
            uneCourse.dateCourse(this.dateCourse(null));
            uneCourse.dotation(this.dotation(null));
            uneCourse.type(this.type(null));
            uneCourse.typeChevaux(this.typeChevaux(null));
            uneCourse.age(this.age(null));
            uneCourse.distance(this.distance(null));
            uneCourse.piste(this.piste(null));
            uneCourse.corde(this.corde(null));
            return uneCourse;
        } catch (TrotException e) {
            return null;
        }
            
    } 

    public void populateFromWeb(WCourse webCourse) {
        name = webCourse.name(null);
        dateCourse = webCourse.getDate();
        dotation = webCourse.getDotation();
        type = webCourse.getType();
        typeChevaux = webCourse.getChevaux();
        age = webCourse.getAge();
        distance = webCourse.getDistance();
        piste = webCourse.getPiste();
        corde = webCourse.getCorde();
        setObjectState(1);
    }
    @Override
    public String toString() {
        return "MCourse{" + "id=" + id + ", name=" + name + "dateCourse=" + dateCourse + ", dotation=" + dotation + ", type=" + type + ", typeChevaux=" + typeChevaux + ", age=" + age + ", distance=" + distance + ", piste=" + piste + ", corde=" + corde + '}';
    }
    @Override
    protected void buildMapping () {
        mapping = new TreeMap<>();
        mapTypes = new TreeMap<>();
        mapping.put("id", "id");
        mapTypes.put("id", "int");
        mapping.put("name", "nom");
        mapTypes.put("name", "String");
        mapping.put("dateCourse", "dateCourse");
        mapTypes.put("dateCourse", "date");
        mapping.put("dotation", "dotation");
        mapTypes.put("dotation", "int");
        mapping.put("type", "type");
        mapTypes.put("type", "String");
        mapping.put("typeChevaux", "chevaux");
        mapTypes.put("typeChevaux", "String");
        mapping.put("age", "age");
        mapTypes.put("age", "String");
        mapping.put("distance", "distance");
        mapTypes.put("distance", "int");
        mapping.put("piste", "piste");
        mapTypes.put("piste", "String");
        mapping.put("corde", "corde");
        mapTypes.put("corde", "String");
    } 
    
    // Get/Setters

    public LocalDateTime dateCourse(LocalDateTime date) {
        if (date == null)
            return this.dateCourse;
        else {
            this.dateCourse = date;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

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

    public String typeChevaux(String type) {
        if (type == null)
            return this.typeChevaux;
        else {
            this.typeChevaux = type;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public String age(String age) {
        if (age == null)
            return this.age;
        else {
            this.age = age;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer dotation(Integer dotation) {
        if (dotation == null)
            return this.dotation;
        else {
            this.dotation = dotation;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public Integer distance(Integer distance) {
        if (distance == null)
            return this.distance;
        else {
            this.distance = distance;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public String piste(String piste) {
        if (piste == null)
            return this.piste;
        else {
            this.piste = piste;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }

    public String corde(String corde) {
        if (corde == null)
            return this.corde;
        else {
            this.corde = corde;
            if (getObjectState() == 10)
                setObjectState(11);
            return null;
        }
    }
}
