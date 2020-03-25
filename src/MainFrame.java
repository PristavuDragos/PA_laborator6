package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawPanel canvas;

    public MainFrame() {
        super("Better than Draw.io");
        init();
    }
    private void init()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);


        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

}
