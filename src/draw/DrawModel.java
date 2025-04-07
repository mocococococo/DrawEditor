package draw;


import java.awt.*;
import java.util.*;

import figures.*;
import figures.Rectangle;


public class DrawModel extends Observable {
    protected ArrayList<Figure> fig;
    protected Figure drawingFigure;
    protected Figure[] Fbox;
    private Color currentColor;
    private FigureType now;
    
    public DrawModel() {
        fig = new ArrayList<Figure>();
        drawingFigure = null;
        currentColor = Color.BLACK;
        Fbox = new Figure[6];
        now = FigureType.RECTANGLE;
    }

    public ArrayList<Figure> getFigures() {
        return fig;
    }
    
    public Figure getFigure(int idx) {
        return fig.get(idx);
    }

    public void setFigureType(FigureType now) {
        this.now = now;
    }

    public FigureType getFigureType() {
        return now;
    }

    public void setColor(Color c) {
        currentColor = c;
    }

    public Color getColor() {
        return currentColor;
    }
    
    public void createFigure(int x, int y) {
        Fbox[0] = new Rectangle(x, y, 0, 0, currentColor);
        Fbox[1] = new FillRectangle(x, y, 0, 0, currentColor);
        Fbox[2] = new Line(x, y, 0, 0, currentColor);
        Fbox[3] = new Circle(x, y, 0, 0, currentColor);
        Fbox[4] = new FillCircle(x, y, 0, 0, currentColor);
        Fbox[5] = new Triangle(x, y, 0, 0, currentColor);

        Figure f = Fbox[this.now.ordinal()];
        fig.add(f);
        drawingFigure = f;
        setChanged();
        notifyObservers();
    }
    
    public void reshapeFigure(int x1, int y1, int x2, int y2) {
        if (drawingFigure != null) {
            
            drawingFigure.reshape(x1, y1, x2, y2, getFigureType());
            setChanged();
            notifyObservers();
        }
    }

    public void resetFigure() {
        setChanged();
        notifyObservers();
    }
}