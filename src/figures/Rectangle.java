package figures;

import java.awt.*;


public class Rectangle extends Figure
{
    public Rectangle(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.drawRect(x, y, width, height);
    }
}