package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

public class DrawPanel extends JPanel
{
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;
    public DrawPanel(MainFrame frame)
    {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage()
    {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }
    private void init()
    {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }
    private void drawShape(int x, int y)
    {
        int radius=(int) (Math.random() * 50)+5 ;
        int sides=(int)frame.configPanel.sidesField.getValue() ;
        Color color =Color.BLACK;
        String col=frame.configPanel.colorCombo.getSelectedItem().toString();
        if (!frame.configPanel.randSizeCheck.isSelected())
        {
            radius=(int)frame.configPanel.sizeField.getValue();
        }
        if(col.equals("Random Color"))
        {
            int r,g,b;
            r=(int)(Math.random()*1000)%255;
            g=(int)(Math.random()*1000)%255;
            b=(int)(Math.random()*1000)%255;
            color=new Color(r,g,b);
        }
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image, 0, 0, this);
    }

}
