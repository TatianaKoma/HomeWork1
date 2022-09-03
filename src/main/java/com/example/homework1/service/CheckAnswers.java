package com.example.homework1.service;

import java.util.List;

public interface CheckAnswers {
    int getScoreForTest(List<Integer> studentChoices, List<Integer> correctAnswers);
}
