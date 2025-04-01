package figures;

import java.awt.*;


public class FillRectangle extends Figure
{
    public FillRectangle(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
        g.fillRect(x, y, width, height);
    }
}