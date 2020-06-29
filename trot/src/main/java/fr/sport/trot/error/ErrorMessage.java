/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.error;

import fr.sport.trot.base.BaseObject;

/**
 *
 * @author alain
 */
public class ErrorMessage extends BaseObject {
    
    public static String getMessage (String errorCode) {
        
        switch (errorCode) {
            case "CSE0001" : return "Ajout enregistrement a échoué ";
            case "CSE0002" : return "Impossible de retrouver les metatdata";
            case "CSE0003" : return "Type de donnée inconnu";
            case "CSE0004" : return "Mise à jour enregistrement a échoué ";
            case "CSE0005" : return "Accès enregistrement a échoué ";
            case "CSE0006" : return "Commit a échoué ";
            case "CCE0001" : return "Méthode setFlags appelée mais type invalide";
            case "CCE0005" : return "Méthode saveObject appelée mais état objet incohérent";
            case "CCE0006" : return "Méthode countRecords appelée sans argument valide";
            case "CCE0007" : return "getter non trouvé";
            default : return "Message d'erreur non trouvé";
        }
    }    
    
}
