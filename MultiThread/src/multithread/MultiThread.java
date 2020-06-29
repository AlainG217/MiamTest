/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multithread;

/**
 *
 * @author stagjava
 */
public class MultiThread {

    /**
     * @param args the command line arguments
     */
// Option 2 pas très élégante. Il doit y avoir moyen de faire mieux
    public static void main(String[] args) {
        Integer nb = 0;
        Integer[] tires = new Integer[6];
            System.out.println(tires.length);

        System.out.println("Début ");
        TirageThread t1 = new TirageThread();
        t1.nb = nb;
        t1.index = 0;
        t1.tires = tires;
        TirageThread t2 = new TirageThread();
        t2.nb = nb;
        t2.tires = tires;
        t2.index = 1;
        TirageThread t3 = new TirageThread();
        t3.nb = nb;
        t3.index = 2;
        t3.tires = tires;
        TirageThread t4 = new TirageThread();
        t4.nb = nb;
        t4.index = 3;
        t4.tires = tires;
        TirageThread t5 = new TirageThread();
        t5.nb = nb;
        t5.index = 4;
        t5.tires = tires;
        TirageThread t6 = new TirageThread();
        t6.nb = nb;
        t6.index = 5;
        t6.tires = tires;
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (Exception e) {}
        System.out.println("");
        System.out.println("Fin ");

    }

}
