package com.example.demo.questions;

public class question {

    // Attributes of a question (e.g., text of the question, possible answers, correct answer, etc.)
    private String questionText;
    private String[] options;
    private int correctOptionIndex;

    private int id;

    private String explain;

    // Constructor
    public question(int id, String questionText, String[] options, int correctOptionIndex, String explain) {
        this.questionText = questionText;
        this.id = id;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
        this.explain = explain;
    }

    // Getter and Setter methods
    public String getQuestionText() {
        return questionText;
    }


    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }

    // Method to check if a given answer is correct
    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctOptionIndex;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

