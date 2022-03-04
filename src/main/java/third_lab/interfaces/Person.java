package third_lab.interfaces;

import third_lab.exceptions.SpecialException;

public interface Person {

    int[] getExamScores();

    void setExamScores(int[] examScores);

    String getSign();

    void setSign(String sign);

    int getId();

    void setId(int id);

    int findAverageExamScores() throws SpecialException;
}
