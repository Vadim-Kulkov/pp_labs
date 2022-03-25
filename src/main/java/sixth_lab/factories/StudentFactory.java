package sixth_lab.factories;

import sixth_lab.interfaces.Factory;
import sixth_lab.entities.Student;

public class StudentFactory implements Factory {

    @Override
    public Student createInstance() {
        return new Student();
    }
}
