package com.progra.proyecto2.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Principal implements ActionListener {

    JFrame jf;
    PanelInicio sp = null;
    JuegoPanel juegoPanel = null;
    PanelInicio startPanel = null;

    public Principal() {
        jf = new JFrame("Tank War");

        //crear Panel de inicio
        startPanel = new PanelInicio();
        //crear panel del hilo dentro de hilo
        Thread startPanelThread = new Thread(startPanel);
        startPanelThread.start();
        jf.add(startPanel);
        // comentar anterior. Crear Panel de juego dentro de hilo.
        juegoPanel = new JuegoPanel("New");
        Thread juegoPanelThread = new Thread(juegoPanel);
        juegoPanelThread.start();
        jf.add(juegoPanel);
        jf.setLocation(600, 300);
        jf.setResizable(false);
        jf.setSize(600, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Principal();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        // TODO Auto-generated method stub

    }

}

  
