package figures;

import java.awt.*;


public class Triangle extends Figure
{
    public Triangle(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.drawLine(x, y, width, height);
        g.drawLine(x, y, Math.min(x,width) + Math.abs(width-x)/2, height/2 + Math.abs(height-y)/2);
        g.drawLine(Math.min(x,width) + Math.abs(width-x)/2, height/2 + Math.abs(height-y)/2, width, height);
    }
}