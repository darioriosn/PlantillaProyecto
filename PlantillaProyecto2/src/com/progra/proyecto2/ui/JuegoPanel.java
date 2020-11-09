/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.proyecto2.ui;

import com.progra.proyecto2.entidades.Jugador;
import com.progra.utils.ImageLoader;
import com.progra.utils.SpriteSheet;
import com.progra.utils.SpriteSheetBuilder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Dario
 */
public class JuegoPanel extends JPanel implements KeyListener, Runnable {

    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    Jugador jugador = null;
    private SpriteSheet spriteSheet;

    public JuegoPanel(String flag) {
        try {
            ImageLoader imgLoader = new ImageLoader();
            image1 = imgLoader.getImage(Panel.class.getResource("/com/progra/proyecto2/resources/explore1.jpg"));
            image2 = imgLoader.getImage(Panel.class.getResource("/com/progra/proyecto2/resources/explore2.jpg"));
            image3 = imgLoader.getImage(Panel.class.getResource("/com/progra/proyecto2/resources/explore3.jpg"));
            BufferedImage sheet = ImageIO.read(Panel.class.getResource("/com/progra/proyecto2/resources/tanks.png"));
            spriteSheet = new SpriteSheetBuilder()
                    .withSheet(sheet)
                    .withColumns(8)
                    .withRows(8)
                  //  .withSpriteSize(40, 34)
                    .withSpriteCount(64).
                    build();
            jugador = new Jugador(400, 300);
        } catch (IOException ex) {
            Logger.getLogger(JuegoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        //draw the score board
        g.setColor(Color.blue);
        g.fillRect(0, 0, 600, 400);

        this.dibujarTanque(g, jugador.getX(), jugador.getY(), jugador.getDirection(), "Jugador");
        BufferedImage sprite = spriteSheet.getSprite(1);
        int x = (getWidth() - sprite.getWidth()) / 2;
        int y = (getHeight() - sprite.getHeight()) / 2;
        g.drawImage(sprite, x, y, this);

    }

    public void dibujarTanque(Graphics g, int x, int y, String direction, String type) {
        //determine if the type is player or enemy
        switch (type) {
            case "Jugador":
                g.setColor(Color.white);
                break;
            case "Enemigo":
                g.setColor(Color.yellow);
                break;
        }

        switch (direction) {
            case "Norte":
                //draw tanks left foot
                g.fill3DRect(x, y, 5, 30, false);
                //draw the tanks right foot
                g.fill3DRect(x + 15, y, 5, 30, false);
                //draw the body of the tank
                g.fill3DRect(x + 5, y + 5, 10, 20, true);
                //draw the weapon room
                g.setColor(Color.red);
                g.fillOval(x + 5, y + 10, 10, 10);
                //draw the weapon
                g.drawLine(x + 10, y + 15, x + 10, y);
                break;
            case "Oeste":
                //draw right foot tank
                g.fill3DRect(x + 10 - 15, y + 15 - 10, 30, 5, false);
                //draw left foot
                g.fill3DRect(x + 10 - 15, y + 15 + 5, 30, 5, false);
                //draw the body of the tank
                g.fill3DRect(x + 10 - 10, y + 15 - 5, 20, 10, true);
                //draw the weapon room
                g.setColor(Color.red);
                g.fillOval(x + 10 - 5, y + 15 - 5, 10, 10);
                //draw the weapon
                g.drawLine(x + 10, y + 15, x + 10 - 15, y + 15);
                break;
            case "Sur":
                //draw right foot
                g.fill3DRect(x, y, 5, 30, false);
                //draw left foot
                g.fill3DRect(x + 15, y, 5, 30, false);
                //draw the body of the tank
                g.fill3DRect(x + 5, y + 5, 10, 20, true);
                //draw the weapon room
                g.setColor(Color.red);
                g.fillOval(x + 5, y + 10, 10, 10);
                //draw the weapon
                g.drawLine(x + 10, y + 15, x + 10, y + 25);
                break;
            case "Este":
                //draw left foot
                g.fill3DRect(x + 10 - 15, y + 15 - 10, 30, 5, false);
                //draw right foot
                g.fill3DRect(x + 10 - 15, y + 15 + 5, 30, 5, false);
                //draw the body of the tank
                g.fill3DRect(x + 10 - 10, y + 15 - 5, 20, 10, true);
                //draw the weapon room
                g.setColor(Color.red);
                g.fillOval(x + 10 - 5, y + 15 - 5, 10, 10);
                //draw the weapon
                g.drawLine(x + 10, y + 15, x + 10 + 15, y + 15);
                break;
        }
    }

    //permite manipular el control de jugador
    @Override
    public void keyPressed(KeyEvent k) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.repaint();
//			}
        }
    }

}
