package figures;

import java.awt.*;


public class Line extends Figure
{
    public Line(int x, int y, int w, int h, Color c)
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
        g.drawLine(x, y, width, height);
    }
}