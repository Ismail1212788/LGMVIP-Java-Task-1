/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.currencyconvertor;

/**
 *
 * @author kali-i
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagePanel extends JPanel {

    private BufferedImage image;
 private double scale = 0.8; // Initial scale factor

    public ImagePanel() {
        try {
            // Load an image from a file (you can change the path)
            image = ImageIO.read(new File("index.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
              Graphics2D g2d = (Graphics2D) g.create();
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();
            
            // Calculate the center position
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

             // Translate to the center and then apply scaling
            g2d.translate(centerX, centerY);
            g2d.scale(scale, scale);
            
           
 // Draw the image centered after scaling
            int imageX = -image.getWidth() / 2;
            int imageY = -image.getHeight() / 2;
            g2d.drawImage(image, imageX, imageY, this);

            g2d.dispose();
        }
    }

}