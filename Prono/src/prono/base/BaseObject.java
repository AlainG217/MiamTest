/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prono.base;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author alain
 */
public class BaseObject {
    protected int id;
    protected String name;
    protected int objectState;
    protected int errorId;
    protected String errorMsg;

    protected BaseObject() {
        id = 0;
        name = "";
        objectState = 0;
        errorId = 0;
        errorMsg = "";
    }
    
    public Integer id(Integer id) {
        if (id == null)
            return this.id;
        else {
            this.id = id;
            return null;
        }
    }
    
    public String name(String name) {
        if (name == null)
            return this.name;
        else {
            this.name = name;
            return null;
        }
    }

    public int getObjectState() {
        return objectState;
    }

    public void setObjectState(int objectState) {
        this.objectState = objectState;
    }

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseObject other = (BaseObject) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
}
