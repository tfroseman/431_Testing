package lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Lab2.lab2
 * thomasroseman on 1/20/16
 */
public class AWTEventTester implements AWTEventListener {
    private int count=0;
    private JTextField box1, box2, box3;
    private JButton submit;
    /**
     * Invoked when an event is dispatched in the AWT.
     *
     * @param event
     */
    @Override
    public void eventDispatched(AWTEvent event) {
        //fill
        //fill
        //button
        //get
        MouseEvent me = (MouseEvent) event;
        //System.out.println(event);
        //System.out.println(event.getID());
        //System.out.println(event.paramString());
        System.out.println(me.getSource());
        //System.out.println(me.getPoint());
        if(me.getID() == MouseEvent.MOUSE_CLICKED){
            if(me.getSource().equals(JTextField.class) && count == 0){
                //First box
                box1 = (JTextField) me.getSource();
                box1.setText("value");
                count ++;
            }
            JTextField jtf = (JTextField) me.getSource();
            jtf.setText("12345");

            //System.out.println(me.getSource());
        }
    }

    public AWTEventTester(ArrayList values){

    }
}
