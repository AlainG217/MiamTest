/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja47;

/**
 *
 * @author stagjava
 */
public class Camion  extends Vehicule {
    private int charge;
    
    public void charger (int charge) {
        setCharge(charge);
    }
    
    public void afficher () {
        super.afficher();
        System.out.println("Charge: " + charge);
    }
    public void setCharge(int charge) {
        if (charge > 0) {
            this.charge = charge;
        } else {
            System.out.println("Charge doit être positive");
        }
    }
    
    public int getCharge () {
        return charge;
    }
    
}
