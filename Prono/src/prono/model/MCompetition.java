/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prono.model;

import java.sql.Connection;

/**
 *
 * @author alain
 */
public class MCompetition extends MBase {
    // Attributes
    private String federation;

    public MCompetition(Connection db) {
        super(db, "competition");
        buildMapping();
    }
    
    @Override
    protected void buildMapping () {
        super.buildMapping();
        mapping.put("federation", "federation");
    }

    public String federation(String federation) {
        if (federation == null)
            return this.federation;
        else {
            this.federation = federation;
            return null;
        }
    }

    
    
    
}
