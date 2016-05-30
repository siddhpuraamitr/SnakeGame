package snake;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame implements Runnable, KeyListener {

    JLabel label[] = new JLabel[700];
    int remem[] = new int[700];
    int cle[] = new int[700];
    
    Thread th;
    int time = 500, k = 0, score = 0, size = 5, er = 0, temp = 0, s = 2, foo;
    ImageIcon b, w, green;
    int l[];

    Main() {
        time = 10;
        l = new int[1000];
        l[0] = 105;
        l[1] = 106;
        l[2] = 107;
        l[3] = 108;
        l[4] = 109;
        setLayout(null);
        addKeyListener(this);
        b = new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/battlefield/src/battlefield/a.png");
        w = new ImageIcon("/Users/Amit/Desktop/My Netbean Projects/battlefield/src/battlefield/a.png");
        for (int i = 0; i < 601; i++) {
            label[i] = new JLabel();
        }


        for (int i = 0; i < 520; i = i + 20) {
            for (int j = 0; j < 400; j = j + 20) {
                label[k].setBounds(j, i, 20, 20);

                label[k].setBorder(BorderFactory.createLineBorder(Color.black));
                add(label[k]);
                k++;

            }
        }
        food();
        label[600].setBounds(420, 0, 80, 80);
        label[600].setFont(new Font("Arial", Font.BOLD, 40));
        label[600].setText(score + "");
        label[599].setBounds(410, 50, 120, 80);
        label[599].setFont(new Font("Arial", Font.BOLD, 20));
        label[599].setText("High Score");
        label[598].setBounds(410, 150, 120, 80);
        label[598].setFont(new Font("Arial", Font.BOLD, 20));
        label[597].setBounds(410, 200, 120, 80);
        label[597].setFont(new Font("Arial", Font.BOLD, 20));
        label[596].setBounds(410, 250, 120, 80);
        label[596].setFont(new Font("Arial", Font.BOLD, 20));
        add(label[600]);
        add(label[599]);
        add(label[598]);
        add(label[597]);
        add(label[596]);

        setSize(600, 600);

        th = new Thread(this);
        th.start();

    }

    public void run() {
        while (true) {

            draw();
            move();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("" + e);

            }

            clear();
        }
    }

    public void food() {

        regen:
        for (int o = 0; o < 1; o++) {
            foo = (int) (Math.random() * 519);
            for (int i = 0; i < size; i++) {
                if (foo == l[i]) {
                    continue regen;
                }
            }
        }

    }

    public void draw() {

        for (int i = 0; i <= 501; i += 20) {
            for (int j = i; j <= i + 19; j++) {
                remem[j] = 0;
            }
        }

        for (int i = 0; i < size; i++) {
            remem[l[i]] = 1;
        }
        remem[foo] = 1;
    }

    public void clear() {
        for (int i = 0; i < 520; i++) {
            if (remem[i] == 0) {
                label[i].setIcon(null);
            } else {
                label[i].setIcon(b);
            }
        }
    }

    public void move() {

        temp = l[0];
        line();
        switch (er) {
            case 0:
                if (0 != l[0] && 20 != l[0] && 40 != l[0] && 60 != l[0] && 80 != l[0] && 100 != l[0] && 120 != l[0] && 140 != l[0] && 160 != l[0] && 180 != l[0] && 200 != l[0] && 220 != l[0] && 240 != l[0] && 260 != l[0] && 280 != l[0] && 300 != l[0] && 320 != l[0] && 340 != l[0] && 360 != l[0] && 380 != l[0] && 400 != l[0] && 420 != l[0] && 440 != l[0] && 460 != l[0] && 480 != l[0] & 500 != l[0]) {
                    l[0] -= 1;       //left
                } else {
                    l[0] += 19;
                }
                break;
            case 1:
                if (19 != l[0] && 39 != l[0] && 59 != l[0] && 79 != l[0] && 99 != l[0] && 119 != l[0] && 139 != l[0] && 159 != l[0] && 179 != l[0] && 199 != l[0] && 219 != l[0] && 239 != l[0] && 259 != l[0] && 279 != l[0] && 299 != l[0] && 319 != l[0] && 339 != l[0] && 359 != l[0] && 379 != l[0] && 399 != l[0] && 419 != l[0] && 439 != l[0] && 459 != l[0] && 479 != l[0] && 499 != l[0] && 519 != l[0]) {
                    l[0] += 1;       //right
                } else {
                    l[0] -= 19;
                }
                break;
            case 2:
                if (0 != l[0] && 1 != l[0] && 2 != l[0] && 3 != l[0] && 4 != l[0] && 5 != l[0] && 6 != l[0] && 7 != l[0] && 8 != l[0] && 9 != l[0] && 10 != l[0] && 11 != l[0] && 12 != l[0] && 13 != l[0] && 14 != l[0] && 15 != l[0] && 16 != l[0] && 17 != l[0] && 18 != l[0] && 19 != l[0]) {
                    l[0] -= 20;      //up
                } else {
                    l[0] += 500;
                }
                break;
            case 3:
                if (500 != l[0] && 501 != l[0] && 502 != l[0] && 503 != l[0] && 504 != l[0] && 505 != l[0] && 506 != l[0] && 507 != l[0] && 508 != l[0] && 509 != l[0] && 510 != l[0] && 511 != l[0] && 512 != l[0] && 513 != l[0] && 514 != l[0] && 515 != l[0] && 516 != l[0] && 517 != l[0] && 518 != l[0] && 519 != l[0]) {
                    l[0] += 20;      //down
                } else {
                    l[0] -= 500;
                }
                break;

        }
        //    line();
        if (foo == l[1]) {
            size++;
            label[600].setText((score = score + 10) + "");
            l[size - 1] = l[2];
            food();
        }
        collide();
    }

    public void collide() {
        for (int i = 2; i <= size; i++) {
            if (l[1] == l[i]) {
                JOptionPane.showMessageDialog(this, "Game Over");
                System.exit(1);
            }
        }
    }

    public void line() {

        for (s = size - 1; s > 1; s--) {
            l[s] = l[s - 1];
        }
        l[1] = temp;
    }

    public static void main(String[] args) {
        Main ob = new Main();
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.setVisible(true);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
       
        
        switch(e.getKeyCode()){
            case 40:
                er = 3;
                break;
            case 38:
                er = 2;
                break;
            case 39:
                er = 1;
                break;
            case 37:
                er = 0;
                break;
        }
        
    }
}
