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

class GUI {
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

    private final Icon currentIcon;
    private final Icon inactiveIcon;
    private final Icon rightIcon;
    private final Icon wrongIcon;

    // Our classes

    private final Questions questions;
    private final HashMap<String, HashMap<String, Object>> pickedQuestions;
    private String current;
    private Integer currentNumber;
    private Integer correctNumber;

    // Logic

    public GUI () {
        this.currentIcon = createImageIcon("/images/current.png", "current question");
        this.inactiveIcon = createImageIcon("/images/inactive.png", "inactive question");
        this.rightIcon = createImageIcon("/images/right.png", "correct question");
        this.wrongIcon = createImageIcon("/images/wrong.png", "incorrect question");

        this.questions = new Questions();
        this.pickedQuestions = new HashMap<>();

        this.current = null;
        this.currentNumber = 0;
        this.correctNumber = 0;

        this.window = new JFrame();
        this.window.setLayout(new MigLayout(
                "insets 7",
                "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"  // Please
        ));
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.setTitle("Quiz");
        this.window.setSize(750, 194);
        this.window.setResizable(false);
        this.window.setLocationRelativeTo(null);

        this.initUI();
        this.setHandlers();
    }

    void resetIcons() {
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
    }

    void setIcon(Integer index, Icon icon) {
        JLabel label;

        switch(index) {
            case 0:
            case 1:
                label = this.answerView1;
                break;
            case 2:
                label = this.answerView2;
                break;
            case 3:
                label = this.answerView3;
                break;
            case 4:
                label = this.answerView4;
                break;
            case 5:
                label = this.answerView5;
                break;
            case 6:
                label = this.answerView6;
                break;
            case 7:
                label = this.answerView7;
                break;
            case 8:
                label = this.answerView8;
                break;
            case 9:
                label = this.answerView9;
                break;
            case 10:
                label = this.answerView10;
                break;
            default:
                return;
        }

        label.setIcon(icon);
    }

    void pickQuestions() {
        this.pickedQuestions.clear();
        this.current = null;
        this.currentNumber = 0;
        this.correctNumber = 0;
        this.resetIcons();

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

    String pickQuestion(){
        Random random = new Random();
        ArrayList<String> keys = new ArrayList<>(this.pickedQuestions.keySet());

        if (keys.size() < 1) {
            return null;
        }

        return keys.get(random.nextInt(keys.size()));
    }

    void initUI(){
        /// Initialize components
        this.statusBar = new JPanel(new MigLayout("", "[grow][grow][grow]"));

        this.questionLabel = new JLabel("Click 'start' to begin!");
        this.questionLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        this.questionLabel.setVerticalTextPosition(SwingConstants.CENTER);
        this.questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.questionLabel.setVerticalAlignment(SwingConstants.CENTER);

        this.startButton = new JButton("Start");
        this.finishButton = new JButton("Finish");

        this.answerButton1 = new JButton("???");
        this.answerButton2 = new JButton("???");
        this.answerButton3 = new JButton("???");
        this.answerButton4 = new JButton("???");

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

        /// Set component defaults

        this.statusBar.setBorder(new MatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        this.statusBar.setSize(600, 50);
        this.statusBar.setBackground(Color.LIGHT_GRAY);

        this.startButton.setBackground(Color.LIGHT_GRAY);
        this.finishButton.setBackground(Color.LIGHT_GRAY);

        this.finishButton.setEnabled(false);

        this.answerButton1.setEnabled(false);
        this.answerButton2.setEnabled(false);
        this.answerButton3.setEnabled(false);
        this.answerButton4.setEnabled(false);

        this.answerViewContainer.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        this.answerViewContainer.setBackground(Color.LIGHT_GRAY);
        this.answerViewContainer.setSize(600, 50);

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

        /// Add components to their containers

        this.statusBar.add(this.startButton, "width 20%, cell 0 0, align left");
        this.statusBar.add(this.finishButton, "width 20%, cell 14 0, align right");

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

        /// Row 1: Question label

        this.window.add(this.questionLabel, "grow, span, align center, wrap");

        /// Row 2-3: Answer buttons

        this.window.add(this.answerButton1, "gap left 97, width 50%");
        this.window.add(this.answerButton2, "width 50%, wrap");
        this.window.add(this.answerButton3, "gap left 97, width 50%");
        this.window.add(this.answerButton4, "width 50%, wrap");

        this.answerButton1.setSize(100, 50);
        this.answerButton2.setSize(100, 50);
        this.answerButton3.setSize(100, 50);
        this.answerButton4.setSize(100, 50);

        /// Bottom dock: Progress

        this.window.add(this.statusBar, "dock south");

        /// Make it visible

        this.window.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    void nextQuestion() {
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
                    "Correct: %s/10. Click 'Start' to play again!", this.correctNumber
            ));

            return;
        }

        this.questionLabel.setText(this.current);
        this.setIcon(this.currentNumber + 1, this.currentIcon);
        this.currentNumber += 1;
        ArrayList<String> answers = (ArrayList<String>) this.pickedQuestions.get(this.current).get("answers");
        Collections.shuffle(answers);

        this.answerButton1.setText(answers.get(0));
        this.answerButton2.setText(answers.get(1));
        this.answerButton3.setText(answers.get(2));
        this.answerButton4.setText(answers.get(3));
    }

    void checkQuestion(String answer) {
        String correct = (String) this.questions.getQuestions().get(this.current).get("correct");

        if (answer.equals(correct)) {
            // Correct!
            this.setIcon(this.currentNumber, this.rightIcon);
            this.correctNumber += 1;
        } else {
            // Wrong!
            this.setIcon(this.currentNumber, this.wrongIcon);
        }

        this.pickedQuestions.remove(this.current);
        this.nextQuestion();
    }

    void setHandlers() {
        this.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                finishButton.setEnabled(true);

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

                setIcon(currentNumber, inactiveIcon);

                questionLabel.setText(String.format(
                        "Correct: %s/10. Click 'Start' to play again!", correctNumber
                ));
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
    ImageIcon createImageIcon(String path, String description) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
