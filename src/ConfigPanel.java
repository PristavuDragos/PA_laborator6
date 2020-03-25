package com.company;

import com.sun.prism.paint.Color;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel
{
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init()
    {
        label = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        sidesField.setValue(6);
        String[] colors={"Black","Random Color"};
        colorCombo = new JComboBox(colors);
        add(label);
        add(sidesField);
        add(colorCombo);
    }
}
