package aiss.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        assertEquals("Incorrect result!", 3, calculator.sum(1, 2));
    }

    @Test
    public void testDifference() {
        Calculator calculator = new Calculator();
        assertEquals("Incorrect result!", 1, calculator.difference(3, 2));
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals("Incorrect result!", 6, calculator.multiplication(2, 3));
    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals("Incorrect result!", 2, calculator.division(6, 3));
    }

    @Test
    public void testModule() {
        Calculator calculator = new Calculator();
        assertEquals("Incorrect result!", 1, calculator.module(5, 2));
    }

    /*
    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        try {
            calculator.division(1, 0);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero!", e.getMessage());
        }
    }
    */

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        calculator.division(1, 0);
    }
}
