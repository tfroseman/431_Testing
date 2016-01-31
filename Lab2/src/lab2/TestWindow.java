package lab2;

import gui.MyGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * Lab2.lab2
 * thomasroseman on 1/19/16
 */
public class TestWindow {
    private JPanel panel1;
    private JButton loadFileButton;
    private JButton selectFieldsButton;
    private JButton resetButton;
    private JButton startButton;
    private JSlider speed_slider;
    private JTextArea textArea1;

    private Point box1, box2, box3, submit;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private MyAWTEventListener ml;
    private JFileChooser fileChooser;
    private File testing_file;
    private ArrayList<TestingValues> testingValuesArrayList;
    private ArrayList<MouseEvent> mouseEventArrayList;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String line;

    public TestWindow() {

        testingValuesArrayList = new ArrayList<>();
        mouseEventArrayList = new ArrayList<>();

        /**
         * Load in a selected file that contains values to use.
         */
        loadFileButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();

                int returnvalue = fileChooser.showOpenDialog(loadFileButton);
                if(returnvalue == JFileChooser.APPROVE_OPTION){
                    testing_file = fileChooser.getSelectedFile();
                    log(testing_file.getAbsolutePath());
                    System.out.println("File chosen");

                    parseFile(testing_file);
                }else{
                    System.out.println("File browser closed");
                }
            }
        });

        /**
         * Record the fields to test against.
         * We will want to capture both insert and sum fields as well as the button
         * Then record those values back to the log area.
         * TODO: Move to new design explained by Dr. Wang
         */
        selectFieldsButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e Action Event called by system
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //Bring up ui to test on
                MyGUI myGUI = new MyGUI();
                myGUI.setVisible(true);

                //Load AWTEventListener
                ml = new MyAWTEventListener();
                //Filter on mouse events
                toolkit.addAWTEventListener(ml, AWTEvent.MOUSE_EVENT_MASK);


            }
        });

        /**
         * Start the test.
         * TODO: Move to new design explained by Dr. Wang
         */
        startButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //Grab the events where a user clicked on 3 fields and a single button
                mouseEventArrayList = ml.getMouseEvents();

                //TODO Remove these lines?
                //Remove listener as it is no longer needed
                //toolkit.removeAWTEventListener(ml);

                for (TestingValues aTestingValuesArrayList : testingValuesArrayList) {
                    //Set first text box
                    JTextField firstbox = (JTextField) mouseEventArrayList.get(1).getSource();
                    firstbox.setText(Integer.toString(aTestingValuesArrayList.getPos1()));

                    //Set second
                    firstbox = (JTextField) mouseEventArrayList.get(2).getSource();
                    firstbox.setText(Integer.toString(aTestingValuesArrayList.getPos2()));

                    //Push Button
                    JButton startbutton = (JButton) mouseEventArrayList.get(4).getSource();
                    startbutton.doClick();

                    //Get Calculated value
                    firstbox = (JTextField) mouseEventArrayList.get(3).getSource();
                    int calculatedfinal = Integer.parseInt(firstbox.getText());
                    log(aTestingValuesArrayList.getActualsum() - calculatedfinal);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }


            }
        });

        /**
         * Clear application values
         * TODO: Clear any new values
         */
        resetButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                ml = null;
            }
        });

        log("Starting Test...\nStart by clicking Set 'Fields' then each of the 2 text boxes and "
                + "the submit button. Load your test file relative to "
                + "execute location. Then you may start the test.");
    }

    /**
     * @param testing_file A file that has been selected to load that contains two values and their correct sum
     */
    private void parseFile(File testing_file){
        try {
            fileReader = new FileReader(testing_file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            while((line = bufferedReader.readLine()) != null){
                testingValuesArrayList.add(new TestingValues(line.split(",")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param message A non carriage return string to log to the textarea
     */
    private void log(String message){
        textArea1.append(message + "\n");
    }

    /**
     *
     * @param value An int to be logged to the textarea
     */
    private void log(int value){
        textArea1.append(String.valueOf(value));
    }

    /**
     * Will reset values in application
     */
    private void reset(){
        Point clear;
        clear = new Point(0,0);
        textArea1.setText("");
        box1 = clear; box2 = clear; submit = clear;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TestWindow");
        frame.setContentPane(new TestWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
