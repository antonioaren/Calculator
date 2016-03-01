package es.ulpgc.eite.calculator.core.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberValidatorTest {
    private NumberValidator _validator;

    @Before
    public void setUp() throws Exception {
       _validator = new NumberValidator(-10, 20);
    }

    @Test
    public void testMin() throws Exception {
        _validator.checkBounds(-10);
    }

    @Test(expected = NumberValidator.Underflow.class)
    public void testUnderMin() throws Exception {
        _validator.checkBounds(-11);
    }

    @Test
    public void testMax() throws Exception {
        _validator.checkBounds(20);

    }

    @Test(expected = NumberValidator.Overflow.class)
    public void testOverMax() throws Exception {
        _validator.checkBounds(21);

    }

}