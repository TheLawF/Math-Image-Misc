package jgui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;

public class DrawPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 绘制直角转弯的平滑弧线（反比例函数曲线）：
        // q2d.setCurve(0,0,0,500,500,500);
        QuadCurve2D q2d = new QuadCurve2D.Float();
        q2d.setCurve(0,0,0,400,400,400);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2));
        g2d.translate(40, 130);

        g2d.setColor(Color.BLACK);
        g2d.drawLine(0,0,0,400);
        g2d.drawLine(0,400,400,400);
        for (int i = 0; i < 400; i += 25) {
            g2d.drawString(String.valueOf(i), i,420);
            g2d.drawString(String.valueOf(i), -25, 400 - i);
        }
        g2d.setColor(Color.RED);
        g2d.draw(q2d);

        g2d.translate(600, 0);
        // 非常好看的连线图，数学中经典的仅使用直线绘制平滑弯曲效果的函数：
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0,0,0,400);
        g2d.drawLine(0,400,400,400);
        for (int i = 0; i < 400; i += 25) {
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(i), i,420);
            g2d.drawString(String.valueOf(i), -25, 400 - i);

            g2d.setColor(new Color(20,210,14));
            g2d.drawLine(0,i,i + 25,400);
        }
    }
}

