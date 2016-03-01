package es.ulpgc.eite.calculator.android.pattern.model;


import es.ulpgc.eite.calculator.core.model.CalculatorModel;
import es.ulpgc.eite.calculator.core.model.I_CalculatorModel;
import es.ulpgc.eite.calculator.core.model.NumberValidator;
import es.ulpgc.eite.framework.android.AndroidScreenModel;

public class AndroidCalculatorModel
        extends AndroidScreenModel implements I_CalculatorModel {

    private I_CalculatorModel _core;


    public AndroidCalculatorModel() {
        setCalculatorCore(new CalculatorModel());
    }


    private void setCalculatorCore(I_CalculatorModel core) {
        _core = core;
    }

    private I_CalculatorModel getCalculatorCore() {
        return _core;
    }

    @Override
    public void add(int operand) throws Exception {
        getCalculatorCore().add(operand);
    }

    @Override
    public void subtract(int operand) throws Exception {
        getCalculatorCore().subtract(operand);
    }

    @Override
    public void multiply(int operand) throws Exception {
        getCalculatorCore().multiply(operand);
    }

    @Override
    public void divide(int operand) throws Exception {
        getCalculatorCore().divide(operand);
    }

    @Override
    public void reset() {
        getCalculatorCore().reset();
    }

    @Override
    public int getResult() {
        return getCalculatorCore().getResult();
    }

    @Override
    public void setResult(int value) {
        getCalculatorCore().setResult(value);
    }

    @Override
    public NumberValidator getValidator() {
        return getCalculatorCore().getValidator();
    }

    @Override
    public void setValidator(NumberValidator validator) {
        getCalculatorCore().setValidator(validator);
    }

}
