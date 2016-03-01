package es.ulpgc.eite.calculator.core.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorModelTest {
    private I_CalculatorModel _myCalc;

    @Before
    public void setUp() throws Exception {
        _myCalc = new CalculatorModel();
    }

    // --------------------------------------------------------	
    @Test
    public void t00initVal() {
        assertTrue (_myCalc.getResult() == 0);
    }

    @Test
    public void t00setGet() {
        _myCalc.setResult(12);
        assertTrue(_myCalc.getResult() == 12);
    }

    @Test
    public void t00setReset() {
        _myCalc.setResult(12);
        _myCalc.reset();
        assertTrue(_myCalc.getResult() == 0);
    }

    // --------------------------------------------------------	
    @Test
    public void t01add01() throws Exception {
        _myCalc.add (5);
        assertTrue (_myCalc.getResult() == 5);
    }

    @Test
    public void t01add02() throws Exception {
        _myCalc.setResult(3);
        _myCalc.add (7);
        assertTrue (_myCalc.getResult() == 10);
    }

    @Test
    public void t01add03() throws Exception {
        _myCalc.setResult(3);
        _myCalc.add (7);
        _myCalc.add(6);
        assertTrue (_myCalc.getResult() == 16);
    }

    @Test
    public void t01add04() throws Exception {
        _myCalc.add (-7);
        assertTrue (_myCalc.getResult() == -7);
    }

    // --------------------------------------------------------
    @Test
    public void t02sub01() throws Exception {
        _myCalc.subtract(5);
        assertTrue (_myCalc.getResult() == -5);
    }

    @Test
    public void t02sub02() throws Exception {
        _myCalc.setResult (3);
        _myCalc.subtract (7);
        assertTrue (_myCalc.getResult() == -4);
    }

    @Test
    public void t02sub03() throws Exception {
        _myCalc.setResult (3);
        _myCalc.subtract (7);
        _myCalc.subtract (6);
        assertTrue (_myCalc.getResult() == -10);
    }

    @Test
    public void t02sub04() throws Exception {
        _myCalc.subtract(-7);
        assertTrue (_myCalc.getResult() == 7);
    }


    // --------------------------------------------------------
    @Test
    public void t03mult01() throws Exception {
        _myCalc.multiply (5);
        assertTrue (_myCalc.getResult() == 0);
    }

    @Test
    public void t03mult02() throws Exception {
        _myCalc.setResult(3);
        _myCalc.multiply (7);
        assertTrue (_myCalc.getResult() == 21);
    }

    @Test
    public void t03mult03() throws Exception {
        _myCalc.setResult(-6);
        _myCalc.multiply (6);
        _myCalc.multiply (3);
        assertTrue (_myCalc.getResult() == -108);
    }

    // --------------------------------------------------------
    @Test
    public void t04div01() throws Exception {
        _myCalc.divide (5);
        assertTrue (_myCalc.getResult() == 0);
    }

    @Test
    public void t04div02() throws Exception {
        _myCalc.divide (7);
        assertTrue (_myCalc.getResult() == 0);
    }

    @Test
    public void t04div03() throws Exception {
        _myCalc.setResult (7);
        _myCalc.divide (-2);
        assertTrue (_myCalc.getResult() == -3);
    }

    @Test(expected=CalculatorModel.DivideByZero.class)
    public void t04divZero1() throws Exception {
        _myCalc.setResult(5);
        _myCalc.divide (0);
        fail("DivisionByZero not raised");
    }

    @Test
    public void t04divZero2() {
        _myCalc.setResult(5);

        try {
            _myCalc.divide (0);
            fail("DivisionByZero not raised");

        } catch (CalculatorModel.DivideByZero e) {
            assertTrue(true);

        } catch (Exception e) {
            fail("unknown exception");
        }

    }


}
