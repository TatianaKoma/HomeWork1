package com.example.homework1.service;

import java.util.List;

public class CheckAnswersImpl implements CheckAnswers {

    @Override
    public int getScoreForTest(List<Integer> studentChoices, List<Integer> correctAnswers) {
        int testScore = 0;
        for (int i = 0; i < studentChoices.size(); i++) {
            if (studentChoices.get(i) == correctAnswers.get(i)) {
                testScore++;
            }
        }
        return testScore;
    }
}
