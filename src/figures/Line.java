package figures;

import java.awt.*;


public class Line extends Figure
{
    public Line(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.drawLine(x, y, width, height);
    }
}