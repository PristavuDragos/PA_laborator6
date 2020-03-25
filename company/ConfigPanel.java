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
    JSpinner sidesField;
    JSpinner sizeField;
    JComboBox colorCombo;
    JCheckBox randSizeCheck;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init()
    {
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
        add(randSizeCheck);
    }
}
