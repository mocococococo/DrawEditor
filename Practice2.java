import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class TimeObservable extends Observable implements ActionListener {
  private javax.swing.Timer timer;
  // 現在時刻を保持するインスタンス変数
  private int hour, min, sec;
 
  public TimeObservable() {
    // 1秒毎にactionPerformedを呼び出す
    timer = new javax.swing.Timer(1000, this);
    timer.start();
  }
 
  public void actionPerformed(ActionEvent arg0) {
    this.setValue();
    setChanged();      // 状態変化のフラグをセット
    notifyObservers(); // 登録されたすべてのObserverのupdateを呼び出す
  }
 
  void setValue() {
    Calendar cal = Calendar.getInstance(); 
    hour = cal.get(Calendar.HOUR_OF_DAY); 
    min = cal.get(Calendar.MINUTE); 
    sec = cal.get(Calendar.SECOND); 
  }
  String getValue(int diff) {
    String currentTime;
    int hour;
    hour = (this.hour + diff + 24) % 24;
    currentTime = String.format("%02d:%02d:%02d", hour, min, sec);
    return currentTime;
  }
}

class ClockPanel extends JPanel implements Observer {
    private TimeObservable timeObservable;
    private int diff;
    private JLabel timeLabel;
    public ClockPanel(TimeObservable to, String place, int diff) {
      timeObservable = to;
      this.diff = diff;
      timeObservable.addObserver(this);
      timeLabel = new JLabel(to.getValue(diff), JLabel.CENTER);
      this.setLayout(new GridLayout(1, 2));
      this.add(new JLabel(place));
      this.add(timeLabel);
    }
    public void update(Observable o, Object arg) {
      timeLabel.setText(timeObservable.getValue(diff));
    }
  }

class Practice2 extends JFrame {
  private TextFieldObserver hex, dec, eight, binary;
  private IntObservable intVal;
   
  public Practice2() {

    TimeObservable t = new TimeObservable();
    this.setLayout(new GridLayout(5, 5));
    this.add(new ClockPanel(t, "Japan", 0));
    this.add(new ClockPanel(t, "London", -9));
    this.add(new ClockPanel(t, "New York", -14));
    this.add(new ClockPanel(t, "Paris", -7));
    this.add(new ClockPanel(t, "Los Angels", -17));

    this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
  public static void main(String[] args) {
    new Practice2();
  }
}