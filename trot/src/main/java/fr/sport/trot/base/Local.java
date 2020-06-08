/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.base;

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
    String params;
    String user;
    String pwd;
    String projectDir;
    String logDir;

    public Local() {
        dbName = "trot";
        server = "localhost";
        port = "3306";
        params = "?useSSL=false&serverTimezone=UTC";
        url = "jdbc:mysql://" + server + ":" + port + "/" + dbName;
        user = "ldnrjava";
        pwd = "ldnrjava";
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

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
    
}
