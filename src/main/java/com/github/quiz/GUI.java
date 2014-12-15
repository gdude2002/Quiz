package com.github.quiz;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class GUI {
    // GUI components
    private final JFrame window;  // Main window
    private JPanel statusBar;  // Status bar

    private JLabel questionLabel;  // Current question

    private JButton startButton;  // "Start" button
    private JButton finishButton;  // "Finish" button

    private JButton answerButton1;  // First answer
    private JButton answerButton2;  // Second answer
    private JButton answerButton3;  // Third answer
    private JButton answerButton4;  // Fourth answer

    private JProgressBar progressBar;  // Quiz progress bar
    private JProgressBar correctProgress;  // Progress bar for correct answers
    private JProgressBar incorrectProgress;  // Progress bar for incorrect answers

    // Logic

    public GUI () {
        this.window = new JFrame();
        this.window.setLayout(new MigLayout(
                "insets 7",
                "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"  // Please
        ));
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.setTitle("Quiz");
        this.window.setSize(750, 156);
        this.window.setResizable(false);
        this.window.setLocationRelativeTo(null);

        this.initUI();
    }

    public void initUI(){
        // Initialize components
        this.statusBar = new JPanel(new MigLayout("", "[grow][grow][grow]"));

        this.questionLabel = new JLabel("Click 'start' to begin!");

        this.startButton = new JButton("Start");
        this.finishButton = new JButton("Finish");

        this.answerButton1 = new JButton("???");
        this.answerButton2 = new JButton("???");
        this.answerButton3 = new JButton("???");
        this.answerButton4 = new JButton("???");

        this.correctProgress = new JProgressBar(0, 10);
        this.progressBar = new JProgressBar(0, 10);
        this.incorrectProgress = new JProgressBar(0, 10);

        // Set component defaults

        this.statusBar.setBorder(new MatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));

        this.finishButton.setEnabled(false);

        this.answerButton1.setEnabled(false);
        this.answerButton2.setEnabled(false);
        this.answerButton3.setEnabled(false);
        this.answerButton4.setEnabled(false);

        this.correctProgress.setStringPainted(true);
        this.progressBar.setStringPainted(true);
        this.incorrectProgress.setStringPainted(true);

        this.correctProgress.setForeground(Color.GREEN);
        this.incorrectProgress.setForeground(Color.RED);

        // Add components to their containers

        this.statusBar.setSize(600, 50);
        this.statusBar.add(this.correctProgress, "grow");
        this.statusBar.add(this.progressBar, "grow");
        this.statusBar.add(this.incorrectProgress, "grow");

        /// Row 1: Question label and start/finish buttons

        this.window.add(this.questionLabel, "cell 0 0 14 1, grow");
        this.window.add(this.startButton, "cell 15 0, grow");
        this.window.add(this.finishButton, "cell 16 0, grow");

        /// Row 2-3: Answer buttons

        this.window.add(this.answerButton1, "cell 4 1 5 1, grow");
        this.window.add(this.answerButton2, "cell 10 1 5 1, grow");

        this.window.add(this.answerButton3, "cell 4 2 5 1, grow");
        this.window.add(this.answerButton4, "cell 10 2 5 1, grow");

        /// Bottom dock: Progress

        this.window.add(this.statusBar, "dock south");

        /// Make it visible

        this.window.setVisible(true);
    }
}
