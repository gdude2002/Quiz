package com.github.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Questions {
    public final HashMap<String, HashMap<String, Object>> questions;

    public Questions() {
        this.questions = new HashMap<>();

        this.addQuestion(
            "How many times Have Manchester United won the F.A. Cup?",  // Question
            3,  // Correct index
            "8", "9", "10", "11"  // Answers
        );

        /* `this.questions` now looks like this:

            this.questions = {
                "How many times Have Manchester United won the F.A. Cup?": {
                    "answers": [
                        "8", "9", "10", "11"
                    ],
                    "correct": "11"
                }
            }
         */

        this.addQuestion(
                "Who holds the record for the most losses in total in the English Soccer Leagues History?",  // Question
                3,  // Correct index
                "Burnley", "Sunderland", "Norwich", " Everton"  // Answers
        );

        /* `this.questions` now looks like this:

            this.questions = {
                 "Who holds the record for the most losses in total in the English Soccer Leagues History?"": {
                    "answers": [
                        "Burnley", "Sunderland", "Norwich", "Everton"
                    ],
                    "correct": "Everton"
                }
            }
         */
        this.addQuestion(
                "Who is the world cups all time top goal scorer?",  // Question
                2,  // Correct index
                "Pele", "Ronaldo", "Miroslav Klose", "Gerd Mueller"  // Answers
        );

        /* `this.questions` now looks like this:

            this.questions = {
                 "Who holds the record for the most losses in total in the English Soccer Leagues History?"": {
                    "answers": [
                        "Pele", "Ronaldo", "Miroslav Klose", "Gerd Mueller"
                    ],
                    "correct": "Miroslav Klose"
                }
            }
         */
        this.addQuestion(
                " Who holds the record for most Premier League goals??",  // Question
                0,  // Correct index
                "Alan Shearer", "Andrew Cole", "Wayne Rooney", "Thierry Henry"  // Answers
        );

        /* `this.questions` now looks like this:

            this.questions = {
                 "Who holds the record for most Premier League goals??"": {
                    "answers": [
                       "Alan Shearer", "Andrew Cole", "Wayne Rooney", "Thierry Henry"
                    ],
                    "correct": "Alan Shearer"
                }
            }
         */
        this.addQuestion(
                " How many clubs have won the Champions League 5 or more times?",  // Question
                2,  // Correct index
                "2", "3", "4", "5"  // Answers
        );

        /* `this.questions` now looks like this:

            this.questions = {
                 " How many clubs have won the Champions League 5 or more times?": {
                    "answers": [
                       "2", "3", "4", "5" , "Thierry Henry"
                    ],
                    "correct": "Alan Shearer"
                }
            }
         */
        this.addQuestion(
                "Which english club knocked both Liverpool F.C. and Chealsea F.C. out of the 2007/2008 FA Cup?",  // Question
                3,  // Correct index
                " Bradford", "Burnley", "Manchester United", "Barnsley"  // Answers
        );

        /* `this.questions` now looks like this:

            this.questions = {
                 " How many clubs have won the Champions League 5 or more times?": {
                    "answers": [
                       "2", "3", "4", "5" , "Thierry Henry"
                    ],
                    "correct": "Alan Shearer"
                }
            }
         */
    }

    /**
     * Add a question.
     *
     * @param question The question itself, including question mark
     * @param correctIndex The array index for the correct answer - starts at 0!
     * @param answers The answers themselves, as a set of String arguments
     */
    public void addQuestion(String question, Integer correctIndex, String ... answers) {
        HashMap<String, Object> questionMap = new HashMap<>();
        questionMap.put("answers", Arrays.asList(answers));
        questionMap.put("correct", answers[correctIndex]);

        this.questions.put(question, questionMap);
    }
}
