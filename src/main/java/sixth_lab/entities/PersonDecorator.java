package sixth_lab.entities;

import sixth_lab.exceptions.SpecialException;
import sixth_lab.interfaces.Person;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class PersonDecorator implements Person {

    private final Person person;

    public PersonDecorator(Person person) {
        this.person = person;
    }

    @Override
    public int[] getExamScores() {
        return person.getExamScores();
    }

    @Override
    public void setExamScores(int[] examScores) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getSign() {
        return person.getSign();
    }

    @Override
    public void setSign(String sign) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getId() {
        return person.getId();
    }

    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int findAverageExamScores() throws SpecialException {
        return person.findAverageExamScores();
    }

    @Override
    public void output(OutputStream out) {
        person.output(out);
    }

    @Override
    public void write(Writer out) {
        person.write(out);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return person.iterator();
    }
}
