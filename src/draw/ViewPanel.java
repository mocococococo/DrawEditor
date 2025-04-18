package draw;

import java.awt.*;
import javax.swing.*;

import figures.Figure;

import java.util.*;

public class ViewPanel extends JPanel implements Observer {
    protected DrawModel model;
    public ViewPanel(DrawModel m, DrawController c) {
        this.setBackground(Color.white);
        this.addMouseListener(c);
        this.addMouseMotionListener(c);
        model = m;
        model.addObserver(this);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Figure> fig = model.getFigures();
        for(int i = 0; i < fig.size(); i++) {
            Figure f = fig.get(i);
            f.draw(g);
        }
    }
    public void update(Observable o, Object arg) {
        repaint();
    }
}