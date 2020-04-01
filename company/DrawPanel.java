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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawPanel extends JPanel
{
    List<ShapeSpecifications> shapes=new ArrayList<>();
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
                if (frame.selectShapePanel.draw.isSelected())
                {
                    drawShape(e.getX(), e.getY());
                    repaint();
                }
                if (frame.selectShapePanel.del.isSelected())
                {
                    int x=e.getX();
                    int y=e.getY();
                    for (int i=shapes.size()-1;i>=0;i--)
                    {
                        ShapeSpecifications temp=shapes.get(i);
                        if ((x - temp.x)*(x - temp.x) + (y - temp.y)*(y - temp.y) <=temp.radius*temp.radius)
                        {
                            shapes.remove(i);
                            i=-1;
                        }
                    }
                    frame.canvas.graphics.setColor(Color.WHITE);
                    frame.canvas.graphics.fillRect(0, 0, frame.canvas.W, frame.canvas.H);
                    frame.repaint();
                }
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
            if (frame.selectShapePanel.Circle.isSelected()) radius=(int)frame.configPanel.radiusField.getValue();
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
        if(frame.selectShapePanel.Star.isSelected())
        {
            ShapeSpecifications star=new ShapeSpecifications(x,y,color,(int)frame.configPanel.nrOfPointsField.getValue()*2,radius,"Star");
            shapes.add(star);
            //new Star(x,y,radius,graphics,(int)frame.configPanel.nrOfPointsField.getValue()*2);
        }
        if(frame.selectShapePanel.Circle.isSelected())
        {
            ShapeSpecifications circle=new ShapeSpecifications(x,y,color,radius,"Circle");
            shapes.add(circle);
            //new Circle(x-radius/2,y-radius/2,radius,graphics);
        }
        if(frame.selectShapePanel.RegularPolygon.isSelected())
        {
            ShapeSpecifications polygon=new ShapeSpecifications("RegularPolygon",x,y,color,sides,radius);
            shapes.add(polygon);
            //graphics.fill(new RegularPolygon(x, y, radius, sides));
        }
    }
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g)
    {
        Iterator<ShapeSpecifications> it=shapes.iterator();
        while (it.hasNext())
        {
            ShapeSpecifications temp=it.next();
            graphics.setColor(temp.color);
            if (temp.shapeType.equals("Star"))
            {
                new Star(temp.x,temp.y,temp.radius,graphics,temp.nPoints);
            }
            if (temp.shapeType.equals("Circle"))
            {
                new Circle(temp.x-temp.radius/2,temp.y-temp.radius/2,temp.radius,graphics);
            }
            if (temp.shapeType.equals("RegularPolygon"))
            {
                graphics.fill(new RegularPolygon(temp.x, temp.y, temp.radius, temp.sides));

            }
        }
        g.drawImage(image, 0, 0, this);
    }

}
