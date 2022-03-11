package fourth_lab.interfaces;

import fourth_lab.exceptions.SpecialException;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

public interface Person extends Serializable {

    int[] getExamScores();

    void setExamScores(int[] examScores);

    String getSign();

    void setSign(String sign);

    int getId();

    void setId(int id);

    int findAverageExamScores() throws SpecialException;

    void output(OutputStream out);

    void write(Writer out);
}
