package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by alxye on 16-May-18.
 */

public class Content extends JPanel implements ActionListener, KeyListener, MouseListener {
    private static Timer t;
    public static Player player = new Player(100,100,50);


    //player rope mechanic
    private static boolean anchorState = false;
    private static Anchor anchor = new Anchor(0, 0, 0, 0);


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
        if(anchorState)
            g.drawLine(anchor.getStartX(), anchor.getStartY(), anchor.getEndX(), anchor.getEndY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //resetting the anchor starting points every frame
        anchor.setStartX(player.getX());
        anchor.setStartY(player.getY());
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
        anchorState = true;
//        anchor = new Anchor(player.getX(), e.getX(), player.getY(), e.getY());
        anchor.setStartX(player.getX());
        anchor.setEndX(e.getX());
        anchor.setStartY(player.getY());
        anchor.setEndY(e.getY());
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