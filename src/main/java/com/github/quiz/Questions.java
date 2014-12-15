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
