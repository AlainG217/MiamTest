/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prono.model;

// SQL
import java.sql.*;
import java.sql.Types.*;

// Java
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map;
import java.lang.reflect.Method;

// Application
import prono.base.BaseObject;
import prono.error.PronoException;
/**
 *
 * @author alain
 */
public abstract class MBase extends BaseObject{

    // Attributes
    private Connection db;
    private String tableName;
    protected TreeMap<String, String> mapping;
    protected ArrayList<MBase> parents;
    protected ArrayList<MBase> sons;
    protected ArrayList<MBase> entityList;
    private String sortBy;
    private String sortAD;
    private MBase parent;
    private ResultSet rs;

    public MBase(Connection db, String tableName) {
        this.db = db;
        this.tableName = tableName;
    }
/*===========================================================================================
#
#	Name		clone
#	
#	Description	Copy an object - must be overriden
#
#==========================================================================================*/
public abstract MBase clone ();
/*===========================================================================================
#
#	Name		countRecords
#	
#	Description	Counts records for the attribute received
#
#==========================================================================================*/    

    public int countRecords (String attribut, Object value) throws PronoException {
        int count = 0;
        String column;

        if (!(attribut == null && value == null) && 
                ((attribut != null && value == null) || 
                (attribut == null && value != null)))  {
            throw new PronoException("CCE0006");
        }
        
        // Build statement
        
        String SQLStr1 = "SELECT count(*) FROM ";
        String SQLWhere = " WHERE ";
        String finalSQL;
        finalSQL = SQLStr1 + tableName;
        
        // finds the related column 
        if (value != null) {
            if (attribut != null)  {
                column = mapping.get(attribut);
                // A faire gérer le type
                SQLWhere = SQLWhere + column + " = '" + value + "'";
                finalSQL += SQLWhere;
            }
        } 
        System.out.println(finalSQL);
        // Execute the statement
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery(finalSQL);
            rs.next();
            count  = rs.getInt(1);
            rs.close();
            
        } catch (SQLException e) {
            throw new PronoException("CSE0005", e);
            
        }
        
        return count;
    }
/*===========================================================================================
#
#	Name			createRecord
#	
#	Description		Inserts a record in DB
#
#==========================================================================================*/
    protected void createRecord () throws PronoException {
        String column;
        String attribut = "";
        boolean firstTime = true;
        
        // Build statement
        
        String SQLStr1 = "INSERT INTO ";
        String SQLColumns = "(";
        String SQLValues = " VALUES(";
        String finalSQL;
        Class[] typeParametres = null;
        Method m;
        
        // Go thru the map
        
        for (Map.Entry<String,String> entry : mapping.entrySet()) {
            attribut = entry.getKey();
            column = entry.getValue();
            
            if (!attribut.equals("id") ) {
                if (firstTime)
                    firstTime = false;
                else {
                    SQLColumns += ", ";
                    SQLValues += ", ";
                }
                SQLColumns += column;
                try {
                    typeParametres = new Class[1];
                    typeParametres[0] = "String".getClass();
                    Object[] parametres = new Object[1];
                    parametres[0] = null;
                    m = getClass().getMethod(attribut, typeParametres);
                    
                    SQLValues += "'" + m.invoke(this, parametres) + "'";
                } catch (Exception e) {
                    throw new PronoException("CCE0007", e);
                   
                }
            }
        }
        SQLColumns += ")";
        SQLValues += ")";
        
        finalSQL = SQLStr1 + tableName + SQLColumns +SQLValues;
        System.out.println(finalSQL);
        
        // Execute the statement

        try {
            Statement stmt = db.createStatement();
            stmt.executeUpdate(finalSQL);
            
        } catch (SQLException e) {
            throw new PronoException("CSE0001", e);
            
        }
        
        // Gets the id
        // Build statement
        
        SQLStr1 = "SELECT MAX(id) FROM ";
        finalSQL = SQLStr1 + tableName;
        
        System.out.println(finalSQL);
        // Execute the statement
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(finalSQL);
            rs.next();
            id  = rs.getInt(1);
            rs.close();
            
        } catch (SQLException e) {
            throw new PronoException("CSE0005", e);
            
        }
        
        setObjectState(10);
    }
/*===========================================================================================
#
#	Name			deleteRecord
#	
#	Description		Deletes a record in DB
#
#==========================================================================================*/
    protected void deleteRecord () throws PronoException {
        
        // Build statement
        
        String finalSQL = "DELETE FROM " + tableName + " WHERE id = " + id;
        
        // Execute the statement

        try {
            Statement stmt = db.createStatement();
            stmt.executeUpdate(finalSQL);
            
        } catch (SQLException e) {
            throw new PronoException("CSE0001", e);
            
        }
        
    }
/*===========================================================================================
#
#	Name			execSelect
#	
#	Description		Execute a Select 
#
#==========================================================================================*/
    protected void execSelect (String SQLStatement) throws PronoException {
        
        ArrayList<MBase> objects = new ArrayList<MBase>();
        
        // Execute the statement
        try {
            Statement stmt = db.createStatement();
            rs = stmt.executeQuery(SQLStatement);
            while (rs.next()) {
                populate();
                objects.add(clone());
            }
            rs.close();
            
        } catch (SQLException e) {
            throw new PronoException("CSE0005", e);
            
        }
        setEntityList(objects);
        
    }
/*===========================================================================================
#
#	Name			getAttributes
#	
#	Description		Gets all attributes 
#
#==========================================================================================*/
public ArrayList<String> getAttributes () {
    ArrayList<String> attributes = new ArrayList<>();

    for (Map.Entry<String,String> entry : mapping.entrySet()) {
        attributes.add(entry.getKey());
    }

    return attributes;
}
/*===========================================================================================
#
#	Name			getAll
#	
#	Description		Gets all records 
#
#==========================================================================================*/
    protected ArrayList<MBase> getAll () throws PronoException {

        ArrayList<MBase> objects = new ArrayList<>();
        ResultSetMetaData meta;
        
        // Build statement
        
        String SQLStatement = "SELECT ";
        String SQLStatementFrom = " FROM " + tableName;
        String finalSQL;
        
        // Build the columns
        
        String SQLStatementColumns = buildColumns();
        
        finalSQL = SQLStatement + SQLStatementColumns + SQLStatementFrom; 
        
        // Build the sort if any
        if (sortBy != null) {
            String SQLStatementSortBy = buildSortBy();
            finalSQL += SQLStatementSortBy;            
        }
        // Execute the statement

        try {
            execSelect(finalSQL);
        } catch (PronoException e) {
            throw new PronoException("CSE0001", e);            
        }
        
        return entityList;
        
    }
/*===========================================================================================
#
#	Name			getAllBy
#	
#	Description		Gets all records 
#
#==========================================================================================*/
    protected ArrayList<MBase> getAllBy (String attribut, String value) throws PronoException {

        ArrayList<MBase> objects = new ArrayList<>();
        ResultSetMetaData meta;
        
        // Build statement
        
        String SQLStatement = "SELECT ";
        String SQLStatementFrom = " FROM " + tableName;
        String finalSQL;
        
        // Build the where
        String SQLStatementWhere = buildWhere(attribut, value, "LIKE");

        // Build the columns
        
        String SQLStatementColumns = buildColumns();
        
        finalSQL = SQLStatement + SQLStatementColumns + SQLStatementFrom; 
        
        // Build the sort if any
        if (sortBy != null) {
            String SQLStatementSortBy = buildSortBy();
            finalSQL += SQLStatementSortBy;            
        }
        // Execute the statement

        try {
            execSelect(finalSQL);
        } catch (PronoException e) {
            throw new PronoException("CSE0001", e);            
        }
        
        return entityList;
        
    }
/*===========================================================================================
#
#	Name			getobjectbyid
#	
#	Description		Gets one record by ID
#
#==========================================================================================*/
    public MBase getobjectbyid(int value) {
        
        try  {
            getRecord("id", value);
        } catch (PronoException e) {
        }
        
        return entityList.get(0);
    }
/*===========================================================================================
#
#	Name			getRecord
#	
#	Description		Gets one record in DB 
#
#==========================================================================================*/
    protected ArrayList<MBase> getRecord (
            String attribut, String value) throws PronoException {

        ArrayList<MBase> objects = new ArrayList<>();
        ResultSetMetaData meta;
    
        // Check parameters
        if (attribut == null)
            throw new PronoException("CCE0002");
        else {
            if (!attribut.equals("id") && value == null)
                throw new PronoException("CCE0003");
        }
        
        // Build statement
        
        String SQLStatement = "SELECT ";
        String SQLStatementFrom = " FROM " + tableName;
        String finalSQL;

        // Build the where
        String SQLStatementWhere = buildWhere(attribut, value, "=");
        
        // Build the columns
        
        String SQLStatementColumns = buildColumns();
        
        finalSQL = SQLStatement + SQLStatementColumns + SQLStatementFrom + 
                SQLStatementWhere; 
        
        // Build the sort if any
        if (sortBy != null) {
            String SQLStatementSortBy = buildSortBy();
            finalSQL += SQLStatementSortBy;            
        }
        // Execute the statement

        try {
            execSelect(finalSQL);
        } catch (PronoException e) {
            throw new PronoException("CSE0001", e);            
        }
        
        return entityList;
        
    }
/*===========================================================================================
#
#	Name			getRecord
#	
#	Description		Gets one record in DB 
#
#==========================================================================================*/
    protected ArrayList<MBase> getRecord (
            String attribut, Integer value) throws PronoException {

        ArrayList<MBase> objects = new ArrayList<>();
        ResultSetMetaData meta;
    
        // Check parameters
        if (attribut == null)
            throw new PronoException("CCE0002");
        else {
            if (!attribut.equals("id") && value == null)
                throw new PronoException("CCE0003");
        }
        
        // Build statement
        
        String SQLStatement = "SELECT ";
        String SQLStatementFrom = " FROM " + tableName;
        String finalSQL;

        // Build the where
        String SQLStatementWhere = buildWhere(attribut, value, "=");
        
        // Build the columns
        
        String SQLStatementColumns = buildColumns();
        
        finalSQL = SQLStatement + SQLStatementColumns + SQLStatementFrom +
                SQLStatementWhere; 
        
        // Build the sort if any
        if (sortBy != null) {
            String SQLStatementSortBy = buildSortBy();
            finalSQL += SQLStatementSortBy;            
        }
        // Execute the statement

        try {
            execSelect(finalSQL);
        } catch (PronoException e) {
            throw new PronoException("CSE0001", e);            
        }
        
        return entityList;
        
    }
/*===========================================================================================
#
#	Name		populate
#	
#	Description	Populates object from result set or received data
#
#==========================================================================================*/    
    
    public void populate () throws PronoException  {
        
        String attribut;
        String column;
        ResultSetMetaData meta;
        Class[] typeParametres = new Class[1];
        Object[] parametres = new Object[1];
        Class classe;
        String className;
        Method m;
        
        boolean receivedF = false; // Received - to be implemented later
        
        // If nothing received, check we have a result set
        
        if (receivedF == false && rs == null) 
            throw new PronoException("CCE0004");

        try {
            meta = rs.getMetaData();
        } catch (Exception e) {
            throw new PronoException("CSEnnnn", e);            
        }
        
        // Go thru the map
        
        for (Map.Entry<String,String> entry : mapping.entrySet()) {
            attribut = entry.getKey();
            column = entry.getValue();
            try {
                int ci = rs.findColumn(column);
                int type = meta.getColumnType(ci); 
                switch (type) {
                    case java.sql.Types.INTEGER: 
                        typeParametres[0] = "Integer".getClass();
                        parametres[0] = rs.getInt(column);
                        m = getClass().getMethod(attribut, typeParametres);
                    
                        m.invoke(this, parametres);
                        break;
                    case java.sql.Types.VARCHAR: 
                        typeParametres[0] = "String".getClass();
                        parametres[0] = rs.getInt(column);
                        m = getClass().getMethod(attribut, typeParametres);
                    
                        m.invoke(this, parametres);
                        break;
                    case java.sql.Types.DATE: 
                        typeParametres[0] = "DateTime".getClass();
                        parametres[0] = rs.getDate(column);
                        m = getClass().getMethod(attribut, typeParametres);
                    
                        m.invoke(this, parametres);
                        break;
                    default :
                        throw new PronoException("CSEnnnn");                                    

                }
/* A implémenter plus tard si nécessaire               
                // Set parent, if any
                if (parents.contains(attribut)) {
                    className = "M" + attribut;
                    classe = Class.forName(className);
                    MBase parent = (MBase) classe.newInstance();
                    parent.id(null);
                }
*/                
            } catch (Exception e) {
                throw new PronoException("CSEnnnn", e);                           
            }
        }
    }
        
            
/*===========================================================================================
#
#	Name		saveObject
#	
#	Description	Controls the update in DB, based on object state
#
#==========================================================================================*/    
    
    
public void saveObject () throws PronoException  {
       
        switch (getObjectState()) {
            case 1 : createRecord();
                break;
            case 11 : updateRecord();
                break;
            case 19 : deleteRecord();
                break;
            default : throw new PronoException("CCE0005");
        }  

    }
/*===========================================================================================
#
#	Name			updateRecord
#	
#	Description		Inserts a record in DB
#
#==========================================================================================*/
    protected void updateRecord () throws PronoException {
        
    }
    
    protected void buildMapping () {
        mapping = new TreeMap<>();
        mapping.put("id", "id");
        mapping.put("name", "nom");
    }
/*===========================================================================================
#
#	Name			buildColumns
#	
#	Description		Builds a column list for a SELECT statement
#
#==========================================================================================*/
    protected String buildColumns () {
        String SQLStatementColumns = "";
        String column;
        ResultSetMetaData meta;
        boolean firstTime = true;
        
        for (Map.Entry<String,String> entry : mapping.entrySet()) {
            column = entry.getValue();
            if (firstTime)
                firstTime = false;
            else
                SQLStatementColumns += ",";
            
            SQLStatementColumns += column;
        }
        
        return SQLStatementColumns;
        
    }
/*===========================================================================================
#
#	Name			buildSortBy
#	
#	Description		Builds a sort for a SELECT statement
#
#==========================================================================================*/
    protected String buildSortBy () {
        String SQLStatementSortBy = " ORDER BY ";
        String column;
        ResultSetMetaData meta;
        
        column = mapping.get(sortBy);
        SQLStatementSortBy += column;
        if (sortAD.equals("D"))
            SQLStatementSortBy += " DESC";

        
        return SQLStatementSortBy;
        
    }
/*===========================================================================================
#
#	Name			buildWhere
#	
#	Description		Builds a simple Where
#
#==========================================================================================*/
    protected String buildWhere (String attribut, String value, String operator) throws PronoException {
        String SQLStatementWhere = " WHERE ";
        String column;
        ResultSetMetaData meta;

        // Find the column to search
        column = mapping.get(attribut);
            try {
                meta = rs.getMetaData();
                int ci = rs.findColumn(attribut);
                int type = meta.getColumnType(ci);
                SQLStatementWhere += column + operator + " ";
                
                if (type == java.sql.Types.INTEGER)
                    SQLStatementWhere += value;
                else {
                    SQLStatementWhere += "'" + value;
                    if (operator.equals("LIKE"))
                        SQLStatementWhere += "%";
                    SQLStatementWhere += "'";
                }
            } catch (Exception e) {
                throw new PronoException("CSE0005", e);
            }
       
        return SQLStatementWhere;
    }

/*===========================================================================================
#
#	Name			buildWhere
#	
#	Description		Builds a simple Where
#
#==========================================================================================*/
    protected String buildWhere (String attribut, Integer value, String operator) throws PronoException {
        String SQLStatementWhere = " WHERE ";
        String column;
        ResultSetMetaData meta;

        // Find the column to search
        column = mapping.get(attribut);
            try {
                meta = rs.getMetaData();
                int ci = rs.findColumn(attribut);
                int type = meta.getColumnType(ci);
                SQLStatementWhere += column + operator;
                
                if (type == java.sql.Types.INTEGER)
                    SQLStatementWhere += value;
                else {
                    SQLStatementWhere += "'" + value + "'";
                }
            } catch (Exception e) {
                throw new PronoException("CSE0005", e);
            }
       
        return SQLStatementWhere;
    }

    public Connection getDb() {
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public TreeMap<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(TreeMap<String, String> mapping) {
        this.mapping = mapping;
    }

    public ArrayList<MBase> getParents() {
        return parents;
    }

    public void setParents(ArrayList<MBase> parents) {
        this.parents = parents;
    }

    public ArrayList<MBase> getSons() {
        return sons;
    }

    public void setSons(ArrayList<MBase> sons) {
        this.sons = sons;
    }

    public ArrayList<MBase> getEntityList() {
        return entityList;
    }

    public void setEntityList(ArrayList<MBase> entityList) {
        this.entityList = entityList;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortAD() {
        return sortAD;
    }

    public void setSortAD(String sortAD) {
        this.sortAD = sortAD;
    }

    public MBase getParent() {
        return parent;
    }

    public void setParent(MBase parent) {
        this.parent = parent;
    }

    
}
