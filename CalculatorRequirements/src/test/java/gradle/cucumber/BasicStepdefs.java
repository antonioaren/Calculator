package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import es.ulpgc.eite.calculator.core.model.I_CalculatorModel;
import es.ulpgc.eite.calculator.core.model.CalculatorModel;

public class BasicStepdefs {

    //  Para hacer este ejercicio vamos a programar:
    //    1) La codigo del modelo de nuestra calculadora en la clase
    //       "CalculatorModel"
    //    2) La interfaz del modelo de nuestra clase en la interfaz
    //       "I_CalculatorModel"
    //
    //  Las operaciones basicas de la calculadora son:
    //        void add(int operand) throws Exception;
    //        void subtract(int operand) throws Exception;
    //        void multiply(int operand) throws Exception;
    //        void divide(int operand) throws Exception;
    //
    //        int getResult();
    //        void setResult(int value);

    private I_CalculatorModel _model;
    private Exception _error;

    @Given("^El numero (\\-?[0-9]+)$")
    public void El_numero_numero_(int arg1) throws Throwable {
        _model = new CalculatorModel();
        _error = null;

        _model.setResult(arg1);
    }

    @When("^le sumamos el numero (\\-?[0-9]+)$")
    public void le_sumamos_el_numero(int arg1) throws Throwable {
        _model.add(arg1);
    }

    @When("^le restamos el numero (\\-?[0-9]+)$")
    public void le_restamos_el_numero_numero_(int arg1) throws Throwable {
        _model.subtract(arg1);
    }

    @When("^lo multiplicamos por (\\-?[0-9]+)$")
    public void lo_multiplicamos_por(int arg1) throws Throwable {
        _model.multiply(arg1);
    }

    @When("^lo dividimos por (\\-?[0-9]+)$")
    public void lo_dividimos_por(int arg1) throws Throwable {
        try {
            _model.divide(arg1);
        } catch (CalculatorModel.DivideByZero e) {
            _error = e;
        }
    }

    @Then("^el resultado es (\\-?[0-9]+)$")
    public void el_resultado_es(int arg1) throws Throwable {
        assertEquals(arg1, _model.getResult());
    }

    @Then("^el resultado es un error$")
    public void el_resultado_es_un_error() throws Throwable {
        assertTrue(_error != null);
    }

}
