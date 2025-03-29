import java.awt.*;
import java.util.*;


////////////////////////////////////////////////
// Model (M)
// model�� java.util.Observable���p������DView�ɊĎ������D
class DrawModel extends Observable {
    protected ArrayList<Figure> fig;
    protected Figure drawingFigure;
    protected Color currentColor;
    protected Figure[] Fbox;
    protected int now;
    public DrawModel() {
        fig = new ArrayList<Figure>();
        drawingFigure = null;
        currentColor = Color.BLACK;
        Fbox = new Figure[6];
        now = 0;
    }
    public ArrayList<Figure> getFigures() {
        return fig;
    }
    public Figure getFigure(int idx) {
        return fig.get(idx);
    }
    public void createFigure(int x, int y) {
        Fbox[0] = new RectangleFigure(x, y, x, y, currentColor);
        Fbox[1] = new fillRectangleFigure(x, y, x, y, currentColor);
        Fbox[2] = new LineFigure(x, y, x, y, currentColor);
        Fbox[3] = new CircleFigure(x, y, x, y, currentColor);
        Fbox[4] = new FillCircleFigure(x, y, x, y, currentColor);
        Fbox[5] = new TriangleFigure(x, y, x, y, currentColor);

        Figure f = Fbox[now];
        fig.add(f);
        drawingFigure = f;
        setChanged();
        notifyObservers();
    }
    public void reshapeFigure(int x1, int y1, int x2, int y2) {
        if (drawingFigure != null) {
            drawingFigure.reshape(x1, y1, x2, y2, this.now);
            setChanged();
            notifyObservers();
        }
    }

    public void resetFigure() {
        setChanged();
        notifyObservers();
    }
}