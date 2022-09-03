package com.example.homework1.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AskQuestionsImpl implements AskQuestions {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public List<Integer> askExamQuestions(Map<String, List<String>> questionsWithAnswers) {
        List<Integer> userChoices = new ArrayList<>();

        Iterator iterator = questionsWithAnswers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println(pair.getKey());
            System.out.println("Answer options: ");
            List<String> answersVariants = (List<String>) pair.getValue();
            for (int i = 0; i < answersVariants.size(); i++) {
                System.out.println((i + 1) + answersVariants.get(i));
            }
            System.out.println("Your choice: ");
            String answer = SCANNER.nextLine();
            int studentAnswer = checkStudentChoice(answer);
            userChoices.add(studentAnswer);
            iterator.remove();
        }
        return userChoices;
    }

    @Override
    public String askInfoQuestions(String question) {
        System.out.println(question);
        return SCANNER.nextLine();
    }

    private int checkStudentChoice(String answer) {
        int studentAnswer;
        while (true) {
            try {
                studentAnswer = Integer.parseInt(answer);
                return studentAnswer;
            } catch (NumberFormatException e) {
                System.out.println("Your input is incorrect. Try again.");
                answer = SCANNER.nextLine();
            }
        }
    }
}
