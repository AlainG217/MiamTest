/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prono.control;

// System
import java.util.logging.Logger;
import java.util.logging.FileHandler;
// SQL
import java.sql.Connection;
import java.sql.DriverManager;
// Application
import prono.base.BaseObject;
import prono.base.Local;
import prono.error.PronoException;
import prono.model.MCompetition;

/**
 *
 * @author alain
 */
public class CPronoDriver extends BaseObject{
    private Connection db;
    private Logger log;
    private Local local;
    private String nextAction;

    public CPronoDriver() {
        super();
        nextAction = "VMM";
        local = new Local();
        
        // Log
        log = Logger.getLogger(CPronoDriver.class.getName());
        FileHandler fh;
        String logName = local.getLogDir() + "prono1.log";
        System.out.println(logName);
/*        try {
          fh = new FileHandler(logName);
          fh.close();
          log.addHandler(fh);
        } catch (SecurityException e) {
          log.severe("Non autorisé à créer la log");
        } catch (IOException e) {
            System.out.println(e.getMessage());
          log.severe("Impossible d'associer la Log");
        } */
        log.info("Lancement de l'application");        
        
        // Connect to DB
        try {
            Class.forName("org.postgresql.Driver");
            
            db = DriverManager.getConnection(local.getUrl(), local.getUser(), local.getPwd());
        } catch (Exception e) {
          log.severe(e.getLocalizedMessage());
          log.info("Sortie...");
        }
        log.info("Connexion base OK");        
                    
    }

    public void drive () {
        
        // Test
        MCompetition compet = new MCompetition(db);
        compet.name("Bundesliga");
        compet.federation("Allemagne");
        compet.setObjectState(1);
        try {
            compet.saveObject();
        } catch (PronoException e) {
            System.out.println("Erreur " + e);
            System.out.println("Erreur " + e.getJavaException());
        }
        System.out.println(compet.id(null));
    }
}
