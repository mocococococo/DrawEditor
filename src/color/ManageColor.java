package color;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import draw.DrawModel;
import draw.FigureType;

public class ManageColor extends JFrame implements AdjustmentListener {
    JScrollBar r,g,b;
    private DrawModel model;
    private int R,G,B;
    private JLabel label;
      
    public ManageColor(DrawModel m)
    {
        model = m;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("subWindow");
        this.setSize(400, 180);
    
        r = new JScrollBar(JScrollBar.HORIZONTAL, 0, 30, 0, 260);
        g = new JScrollBar(JScrollBar.HORIZONTAL, 0, 30, 0, 260);
        b = new JScrollBar(JScrollBar.HORIZONTAL, 0, 30, 0, 260);
        r.addAdjustmentListener(this);
        g.addAdjustmentListener(this);
        b.addAdjustmentListener(this);

        r.setUI(new ColoredScrollBarUI(new Color(r.getValue(), 0, 0)));
        g.setUI(new ColoredScrollBarUI(new Color(0, g.getValue(), 0)));
        b.setUI(new ColoredScrollBarUI(new Color(0, 0, b.getValue())));
    
        this.setLayout(new GridLayout(4, 2));
        this.add(new JLabel("RED"));
        this.add(r);
        this.add(new JLabel("GREEN"));
        this.add(g);
        this.add(new JLabel("BLUE"));
        this.add(b);
        this.add(new JLabel("Figure is"));
        label = new JLabel("rect");
        this.add(label);
    
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
  
    public void showFigure()
    {
        String t = "Rect";
        if(model.getFigureType() == FigureType.RECTANGLE) {
            t = "Rect";
        } else if(model.getFigureType() == FigureType.FILL_RECTANGLE) {
            t = "fillRect";
        } else if(model.getFigureType() == FigureType.LINE) {
            t = "Line";
        } else if(model.getFigureType() == FigureType.CIRCLE) {
            t = "Oval";
        } else if(model.getFigureType() == FigureType.FILL_CIRCLE) {
            t = "fillOval";
        } else if(model.getFigureType() == FigureType.TRIANGLE) {
            t = "Triangle";
        }
        label.setText(t);
        this.setVisible(true);
    }
  
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        R = r.getValue();
        G = g.getValue();
        B = b.getValue();
        model.setColor(new Color(R, G, B));
        
        if (r.getUI() instanceof ColoredScrollBarUI)
        {
            ((ColoredScrollBarUI)r.getUI()).setThumbColor(new Color(R, 0, 0));
            r.repaint();
        }
        if (g.getUI() instanceof ColoredScrollBarUI)
        {
            ((ColoredScrollBarUI)g.getUI()).setThumbColor(new Color(0, G, 0));
            g.repaint();
        }
        if (b.getUI() instanceof ColoredScrollBarUI)
        {
            ((ColoredScrollBarUI)b.getUI()).setThumbColor(new Color(0, 0, B));
            b.repaint();
        }
        
    }
}