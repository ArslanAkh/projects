import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class ZeroAndCross implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    int size = 450;

    Font timesPlainFont50 = new Font("TimesRoman", Font.PLAIN, 50);
    Font timesPlainFont100 = new Font("TimesRoman", Font.PLAIN, 100);

    ZeroAndCross() {

        frame.setResizable(false);
        frame.setLocation(750, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size, size);
        frame.getContentPane().setBackground(new Color(60, 60, 60));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(45, 45, 45));
        textfield.setForeground(new Color(25, 150, 0));
        textfield.setFont(timesPlainFont50);
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Cross & Zero");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, size, 50);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(100, 100, 100));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(timesPlainFont100);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(155, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 135));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }

    }

    public void firstTurn() {

        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        // check X win conditions
        if (
                (buttons[0].getText().equals("X")) &&
                (buttons[1].getText().equals("X")) &&
                (buttons[2].getText().equals("X"))
        ) {
            xWins(0,1,2);
        }

        if (
                (buttons[3].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[5].getText().equals("X"))
        ) {
            xWins(3,4,5);
        }

        if (
                (buttons[6].getText().equals("X")) &&
                        (buttons[7].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(6,7,8);
        }

        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[3].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(0,3,6);
        }

        if (
                (buttons[1].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[7].getText().equals("X"))
        ) {
            xWins(1,4,7);
        }

        if (
                (buttons[2].getText().equals("X")) &&
                        (buttons[5].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(2,5,8);
        }

        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(0,4,8);
        }

        if (
                (buttons[2].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(2,4,6);
        }

        // check O win conditions
        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[1].getText().equals("O")) &&
                        (buttons[2].getText().equals("O"))
        ) {
            oWins(0,1,2);
        }

        if (
                (buttons[3].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[5].getText().equals("O"))
        ) {
            oWins(3,4,5);
        }

        if (
                (buttons[6].getText().equals("O")) &&
                        (buttons[7].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(6,7,8);
        }

        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[3].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(0,3,6);
        }

        if (
                (buttons[1].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[7].getText().equals("O"))
        ) {
            oWins(1,4,7);
        }

        if (
                (buttons[2].getText().equals("O")) &&
                        (buttons[5].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(2,5,8);
        }

        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(0,4,8);
        }

        if (
                (buttons[2].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(2,4,6);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i<buttons.length;i++) {
            buttons[i].setEnabled(false);
            textfield.setText("X wins");
        }
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i<buttons.length;i++) {
            buttons[i].setEnabled(false);
            textfield.setText("O wins");
        }
    }

}
