/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorbov;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Igor
 */
public class Gorbov {

    private Vector red = new Vector();
    private Vector black = new Vector();
    private BufferedImage field;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame f = new MainFrame();
        f.setVisible(true);
    }

    Gorbov() {
        for (int i = 1; i < 25; i++) {
            red.add(i);
            black.add(i);
        }
        black.add(25);
    }

    public void drawFillMatrix() {
        setField(new BufferedImage(561, 561, BufferedImage.TYPE_INT_ARGB));
        Graphics g = getField().getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.fillRect(0, 0, 561, 561);

        Vector copy_red = (Vector) red.clone();
        Vector copy_black = (Vector) black.clone();
        Color red_color = new Color(255, 64, 64);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                int color = new Random().nextInt(2);
                int elem_num = 0;
                int elem = 0;
                if (color == 0) { // red
                    if (!copy_red.isEmpty()) {
                        elem_num = new Random().nextInt(copy_red.size());
                        elem = (int) copy_red.get(elem_num);
                        copy_red.remove(elem_num);
                        g2.setColor(red_color);
                        System.out.println(copy_red);
                    } else if (!copy_black.isEmpty()) {
                        elem_num = new Random().nextInt(copy_black.size());
                        elem = (int) copy_black.get(elem_num);
                        copy_black.remove(elem_num);
                        g2.setColor(Color.BLACK);
                        System.out.println(copy_black);
                    }
                } else // black
                if (!copy_black.isEmpty()) {
                    elem_num = new Random().nextInt(copy_black.size());
                    elem = (int) copy_black.get(elem_num);
                    copy_black.remove(elem_num);
                    g2.setColor(Color.BLACK);
                    System.out.println(copy_black);
                } else // red
                 if (!copy_red.isEmpty()) {
                        elem_num = new Random().nextInt(copy_red.size());
                        elem = (int) copy_red.get(elem_num);
                        copy_red.remove(elem_num);
                        g2.setColor(red_color);
                        System.out.println(copy_red);
                    }

                g2.setFont(new Font("Arial", Font.BOLD, 18));
                g2.fillRect(80 * i, 80 * j, 80, 80);
                g2.setColor(Color.WHITE);
                g2.drawString(String.valueOf(elem), 80 * i + 35, 80 * j + 45);
            }
        }

    }

    public void drawMatrix() {
        setField(new BufferedImage(561, 561, BufferedImage.TYPE_INT_ARGB));
        Graphics g = getField().getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.fillRect(0, 0, 561, 561);

        Vector copy_red = (Vector) red.clone();
        Vector copy_black = (Vector) black.clone();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                g2.setColor(Color.BLACK);
                g2.drawRect(80 * i, 80 * j, 80, 80);
                int color = new Random().nextInt(2);
                int elem_num = 0;
                int elem = 0;
                if (color == 0) { // red
                    if (!copy_red.isEmpty()) {
                        elem_num = new Random().nextInt(copy_red.size());
                        elem = (int) copy_red.get(elem_num);
                        copy_red.remove(elem_num);
                        g2.setColor(Color.RED);
                        System.out.println(copy_red);
                    } else if (!copy_black.isEmpty()) {
                        elem_num = new Random().nextInt(copy_black.size());
                        elem = (int) copy_black.get(elem_num);
                        copy_black.remove(elem_num);
                        g2.setColor(Color.BLACK);
                        System.out.println(copy_black);
                    }
                } else // black
                if (!copy_black.isEmpty()) {
                    elem_num = new Random().nextInt(copy_black.size());
                    elem = (int) copy_black.get(elem_num);
                    copy_black.remove(elem_num);
                    g2.setColor(Color.BLACK);
                    System.out.println(copy_black);
                } else // red
                 if (!copy_red.isEmpty()) {
                        elem_num = new Random().nextInt(copy_red.size());
                        elem = (int) copy_red.get(elem_num);
                        copy_red.remove(elem_num);
                        g2.setColor(Color.RED);
                        System.out.println(copy_red);
                    }

                g2.setFont(new Font("Arial", Font.BOLD, 22));
                g2.drawString(String.valueOf(elem), 80 * i + 32, 80 * j + 45);
            }
        }

    }

    /**
     * @return the red
     */
    public Vector getRed() {
        return red;
    }

    /**
     * @param red the red to set
     */
    public void setRed(Vector red) {
        this.red = red;
    }

    /**
     * @return the black
     */
    public Vector getBlack() {
        return black;
    }

    /**
     * @param black the black to set
     */
    public void setBlack(Vector black) {
        this.black = black;
    }

    /**
     * @return the field
     */
    public BufferedImage getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(BufferedImage field) {
        this.field = field;
    }

}
