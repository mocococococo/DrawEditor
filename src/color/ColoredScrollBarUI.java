package color;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ColoredScrollBarUI extends BasicScrollBarUI
{
    private Color thumbColor;

    public ColoredScrollBarUI(Color thumbColor)
    {
        this.thumbColor = thumbColor;
    }
    
    public void setThumbColor(Color thumbColor)
    {
        this.thumbColor = thumbColor;
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds)
    {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(thumbBounds.x, thumbBounds.y);
        g2.setColor(thumbColor);
        g2.fillRoundRect(0, 0, thumbBounds.width, thumbBounds.height, 10, 10);
        g2.dispose();
    }

    @Override
    protected void paintDecreaseHighlight(Graphics g) {
        // 何もしない → クリック時のハイライトを描画しない
    }

    @Override
    protected void paintIncreaseHighlight(Graphics g) {
        // 何もしない → クリック時のハイライトを描画しない
    }
}
