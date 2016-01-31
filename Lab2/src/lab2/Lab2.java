/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import gui.MyGUI;
import java.awt.AWTEvent;
import java.awt.Toolkit;

/**
 *
 * @author tfr5029
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyGUI.main(args);
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        MyAWTEventListener ml = new MyAWTEventListener();
        
        toolkit.addAWTEventListener(ml, AWTEvent.MOUSE_EVENT_MASK);
    }
    
}

//Failed Values
/**
 * 10101 + 10101 = 20203
 * 10101 + 10105 = 20207
 * 10101 + 20 = 10122
 * 10101 + 1 = 10103
 * 101010 + 1 = 101012
 * 101010 + 15 = 101026
*/

//Working Values
/**
 * 1 + 1 = 2
 * 3 + 3 = 6
 * 10 + 9 = 19
 * 13 + 9 = 22
 */
