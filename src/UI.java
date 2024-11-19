import Logic.Session;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class UI extends JPanel implements ActionListener {

    private JPanel ui;
    private Timer timer;
    public boolean ePressed = false;

    public UI() {
        setBackground(Color.black);
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
                for (int i = 0; i < Session.get().curobqu; i++) {
                    g.drawImage(Session.get().EVCCurrentBoard.get(i).getImage(),
                            (int) Session.get().EVCCurrentBoard.get(i).getVisualContentX(),
                            (int) Session.get().EVCCurrentBoard.get(i).getVisualContentY(), this);
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

        ui.setPreferredSize(new Dimension(
                Session.get().BoardsInGame.get(Session.get().currentBoardIndex).boardWidth,
                Session.get().BoardsInGame.get(Session.get().currentBoardIndex).boardLength));
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



            /*if (key == KeyEvent.VK_A && Game.EVCCurrentBoard.get(Game.curobqu - 1).getVisualContentX() != 0) {
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTBX(Game.EVCCurrentBoard.get(Game.curobqu - 1).getVisualContentX() - 1);
                move();
            }
            if (key == KeyEvent.VK_D && Game.EVCCurrentBoard.get(Game.curobqu - 1).getVisualContentX() != Game.rangeX) {
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTBX(Game.EVCCurrentBoard.get(Game.curobqu - 1).getVisualContentX() + 1);
                move();
            }
            if (key == KeyEvent.VK_W && Game.EVCCurrentBoard.get(Game.curobqu - 1).getVisualContentY() != 0) {
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTBY(Game.EVCCurrentBoard.get(Game.curobqu - 1).getVisualContentY() - 1);
                move();
            }
            if (key == KeyEvent.VK_S && Game.EVCCurrentBoard.get(Game.curobqu - 1).getVisualContentY() != Game.rangeY) {
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTBY(Game.EVCCurrentBoard.get(Game.curobqu - 1).getVisualContentY() + 1);
                move();
            }
            if (key == KeyEvent.VK_E && Game.EVCCurrentBoard.get(Game.curobqu - 1).getVisualContentX() == 0 &&
                    Game.EVCCurrentBoard.get(Game.curobqu - 1).getVisualContentY() == 0) {

                System.out.println("curloc = " + Game.curloc);
                System.out.println("EVCCurrentBoard - " + Game.EVCCurrentBoard.get(0).getName());
                Game.curloc = 1;
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTBX(1);
                Game.EVCCurrentBoard.get(Game.curobqu - 1).setRTBY(1);
                Game.changeBoard();
                move();
            }*/
        }
    }
}