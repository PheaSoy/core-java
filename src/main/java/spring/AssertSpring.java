package spring;

import model.Student;
import org.springframework.util.Assert;

public class AssertSpring {


    public static void main(String args[]) {
        Student student = null;
        Assert.notNull(student, "Student must be not null");
    }

}
