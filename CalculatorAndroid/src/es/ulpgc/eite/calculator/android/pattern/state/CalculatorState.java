package es.ulpgc.eite.calculator.android.pattern.state;


import es.ulpgc.eite.calculator.core.model.NumberValidator;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;

public class CalculatorState implements I_ScreenState {

    private String _display;
    private String _number;
    private String _savedOperand;
    private int _result;
    private NumberValidator _validator;

    public CalculatorState() {
        setResult(0);
        setSavedOperand("");
        setNumber("0");
        setDisplay("0");
        setValidator(new NumberValidator(
                Integer.MIN_VALUE, Integer.MAX_VALUE));
    }


    public String getDisplay() {
        return _display;
    }

    public String getNumber() {
        return _number;
    }

    public int getResult() {
        return _result;
    }

    public String getSavedOperand() {
        return _savedOperand;
    }


    public void setDisplay(String display) {
        _display = display;
    }

    public void setNumber(String n) {
        _number = n;
    }

    public void setResult(int r) {
        _result = r;
    }

    public void setSavedOperand(String so) {
        _savedOperand = so;
    }

    public NumberValidator getValidator() {
        return _validator;
    }

    public void setValidator(NumberValidator validator) {
        _validator = validator;
    }

}
