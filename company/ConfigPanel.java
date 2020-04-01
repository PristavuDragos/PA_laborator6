package com.company;

import com.sun.prism.paint.Color;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel
{
    final MainFrame frame;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel labelc1;
    JLabel labelc2;
    JLabel labelS1;
    JLabel labelS2;
    JLabel labelS3;
    JSpinner sidesField;
    JSpinner nrOfPointsField;
    JSpinner sizeField;
    JSpinner radiusField;
    JComboBox colorCombo;
    JCheckBox randSizeCheck;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init()
    {
        // Regular Polygon
        label1 = new JLabel("Number of sides:");
        label2 = new JLabel("Color:");
        label3 = new JLabel("Size:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        sizeField = new JSpinner(new SpinnerNumberModel(5, 5, 100, 5));
        sidesField.setValue(6);
        sizeField.setValue(20);
        String[] colors={"Random Color","Black"};
        colorCombo = new JComboBox(colors);
        randSizeCheck=new JCheckBox("Random Size");
        JDialog getSizeInput;
        add(label1);
        add(sidesField);
        add(label2);
        add(colorCombo);
        add(label3);
        add(sizeField);
        add(randSizeCheck);

        //  Circle
        labelc1= new JLabel("Color: ");
        labelc2= new JLabel("Radius: ");
        radiusField = new JSpinner(new SpinnerNumberModel(10, 10, 125, 5));

        // Star
        labelS1= new JLabel("Color: ");
        labelS2= new JLabel("Radius: ");
        labelS3= new JLabel("Number of points: ");
        nrOfPointsField= new JSpinner(new SpinnerNumberModel(5, 5, 10, 1));
    }
}
