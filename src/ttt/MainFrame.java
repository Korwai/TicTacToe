package ttt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    private MainPanel mp;
    private JTextArea jta;

    public MainFrame() {
        super("Tic Tac Toe");
        setLayout(new BorderLayout());

        mp = new MainPanel();
        jta = new JTextArea();

        add(mp, BorderLayout.SOUTH);
        add(jta, BorderLayout.NORTH);

        jta.setSize(800, 200);
        jta.setVisible(true);
        jta.setEditable(false);
        jta.append("O's turn!");

        setSize(550, 550);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        for(int rows = 0; rows < mp.getBtns().getBoard().length; rows++) {
            for (int cols = 0; cols < mp.getBtns().getBoard()[rows].length; cols++) {
                mp.getBtns().getBoard()[rows][cols].addActionListener(this);
            }
        }

    }

    public MainPanel getMp() {
        return mp;
    }

    public JTextArea getJta() {
        return jta;
    }

    public void switchTurnText() {
        jta.setLineWrap(true);
        if (mp.getTurn() == 1) {
            jta.setText("");
            jta.append("X's turn!");
        } else {
            jta.setText("");
            jta.append("O's turn!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        switchTurnText();
        if(mp.getBtns().checkWin()) {
            char winner = mp.getBtns().getWinner();
            jta.setText("");
            if(winner == 'X')
                jta.append("X won the game!");
            else if(winner == 'O') {
                jta.setText("O won the game!");
            }
        }
        if(mp.getBtns().checkSlots()) {
            jta.setText("It's a tie! No winner!");
        }

    }
}
