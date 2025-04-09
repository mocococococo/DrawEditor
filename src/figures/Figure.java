package figures;

import java.awt.*;

import draw.FigureType;


public abstract class Figure {
    protected int x, y, width, height;
    protected Color color;

    public Figure(int x, int y, int w, int h, Color c)
    {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = c;
    }

    public void setSize(int w, int h)
    {
        this.width = w;
        this.height = h;
    }

    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Color getColor()
    {
        return this.color;
    }

    public void reshape(int x1, int y1, int x2, int y2)
    {
        int newx, newy, newh, neww;
        newx = Math.min(x1, x2);
        newy = Math.min(y1, y2);
        neww = Math.abs(x1 - x2);
        newh = Math.abs(y1 - y2);
        setLocation(newx, newy);
        setSize(neww, newh);
    }
    
    public void draw(Graphics g)
    {
        g.setColor(this.color);
    }
}