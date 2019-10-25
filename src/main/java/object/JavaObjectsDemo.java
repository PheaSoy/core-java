package object;

import model.Student;
import org.apache.log4j.Logger;

import java.util.Objects;


public class JavaObjectsDemo {

    static Logger logger = Logger.getLogger(JavaObjectsDemo.class);

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
