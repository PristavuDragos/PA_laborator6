package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
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
    JFileChooser fileChooser=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    public ControlPanel(MainFrame frame)
    {
        this.frame = frame; init();
    }
    private void init()
    {
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG images", "png", "jpg");
        fileChooser.addChoosableFileFilter(filter);
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
            fileChooser.setDialogTitle("Save/Name your file");
            int returnValue = fileChooser.showSaveDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if(!file.getAbsolutePath().contains("."))
                {
                    File auxFile = new File(file.getAbsolutePath()+".png");
                    ImageIO.write(frame.canvas.image, "PNG", auxFile);
                }
                else System.out.println("THE FILE SHOULD NOT HAVE '.' IN THE NAME");
            }
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e)
    {
        try
        {
            fileChooser.setDialogTitle("Select an image");
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION)
            {

                File file = fileChooser.getSelectedFile();
                if(file.getAbsolutePath().contains(".png") || file.getAbsolutePath().contains(".jpg"))
                {
                    frame.canvas.image = ImageIO.read(file);
                    frame.canvas.graphics = frame.canvas.image.createGraphics();
                    frame.canvas.update(frame.canvas.graphics);
                    //frame.canvas.paintComponent(frame.canvas.graphics);
                    frame.repaint();
                }
                else System.out.println("INVALID FILE TYPE");
            }
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e)
    {
        frame.canvas.shapes.clear();
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, frame.canvas.W, frame.canvas.H);
        frame.repaint();
    }
    private void exit(ActionEvent e)
    {
        System.exit(0);
    }
}
