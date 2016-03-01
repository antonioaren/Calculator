package es.ulpgc.eite.calculator.core.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CalculatorModelTestWithValidator {
    private I_CalculatorModel _myCalc;
    private int _minValue;
    private int _maxValue;

    @Before
    public void setUp() throws Exception {
        _minValue = -100;
        _maxValue = 200;
        _myCalc = new CalculatorModel(_minValue, _maxValue);
    }

    // --------------------------------------------------------
    @Test
    public void t01setMax() throws Exception {
        _myCalc.setResult (_maxValue);
        assertEquals(_maxValue, _myCalc.getResult());
    }

    @Test
    public void t01setMin() throws Exception {
        _myCalc.setResult (_minValue);
        assertEquals(_minValue, _myCalc.getResult());
    }

    // --------------------------------------------------------
    @Test(expected = NumberValidator.Overflow.class)
    public void t02addOverflow() throws Exception {
        _myCalc.setResult (_maxValue);
        _myCalc.add (7);
    }

    @Test(expected = NumberValidator.Underflow.class)
    public void t02addUnderflow() throws Exception {
        _myCalc.setResult (_minValue);
        _myCalc.add (-1);
    }

    // --------------------------------------------------------
    @Test(expected = NumberValidator.Overflow.class)
    public void t03subOverflow() throws Exception {
        _myCalc.setResult (_maxValue);
        _myCalc.subtract(-1);
    }

    @Test(expected = NumberValidator.Underflow.class)
    public void t03subUnderflow() throws Exception {
        _myCalc.setResult (_minValue);
        _myCalc.subtract(1);
    }

    // --------------------------------------------------------
    // Se deja como ejercicio hacer el resto de los tests!

}
