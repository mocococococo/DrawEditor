package figures;

import java.awt.*;


public class Triangle extends Figure
{
    public Triangle(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }
    
    @Override
    public void reshape(int x1, int y1, int x2, int y2)
    {
        int baseLeftX = x;
        int baseLeftY = height;
        int baseRightX = width;
        int baseRightY = height;
        
        int sideLength = baseRightX - baseLeftX;
        
        int apexX = baseLeftX + sideLength / 2;
        int apexY = baseLeftY - (int)(sideLength * Math.sqrt(3) / 2);
        
        setLocation(apexX, apexY);
        setSize(baseRightX - baseLeftX, baseLeftY - apexY);
    }

    @Override
    public void draw(Graphics g)
    {
        super.draw(g);
    }
}