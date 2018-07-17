package Main;

import javax.swing.*;

/**
 * Created by alxye on 17-Jul-18.
 */
public class Main {
    public static int screenHeight = 800;
    public static int screenWidth = 1500;
    public Main() {
        JFrame frame = new JFrame();
        frame.setTitle("Walrus Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Content());
        frame.setResizable(false);
        frame.setSize(screenWidth, screenHeight);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}
