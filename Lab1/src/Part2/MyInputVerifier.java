package Part2;

import javax.swing.*;

public class MyInputVerifier extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
        JTextField name = (JTextField) input;
        return name.getText().length() <= 10;
    }
}
