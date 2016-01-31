package Part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.regex.Pattern;

/**
 * Lab1.Part2
 * thomasroseman on 1/12/16
 */
public class StartWindow {
    private JButton startButton;
    private JPanel rootpanel;
    private JTextField nameField;
    private JTextField ageField;
    private InputDialog inputDialog;


    private boolean name = false;
    private boolean age = false;
    private int AGE;

    public StartWindow() {
        startButton.setEnabled(false);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDialog = new InputDialog(nameField.getText(), ageField.getText());
                inputDialog.pack();
                inputDialog.setVisible(false);

            }
        });

        nameField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                if ((!Pattern.matches("([A-z]\\-?\\s?,?)*", nameField.getText())) || nameField.getText().equals("")) {
                    name = false;
                    System.out.println("Name is bad");
                    return false;
                }
                name = true;
                check();
                System.out.println("Name is okay");
                return true;
            }
        });

        ageField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                try {
                    AGE = Integer.parseInt(ageField.getText());
                } catch (NumberFormatException e) {
                    System.out.println("There was no number to convert");
                    AGE = -1;
                }
                if ((AGE > 100) || (AGE < 0)) {
                    age = false;
                    return false;
                }
                age = true;
                check();
                return true;
            }
        });

        rootpanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                check();
            }
        });
    }

    private void check() {
        if (name && age) {
            startButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StartWindow");
        frame.setContentPane(new StartWindow().rootpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootpanel = new JPanel();
        rootpanel.setLayout(new GridBagLayout());
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootpanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        rootpanel.add(spacer2, gbc);
        startButton = new JButton();
        startButton.setMaximumSize(new Dimension(150, 48));
        startButton.setMinimumSize(new Dimension(75, 32));
        startButton.setText("Go");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootpanel.add(startButton, gbc);
        nameField = new JTextField();
        nameField.setColumns(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootpanel.add(nameField, gbc);
        ageField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootpanel.add(ageField, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        rootpanel.add(spacer3, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootpanel;
    }
}
