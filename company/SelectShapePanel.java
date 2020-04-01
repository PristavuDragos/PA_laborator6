package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SelectShapePanel extends JPanel
{
    final MainFrame frame;
    ButtonGroup bGroup;
    ButtonGroup drawAndDelete;
    JRadioButton draw;
    JRadioButton del;
    JRadioButton RegularPolygon;
    JRadioButton Circle;
    JRadioButton Star;
    JLabel layoutDummy;

    public SelectShapePanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }
    private void init()
    {
        bGroup=new ButtonGroup();
        RegularPolygon = new JRadioButton("Regular Polygon");
        Circle = new JRadioButton("Circle");
        Star = new JRadioButton("Star");
        bGroup.add(RegularPolygon);
        bGroup.add(Circle);
        bGroup.add(Star);

        drawAndDelete=new ButtonGroup();
        draw= new JRadioButton("Draw");
        del= new JRadioButton("Delete");
        drawAndDelete.add(draw);
        drawAndDelete.add(del);
        draw.setSelected(true);

        RegularPolygon.setSelected(true);
        RegularPolygon.addActionListener(this::RegularPolygon);
        Circle.addActionListener(this::Circle);
        Star.addActionListener(this::Star);

        layoutDummy=new JLabel(" ");
        setLayout(new GridLayout(10, 1));
        JDialog getSizeInput;
        add(RegularPolygon);
        add(Circle);
        add(Star);
        add(layoutDummy);
        add(layoutDummy);
        add(layoutDummy);
        add(draw);
        add(del);
    }
    private void RegularPolygon(ActionEvent e)
    {
        frame.configPanel.removeAll();
        frame.configPanel.add(frame.configPanel.label1);
        frame.configPanel.add(frame.configPanel.sidesField);
        frame.configPanel.add(frame.configPanel.label2);
        frame.configPanel.add(frame.configPanel.colorCombo);
        frame.configPanel.add(frame.configPanel.label3);
        frame.configPanel.add(frame.configPanel.sizeField);
        frame.configPanel.add(frame.configPanel.randSizeCheck);
        frame.configPanel.updateUI();
    }

    private void Circle(ActionEvent e)
    {
        frame.configPanel.removeAll();
        frame.configPanel.add(frame.configPanel.labelc1);
        frame.configPanel.add(frame.configPanel.colorCombo);
        frame.configPanel.add(frame.configPanel.labelc2);
        frame.configPanel.add(frame.configPanel.radiusField);
        frame.configPanel.add(frame.configPanel.randSizeCheck);
        frame.configPanel.updateUI();
    }

    private void Star(ActionEvent e)
    {
        frame.configPanel.removeAll();
        frame.configPanel.add(frame.configPanel.labelS3);
        frame.configPanel.add(frame.configPanel.nrOfPointsField);
        frame.configPanel.add(frame.configPanel.labelS1);
        frame.configPanel.add(frame.configPanel.colorCombo);
        frame.configPanel.add(frame.configPanel.labelS2);
        frame.configPanel.add(frame.configPanel.sizeField);
        frame.configPanel.add(frame.configPanel.randSizeCheck);
        frame.configPanel.updateUI();
    }

}
