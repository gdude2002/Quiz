package com.github.quiz;

import javax.swing.*;
import java.awt.EventQueue;

/**
 * Application entry point
 */
class Main {

    public static void main (String ... args) {
        // Start up the event queue
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Set the JGoodies native Look+Feel
                    UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");

                } catch (Exception e) {
                    // If it can't be set, print the error, we'll just use Swing's default crappy look
                    e.printStackTrace();
                }

                // Create our GUI and do our startup tasks
                new GUI();
            }
        });
    }
}
