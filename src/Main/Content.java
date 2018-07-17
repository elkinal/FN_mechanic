package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;

/**
 * Created by alxye on 16-May-18.
 */

public class Content extends JPanel implements ActionListener, KeyListener, MouseListener {
    private static Timer t;
    public static Player player = new Player(300,400,50);


    //player rope mechanic
    private static boolean anchorState = false;
    private static Anchor anchor = new Anchor(0, 0, 0, 0);
    private static int anchorRadius;
    private static double angle = 0;

    public Content() {
        t = new Timer(5, this);
        t.start();
        super.setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(player.getX()-player.getSize()/2, player.getY()-player.getSize()/2, player.getSize(), player.getSize());
        if(anchorState) {
            g.drawLine(anchor.getStartX(), anchor.getStartY(), anchor.getEndX(), anchor.getEndY()); //radius line
            g.drawLine(anchor.getStartX(), anchor.getStartY(), anchor.getEndX(), anchor.getEndY() - anchorRadius); //relative angle line
            g.drawOval(anchor.getEndX() - anchorRadius , anchor.getEndY() - anchorRadius , anchorRadius*2, anchorRadius*2); //circle
        }
//        System.out.println(anchor.getDistance());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //resetting the anchor starting points every frame
        anchor.setStartX(player.getX());
        anchor.setStartY(player.getY());
        //experimental code to move an object in a circle
        /*X := originX + cos(angle)*radius;
        Y := originY + sin(angle)*radius;*/
/*        if(anchorState) {
            player.setX((int) (anchor.getEndX() + Math.cos(angle) * anchorRadius));
            player.setY((int) (anchor.getEndY() + Math.sin(angle) * anchorRadius));
            angle += (Math.PI * 2 * anchorRadius) / 3600000;
            System.out.println("Circumference: " + (int) (Math.PI * 2 * anchorRadius) + " Distance (radians):  " + angle*5);
//            System.out.println("Angle: " + angle + "Circumference" + Math.PI * Math.pow(anchorRadius,2));

            *//*if(angle > 6.3)
                angle = 0;*//*
        }   //there is an error with the angle because the angle is the distance travelled along the circumference,
            //but the circumference varies with different circle sizes
        //----------------*/
/*        if(anchorState) {
            player.setX((int)(anchor.getEndX() + anchorRadius * Math.cos(angle)));
            player.setY((int)(anchor.getEndY() + anchorRadius * Math.sin(angle)));
            angle+=Math.PI/180.0 * 0.1; //moves 0.1 degree / frame, or 20 degrees per second
            //experimental code here
            *//*double angleOffset = 0;
            if(!(anchor.getStartX() == anchor.getEndX() || anchor.getStartY() == anchor.getEndY()))
            {
                angleOffset = Math.toDegrees(Math.atan2(Math.abs(anchor.getEndY() - anchor.getStartY()), Math.abs(anchor.getEndX() - anchor.getStartX())));
            }*//*
            *//*else {
                angleOffset = Math.toDegrees(Math.atan2((double)(Math.abs(anchor.getEndY() - anchor.getStartY())), (double)(Math.abs(anchor.getEndX() - anchor.getStartX()))));
            }*//*
            System.out.println(angle);
        }*/
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            player.setY(player.getY()+50);
        if(e.getKeyCode() == KeyEvent.VK_UP)
            player.setY(player.getY()-50);
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            player.setX(player.getX()+50);
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            player.setX(player.getX()-50);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        anchorState = !anchorState;
//        anchor = new Anchor(player.getX(), e.getX(), player.getY(), e.getY());
        anchor.setStartX(player.getX());
        anchor.setEndX(e.getX());
        anchor.setStartY(player.getY());
        anchor.setEndY(e.getY());
        //really important stuff
        angle = Math.toDegrees(Math.atan2(anchor.getEndY() - anchor.getStartY(), anchor.getEndX() - anchor.getStartX()));
        if(angle < 0)
            angle = 360 - Math.abs(angle);
        System.out.println(angle);
        //really important stuff
        anchorRadius = (int) Math.sqrt(Math.abs(Math.pow(anchor.getStartX() - anchor.getEndX(), 2) + Math.pow(anchor.getStartY() - anchor.getEndY(), 2)));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}