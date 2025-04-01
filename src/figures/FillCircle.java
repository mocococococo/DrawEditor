package figures;

import java.awt.*;


public class FillCircle extends Figure
{
    public FillCircle(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.fillOval(x, y, width, height);
    }
}