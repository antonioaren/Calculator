package es.ulpgc.eite.calculator.core.presenter;


import es.ulpgc.eite.calculator.core.model.I_CalculatorModel;
import es.ulpgc.eite.calculator.core.view.I_CalculatorView;

public class CalculatorPresenter implements I_CalculatorPresenter {


    private String _display;
    private String _number;
    private String _savedOperand;

    private I_CalculatorModel _model;
    private I_CalculatorView _view;


    public CalculatorPresenter(I_CalculatorView view, I_CalculatorModel model) {

        setCalculatorView(view);
        setCalculatorModel(model);

        setNumber("0");
        setSavedOperand("");
        setDisplay("0");
    }


    private void setCalculatorModel(I_CalculatorModel model) {
        _model = model;    
    }
    
    private I_CalculatorModel getCalculatorModel() {
        return _model;
    }

    private void setCalculatorView(I_CalculatorView view) {
        _view = view;    
    }
    
    private I_CalculatorView getCalculatorView() {
        return _view;
    }


    @Override
    public void displayNumber() {
        getCalculatorView().display(getDisplay());
    }


    @Override
    public String getDisplay() {
        return _display;
    }

    @Override
    public void setDisplay(String display) {
        _display = display;
    }


    @Override
    public void setNumber(String n) {
        _number = n;
    }

    @Override
    public void setSavedOperand(String so) {
        _savedOperand = so;
    }

    @Override
    public void setResult(int r) {
        getCalculatorModel().setResult(r);
    }

    @Override
    public int getResult() {
        return getCalculatorModel().getResult();
    }

    @Override
    public String getNumber() {
        return _number;
    }

    @Override
    public String getSavedOperand() {
        return _savedOperand;
    }

    @Override
    public void backspacePressed() {

        setSavedOperand("");

        if (getNumber().length() == 1) {
            setNumber("0");
        } else {
            setNumber(removeRightChar(getNumber()));
        }

        setDisplay(getNumber());
        displayNumber();
    }

    @Override
    public void clearPressed() {

        getCalculatorModel().reset();

        setNumber("0");
        setSavedOperand("");

        setDisplay(getNumber());
        displayNumber();
    }

    @Override
    public void digitPressed(String c) {

        Integer maxInt = Integer.MAX_VALUE;
        int maxDigits = maxInt.toString().length();

        if (getNumber().length() == maxDigits) {
            ;
        } else if (getNumber().equals("0")) {
            setNumber(c);
        } else {
            setNumber(getNumber() + c);

        }

        setDisplay(getNumber());
        displayNumber();
    }


    @Override
    public void operatorPressed(String c) {

        Integer n;

        try {
            n = convertToInteger(getNumber());
        } catch (Exception e) {
            getCalculatorView().displayWarning("wrong number");
            Integer current_value = getCalculatorModel().getResult();
            setNumber(current_value.toString());
            setDisplay(getNumber());
            displayNumber();
            setNumber("0");
            return;
        }

        if (getSavedOperand().equals("")
        && getCalculatorModel().getResult() == 0) {

            getCalculatorModel().setResult(n);

        } else {
            try {

                if (getSavedOperand().equals("+")) {
                    getCalculatorModel().add(n);

                } else if (getSavedOperand().equals("-")) {
                    getCalculatorModel().subtract(n);

                } else if (getSavedOperand().equals("*")) {
                    getCalculatorModel().multiply(n);

                } else if (getSavedOperand().equals("/")) {
                    getCalculatorModel().divide(n);
                }

            } catch (Exception e) {
                getCalculatorView().displayWarning("operation error");
            }
        }

        Integer current_value = getCalculatorModel().getResult();
        setNumber(current_value.toString());
        setDisplay(getNumber());
        displayNumber();

        setNumber("0");
        setSavedOperand(c);
    }


    @Override
    public void dotPressed() { // todo

    }

    private String removeRightChar(String text) {
        int numChars = text.length();

        if (numChars != 0) {
            return text.substring(0, numChars - 1);
        } else {
            return "";
        }
    }

    private Integer convertToInteger(String text) throws Exception {
        Integer number = Integer.parseInt(text);
        return number;
    }


}