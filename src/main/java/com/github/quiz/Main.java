package com.github.quiz;

import java.awt.EventQueue;

/**
 * Application entry point
 */
public class Main {

    public static void main (String ... args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    }
}
