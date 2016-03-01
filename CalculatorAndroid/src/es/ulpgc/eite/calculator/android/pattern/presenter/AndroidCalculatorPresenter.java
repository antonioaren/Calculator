package es.ulpgc.eite.calculator.android.pattern.presenter;


import es.ulpgc.eite.calculator.core.model.I_CalculatorModel;
import es.ulpgc.eite.calculator.core.presenter.CalculatorPresenter;
import es.ulpgc.eite.calculator.core.presenter.I_CalculatorPresenter;
import es.ulpgc.eite.calculator.core.view.I_CalculatorView;
import es.ulpgc.eite.calculator.android.pattern.state.CalculatorState;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;
import es.ulpgc.eite.framework.android.AndroidScreenPresenter;

public abstract class AndroidCalculatorPresenter
        extends AndroidScreenPresenter implements I_CalculatorPresenter {

    private I_CalculatorPresenter _core;

    private void setCalculatorCore(I_CalculatorPresenter core) {
        _core = core;
    }

    private I_CalculatorPresenter getCalculatorCore() {
        return _core;
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getCalculatorView().initCalculator();
        setCalculatorCore(new CalculatorPresenter(
                getCalculatorView(), getCalculatorModel()));
    }


    @Override
    public void backScreen() {
        debug("backScreen");
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");

        displayNumber();
    }


    @Override
    public void pauseScreen() {
        debug("pauseScreen");

    }


    public I_CalculatorModel getCalculatorModel() {
        return (I_CalculatorModel) getScreenModel();
    }

    public I_CalculatorView getCalculatorView() {
        return (I_CalculatorView) getScreenView();
    }


    public void changeOrientation(int code){
        debug("changeOrientation");

        startNextScreenWithFinish(code, true);
    }


    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {

        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        return getScreenState();
    }


    @Override
    public I_ScreenState getScreenState() {


        CalculatorState _state = new CalculatorState();
        _state.setDisplay(getDisplay());
        _state.setNumber(getNumber());
        _state.setSavedOperand(getSavedOperand());
        _state.setResult(getCalculatorModel().getResult());
        _state.setValidator(getCalculatorModel().getValidator());

        debug("getScreenState", "number", _state.getNumber());
        debug("getScreenState", "savedOperand", _state.getSavedOperand());
        debug("getScreenState", "result", _state.getResult());
        debug("getScreenState", "display", _state.getDisplay());

        return _state;
    }


    @Override
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        if(state != null) {

            CalculatorState _state = (CalculatorState) state;

            debug("setCurrentState", "number", _state.getNumber());
            debug("setCurrentState", "savedOperand", _state.getSavedOperand());
            debug("setCurrentState", "result", _state.getResult());
            debug("setCurrentState", "display", _state.getDisplay());

            setDisplay(_state.getDisplay());
            setNumber(_state.getNumber());
            setSavedOperand(_state.getSavedOperand());
            getCalculatorModel().setResult(_state.getResult());
            getCalculatorModel().setValidator(_state.getValidator());
        }
    }


    @Override
    public void displayNumber() {
        debug("displayNumber");
        getCalculatorCore().displayNumber();
    }

    @Override
    public String getDisplay() {
        String display = getCalculatorCore().getDisplay();
        debug("getDisplay", "display", display);
        return display;
    }

    @Override
    public void setDisplay(String display) {
        debug("setDisplay", "display", display);
        getCalculatorCore().setDisplay(display);
    }

    @Override
    public void digitPressed(String c) {
        debug("digitPressed", "digit", c);
        getCalculatorCore().digitPressed(c);
    }

    @Override
    public void operatorPressed(String c) {
        debug("operatorPressed", "operator", c);
        getCalculatorCore().operatorPressed(c);
    }

    @Override
    public void clearPressed() {
        debug("clearPressed");
        getCalculatorCore().clearPressed();
    }

    @Override
    public void backspacePressed() {
        debug("backspacePressed");
        getCalculatorCore().backspacePressed();
    }

    @Override
    public void dotPressed() {
        debug("dotPressed");
        getCalculatorCore().dotPressed();
    }

    @Override
    public String getNumber() {
        String number = getCalculatorCore().getNumber();
        debug("getNumber", "number", number);
        return number;
    }

    @Override
    public String getSavedOperand() {
        String operand = getCalculatorCore().getSavedOperand();
        debug("getSavedOperand", "operand", operand);
        return operand;
    }

    @Override
    public int getResult() {
        int result = getCalculatorCore().getResult();
        debug("getResult", "result", result);
        return result;
    }

    @Override
    public void setNumber(String n) {
        debug("setNumber", "number", n);
        getCalculatorCore().setNumber(n);
    }

    @Override
    public void setSavedOperand(String so) {
        debug("setSavedOperand", "operand", so);
        getCalculatorCore().setSavedOperand(so);
    }

    @Override
    public void setResult(int r) {
        debug("setResult", "result", r);
        getCalculatorCore().setResult(r);
    }

}