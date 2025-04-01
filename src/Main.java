import java.awt.*;
import javax.swing.*;

import color.ManageColor;
import draw.DrawController;
import draw.DrawModel;
import draw.FigureMenus;
import draw.ViewPanel;


public class Main extends JFrame {
    DrawModel model;
    ViewPanel view;
    FigureMenus menu;
    ManageColor color;
    DrawController controller;
    public Main() {
        model = new DrawModel();
        controller = new DrawController(model);
        view = new ViewPanel(model, controller);
        color = new ManageColor(model);
        menu = new FigureMenus(model, controller, color);
        this.setBackground(Color.black);
        this.setTitle("Draw Editor");
        this.setSize(700, 500);
        this.setJMenuBar(menu);
        this.add(view);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}