package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel
{
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    public ControlPanel(MainFrame frame)
    {
        this.frame = frame; init();
    }
    private void init()
    {
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e)
    {
        try
        {
            ImageIO.write(frame.canvas.image, "PNG", new File("e:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e)
    {
        try
        {
            File file = new File("e:/test.png");
            frame.canvas.image=ImageIO.read(file);
            frame.canvas.graphics = frame.canvas.image.createGraphics();
            frame.canvas.update(frame.canvas.graphics);
            //frame.canvas.paintComponent(frame.canvas.graphics);
            frame.repaint();
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e)
    {
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, frame.canvas.W, frame.canvas.H);
        frame.repaint();
    }
    private void exit(ActionEvent e)
    {
        System.exit(0);
    }
}
