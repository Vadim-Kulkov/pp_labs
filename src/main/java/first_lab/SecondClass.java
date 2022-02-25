package first_lab;

public class SecondClass{

    private int firstVariable;
    private int secondVariable;

    public SecondClass(int firstVariable, int secondVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
    }

    public int randomMethod() {
        return firstVariable * secondVariable;
    }

    public int getFirstVariable() {
        return firstVariable;
    }
    public void setFirstVariable(int firstVariable) {
        this.firstVariable = firstVariable;
    }

    public int getSecondVariable() {
        return secondVariable;
    }
    public void setSecondVariable(int secondVariable) {
        this.secondVariable = secondVariable;
    }

}