package jgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SliderFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bezier Curve Painting UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d.width, d.height);
        frame.setVisible(true);

        DrawPanel dp = new DrawPanel();
        // dp.paintComponent(frame.getGraphics());

        frame.add(dp);

    }

}
