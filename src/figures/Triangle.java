package figures;

import java.awt.*;


public class Triangle extends Figure
{
    private int apexX, apexY;

    public Triangle(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }

    @Override
    public void reshape(int x1, int y1, int x2, int y2)
    {
        int newx, newy, newh, neww;
        newx = x1;
        newy = y1;
        neww = x2;
        newh = y2;
        setLocation(newx, newy);
        setSize(neww, newh);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        if (x != width && y != height) {
            double dx = width - x;
            double dy = height - y;
            double distance = Math.sqrt(dx * dx + dy * dy);
            
            double H = distance * Math.sqrt(3) / 2.0;
            double midX = (x + width) / 2.0;
            double midY = (y + height) / 2.0;
            
            double ux = dy / distance;
            double uy = -dx / distance;
            
            this.apexX = (int)(midX + H * ux);
            this.apexY = (int)(midY + H * uy);
        } else {
            this.apexX = x;
            this.apexY = y;
        }

        g.drawLine(x, y, width, height);
        g.drawLine(this.x, this.y, this.apexX, this.apexY);
        g.drawLine(this.apexX, this.apexY, this.width, this.height);
    }
}