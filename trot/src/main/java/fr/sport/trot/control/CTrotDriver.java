/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.control;

// System
import java.util.logging.Logger;
import java.util.logging.FileHandler;
// SQL
import java.sql.Connection;
import java.sql.DriverManager;
// Application
import fr.sport.trot.base.BaseObject;
import fr.sport.trot.base.Local;
import fr.sport.trot.error.TrotException;
import fr.sport.trot.web.WebPage;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author alain
 */
public class CTrotDriver extends BaseObject{
    // Base attributes
    private Connection db;
    private Logger log;
    private Local local;

    // Logic attributes
    private String nextAction;
    
    // Web acquisition attributes
    private WebPage webPage;
    private String historyStDate;
    private String baseURL;

    public CTrotDriver(String na) {
        super();
        nextAction = na;
        historyStDate = "";
        baseURL = "https://www.zone-turf.fr/rapports/";
        local = new Local();
        
        // Log
        log = Logger.getLogger(CTrotDriver.class.getName());
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
            
            db = DriverManager.getConnection(local.getUrl() + local.getParams(), local.getUser(), local.getPwd());
            db.setAutoCommit(false);
            log.info("Connexion base OK");        
       } catch (Exception e) {
          log.severe(e.getLocalizedMessage());
          log.info("Sortie...");
        }
                    
    }

    public void drive () {
       
        // Analyze the page
        String urlName = "https://www.zone-turf.fr/rapports/r1-c1-prix-de-pavilly-488534.html";
        
        while (!(nextAction.equals("END")) ) {
            processNextAction();
        }        

    }
    
    protected void processNextAction() {
        
        switch (nextAction) {
            case "HST" : 
                processHistory();
                nextAction = "END";
                break;
            case "CFW" : 
                processCoursePage("");
                break;
            
        }
    }

    protected void processHistory() {
        // Variables
        LocalDateTime uneDate;
        DayOfWeek dayName;
        String url;
        
        // Set start date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        uneDate = LocalDate.parse(historyStDate, formatter).atStartOfDay();
        // Set end date
        LocalDateTime endDate = LocalDate.now().atStartOfDay();
        
//        while (uneDate.isBefore(endDate)) {
            
            // Format the url
            dayName = uneDate.getDayOfWeek();
            url = baseURL + uneDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRANCE)+ "-" + 
                            uneDate.getDayOfMonth() + "-" + 
                            uneDate.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE)+ "-" +
                            uneDate.getYear() + "/" ;
            
            System.out.println(url);

            WebPage webPage = new WebPage(url);
            webPage.analyzePage("day");
            
//        }
        
    }
    
    protected void processCoursePage(String urlName) {
        
        // Init
        System.out.println("processCoursePage début");
        
        // Get the page and analyze it

//        WebPage coursePage = new WebPage(urlName);
        webPage = new WebPage();
        webPage.analyzePage();
        
        CCourse uneCourse = null;
        try {
            uneCourse= new CCourse(db);
            
        } catch (TrotException e) {
            e.show();
            
        }
        uneCourse.setWebCourse(webPage.getCourse());
        
        //  Create from web
        uneCourse.drive(nextAction);
    }
    
    // Getters and setters

    public Connection getDb() {
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public WebPage getWebPage() {
        return webPage;
    }

    public void setCoursePage(WebPage webPage) {
        this.webPage = webPage;
    }

    public String getHistoryStDate() {
        return historyStDate;
    }

    public void setHistoryStDate(String historyStDate) {
        this.historyStDate = historyStDate;
    }
    
}
