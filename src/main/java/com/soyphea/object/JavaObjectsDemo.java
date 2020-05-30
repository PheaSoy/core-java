package com.soyphea.object;


import com.soyphea.model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class JavaObjectsDemo {

    static Logger logger = LogManager.getLogger(JavaObjectsDemo.class);

    public static void main(String args[]) {

        Student student = new Student(null, 'M', "12A");
        logger.info("Student is null:" + Objects.isNull(student));
        Objects.requireNonNull(student.getName(), () -> generateErrorMessage(student));
    }

    public static String generateErrorMessage(Student student) {
        return "Boom Student name is null now!!!";
    }

    class MyCustomException extends RuntimeException {

        public MyCustomException() {
            super();
        }

        public MyCustomException(String message) {
            super(message);
        }
    }
}
