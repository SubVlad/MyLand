import Logic.VisualContent;
import Logic.Game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.MouseInfo.getPointerInfo;


public class UI extends JPanel implements ActionListener {

    private JPanel ui;
    private Timer timer;
    public boolean ePressed = false;

    public UI() {
        setBackground(Color.black);
        Game game = new Game();
        initUI();
        addKeyListener(new VisualContentKeyListener());
        setFocusable(true);
        timer = new Timer(250, this);
        timer.start();
    }


    public void initUI() {
        ui = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < Game.curobqu; i++) {
                    g.drawImage(Game.EVCCurrentBoard.get(i).getImage(),
                            (int) Game.EVCCurrentBoard.get(i).getRTWX(),
                            (int) Game.EVCCurrentBoard.get(i).getRTWY(), this);
                }
            }

            ;
        };

        ui.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1)
                    pressLeftButton();

                ui.repaint();
            }
        });

        ui.setPreferredSize(new Dimension(Game.BoardsInGame.get(Game.currentBoard).boardWidth, Game.BoardsInGame.get(Game.currentBoard).boardLength));

        add(ui);
    }

    public void pressLeftButton() {
        System.out.println(getMousePosition());
    }

    public void move() {

        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }



    class VisualContentKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();



            /*if (key == KeyEvent.VK_A && Game.EVCCurrentBoard.get(Game.curobqu - 1).getRTWX() != 0) {
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTWX(Game.EVCCurrentBoard.get(Game.curobqu - 1).getRTWX() - 1);
                move();
            }
            if (key == KeyEvent.VK_D && Game.EVCCurrentBoard.get(Game.curobqu - 1).getRTWX() != Game.rangeX) {
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTWX(Game.EVCCurrentBoard.get(Game.curobqu - 1).getRTWX() + 1);
                move();
            }
            if (key == KeyEvent.VK_W && Game.EVCCurrentBoard.get(Game.curobqu - 1).getRTWY() != 0) {
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTWY(Game.EVCCurrentBoard.get(Game.curobqu - 1).getRTWY() - 1);
                move();
            }
            if (key == KeyEvent.VK_S && Game.EVCCurrentBoard.get(Game.curobqu - 1).getRTWY() != Game.rangeY) {
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTWY(Game.EVCCurrentBoard.get(Game.curobqu - 1).getRTWY() + 1);
                move();
            }
            if (key == KeyEvent.VK_E && Game.EVCCurrentBoard.get(Game.curobqu - 1).getRTWX() == 0 &&
                    Game.EVCCurrentBoard.get(Game.curobqu - 1).getRTWY() == 0) {

                System.out.println("curloc = " + Game.curloc);
                System.out.println("EVCCurrentBoard - " + Game.EVCCurrentBoard.get(0).getName());
                Game.curloc = 1;
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTWX(1);
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTWY(1);
                Game.changeBoard();
                move();
            }*/
        }
    }
}