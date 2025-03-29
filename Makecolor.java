import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Makecolor extends JFrame implements AdjustmentListener {
    JScrollBar r,g,b;
    protected DrawModel model;
    protected int R,G,B;
    protected JLabel label;
      
    Makecolor(DrawModel m) {
        model = m;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("subWindow");
        this.setSize(400, 180);
    
        r = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260);
        g = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260);
        b = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260);
        r.addAdjustmentListener(this);
        g.addAdjustmentListener(this);
        b.addAdjustmentListener(this);
    
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
  
    public void showFigure() {
        String t = "Rect";
        if(model.now == 0) {
          t = "Rect";
        } else if(model.now == 1) {
          t = "fillRect";
        } else if(model.now == 2) {
          t = "Line";
        } else if(model.now == 3) {
          t = "Oval";
        } else if(model.now == 4) {
          t = "fillOval";
        } else if(model.now == 5) {
          t = "Triangle";
        }
        label.setText(t);
        this.setVisible(true);
    }
  
    public void adjustmentValueChanged(AdjustmentEvent e) {
        R = r.getValue();
        G = g.getValue();
        B = b.getValue();
        System.out.print("R = "); System.out.println(R);
        System.out.print("G = "); System.out.println(G);
        System.out.print("B = "); System.out.println(B);
        model.currentColor = new Color(R,G,B);
    }
}