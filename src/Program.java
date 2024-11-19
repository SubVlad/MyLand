import Logic.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static java.lang.Thread.sleep;


public class Program extends JFrame implements ActionListener
{
    private JPanel ui;
    private Timer timer;
    public static ArrayList<Thread> threads;

    public static void main(String[] args)
    {
        Program mw = new Program();
    }

    public Program() {
        Session.get();
        threads = new ArrayList<>();
        Session.get().threads = threads;
        initUI();
        addKeyListener(new VisualContentKeyListener());
        setFocusable(true);
        timer = new Timer(150, this); //default delay - 250
        timer.start();
        initFrame();
        threads.add(new Thread(new MainRoutine(),"MainRoutine"));;
        threads.add(new Thread(new RepaintRoutine(),"RepaintRoutine"));
        threads.forEach((n) -> n.start());


    }
    public void initFrame()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Land");
        setResizable(true);
        setVisible(true);
        setSize(615,643);
        setLocationRelativeTo(null);
    }




    public void initUI() {;
        Board currentBoard = Session.get().curBoard;
        ui = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < currentBoard.environments.size(); i++) { // default i < game.curobqu
                    g.drawImage(Session.get().EVCCurrentBoard.get(i).getImage(),
                            Session.get().EVCCurrentBoard.get(i).getVisualContentX() + Session.get().cameraPosition.x,
                            Session.get().EVCCurrentBoard.get(i).getVisualContentY() + Session.get().cameraPosition.y,
                            this);
                }
                for (int i = 0; i < currentBoard.movingVisibles.size(); i++) { // default i < game.curobqu
                    g.drawImage(Session.get().MVCCurrentBoard.get(i).getImage(),
                            Session.get().MVCCurrentBoard.get(i).getVisualContentX() + Session.get().cameraPosition.x,
                            Session.get().MVCCurrentBoard.get(i).getVisualContentY() + Session.get().cameraPosition.y,
                            this);
                }
                for (int i = 0; i < currentBoard.infoPanels.size(); i++) { // default i < game.curobqu
                    g.drawImage(Session.get().IPCurrentBoard.get(i).getImage(),
                            Session.get().IPCurrentBoard.get(i).getVisualContentX(),
                            Session.get().IPCurrentBoard.get(i).getVisualContentY(),
                            this);
                }
            }
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
                currentBoard.boardWidth,
                currentBoard.boardLength));

        add(ui);
    }

    public void pressLeftButton() {
       // System.out.println(getMousePosition());
        Session.get().cursor.netX = getMousePosition().x - 8;
        Session.get().cursor.netY = getMousePosition().y - 30;
        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //repaint(); // здесь - метод, который вызывается по истечению таймера Timer, скорее всего. так или иначе, он вызывается главным тредом, и потому я перенес repaint() в тред движения, так как перерисовывание графики должно происходить после каждого шага каждого объекта, и тогда всё будет выглядеть гладко
    }



    class VisualContentKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_1){
                Session.get().keyNumber = key-48;
            }
            if(key == KeyEvent.VK_2){
                Session.get().keyNumber = key-48;
            }
            if(key == KeyEvent.VK_3){
                Session.get().keyNumber = key-48;
            }
            if(key == KeyEvent.VK_4){
                Session.get().keyNumber = key-48;
            }

            //

            if(key == KeyEvent.VK_A){
                Session.get().players[0].updateButtons(0, 1);
                Session.get().cameraDelta.x = 3;
            }
            if(key == KeyEvent.VK_D){
                Session.get().players[0].updateButtons(1, 1);
                Session.get().cameraDelta.x = -3;
            }
            if(key == KeyEvent.VK_W){
                Session.get().players[0].updateButtons(2, 1);
                Session.get().cameraDelta.y = 3;
            }
            if(key == KeyEvent.VK_S){
                Session.get().players[0].updateButtons(3, 1);
                Session.get().cameraDelta.y = -3;
            }
        }

        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_1){
                Session.get().keyNumber = 0;
            }
            if(key == KeyEvent.VK_2){
                Session.get().keyNumber = 0;
            }
            if(key == KeyEvent.VK_3){
                Session.get().keyNumber = 0;
            }
            if(key == KeyEvent.VK_4){
                Session.get().keyNumber = 0;
            }

            //

            if(key == KeyEvent.VK_A){
                Session.get().players[0].updateButtons(0, 0);
                Session.get().cameraDelta.x = 0;
            }
            if(key == KeyEvent.VK_D){
                Session.get().players[0].updateButtons(1, 0);
                Session.get().cameraDelta.x = 0;
            }
            if(key == KeyEvent.VK_W){
                Session.get().players[0].updateButtons(2, 0);
                Session.get().cameraDelta.y = 0;
            }
            if(key == KeyEvent.VK_S){
                Session.get().players[0].updateButtons(3, 0);
                Session.get().cameraDelta.y = 0;
            }

        }


    }

    /*public static class Cursor
    {
        public static int netX;
        public static int netY;
        public Cursor()
        {
        }
        *//*public static void setX(int netX) {
            this.x = netX;
        }
        public static void setY(int netY) {
            this.netY = netY;
        }*//*
        *//*public int getX() {
            return netX;
        }
        public int getY() {
            return netY;
        }*//*
    }*/
    public class MainRoutine implements Runnable {
        byte waitForGC = 0; // каждые 30 тиков вызывать Сборщик мусора
        int w = 0;
        public synchronized void run() {
            Board currentBoard = Session.get().curBoard;

            while(true){
                try {
                    Thread.sleep(15);  // no more than 15
                } catch (InterruptedException e) {
                }
                for(int i = 0; i < currentBoard.movables.size(); i++){
                    currentBoard.movables.get(i).performMove();
                }
                Session.get().cameraPosition.x += Session.get().cameraDelta.x;
                Session.get().cameraPosition.y += Session.get().cameraDelta.y;

                //the segment bellow allows to decrease the RAM demand by calling the garbage collector all the time
                if(waitForGC == 30){
                    Runtime.getRuntime().gc(); // без этого метода наблюдается постоянный рост потребления ОП
                    waitForGC = 0;
                }else{
                    waitForGC++;
                }
            }
        }
    }
    public class RepaintRoutine implements Runnable {
        public synchronized void run() {
            while(true){
                //System.out.println(Session.get().players[0].getRTBX() + " " + Session.get().players[0].getRTBY());
                try {
                    Thread.sleep(15);  // no more than 15
                } catch (InterruptedException e) {
                }
                ui.repaint();
            }
        }
    }
}