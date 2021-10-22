package ss8_clean_code_refactoring.thuc_hanh.refactoring_doi_ten_bien_va_tach_hang;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {

    public static final char MULTIPLICATION = '*';
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char DIVISION = '/';
    //    public static final char DIVISION = '/';
    public static final char EQUAL = '=';

    @Test
    @DisplayName("Testing addition")
    void testCalculateAdd() {
        int firstOperand = 1;
        int secondOperand = 1;
        int expected = 2;

        int result = Calculator.calculate(firstOperand, secondOperand, ADDITION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing subtraction")
    void testCalculateSub() {
        int firstOperand = 2;
        int secondOperand = 1;
        int expected = 1;

        int result = Calculator.calculate(firstOperand, secondOperand, SUBTRACTION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing multiplication")
    void testCalculateMul() {
        int firstOperand = 2;
        int secondOperand = 2;
        int expected = 4;

        int result = Calculator.calculate(firstOperand, secondOperand, MULTIPLICATION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division")
    void testCalculateDiv() {
        int firstOperand = 6;
        int secondOperand = 3;
        int expected = 2;

        int result = Calculator.calculate(firstOperand, secondOperand, DIVISION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division by zero")
    void testCalculateDivByZero() {
        int firstOperand = 2;
        int secondOperand = 0;

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(firstOperand, secondOperand, CalculatorTest.DIVISION);});
    }

    @Test
    @DisplayName("Testing wrong operator")
    void testCalculateWrongOperator() {
        int firstOperand = 2;
        int secondOperand = 0;

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(firstOperand, secondOperand, EQUAL);});
    }
}