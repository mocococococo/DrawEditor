package observer;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TextFieldObserver extends JTextField implements Observer, ActionListener {
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