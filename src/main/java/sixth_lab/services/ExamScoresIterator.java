package sixth_lab.services;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExamScoresIterator implements Iterator<Integer> {

    private final Integer[] examScoresList;

    private int index;

    public ExamScoresIterator(Integer[] personList) {
        this.examScoresList = personList;
    }

    public ExamScoresIterator(int[] personList) {
        Integer[] examScoresIntegerList = new Integer[personList.length];
        Arrays.setAll(examScoresIntegerList, i -> personList[i]);
        this.examScoresList = examScoresIntegerList;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        if (index >= examScoresList.length)
            return false;
        return examScoresList[index] != null;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next() {
        if (index >= examScoresList.length) {
            throw new NoSuchElementException();
        }
        return examScoresList[index++];
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
