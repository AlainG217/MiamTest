/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */

package multithread;

/**
 *
 * @author stagjava
 */
public class TirageThread extends Thread {
    public Integer nb;
    public Integer[] tires;
    public int index = 0;

    @Override
    public void run() {
//        System.out.println("Début " + this.getName());
        boolean continuer = true;
        boolean found = false;
        try {
        sleep(1000);
        } catch (Exception e) {}
        while (continuer) {
            synchronized (nb) {
                nb = (int)((Math.random())*49);
            }
            for (Integer n : tires) {
                if (n == nb) {
                    found = true;
                    break;
                }               
            }
            if (found == false) {
                tires[index] = nb;
                System.out.print(nb + " , ");
                continuer = false;
            }
            found = false;
        }
//        System.out.println("Fin " + this.getName());

    }
    
}
