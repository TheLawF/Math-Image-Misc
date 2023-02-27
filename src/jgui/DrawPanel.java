package jgui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;


public class DrawPanel extends JPanel {
    private Point[] points = {
            new Point(0, 0),
            new Point(100, 100),
            new Point(200, -100),
            new Point(300, 100),
            new Point(330, -80),
            new Point(350, -70)
    };

    GeneralPath path = new GeneralPath();

    public void drawSmoothCurve() {
        path.moveTo(points[0].x, points[0].y);

        for (int i = 0; i < points.length-1; ++i) {
            Point sp = points[i];
            Point ep = points[i+1];
            Point c1 = new Point((sp.x + ep.x)/2, sp.y);
            Point c2 = new Point((sp.x + ep.x)/2, ep.y);

            path.curveTo(c1.x, c1.y, c2.x, c2.y, ep.x, ep.y);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GeneralPath p = new GeneralPath();

        // 绘制直角转弯的平滑弧线（反比例函数曲线）：
        // q2d.setCurve(0,0,0,500,500,500);
        QuadCurve2D q2d = new QuadCurve2D.Float();
        q2d.setCurve(0,0,0,500,500,500);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2));
        g2d.translate(40, 130);

        // 非常好看的连线图，数学中经典的仅使用直线绘制平滑弯曲效果的函数：
        g2d.drawLine(0,0,0,400);
        g2d.drawLine(0,400,400,400);
        for (int i = 0; i < 400; i += 25) {
            g2d.drawString(String.valueOf(i), i,420);
            g2d.drawString(String.valueOf(i), -25, 400 - i);
            g2d.drawLine(0,i,i + 25,400);
        }

        // g2d.draw(q2d);
        // g2d.drawLine(0,0,0,500);
        // g2d.drawLine(0,500,500,500);
    }
}

