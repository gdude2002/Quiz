package com.github.quiz;

import java.util.Arrays;
import java.util.HashMap;

public class Questions {
    public final HashMap<String, HashMap<String, Object>> questions;

    public Questions() {
        this.questions = new HashMap<>();

        this.addQuestion(
                "How many times Have Manchester United won the F.A. Cup?",  // Question
                3,  // Correct index
                "8", "9", "10", "11"  // Answers
        );

        this.addQuestion(
                "Who holds the record for the most losses in total in the English Soccer Leagues History?",  // Question
                3,  // Correct index
                "Burnley", "Sunderland", "Norwich", " Everton"  // Answers
        );

        this.addQuestion(
                "Who is the world cups all time top goal scorer?",  // Question
                2,  // Correct index
                "Pele", "Ronaldo", "Miroslav Klose", "Gerd Mueller"  // Answers
        );

        this.addQuestion(
                "Who holds the record for most Premier League goals?",  // Question
                0,  // Correct index
                "Alan Shearer", "Andrew Cole", "Wayne Rooney", "Thierry Henry"  // Answers
        );

        this.addQuestion(
                "How many clubs have won the Champions League 5 or more times?",  // Question
                2,  // Correct index
                "2", "3", "4", "5"  // Answers
        );

        this.addQuestion(
                "Which english club knocked both Liverpool F.C. and Chelsea F.C. out of the 2007/2008 FA Cup?",  // Question
                3,  // Correct index
                "Bradford", "Burnley", "Manchester United", "Barnsley"  // Answers
        );
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
