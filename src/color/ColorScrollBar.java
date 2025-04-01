package color;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorScrollBar extends JFrame implements AdjustmentListener {
	JScrollBar Red, Green, Blue;
    protected int R,G,B;
    
    ColorScrollBar() {
		getContentPane().setLayout(new FlowLayout());

		Red = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260);
        Green = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260);
        Blue = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260);
	    Red.setPreferredSize(new Dimension(150, 17));
        Green.setPreferredSize(new Dimension(150, 17));
        Blue.setPreferredSize(new Dimension(150, 17));
		Red.addAdjustmentListener(this);
        Green.addAdjustmentListener(this);
        Blue.addAdjustmentListener(this);
		getContentPane().add(Red);
        getContentPane().add(Green);
        getContentPane().add(Blue);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ColorScrollBar");
		setSize(260, 120);
		setVisible(true);
	}
	public void adjustmentValueChanged(AdjustmentEvent e) {
		R = Red.getValue();
        G = Green.getValue();
        B = Blue.getValue();
        System.out.println(R);
        System.out.println(G);
        System.out.println(B);
	}
	public static void main(String[] args) {
		new ColorScrollBar();
	}
}