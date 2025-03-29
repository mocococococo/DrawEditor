import java.awt.*;


class RectangleFigure extends Figure {
    public RectangleFigure(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
}

class fillRectangleFigure extends Figure {
    public fillRectangleFigure(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

class LineFigure extends Figure {
    public LineFigure(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x, y, width, height);
    }
}

class CircleFigure extends Figure {
    public CircleFigure(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }
}

class FillCircleFigure extends Figure {
    public FillCircleFigure(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}

class TriangleFigure extends Figure {
    public TriangleFigure(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x, y, width, height);
        g.drawLine(x, y, Math.min(x,width) + Math.abs(width-x)/2, height/2 + Math.abs(height-y)/2);
        g.drawLine(Math.min(x,width) + Math.abs(width-x)/2, height/2 + Math.abs(height-y)/2, width, height);
    }
}