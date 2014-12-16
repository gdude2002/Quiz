package com.github.quiz;

import javax.swing.*;
import java.awt.EventQueue;

/**
 * Application entry point
 */
class Main {

    public static void main (String ... args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new GUI();
            }
        });
    }
}
