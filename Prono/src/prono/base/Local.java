/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prono.base;

import java.sql.*;

/**
 *
 * @author alain
 */
public class Local {
    // Attributes
    String dbName;
    String server;
    String port;
    String url;
    String user;
    String pwd;
    String projectDir;
    String logDir;

    public Local() {
        dbName = "pronos";
        server = "localhost";
        port = "5432";
        url = "jdbc:postgresql://" + server + ":" + port + "/" + dbName;
        user = "postgres";
        pwd = "agy";
        projectDir = "/home/NetBeansProjects/Prono/";
        logDir = projectDir + "log/";
    }

    public String getLogDir() {
        return logDir;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }
    
}
