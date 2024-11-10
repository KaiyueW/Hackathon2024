package com.example.demo.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/questionbank")
@CrossOrigin(origins = "http://localhost:63342")
public class questionbankController {

    @Autowired
    private QuestionBankService questionBankService; // Assuming a service layer for question management



    @GetMapping("/random5")
    public List<question> getRandomFiveQuestions() {
        List<question> allQuestions = questionBankService.getAllQuestions(); // Fetch all questions

        if (allQuestions.size() < 5) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Not enough questions in the question bank"
            );
        }

        // Shuffle the list and return a sublist of 5 questions
        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, 5);
    }

}
