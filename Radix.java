import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class Radix extends JFrame implements ActionListener {
  private JTextField hex, dec;
 
  public Radix() {
    hex = new JTextField(3);
    dec = new JTextField(3);
    hex.addActionListener(this);
    dec.addActionListener(this);
    this.setLayout(new GridLayout(2, 2));
    this.add(new JLabel("16"));
    this.add(hex);
    this.add(new JLabel("10"));
    this.add(dec);
    this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
 
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == hex) {
      String s = hex.getText(); // 16�i���t�B�[���h����ǂݎ��
      int v = Integer.parseInt(s, 16);
      dec.setText(Integer.toString(v, 10)); // 10�i���t�B�[���h�ɏ�������
    } else if (e.getSource() == dec) {
      String s = dec.getText(); // 10�i���t�B�[���h����ǂݎ��
      int v = Integer.parseInt(s, 10);
      hex.setText(Integer.toString(v, 16)); // 16�i���t�B�[���h�ɏ�������
    }
  }
 
  public static void main(String[] args) {
    new Radix();
  }
}