package com.github.quiz;

import java.util.HashMap;

/**
 * Simple questions storage wrapper. This was designed to be extended, but I never
 * got around to adding other questions handlers.
 */
class Questions {
    private final HashMap<String, HashMap<String, Object>> questions;

    public Questions() {
        Storage storage = new Storage();
        this.questions = storage.load();

        System.out.printf("Loaded %s questions.", this.questions.size());
    }

    public HashMap<String, HashMap<String, Object>> getQuestions() {
        return questions;
    }
}
