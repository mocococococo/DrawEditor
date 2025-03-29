import javax.swing.*;
import java.awt.*;


class DrawFrame extends JFrame {
    DrawModel model;
    ViewPanel view;
    FigureMenus menu;
    Makecolor color;
    DrawController cont;
    public DrawFrame() {
        model = new DrawModel();
        cont = new DrawController(model);
        view = new ViewPanel(model,cont);
        color = new Makecolor(model);
        menu = new FigureMenus(model, cont, color);
        this.setBackground(Color.black);
        this.setTitle("Draw Editor");
        this.setSize(1000, 1000);
        this.setJMenuBar(menu);
        this.add(view);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new DrawFrame();
    }
}