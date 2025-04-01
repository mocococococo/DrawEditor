package observer;

import java.util.*;

class IntObservable extends Observable {
    private int value;
    public int getValue() {
        return value;
    }
    public void setValue(int v) {
        value = v;
        setChanged();      // 状態変化のフラグをセット
        notifyObservers(); // 登録されたすべてのObserverのupdateを呼び出す
    }
}