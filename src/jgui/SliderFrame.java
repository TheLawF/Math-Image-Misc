package jgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SliderFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Slider Painting UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(800, 600);
        frame.setVisible(true);

        DrawPanel dp = new DrawPanel();
        JLabel positionLabel = new JLabel();
        positionLabel.setFont(new Font("微软雅黑", Font.BOLD, 38));
        dp.paintComponent(frame.getGraphics());
        dp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseMoved(e);
                System.out.println(e.getXOnScreen() + ", " + e.getYOnScreen());
            }
        });

        dp.add(positionLabel);
        frame.add(dp);

    }

}
