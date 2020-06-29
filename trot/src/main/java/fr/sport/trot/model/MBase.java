/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.model;

// SQL
import java.sql.*;
import java.sql.Types.*;

// Java
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map;
import java.lang.reflect.Method;

// Application
import fr.sport.trot.base.BaseObject;
import fr.sport.trot.error.TrotException;
import java.time.LocalDateTime;

/**
 *
 * @author alain
 */
public abstract class MBase extends BaseObject{

    // Attributes
    private Connection db;
    private String tableName;
    protected TreeMap<String, String> mapping;
    protected TreeMap<String, String> mapTypes;
    protected ArrayList<MBase> parents;
    protected ArrayList<MBase> sons;
    protected ArrayList<MBase> entityList;
    private String sortBy;
    private String sortAD;
    private MBase parent;
    private ResultSet rs;

    public MBase(Connection db, String tableName) throws TrotException {
        this.db = db;
        this.tableName = tableName;
        this.sortBy = null;
        
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

    public int countRecords (String attribut, Object value) throws TrotException {
        int count = 0;
        String column;
        String columnType;

        if (!(attribut == null && value == null) && 
                ((attribut != null && value == null) || 
                (attribut == null && value != null)))  {
            throw new TrotException("CCE0006","countRecords");
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
                columnType = mapTypes.get(attribut);
                // En fonction du type
                switch (columnType) {
                    case "numeric" : SQLWhere = SQLWhere + column + " = " + value;
                    break;
                    case "int" : SQLWhere = SQLWhere + column + " = " + value;
                    break;
                    case "boolean" : SQLWhere = SQLWhere + column + " = " + value;
                    break;
                    case "date" : SQLWhere = SQLWhere + column + " = '" + value + "'";
                    break;
                    case "String" : SQLWhere = SQLWhere + column + " = '" + value + "'";
                    break;
                    default: throw new TrotException("CSE0003", "countRecords");
                }
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
            throw new TrotException("CSE0005", e, tableName, "countRecords");            
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
    protected void createRecord () throws TrotException {
//         System.out.println("MBase createRecord début " + getObjectState());
        String column;
        String columnType;
        String attribut = "";
        boolean firstTime = true;
        Object[] parametres ;        
        Class[] typeParametres = null;
        typeParametres = new Class[1];
        parametres = new Object[1];
        // Build statement
        
        String SQLStr1 = "INSERT INTO ";
        String SQLColumns = " (";
        String SQLValues = " VALUES(";
        String finalSQL;
        Method m;
        
        // Go thru the map
        
        for (Map.Entry<String,String> entry : mapping.entrySet()) {
            attribut = entry.getKey();
            column = entry.getValue();
            columnType = mapTypes.get(attribut);
           
            if (!attribut.equals("id") ) {
                if (firstTime)
                    firstTime = false;
                else {
                    SQLColumns += ", ";
                    SQLValues += ", ";
                }
                SQLColumns += column;
                try {
                    // En fonction du type
                    switch (columnType) {
                        case "numeric" : 
                            Double unDouble = 0.0;
                            typeParametres[0] = unDouble.getClass();
                            m = getClass().getMethod(attribut, typeParametres);
                            SQLValues +=  m.invoke(this, parametres);
                            break;
                        case "int" :
                            Integer unInt = 0;
                            typeParametres[0] = unInt.getClass();
                            m = getClass().getMethod(attribut, typeParametres);
                            SQLValues +=  m.invoke(this, parametres);
                            break;
                        case "boolean" : 
                            Boolean unBoulean = false;
                            typeParametres[0] = unBoulean.getClass();
                            m = getClass().getMethod(attribut, typeParametres);
                            SQLValues +=  m.invoke(this, parametres);
                            break;
                        case "date" : 
                            LocalDateTime uneDate = LocalDateTime.now();
                            typeParametres[0] = uneDate.getClass();
                            m = getClass().getMethod(attribut, typeParametres);
                            SQLValues += "'" + m.invoke(this, parametres) + "'";
                            break;
                        case "String" : 
                            typeParametres[0] = "".getClass();
                            m = getClass().getMethod(attribut, typeParametres);
                            SQLValues += "'" + m.invoke(this, parametres) + "'";
                            break;
                        default: throw new TrotException("CSE0003", "createRecord");
                    }
                    
                } catch (Exception e) {
                    throw new TrotException("CCE0007", e, tableName, "createRecord"); 
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
            throw new TrotException("CSE0001", e, tableName, "createRecord");
            
        }
        catch (NullPointerException en) {
            throw new TrotException("CSE0001", en, tableName, "createRecord");
            
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
            throw new TrotException("CSE0005", e, tableName, "createRecord");
            
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
    protected void deleteRecord () throws TrotException {
        
        // Build statement
        
        String finalSQL = "DELETE FROM " + tableName + " WHERE id = " + id;
        
        // Execute the statement

        try {
            Statement stmt = db.createStatement();
            stmt.executeUpdate(finalSQL);
            
        } catch (SQLException e) {
            throw new TrotException("CSE0001", e, tableName, "deleteRecord");
            
        }
        
    }
/*===========================================================================================
#
#	Name			execSelect
#	
#	Description		Execute a Select 
#
#==========================================================================================*/
    protected void execSelect (String SQLStatement) throws TrotException {
        
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
            System.out.println("exc" + e);
            throw new TrotException("CSE0005", e, tableName, "execSelect");
            
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
    public ArrayList<MBase> getAll () throws TrotException {

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
        } catch (TrotException e) {
            throw new TrotException("CSE0001", e);            
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
    public ArrayList<MBase> getAllBy (String attribut, String value) throws TrotException {

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
        
        finalSQL = SQLStatement + 
                SQLStatementColumns + SQLStatementFrom + SQLStatementWhere; 
        
        // Build the sort if any
        if (sortBy != null) {
            String SQLStatementSortBy = buildSortBy();
            finalSQL += SQLStatementSortBy;            
        }
        System.out.println(finalSQL);
        // Execute the statement

        try {
            execSelect(finalSQL);
        } catch (TrotException e) {
            throw new TrotException("CSE0001", e);            
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
        
         System.out.println("getobjectbyid "  + value);
        try  {
            getRecord("id", value);
        } catch (TrotException e) {
            e.show();
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
    public ArrayList<MBase> getRecord (
            String attribut, String value) throws TrotException {

    
        // Check parameters
        if (attribut == null)
            throw new TrotException("CCE0002");
        else {
            if (!attribut.equals("id") && value == null)
                throw new TrotException("CCE0003");
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
        System.out.println(finalSQL);

        try {
            execSelect(finalSQL);
        } catch (TrotException e) {
            throw new TrotException("CSE0001", e);            
        }
        
        return entityList;
        
    }
    public ArrayList<MBase> getRecord (
            String attribut, Integer value) throws TrotException {

    
        // Check parameters
        if (attribut == null)
            throw new TrotException("CCE0002");
        else {
            if (!attribut.equals("id") && value == null)
                throw new TrotException("CCE0003");
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
        System.out.println(finalSQL);

        try {
            execSelect(finalSQL);
        } catch (TrotException e) {
            throw new TrotException("CSE0001", e);            
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
    public ArrayList<MBase> getRecord (
            String[] attributs, String[] values) throws TrotException {

        ArrayList<MBase> objects = new ArrayList<>();
    
        // Check parameters
        if (attributs.length == 0) 
            throw new TrotException("CCE0002", "getRecord");

            if (values.length == 0) 
            throw new TrotException("CCE0003", "getRecord");
        
        // Build statement
        
        String SQLStatement = "SELECT ";
        String SQLStatementFrom = " FROM " + tableName;
        String finalSQL;

        // Build the where
        String SQLStatementWhere = buildWhere(attributs, values, "=");
       
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
        } catch (TrotException e) {
            throw new TrotException("CSE0001", e);            
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
    
    public void populate () throws TrotException  {
        
        String attribut;
        String column;
        String columnType;
        Class[] typeParametres = new Class[1];
        Object[] parametres = new Object[1];
        Class classe;
        String className;
        Method m;
        
        boolean receivedF = false; // Received - to be implemented later
        
        // If nothing received, check we have a result set
        
        if (receivedF == false && rs == null) 
            throw new TrotException("CCE0004", "populate");
       
        // Go thru the map
        
        for (Map.Entry<String,String> entry : mapping.entrySet()) {
            attribut = entry.getKey();
            column = entry.getValue();
            columnType = mapTypes.get(attribut);
            try {
                switch (columnType) {
                    case "int": 
                        Integer unInt = 0;
                        typeParametres[0] = unInt.getClass();
                        parametres[0] = rs.getInt(column);
                        m = getClass().getMethod(attribut, typeParametres);
                    
                        m.invoke(this, parametres);
                        break;
                    case "numeric": 
                        Double unDouble = 0.0;
                        typeParametres[0] = unDouble.getClass();
                        parametres[0] = rs.getDouble(column);
                        m = getClass().getMethod(attribut, typeParametres);
                    
                        m.invoke(this, parametres);
                        break;
                    case "boolean": 
                        Boolean unBoolean = false;
                        typeParametres[0] = unBoolean.getClass();
                        parametres[0] = rs.getBoolean(column);
                        m = getClass().getMethod(attribut, typeParametres);
                    
                        m.invoke(this, parametres);
                        break;
                    case "String": 
                        typeParametres[0] = "".getClass();
                        parametres[0] = rs.getString(column);
                        m = getClass().getMethod(attribut, typeParametres);
                    
                        m.invoke(this, parametres);
                        break;
                    case "date": 
                        LocalDateTime uneDate = null;
                        typeParametres[0] = uneDate.getClass();
                        parametres[0] = rs.getDate(column);
                        m = getClass().getMethod(attribut, typeParametres);
                    
                        m.invoke(this, parametres);
                        break;
                    default :
                        throw new TrotException("CSE0003", "populate");                                    

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
                throw new TrotException("CSEnnnn", e);                           
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
    
    
public void saveObject () throws TrotException  {
//         System.out.println("MBase saveObject début " + getObjectState());
        switch (getObjectState()) {
            case 1 : createRecord();
                break;
            case 11 : updateRecord();
                break;
            case 19 : deleteRecord();
                break;
            default : throw new TrotException("CCE0005");
        }  

    }
/*===========================================================================================
#
#	Name			updateRecord
#	
#	Description		Inserts a record in DB
#
#==========================================================================================*/
    protected void updateRecord () throws TrotException {
        // Build statement
        
        String SQLStatement = "UPDATE " + tableName + " SET ";
        String finalSQL;

        // Build the where
        String SQLStatementWhere = " WHERE id = " + id;
        
        // Build the columns
        
        try {
            String SQLStatementColumns = buildSetColumns();

            finalSQL = SQLStatement + SQLStatementColumns + SQLStatementWhere; 

            // Execute the statement
            System.out.println(finalSQL);

            Statement stmt = db.createStatement();
            stmt.executeUpdate(finalSQL);
        } catch (Exception e) {
            throw new TrotException("CSE0004", e, tableName, "updateRecord");            
        }
        
    }
    
    protected void buildMapping () {
        mapping = new TreeMap<>();
        mapTypes = new TreeMap<>();
        mapping.put("id", "id");
        mapTypes.put("id", "int");
        mapping.put("name", "nom");
        mapTypes.put("name", "String");
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
#	Name			buildColumns
#	
#	Description		Builds a column list for a SELECT statement
#
#==========================================================================================*/
    protected String buildSetColumns () throws TrotException {
        String SQLStatementColumns = "";
        String attribut;
        String column;
        String columnType;
        boolean firstTime = true;
        Object[] parametres ;        
        Class[] typeParametres = null;
        typeParametres = new Class[1];
        parametres = new Object[1];
        Method m;
                
        // Go thru the map
        
        for (Map.Entry<String,String> entry : mapping.entrySet()) {
            attribut = entry.getKey();
            column = entry.getValue();
            columnType = mapTypes.get(attribut);
           
            if (!attribut.equals("id") ) {
                if (firstTime)
                    firstTime = false;
                else {
                    SQLStatementColumns += ", ";
                }
                SQLStatementColumns += column + " = ";
                try {
                    // En fonction du type
                    switch (columnType) {
                        case "numeric" : 
                            Double unDouble = 0.0;
                            typeParametres[0] = unDouble.getClass();
                            m = getClass().getMethod(attribut, typeParametres);
                            SQLStatementColumns +=  m.invoke(this, parametres);
                            break;
                        case "int" :
                            Integer unInt = 0;
                            typeParametres[0] = unInt.getClass();
                            m = getClass().getMethod(attribut, typeParametres);
                            SQLStatementColumns +=  m.invoke(this, parametres);
                            break;
                        case "boolean" : 
                            Boolean unBoulean = false;
                            typeParametres[0] = unBoulean.getClass();
                            m = getClass().getMethod(attribut, typeParametres);
                            SQLStatementColumns +=  m.invoke(this, parametres);
                            break;
                        case "date" : 
                            LocalDateTime uneDate = LocalDateTime.now();
                            typeParametres[0] = uneDate.getClass();
                            m = getClass().getMethod(attribut, typeParametres);
                            SQLStatementColumns += "'" + m.invoke(this, parametres) + "'";
                            break;
                        case "String" : 
                            typeParametres[0] = "".getClass();
                            m = getClass().getMethod(attribut, typeParametres);
                            SQLStatementColumns += "'" + m.invoke(this, parametres) + "'";
                            break;
                        default: throw new TrotException("CSE0003", "createRecord");
                    }
                } catch (Exception e) {
                    throw new TrotException("CCE0007", e, tableName, "buildSetColumns");
                }
            }                
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
    protected String buildWhere (String attribut, String value, String operator) throws TrotException {
        String SQLWhere = " WHERE ";
        String column;

        // Find the column to search
        column = mapping.get(attribut);
        SQLWhere += column + " " + operator + " '" + value;
        if (operator.equals("LIKE"))
            SQLWhere += "%";
        SQLWhere += "'";
       
        return SQLWhere;

    }
/*===========================================================================================
#
#	Name			buildWhere
#	
#	Description		Builds a simple Where
#
#==========================================================================================*/
    protected String buildWhere (String[] attributs, String[] values, 
                        String operator) throws TrotException {
        String SQLWhere = " WHERE ";
        String attribut;
        String column;
        boolean first = true;

        for (int i = 0; i < attributs.length; i++) {
            // Find the column to search
            attribut = attributs[i];
            column = mapping.get(attribut);
            if (!first)
                SQLWhere += " AND ";
            
            SQLWhere += column + " " + operator + " '" + values[i];
            if (operator.equals("LIKE"))
                SQLWhere += "%";
            SQLWhere += "'";
            first = false;
        }
       
        return SQLWhere;

    }

/*===========================================================================================
#
#	Name			buildWhere
#	
#	Description		Builds a simple Where
#
#==========================================================================================*/
    protected String buildWhere (String attribut, Integer value, String operator)
        throws TrotException {
        String SQLWhere = " WHERE ";
        String column;

        // Find the column to search
        column = mapping.get(attribut);
        SQLWhere += column + " " + operator + " " + value;
                // En fonction du type
       
        return SQLWhere;
    }
    
    public String name(String name) {
        if (name == null)
            return this.name;
        else {
            this.name = name;
            return null;
        }
    }
    public Integer id(Integer id) {
        if (id == null)
            return this.id;
        else {
            this.id = id;
            return null;
        }
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
