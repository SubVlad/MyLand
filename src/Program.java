import Logic.Game;
import Logic.MovableObject;
import Logic.Velocity;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Program extends JFrame implements ActionListener
{
    private JLabel label;
    private Image image;
    private JPanel ui;
    private Timer timer;
    public boolean ePressed = false;
    public ArrayList<Thread> threads;
    public int sl = 15; // no more than 15

    public static void main(String[] args)
    {
        Program mw = new Program();
    }

    public Program() {
        threads = new ArrayList<>();
        Game game = new Game();
        initUI();
        addKeyListener(new VisualContentKeyListener());
        setFocusable(true);
        timer = new Timer(150, this); //default delay - 250
        timer.start();
        initFrame();
        threads.add(new Thread(new MyThread0(),"MyThread0"));
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




    public void initUI() {
        ui = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < Game.BoardsInGame.get(Game.currentBoard).EVO.size(); i++) { // default i < game.curobqu
                    g.drawImage(Game.EVCCurrentBoard.get(i).getImage(),
                            (int) Game.EVCCurrentBoard.get(i).getRTWX(),
                            (int) Game.EVCCurrentBoard.get(i).getRTWY(), this);
                }
                for (int i = 0; i < Game.BoardsInGame.get(Game.currentBoard).MVO.size(); i++) { // default i < game.curobqu
                    g.drawImage(Game.MVCCurrentBoard.get(i).getImage(),
                            (int) Game.MVCCurrentBoard.get(i).getRTWX(),
                            (int) Game.MVCCurrentBoard.get(i).getRTWY(), this);
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

        ui.setPreferredSize(new Dimension(Game.BoardsInGame.get(Game.currentBoard).boardWidth, Game.BoardsInGame.get(Game.currentBoard).boardLength));

        add(ui);
    }

    public void pressLeftButton() {
       // System.out.println(getMousePosition());
        Game.Cursor.netX = getMousePosition().x - 8;
        Game.Cursor.netY = getMousePosition().y - 30;
        Game.changeHexColor();
        repaint();
    }

    public void move() {

        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //repaint(); // здесь - метод, который вызывается по истечению таймера Timer, скорее всего. так или иначе, он вызывается главным тредом, и потому я перенес repaint() в тред движения, так как перерисовывание графики должно происходить после каждого шага каждого объекта, и тогда всё будет выгляддеть гладко
    }



    class VisualContentKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_1){
                Game.keyNumber = key-48;
            }
            if(key == KeyEvent.VK_2){
                Game.keyNumber = key-48;
            }
            if(key == KeyEvent.VK_3){
                Game.keyNumber = key-48;
            }
            if(key == KeyEvent.VK_4){
                Game.keyNumber = key-48;
            }
            if(key == KeyEvent.VK_W){
                //Game.BoardsInGame[Game.currentBoard].MO.get(Game.players[0].getMovableIndex()).setVelocity(new Velocity(0, -1));
                //Game.players[0].setRTWY(-1);//бля, идея была в том, что б найти визуал-индекс через мувабл-индекс игрока. нужно что б нажатие клавиши
                //Game.players[0].getVisualContent().setRTWY(-1);// придавало велосити игроку, и значение велосити двигало как коллайдер-тело игрока, так и его визуал

                Game.players[0].getVelocity().setDirectionYup(1);
            }    //значит, надо что б программа постоянно вычисляла положение - дельта - на велосити игрока. но для сберегания мощностей, лучше это вычисление начинать при нажатии клавиши или ином ивенте
            if(key == KeyEvent.VK_S){
                Game.players[0].getVelocity().setDirectionYdown(1);
            }
            if(key == KeyEvent.VK_A){
                Game.players[0].getVelocity().setDirectionXleft(1);
            }
            if(key == KeyEvent.VK_D){
                Game.players[0].getVelocity().setDirectionXright(1);
            }



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

        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_1){
                Game.keyNumber = 0;
            }
            if(key == KeyEvent.VK_2){
                Game.keyNumber = 0;
            }
            if(key == KeyEvent.VK_3){
                Game.keyNumber = 0;
            }
            if(key == KeyEvent.VK_4){
                Game.keyNumber = 0;
            }
            if(key == KeyEvent.VK_W){
                Game.players[0].getVelocity().setDirectionYup(0);
            }
            if(key == KeyEvent.VK_S){
                Game.players[0].getVelocity().setDirectionYdown(0);
            }
            if(key == KeyEvent.VK_A){
                Game.players[0].getVelocity().setDirectionXleft(0);
            }
            if(key == KeyEvent.VK_D){
                Game.players[0].getVelocity().setDirectionXright(0);
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
    class MyThread0 implements Runnable {
        public void run() {
            while(true){
                try {
                    Thread.sleep(sl);
                } catch (InterruptedException e) {
                }
                Game.BoardsInGame.get(Game.currentBoard).MO.forEach(MovableObject::move); // default - MO.forEach((n) -> n.move());
                ui.repaint();
            }
        }
    }
}