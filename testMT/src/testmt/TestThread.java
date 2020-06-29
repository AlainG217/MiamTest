/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmt;

/**
 *
 * @author stagjava
 */
public class TestThread extends Thread{

    @Override
    public void run() {
        System.out.println("Thread no2");
        try {
        sleep(10000);
        } catch (Exception e) {}
        System.out.println("Thread no2");
    }
    
}
