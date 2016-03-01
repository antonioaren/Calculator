package es.ulpgc.eite.calculator.core.model;


public class CalculatorModel implements I_CalculatorModel {

    private int _result;
    private NumberValidator _validator;

    public class DivideByZero extends Exception {
        private static final long serialVersionUID = 1L;
    }

    public CalculatorModel() {
        setValidator(new NumberValidator(
                Integer.MIN_VALUE, Integer.MAX_VALUE));
        reset();
    }

    public CalculatorModel(int minValue, int maxValue) {
        setValidator(new NumberValidator(minValue, maxValue));
        reset();
    }

    @Override
    public void add(int operand) throws Exception {
        long newResult = (long) getResult() + operand;
        getValidator().checkBounds(newResult);
        setResult((int) newResult);
    }

    @Override
    public void subtract(int operand) throws Exception {
        long newResult = (long) getResult() - operand;
        getValidator().checkBounds(newResult);
        setResult((int) newResult);
    }

    @Override
    public void multiply(int operand) throws Exception {
        long newResult = (long) getResult() * operand;
        getValidator().checkBounds(newResult);
        setResult((int) newResult);
    }

    @Override
    public void divide(int operand) throws Exception {
        if (operand == 0) {
            throw new DivideByZero();
        }

        long newResult = (long) getResult() / operand;
        getValidator().checkBounds(newResult);
        setResult((int) newResult);
    }

    @Override
    public void reset() {
        setResult(0);
    }


    @Override
    public int getResult() {
        return _result;
    }

    @Override
    public NumberValidator getValidator() {
        return _validator;
    }

    @Override
    public void setValidator(NumberValidator validator) {
        _validator = validator;
    }

    @Override
    public void setResult(int value) {
        _result = value;
    }


}
