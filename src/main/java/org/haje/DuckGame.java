package org.haje;

import org.haje.ducks.DecoyDuck;
import org.haje.ducks.MallardDuck;
import org.haje.ducks.RedheadDuck;
import org.haje.ducks.RubberDuck;
import org.haje.ducks.Duck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class DuckGame extends JPanel implements KeyListener {
    private Duck duck;

    public DuckGame() {
        setFocusable(true);
        addKeyListener(this);
        duck = getRandomDuck();
    }

    private Duck getRandomDuck() {
        // TODO: Polymorphism(다형성), Inheritance(상속)
        Random random = new Random();
        int duckType = random.nextInt(4);
        switch (duckType) {
            case 0:
                return new MallardDuck(200, 200);
            case 1:
                return new RedheadDuck(200, 200);
            case 2:
                return new RubberDuck(200, 200);
            case 3:
                return new DecoyDuck(200, 200);
            default:
                return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO: Polymorphism(다형성), Inheritance(상속)
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        duck.draw(g2d);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //TODO: 캡슐화(encapsulation)
        //HINT: create method in duck class to move the duck
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                duck.ChangeY(-5);
                break;
            case KeyEvent.VK_S:
                duck.ChangeY(5);
                break;
            case KeyEvent.VK_A:
                duck.ChangeX(-5);
                break;
            case KeyEvent.VK_D:
                duck.ChangeX(5);
                break;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Duck Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new DuckGame());
        frame.setVisible(true);
    }
}