/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.currencyconvertor;

/**
 *
 * @author kali-i
 */

import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.ColorUIResource;

public class RoundedCornerTextField extends JTextField {
    public RoundedCornerTextField() {
        setOpaque(false);
        setBorder(new RoundBorder());
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!isOpaque()) {
            super.paintComponent(g);
            return;
        }

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Rounded corner arc radius
        int arc = 10;

        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, width - 1, height - 1, arc, arc);

        super.paintComponent(g);

        g2d.dispose();
    }

    // Set the background color explicitly to make it round
    @Override
    public void setBackground(Color bg) {
        if (bg instanceof ColorUIResource) {
            bg = null;
        }
        super.setBackground(bg);
    }

    private class RoundBorder extends AbstractBorder {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int arc = 20; 

            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(x, y, width - 1, height - 1, arc, arc);

            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(2, 5, 2, 5); // Adjust the insets as needed
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(2, 5, 2, 5); // Adjust the insets as needed
            return insets;
        }
    }
}
