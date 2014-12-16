package com.github.quiz;

import java.util.HashMap;

class Questions {
    private final HashMap<String, HashMap<String, Object>> questions;
    private final Storage storage;

    public Questions() {
        this.storage = new Storage();
        this.questions = this.storage.load();

        System.out.printf("Loaded %s questions.", this.questions.size());
    }

    public HashMap<String, HashMap<String, Object>> getQuestions() {
        return questions;
    }
}
