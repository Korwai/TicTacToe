package ttt;

import javax.swing.*;

public class TextRegion extends JPanel {
    private JTextArea jta;

    public TextRegion() {
        jta = new JTextArea();
        jta.setSize(800, 300);
        jta.setVisible(true);
    }

    public JTextArea getJta(){
        return jta;
    }
}
