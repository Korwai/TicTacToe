package ttt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons implements ActionListener {
    private JButton[][] board;
    private JButton[][] winLines;
    private MainPanel mp;
    private int turn;
    private char winner;

    public Buttons(MainPanel mp) {
        board = new JButton[3][3];
        this.mp = mp;
        turn = 1;
    }

    public JButton[][] initialize() {
        for(int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols < board[rows].length; cols++) {
                board[rows][cols] = new JButton("Click me!");
                board[rows][cols].setSize(new Dimension(100, 100));
                board[rows][cols].addActionListener(this);
                mp.add(board[rows][cols]);
            }
        }
        return board;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if(clicked.getText().equals("X") || clicked.getText().equals("O")) {
            System.out.println("Cannot put new symbol here! This button has already been taken by: " + clicked.getText());
        } else if (turn == 0) {
            clicked.setText("X");
            clicked.setFont(new Font("Arial", Font.PLAIN, 70));
            turn = 1;
        } else if (turn == 1) {
            turn = 0;
            clicked.setText("O");
            clicked.setFont(new Font("Arial", Font.PLAIN, 70));
        }

        if (checkWin()) {
            stopInteraction();
        }
        if(checkSlots() && !checkWin()) {
            stopInteraction();
            System.out.println("It's a tie!");
        }

    }

    public JButton[][] getBoard() {
        return board;
    }

    public boolean checkWin() {
        String[][] winLines = new String[8][];
        winLines[0] = new String[]{board[0][0].getText(), board[0][1].getText(), board[0][2].getText()};
        winLines[1] = new String[]{board[1][0].getText(), board[1][1].getText(), board[1][2].getText()};
        winLines[2] = new String[]{board[1][0].getText(), board[1][1].getText(), board[1][2].getText()};
        winLines[2] = new String[]{board[2][0].getText(), board[2][1].getText(), board[2][2].getText()};
        winLines[3] = new String[]{board[0][0].getText(), board[1][0].getText(), board[2][0].getText()};
        winLines[4] = new String[]{board[0][1].getText(), board[1][1].getText(), board[2][1].getText()};
        winLines[5] = new String[]{board[0][2].getText(), board[1][2].getText(), board[2][2].getText()};
        winLines[6] = new String[]{board[0][0].getText(), board[1][1].getText(), board[2][2].getText()};
        winLines[7] = new String[]{board[2][0].getText(), board[1][1].getText(), board[0][2].getText()};

        boolean win = false;
        for (int i = 0; i <= 7; i++) {
            String first;
            if(!winLines[i][0].equals("Click me!")) {
                first = winLines[i][0];
                if (winLines[i][1].equals(first) && winLines[i][2].equals(first)) {
                    if(turn==0) {
                        winner = 'O';
                    }
                    if(turn==1) {
                        winner = 'X';
                    }
                    win = true;
                }
            }
        }
        return win;
    }

    public boolean checkSlots() {
        boolean filled = true;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[j][i].getText().equals("Click me!")) {
                    filled = false;
                }
            }
        }
        return filled;
    }

    public void stopInteraction() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[j][i].removeActionListener(this);
            }
        }

    }

    public int getTurn() {
        return turn;

    }

    public char getWinner() {
        return winner;
    }
}
