import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


class RectangleFigure extends Figure {
  public RectangleFigure(int x, int y, int w, int h, Color c) {
    super(x, y, w, h, c);
    // �����t���̃R���X�g���N�^�͌p������Ȃ��̂ŁC�R���X�g���N�^���`�D
    // super�Őe�̃R���X�g���N�^���Ăяo�������D
  }
  public void draw(Graphics g) {
    g.setColor(color);
    g.drawRect(x, y, width, height);
  }
}

class fillRectangleFigure extends Figure {
  public fillRectangleFigure(int x, int y, int w, int h, Color c) {
    super(x, y, w, h, c);
    // �����t���̃R���X�g���N�^�͌p������Ȃ��̂ŁC�R���X�g���N�^���`�D
    // super�Őe�̃R���X�g���N�^���Ăяo�������D
  }
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(x, y, width, height);
  }
}

class LineFigure extends Figure {
  public LineFigure(int x, int y, int w, int h, Color c) {
    super(x, y, w, h, c);
    // �����t���̃R���X�g���N�^�͌p������Ȃ��̂ŁC�R���X�g���N�^���`�D
    // super�Őe�̃R���X�g���N�^���Ăяo�������D
  }
  public void draw(Graphics g) {
    g.setColor(color);
    g.drawLine(x, y, width, height);
  }
}

class CircleFigure extends Figure {
  public CircleFigure(int x, int y, int w, int h, Color c) {
    super(x, y, w, h, c);
    // �����t���̃R���X�g���N�^�͌p������Ȃ��̂ŁC�R���X�g���N�^���`�D
    // super�Őe�̃R���X�g���N�^���Ăяo�������D
  }
  public void draw(Graphics g) {
    g.setColor(color);
    g.drawOval(x, y, width, height);
  }
}

class FillCircleFigure extends Figure {
  public FillCircleFigure(int x, int y, int w, int h, Color c) {
    super(x, y, w, h, c);
    // �����t���̃R���X�g���N�^�͌p������Ȃ��̂ŁC�R���X�g���N�^���`�D
    // super�Őe�̃R���X�g���N�^���Ăяo�������D
  }
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillOval(x, y, width, height);
  }
}

class TriangleFigure extends Figure {
  public TriangleFigure(int x, int y, int w, int h, Color c) {
    super(x, y, w, h, c);
    // �����t���̃R���X�g���N�^�͌p������Ȃ��̂ŁC�R���X�g���N�^���`�D
    // super�Őe�̃R���X�g���N�^���Ăяo�������D
  }
  public void draw(Graphics g) {
    g.setColor(color);
    g.drawLine(x, y, width, height);
    g.drawLine(x, y, Math.min(x,width) + Math.abs(width-x)/2, height/2 + Math.abs(height-y)/2);
    g.drawLine(Math.min(x,width) + Math.abs(width-x)/2, height/2 + Math.abs(height-y)/2, width, height);
  }
}
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

class FigureMenus extends JMenuBar implements ActionListener {
  protected DrawModel model;
  protected Makecolor color;

  public FigureMenus(DrawModel m, DrawController c, Makecolor r) {
    color = r;
    model = m;
    JMenu figure = new JMenu("Figure");
    JMenu delete = new JMenu("Delete");
    this.add(figure);
    this.add(delete);

    JMenuItem[] figures = new JMenuItem[6]; // �}�`?��
    JMenuItem[] deletes = new JMenuItem[2]; // �}�`�폜?��
    int i;
    this.setVisible(true);

    figures[0] = new JMenuItem("Rect");
    figures[1] = new JMenuItem("fillRect");
    figures[2] = new JMenuItem("Line");
    figures[3] = new JMenuItem("Oval");
    figures[4] = new JMenuItem("FillOval");
    figures[5] = new JMenuItem("Triangle");

    for (i = 0; i < 6; i++) {
      figures[i].addActionListener(this);
      figure.add(figures[i]);
    }

    deletes[0] = new JMenuItem("All");
    deletes[1] = new JMenuItem("Last");
    for (i = 0; i < 2; i++) {
      deletes[i].addActionListener(this);
      delete.add(deletes[i]);
    }
  }

  public void actionPerformed(ActionEvent e) {
    String t = e.getActionCommand();

    if (t.equals("Rect")) {
      model.now = 0;
      color.showFigure();
    } else if (t.equals("fillRect")) {
      model.now = 1;
      color.showFigure();
    } else if (t.equals("Line")) {
      model.now = 2;
      color.showFigure();
    } else if (t.equals("Oval")) {
      model.now = 3;
      color.showFigure();
    } else if (t.equals("FillOval")) {
      model.now = 4;
      color.showFigure();
    } else if (t.equals("Triangle")) {
      model.now = 5;
      color.showFigure();
    } else if (t.equals("All")) {
      model.fig.clear();
      model.resetFigure();
    } else if (t.equals("Last")) {
      if (model.fig.size() != 0) {
        model.fig.remove(model.fig.size() - 1);
        model.resetFigure();
      }
    }
  }
}

//////////////////////////////////////////////////
// Main class
//   (GUI��g�ݗ��ĂĂ���̂ŁCview �̈ꕔ�ƍl���Ă��悢)
class DrawFrame extends JFrame {
  DrawModel model;
  ViewPanel view;
  FigureMenus menu;
  Makecolor color;
  DrawController cont;
  public DrawFrame() {
    model = new DrawModel();
    cont = new DrawController(model);
    view = new ViewPanel(model,cont);
    color = new Makecolor(model);
    menu = new FigureMenus(model, cont, color);
    this.setBackground(Color.black);
    this.setTitle("Draw Editor");
    this.setSize(1000, 1000);
    this.setJMenuBar(menu);
    this.add(view);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
  public static void main(String[] args) {
    new DrawFrame();
  }
}