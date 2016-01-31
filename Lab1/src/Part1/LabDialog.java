package Part1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class LabDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField namefield;
    private JTextField agefield;
    private JLabel namelabel;
    private JLabel agelabel;


    public LabDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        namefield.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                return !((namefield.getText().length() > 15) || !Pattern.matches("([A-z]\\-?\\s?,?)*", namefield.getText()) || namefield.getText().equals(""));
            }
        });


        namefield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);

                try {
                    checkName();
                } catch (NameException e1) {
                    e1.printStackTrace();
                }
            }
        });

        agefield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyTyped(e);

                try {
                    checkAge();
                } catch (AgeException e1) {
                    e1.printStackTrace();
                    agefield.setText("0");
                }
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        LabDialog dialog = new LabDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void checkName() throws NameException {
        if (namefield.getText().length() > 15) {
            namelabel.setText("Name can not be longer than 15 characters");
            throw new NameException("Name is too long");
        } else if (!Pattern.matches("([A-z]\\-?\\s?,?)*", namefield.getText())) {
            namelabel.setText("Names can only use A-z , - or spaces");
            throw new NameException("Name has invalid char");
        } else {
            namelabel.setText("");
        }
    }

    private void checkAge() throws AgeException {
        try {
            if (Integer.parseInt(agefield.getText()) > 100) {
                agelabel.setText("Age is too large");
                throw new AgeException("Age is too large");
            } else if (Integer.parseInt(agefield.getText()) < 0) {
                agelabel.setText("Age is too small");
                throw new AgeException("Age is too small");
            } else {
                agelabel.setText("");
                System.out.println(agefield.getText());
            }
        } catch (Exception e) {
            agefield.setText("0");
        }
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
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        contentPane.setMinimumSize(new Dimension(100, 100));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(panel1, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        buttonOK = new JButton();
        buttonOK.setText("OK");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel2.add(buttonOK, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(panel3, gbc);
        namefield = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(namefield, gbc);
        agefield = new JTextField();
        agefield.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(agefield, gbc);
        namelabel = new JLabel();
        namelabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(namelabel, gbc);
        agelabel = new JLabel();
        agelabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(agelabel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}