package com.example.demo.questions;

public class questionBank {
    private question[] questions; // Array to store questions
    private int numberOfQuestions; // Keeps track of the number of questions in the bank
    private final int maxQuestions = 10000; // Maximum number of questions that the bank can hold

    // Constructor to initialize the question bank with a specified capacity
    public questionBank() {
        this.questions = new question[maxQuestions];
        this.numberOfQuestions = 0; // Initially, no questions are in the bank
    }

    // Method to add a question to the bank
    public boolean addQuestion(question question) {
        if (numberOfQuestions < maxQuestions) {
            questions[numberOfQuestions] = question;
            numberOfQuestions++;
            return true;
        } else {
            System.out.println("Question bank is full. Cannot add more questions.");
            return false;
        }
    }

    // Method to retrieve a question by its index
    public question getQuestion(int index) {
        if (index >= 0 && index < numberOfQuestions) {
            return questions[index];
        } else {
            System.out.println("Invalid question index.");
            return null;
        }
    }

    // Method to get the total number of questions in the bank
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
}

