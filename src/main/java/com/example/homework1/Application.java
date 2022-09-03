package com.example.homework1;

import com.example.homework1.service.Exam;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Exam exam = context.getBean("exam", Exam.class);
        exam.examStudents("src/main/resources/data.csv");
        context.close();
    }
}
