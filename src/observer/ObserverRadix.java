package observer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class TextFieldObserver extends JTextField implements Observer, ActionListener {
    private IntObservable intVal;
    private int radix;
    public TextFieldObserver(IntObservable s, int r) {
        intVal = s;
        radix = r;
        intVal.addObserver(this); // Observerオブジェクトの登録．重要です！
        this.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        String s = this.getText();
        intVal.setValue(Integer.parseInt(s, radix));
    }
    public void update(Observable o, Object arg) {
        String s = Integer.toString(intVal.getValue(), radix);
        setText(s);
    }
}

class ObserverRadix extends JFrame {
    private TextFieldObserver hex, dec, eight, binary;
    private IntObservable intVal;
    
    public ObserverRadix() {
        intVal = new IntObservable();
        hex = new TextFieldObserver(intVal, 16);
        dec = new TextFieldObserver(intVal, 10);
        eight = new TextFieldObserver(intVal, 8);
        binary = new TextFieldObserver(intVal, 2);

    
        this.setLayout(new GridLayout(4, 4));
        this.add(new JLabel("16"));
        this.add(hex);
        this.add(new JLabel("10"));
        this.add(dec);
        this.add(new JLabel("8"));
        this.add(eight);
        this.add(new JLabel("2"));
        this.add(binary);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new ObserverRadix();
    }
}