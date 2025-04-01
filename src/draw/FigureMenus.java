package draw;

import java.awt.event.*;
import javax.swing.*;

import color.ManageColor;

public class FigureMenus extends JMenuBar implements ActionListener
{
    protected DrawModel model;
    protected ManageColor color;

    public FigureMenus(DrawModel m, DrawController c, ManageColor r)
    {
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
        figures[3] = new JMenuItem("Circle");
        figures[4] = new JMenuItem("FillCircle");
        figures[5] = new JMenuItem("Triangle");

        for (i = 0; i < 6; i++)
        {
            figures[i].addActionListener(this);
            figure.add(figures[i]);
        }

        deletes[0] = new JMenuItem("All");
        deletes[1] = new JMenuItem("Last");

        for (i = 0; i < 2; i++)
        {
            deletes[i].addActionListener(this);
            delete.add(deletes[i]);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        String selectedCommand = e.getActionCommand();
        switch (selectedCommand) {
            case "Rect":
                model.setFigureType(FigureType.RECTANGLE);
                break;
            case "fillRect":
                model.setFigureType(FigureType.FILL_RECTANGLE);
                break;
            case "Line":
                model.setFigureType(FigureType.LINE);
                break;
            case "Circle":
                model.setFigureType(FigureType.CIRCLE);
                break;
            case "FillCircle":
                model.setFigureType(FigureType.FILL_CIRCLE);
                break;
            case "Triangle":
                model.setFigureType(FigureType.TRIANGLE);
                break;
            case "All":
                model.fig.clear();
                model.resetFigure();
                return;
            case "Last":
                if (!model.fig.isEmpty()) {
                    model.fig.remove(model.fig.size() - 1);
                    model.resetFigure();
                }
                return;
            default:
                return;
        }
        
        color.showFigure();
    }
}