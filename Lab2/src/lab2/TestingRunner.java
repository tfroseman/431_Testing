/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class TestingRunner implements Runnable {
    private Point box1, box2, box3, submit;
    private int sleep;
    private File file;
    private ArrayList<TestingValues> testingValuesArrayList;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String line;
    private Robot robot;
    private Toolkit toolkit;


    public TestingRunner(Point box1, Point box2, Point box3, Point submit, File file, int sleep, Toolkit toolkit) {
        this.box1 = box1;
        this.box2 = box2;
        this.box3 = box3;
        this.submit = submit;
        this.sleep = sleep;
        this.file = file;
        this.toolkit = toolkit;
        this.testingValuesArrayList = new ArrayList<>();
    }

    private void parseFile(){
        try {
            fileReader = new FileReader(file);
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

    private void test(){
        AWTEventTester awtEventTester = new AWTEventTester(testingValuesArrayList);
        try {
            toolkit.addAWTEventListener(awtEventTester, AWTEvent.MOUSE_EVENT_MASK);
            robot = new Robot();
            for (int i = 0; i < testingValuesArrayList.size(); i++) {
                robot.mouseMove(box1.x, box1.y);
                robot.mousePress(1);
                
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        parseFile();
        test();
    }
    
}
