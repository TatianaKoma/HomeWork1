package com.example.homework1.service;

import java.util.List;
import java.util.Map;

public interface AskQuestions {
    List<Integer> askExamQuestions(Map<String, List<String>> questionsWithAnswers);
    String askInfoQuestions(String question);
}
