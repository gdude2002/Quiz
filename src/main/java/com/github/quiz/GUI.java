package com.github.quiz;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

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

    private JPanel answerViewContainer;

    private JLabel answerView1;
    private JLabel answerView2;
    private JLabel answerView3;
    private JLabel answerView4;
    private JLabel answerView5;
    private JLabel answerView6;
    private JLabel answerView7;
    private JLabel answerView8;
    private JLabel answerView9;
    private JLabel answerView10;

    // Icons

    Icon currentIcon;
    Icon inactiveIcon;
    Icon rightIcon;
    Icon wrongIcon;

    // Our classes

    private Questions questions;
    private HashMap<String, HashMap<String, Object>> pickedQuestions;
    private String current;

    // Logic

    public GUI () {
        this.currentIcon = createImageIcon("/images/current.png", "current question");
        this.inactiveIcon = createImageIcon("/images/inactive.png", "inactive question");
        this.rightIcon = createImageIcon("/images/right.png", "correct question");
        this.wrongIcon = createImageIcon("/images/wrong.png", "incorrect question");

        this.questions = new Questions();
        this.pickedQuestions = new HashMap<>();
        this.current = null;

        this.window = new JFrame();
        this.window.setLayout(new MigLayout(
                "insets 7",
                "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"  // Please
        ));
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.setTitle("Quiz");
        this.window.setSize(750, 206);
        this.window.setResizable(false);
        this.window.setLocationRelativeTo(null);

        this.initUI();
        this.setHandlers();
    }

    public void pickQuestions() {
        this.pickedQuestions.clear();
        this.current = null;

        Random random = new Random();
        ArrayList<String> keys = new ArrayList<>(this.questions.getQuestions().keySet());

        for (int i = 0; i < 10; i += 1) {
            if (keys.size() < 1) {
                return;  // No more questions available
            }

            String key = keys.get(random.nextInt(keys.size()));
            keys.remove(key);

            this.pickedQuestions.put(key, this.questions.getQuestions().get(key));
        }
    }

    public String pickQuestion(){
        Random random = new Random();
        ArrayList<String> keys = new ArrayList<>(this.pickedQuestions.keySet());

        if (keys.size() < 1) {
            return null;
        }

        return keys.get(random.nextInt(keys.size()));
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

        this.answerView1 = new JLabel();
        this.answerView2 = new JLabel();
        this.answerView3 = new JLabel();
        this.answerView4 = new JLabel();
        this.answerView5 = new JLabel();
        this.answerView6 = new JLabel();
        this.answerView7 = new JLabel();
        this.answerView8 = new JLabel();
        this.answerView9 = new JLabel();
        this.answerView10 = new JLabel();

        this.answerViewContainer = new JPanel(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow]"));

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

        this.answerViewContainer.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        this.answerViewContainer.setBackground(Color.LIGHT_GRAY);

        this.answerView1.setIcon(this.inactiveIcon);
        this.answerView2.setIcon(this.inactiveIcon);
        this.answerView3.setIcon(this.inactiveIcon);
        this.answerView4.setIcon(this.inactiveIcon);
        this.answerView5.setIcon(this.inactiveIcon);
        this.answerView6.setIcon(this.inactiveIcon);
        this.answerView7.setIcon(this.inactiveIcon);
        this.answerView8.setIcon(this.inactiveIcon);
        this.answerView9.setIcon(this.inactiveIcon);
        this.answerView10.setIcon(this.inactiveIcon);

        // Add components to their containers

        this.statusBar.setSize(600, 50);
        this.statusBar.add(this.correctProgress, "grow");
        this.statusBar.add(this.progressBar, "grow");
        this.statusBar.add(this.incorrectProgress, "grow");

        this.answerViewContainer.add(this.answerView1, "align center");
        this.answerViewContainer.add(this.answerView2, "align center");
        this.answerViewContainer.add(this.answerView3, "align center");
        this.answerViewContainer.add(this.answerView4, "align center");
        this.answerViewContainer.add(this.answerView5, "align center");
        this.answerViewContainer.add(this.answerView6, "align center");
        this.answerViewContainer.add(this.answerView7, "align center");
        this.answerViewContainer.add(this.answerView8, "align center");
        this.answerViewContainer.add(this.answerView9, "align center");
        this.answerViewContainer.add(this.answerView10, "align center");

        this.window.add(this.answerViewContainer, "dock north");

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

    @SuppressWarnings("unchecked")
    public void nextQuestion() {
        this.current = pickQuestion();

        if (this.current == null) {
            finishButton.setEnabled(false);
            startButton.setEnabled(true);

            answerButton1.setText("???");
            answerButton2.setText("???");
            answerButton3.setText("???");
            answerButton4.setText("???");

            answerButton1.setEnabled(false);
            answerButton2.setEnabled(false);
            answerButton3.setEnabled(false);
            answerButton4.setEnabled(false);

            questionLabel.setText(String.format(
                    "Correct: %s/%s. Click 'Start' to play again!", correctProgress.getValue(), progressBar.getValue()
            ));

            progressBar.setValue(0);
            correctProgress.setValue(0);
            incorrectProgress.setValue(0);

            return;
        }

        this.questionLabel.setText(this.current);
        ArrayList<String> answers = (ArrayList<String>) this.pickedQuestions.get(this.current).get("answers");
        Collections.shuffle(answers);

        this.answerButton1.setText(answers.get(0));
        this.answerButton2.setText(answers.get(1));
        this.answerButton3.setText(answers.get(2));
        this.answerButton4.setText(answers.get(3));
    }

    public void checkQuestion(String answer) {
        String correct = (String) this.questions.getQuestions().get(this.current).get("correct");

        if (answer.equals(correct)) {
            // Correct!
            this.correctProgress.setValue(this.correctProgress.getValue() + 1);
        } else {
            // Wrong!
            this.incorrectProgress.setValue(this.incorrectProgress.getValue() + 1);
        }

        progressBar.setValue(progressBar.getValue() + 1);

        this.pickedQuestions.remove(this.current);
        this.nextQuestion();
    }

    public void setHandlers() {
        this.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                finishButton.setEnabled(true);

                progressBar.setValue(0);
                correctProgress.setValue(0);
                incorrectProgress.setValue(0);

                pickQuestions();
                nextQuestion();

                answerButton1.setEnabled(true);
                answerButton2.setEnabled(true);
                answerButton3.setEnabled(true);
                answerButton4.setEnabled(true);
            }
        });

        this.finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finishButton.setEnabled(false);
                startButton.setEnabled(true);

                answerButton1.setText("???");
                answerButton2.setText("???");
                answerButton3.setText("???");
                answerButton4.setText("???");

                answerButton1.setEnabled(false);
                answerButton2.setEnabled(false);
                answerButton3.setEnabled(false);
                answerButton4.setEnabled(false);

                questionLabel.setText(String.format(
                        "Correct: %s/%s. Click 'Start' to play again!", correctProgress.getValue(), progressBar.getValue()
                ));

                progressBar.setValue(0);
                correctProgress.setValue(0);
                incorrectProgress.setValue(0);
            }
        });

        this.answerButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkQuestion(answerButton1.getText());
            }
        });

        this.answerButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkQuestion(answerButton2.getText());
            }
        });

        this.answerButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkQuestion(answerButton3.getText());
            }
        });

        this.answerButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkQuestion(answerButton4.getText());
            }
        });
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path, String description) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
