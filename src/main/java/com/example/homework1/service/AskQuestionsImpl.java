package com.example.homework1.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class AskQuestionsImpl implements AskQuestions {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public List<Integer> askExamQuestions(Map<String, List<String>> questionsWithAnswers) {
        List<Integer> userChoices = new ArrayList<>();

        Iterator<Map.Entry<String, List<String>>> iterator = questionsWithAnswers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> pair = iterator.next();
            System.out.println(pair.getKey());
            System.out.println("Answer options: ");
            List<String> answersVariants = pair.getValue();
            IntStream.range(0, answersVariants.size()).mapToObj(i -> (i + 1) +
                   answersVariants.get(i)).forEachOrdered(System.out::println);
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

    // I used 'while' here in case the user input incorrect data many times
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
