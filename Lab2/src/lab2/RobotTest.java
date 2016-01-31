/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tfr5029
 */
public class RobotTest {
    public static void main(String[] args){
        try {
            Robot r = new Robot();
            r.mouseMove(0,0);
            for(int i = 0; i<500; i++){
                r.mouseMove(i, 100);
                
            }
        } catch (AWTException ex) {
            Logger.getLogger(RobotTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
