package es.ulpgc.eite.calculator.core.model;

public interface I_CalculatorModel {

    void add(int operand) throws Exception;
    void subtract(int operand) throws Exception;
    void multiply(int operand) throws Exception;
    void divide(int operand) throws Exception;
    void reset();

    int getResult();
    void setResult(int value);

    //  Metodos adicionales para guardar/recuperar el estado

    NumberValidator getValidator();
    void setValidator(NumberValidator validator);
}
