import javax.swing.*;
import java.awt.event.*;

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

        JMenuItem[] figures = new JMenuItem[6];
        JMenuItem[] deletes = new JMenuItem[2];
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