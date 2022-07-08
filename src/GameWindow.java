import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors


public class GameWindow {
    private JPanel jpanel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JLabel scoreP1;
    private JLabel scoreP2;
    private JLabel move;

    public GameWindow() {
        JButton[] buttons = {button1,button2,button3,button4,button5,button6,button7,button8,button9};
        TicTacToe game = new TicTacToe();
        game.newGame("P1");
        try {
            var xImg = ImageIO.read(new File("x.png"));
            var oImg = ImageIO.read(new File("o.png"));
        }
        catch (IOException e) {
        }
        move.setFont(new Font("Arial", Font.BOLD, 15));
        scoreP1.setFont(new Font("Arial", Font.PLAIN, 15));
        scoreP2.setFont(new Font("Arial", Font.PLAIN, 15));

        move.setText("Ruch gracza "+game.getMove()+" ("+game.getXO()+")");
        scoreP1.setText("");
        scoreP2.setText("");

        scoreP1.setForeground(Color.RED);
        scoreP2.setForeground(Color.BLUE);

        for (JButton jb:buttons) {
            jb.setFont(new Font("Arial", Font.PLAIN, 40));
            jb.setText("");
        }
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String outcome = null;
                var button = e.getSource();
                int i=0;
                for (JButton jb:buttons) {
                    if (jb==button) {
                        outcome= game.makeMove(i);
                        if (game.getMove() == "P1")
                            jb.setForeground(Color.BLUE);
                        else
                            jb.setForeground(Color.RED);
                    }
                    i++;
                }
                i=0;
                for (JButton jb:buttons) {
                    if(game.gameNet[i]>='A' && game.gameNet[i]<='I')
                        jb.setText("");
                    else {
                        jb.setText(String.valueOf(game.gameNet[i]));
                    }
                    i++;
                }
                scoreP1.setText(String.valueOf("P1 wins: "+game.scoreP1));
                scoreP2.setText(String.valueOf("P2 wins: "+game.scoreP2));
                if(outcome!=null) {
                    if (outcome == "P1 WINS")
                        move.setForeground(Color.RED);
                    else if(outcome == "P2 WINS")
                        move.setForeground(Color.BLUE);
                    else
                        move.setForeground(Color.BLACK);
                    move.setText(outcome);
                }
                else {
                    move.setForeground(Color.BLACK);
                    move.setText("Ruch gracza " + game.getMove() + " (" + game.getXO() + ")");
                }
            }
        };
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        button5.addActionListener(listener);
        button6.addActionListener(listener);
        button7.addActionListener(listener);
        button8.addActionListener(listener);
        button9.addActionListener(listener);
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setContentPane(new GameWindow().jpanel1);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setSize(640,480);
        jframe.setVisible(true);
    }
}
