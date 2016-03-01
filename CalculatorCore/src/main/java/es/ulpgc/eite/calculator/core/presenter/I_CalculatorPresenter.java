package es.ulpgc.eite.calculator.core.presenter;

public interface I_CalculatorPresenter {
    void digitPressed(String c);
    void operatorPressed(String c);

    void clearPressed();
    void backspacePressed();
    void dotPressed();

    //  Metodos adicionales para guardar/recuperar el estado

    void displayNumber();
    String getDisplay();
    void setDisplay(String display);

    String getNumber();
    String getSavedOperand();
    int getResult();

    void setNumber(String n);
    void setSavedOperand(String so);
    void setResult(int r);
}
