package sixth_lab.factories;

import sixth_lab.entities.PersonDecorator;
import sixth_lab.entities.Student;
import sixth_lab.interfaces.Factory;

public class PersonDecoratorFactory implements Factory {

    @Override
    public PersonDecorator createInstance() {
        return new PersonDecorator(new Student());
    }
}
