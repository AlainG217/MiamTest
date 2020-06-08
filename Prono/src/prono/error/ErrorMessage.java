/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prono.error;

import prono.base.BaseObject;

/**
 *
 * @author alain
 */
public class ErrorMessage extends BaseObject {
    
    public static String getMessage (String errorCode) {
        
        switch (errorCode) {
            case "CSE0001" : return "Ajout enregistrement a échoué ";
            case "CSE0005" : return "Accès enregistrement a échoué ";
            case "CCE0005" : return "Méthode saveObject appelée mais état objet incohérent";
            case "CCE0006" : return "Méthode countRecords appelée sans argument valide";
            case "CCE0007" : return "getter non trouvé";
            default : return "Message d'erreur non trouvé";
        }
    }    
    
}
