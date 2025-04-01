package figures;

import java.awt.*;


public class Circle extends Figure
{
    public Circle(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.drawOval(x, y, width, height);
 
    }
}