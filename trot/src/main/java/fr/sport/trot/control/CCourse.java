/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.control;

import fr.sport.trot.error.TrotException;
import fr.sport.trot.model.MCourse;
import fr.sport.trot.web.WCourse;
import fr.sport.trot.web.WCourseRang;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

/**
 *
 * @author stagjava
 */
public class CCourse {
    // Attributes
    private Connection db;
    private WCourse webCourse;
    private MCourse mCourse;

    public CCourse(Connection db) throws TrotException {
        this.db = db;
        this.mCourse = new MCourse(db);
    }
    
    public void drive (String action) {
//         System.out.println("CCourse drive début");
       
        // Create from web
        if (action.equals("CFW")) {
            createFromWeb();
            
        }
    }

    protected void createFromWeb() {
 //        System.out.println("CCourse createFromWeb début");

        WCourseRang rang;
        try {
            // Créer la course 
            mCourse.populateFromWeb(webCourse );
            mCourse.saveObject();
        
        // Créer le détail et potentiellement tous les éléments afférents
            CCourseRang unRang = new CCourseRang(db);
            Iterator<WCourseRang> it2 = webCourse.getRangs().iterator();
            while (it2.hasNext()) {
                rang = it2.next();
                unRang.setWebRang(rang);
                unRang.drive("CFW", this);
            }
            
            // Commit
            try {
                db.commit();
            } catch (SQLException ec) {
                throw new TrotException("CSE0006", ec, "", "createFromWeb");
            }
            
        } catch (TrotException e) {
            e.show();
            try {
                db.rollback();
            } catch (SQLException er) {
                
            } 
        }
        
    }
    
    // Getters and setters
    
    public WCourse getWebCourse() {
        return webCourse;
    }

    public void setWebCourse(WCourse webCourse) {
        this.webCourse = webCourse;
    }

    public MCourse getmCourse() {
        return mCourse;
    }

    public void setmCourse(MCourse mCourse) {
        this.mCourse = mCourse;
    }
    
}
