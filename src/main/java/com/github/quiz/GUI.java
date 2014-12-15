package com.github.quiz;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class GUI {
    // GUI components
    JFrame window;  // Main window
    JPanel statusBar;  // Status bar

    JLabel questionLabel;  // Current question

    JButton startButton;  // "Start" button
    JButton finishButton;  // "Finish" button

    JButton answerButton1;  // First answer
    JButton answerButton2;  // Second answer
    JButton answerButton3;  // Third answer
    JButton answerButton4;  // Fourth answer

    JProgressBar progressBar;  // Quiz progress bar

    // Logic

    public GUI () {
        this.window = new JFrame();
        this.window.setLayout(new MigLayout(
                "insets 10",
                "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"  // Please
        ));
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.setTitle("Quiz");
        this.window.setSize(600, 600);

        this.initUI();
    }

    public void initUI(){
        // Initialize components
        this.statusBar = new JPanel(new MigLayout("", "[grow]"));

        this.questionLabel = new JLabel("Click 'start' to begin!");

        this.startButton = new JButton("Start");
        this.finishButton = new JButton("Finish");

        this.answerButton1 = new JButton("???");
        this.answerButton2 = new JButton("???");
        this.answerButton3 = new JButton("???");
        this.answerButton4 = new JButton("???");

        this.progressBar = new JProgressBar(0, 10);

        // Set component defaults

        this.finishButton.setEnabled(false);

        this.answerButton1.setEnabled(false);
        this.answerButton2.setEnabled(false);
        this.answerButton3.setEnabled(false);
        this.answerButton4.setEnabled(false);

        this.progressBar.setStringPainted(true);

        // Add components to their containers

        this.statusBar.setSize(600, 50);
        this.statusBar.add(this.progressBar, "grow");

        /// Row 1: Question label and start/finish buttons

        this.window.add(this.questionLabel, "align center, span 14, grow");
        this.window.add(this.startButton, "align right, span 1, grow");
        this.window.add(this.finishButton, "align right, span 1, grow");

        /// Row 2: Answer buttons

        /// Bottom dock: Progress

        this.window.add(this.statusBar, "dock south");
    }
}
