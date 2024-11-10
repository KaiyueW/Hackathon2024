package com.example.demo.questions;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionBankService {

    private final List<question> questionBank; // Stores all questions in the bank

    // Constructor initializes the question bank list
    public QuestionBankService() {
        this.questionBank = new ArrayList<>();
    }

    // Method to add a new question to the bank
    public void addQuestion(question question) {
        questionBank.add(question);
    }

    // Method to retrieve all questions
    public List<question> getAllQuestions() {
        return new ArrayList<>(questionBank); // Return a copy to avoid modification outside the service
    }

    // Method to get a specific question by its ID
    public Optional<question> getQuestionById(int id) {
        return questionBank.stream()
                .filter(question -> question.getId() == id)
                .findFirst();
    }

    // Method to retrieve a random set of questions (e.g., 5 questions)
    public List<question> getRandomQuestions(int numberOfQuestions) {
        if (numberOfQuestions > questionBank.size()) {
            throw new IllegalArgumentException("Not enough questions in the bank to fulfill the request.");
        }

        // Create a copy of the question bank, shuffle it, and return the sublist
        List<question> shuffledQuestions = new ArrayList<>(questionBank);
        Collections.shuffle(shuffledQuestions);
        return shuffledQuestions.subList(0, numberOfQuestions);
    }
}
