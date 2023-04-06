package com.leetcode.test;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-04-06-[下午 8:50]-周四
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fireworks extends JPanel {

    private ArrayList<Particle> particles = new ArrayList<>();
    private Random rand = new Random();

    public Fireworks() {
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                explode(e.getX(), e.getY());
            }
        });
    }

    public void explode(int x, int y) {
        for (int i = 0; i < 100; i++) {
            particles.add(new Particle(x, y));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Particle p : particles) {
            g.setColor(p.color);
            g.fillOval(p.x, p.y, 10, 10);
        }
    }

    private class Particle {
        public int x, y, vx, vy;
        public Color color;

        public Particle(int x, int y) {
            this.x = x;
            this.y = y;
            this.vx = rand.nextInt(20) - 10;
            this.vy = rand.nextInt(20) - 10;
            this.color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        }

        public void move() {
            x += vx;
            y += vy;
            vy += 1;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fireworks");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fireworks fireworks = new Fireworks();
        frame.add(fireworks);
        frame.setVisible(true);
        while (true) {
            fireworks.repaint();
            for (Particle p : fireworks.particles) {
                p.move();
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

