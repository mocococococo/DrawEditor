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
        g2.fillRect(1, 1, thumbBounds.width-2, thumbBounds.height-2);
        g2.dispose();
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        return new Dimension(16, 30); // 幅を 16 ピクセル以上にする 等
}

    @Override
    protected void paintDecreaseHighlight(Graphics g)
    {}

    @Override
    protected void paintIncreaseHighlight(Graphics g) 
    {}
}
