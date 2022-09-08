package com.example.homework1;

import com.example.homework1.service.Exam;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Exam exam = context.getBean("exam", Exam.class);
        exam.examStudents();
        context.close();
    }
}
