package ttt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private Buttons btns;
    private GridLayout gl;

    public MainPanel() {

        gl = new GridLayout(3, 3, 20, 20);

        btns = new Buttons(this);
        btns.initialize();

        setLayout(gl);

        setPreferredSize(new Dimension(500, 500));
        setVisible(true);


    }

    public Buttons getBtns() {
        return btns;
    }

    public int getTurn() {

        return btns.getTurn();
    }

}
