package com.example.homework1.service;

import com.example.homework1.model.Student;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExamImpl implements Exam {
    private static final List<Integer> CORRECT_ANSWERS = Arrays.asList(2, 2, 2, 3, 1);
    private final CsvParserImpl csvParser;
    private final AskQuestionsImpl askQuestions;
    private final CheckAnswersImpl checkAnswers;

    public ExamImpl(CsvParserImpl csvParser, AskQuestionsImpl askQuestions, CheckAnswersImpl checkAnswers) {
        this.csvParser = csvParser;
        this.askQuestions = askQuestions;
        this.checkAnswers = checkAnswers;
    }

    @Override
    public void examStudents() throws IOException {
        Map<String, List<String>> questionsWithAnswers = csvParser.getDataFromCsvFile();
        System.out.println("Hello.Welcome to the exam!");
        String name = askQuestions.askInfoQuestions("Please enter your name:");
        String surname = askQuestions.askInfoQuestions("Please enter your surname:");
        System.out.println("Lets start! After each question please choose the number of the answer you think is correct:\n");
        List<Integer> studentChoices = askQuestions.askExamQuestions(questionsWithAnswers);
        int examScore = checkAnswers.getScoreForTest(studentChoices, CORRECT_ANSWERS);
        Student student = new Student(name, surname, examScore);
        System.out.println(student);
    }
}
