package lab2;



import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class MyAWTEventListener implements AWTEventListener {

    private ArrayList<MouseEvent> mouseEventArrayList = new ArrayList<>();

    public MyAWTEventListener() {
    }

    @Override
    public void eventDispatched(AWTEvent event) {
        //Cast AWTEvent to a mouse event
        MouseEvent me = (MouseEvent) event;



        if(me.getID() == MouseEvent.MOUSE_CLICKED){
            mouseEventArrayList.add(me);
            System.out.println(me.getSource());
            //JTextField jtf = (JTextField) me.getSource();
            //jtf.setText("12345");

        }

    }

    public ArrayList<MouseEvent> getMouseEvents(){
        return mouseEventArrayList;
    }
}
