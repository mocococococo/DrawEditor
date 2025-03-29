import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JScrollBarTest extends JFrame implements AdjustmentListener {
	JScrollBar r, g, b;
    protected int R,G,B;
    
    JScrollBarTest() {
		getContentPane().setLayout(new FlowLayout());

		r = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260);
        g = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260);
        b = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260);
	    r.setPreferredSize(new Dimension(150, 17));
        g.setPreferredSize(new Dimension(150, 17));
        b.setPreferredSize(new Dimension(150, 17));
		r.addAdjustmentListener(this);
        g.addAdjustmentListener(this);
        b.addAdjustmentListener(this);
		getContentPane().add(r);
        getContentPane().add(g);
        getContentPane().add(b);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JScrollBarTest");
		setSize(260, 120);
		setVisible(true);
	}
	public void adjustmentValueChanged(AdjustmentEvent e) {
		R = r.getValue();
        G = g.getValue();
        B = b.getValue();
        System.out.println(R);
        System.out.println(G);
        System.out.println(B);
	}
	public static void main(String[] args) {
		new JScrollBarTest();
	}
}