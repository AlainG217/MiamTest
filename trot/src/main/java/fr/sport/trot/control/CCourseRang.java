/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.control;

import fr.sport.trot.error.TrotException;
import fr.sport.trot.model.MBase;
import fr.sport.trot.model.MCheval;
import fr.sport.trot.model.MCourse;
import fr.sport.trot.model.MCourseRang;
import fr.sport.trot.model.MPersonne;
import fr.sport.trot.web.WCourseRang;
import java.sql.Connection;
import java.util.Iterator;

/**
 *
 * @author stagjava
 */
public class CCourseRang {
    // Attributes
    private WCourseRang webRang;
    private MCourseRang mCourseRang;
    private MPersonne mJockey;
    private MPersonne mEntraineur;
    private MPersonne mProprietaire;
    private MCheval mCheval;

    public CCourseRang(Connection db) throws TrotException {
        this.mCourseRang = new MCourseRang(db);
        this.mJockey = new MPersonne(db);
        this.mEntraineur = new MPersonne(db);
        this.mProprietaire = new MPersonne(db);
        this.mCheval = new MCheval(db);
    }
    
    public void drive (String action, CCourse caller) {
        
        // Create from web
        if (action.equals("CFW")) {
            createRangFromWeb(caller.getmCourse());
        }
    }


    protected void createRangFromWeb(MCourse course) {
        // Variables
        
        mCourseRang.idCourse(course.id(null));

        // Vérifier l'existence des personnes
        mJockey = getPersonne(webRang.getJockey(), "J");
        mCourseRang.idJockey(mJockey.id(null));
        mEntraineur = getPersonne(webRang.getEntraineur(), "E");
        mProprietaire = getPersonne(webRang.getProprietaire(), "P");

        // Vérifier l'existence du cheval
        try {
            mCheval.name(webRang.name(null));
                System.out.println(mCheval.name(null));
            mCheval.getRecord("name", mCheval.name(null));
            if (mCheval.getEntityList().isEmpty()) {
                System.out.println("Création");
                // Not found create it
                mCheval.name(webRang.name(null));
                mCheval.type(webRang.getType());
                mCheval.age(Integer.parseInt(webRang.getType().substring(1)));
                mCheval.gains(0);
                mCheval.gainsG(0);
                mCheval.gainsP(0);
                mCheval.setGains(webRang.getRang(), course.dotation(null));
                mCheval.idEntraineur(mEntraineur.id(null));
                mCheval.idProp(mProprietaire.id(null));
                mCheval.setObjectState(1);
                mCheval.saveObject();
            } else { 
                System.out.println("Found");
                if (webRang.getRang() >= 1 && webRang.getRang() <= 7) {
                    mCheval.setGains(webRang.getRang(), course.dotation(null));
                    mCheval.setObjectState(11);
                    mCheval.saveObject();
                }
            }
            mCourseRang.idCheval(mCheval.id(null));

            // Populate other data
            mCourseRang.populateFromWeb(webRang);
            mCourseRang.saveObject();
        } catch (TrotException e) {
            e.show();
        }
        
    }
    
    protected MPersonne getPersonne (String np, String type) {

        MPersonne unePersonne = null;
        try {
            MPersonne personne = new MPersonne(mJockey.getDb());
            String[] nomprenom = decompose(np);
            personne.name(nomprenom[1]);
            String[] attributes = {"prenom","name"};
            personne.getRecord(attributes, nomprenom);
            
            if (personne.getEntityList().isEmpty()) {
                // Not found create it
                personne.prenom(nomprenom[0]);
                personne.setFlags(type);
                personne.setObjectState(1);
                personne.saveObject();
            } else {
                switch (type) {
                    case "J" : 
                        personne.isJockey(true);
                        break;
                    case "E" : 
                        personne.isEntraineur(true);
                        break;
                    case "P" : 
                        personne.isProprietaire(true);
                        break;
                }
                if (personne.getObjectState() == 11) {
                    personne.saveObject();
                }
                
            }   
            return personne;
        } catch (TrotException e) {
            e.show();
            return null;            
        }
    }

    protected String[] decompose(String np) {
        String[] arr = new String[2];
        int lb = np.lastIndexOf(" ");
        arr[0] = np.substring(0, lb);
        arr[1] = np.substring(lb+1);
        return arr;
    }

    // Getters and setters

    public WCourseRang getWebRang() {
        return webRang;
    }

    public void setWebRang(WCourseRang webRang) {
        this.webRang = webRang;
    }

    public MCourseRang getmCourseRang() {
        return mCourseRang;
    }

    public void setmCourseRang(MCourseRang mCourseRang) {
        this.mCourseRang = mCourseRang;
    }

    public MPersonne getmJockey() {
        return mJockey;
    }

    public void setmJockey(MPersonne mJockey) {
        this.mJockey = mJockey;
    }

    public MPersonne getmEntraineur() {
        return mEntraineur;
    }

    public void setmEntraineur(MPersonne mEntraineur) {
        this.mEntraineur = mEntraineur;
    }

    public MPersonne getmProprietaire() {
        return mProprietaire;
    }

    public void setmProprietaire(MPersonne mProprietaire) {
        this.mProprietaire = mProprietaire;
    }

    public MCheval getmCheval() {
        return mCheval;
    }

    public void setmCheval(MCheval mCheval) {
        this.mCheval = mCheval;
    }
    
}
