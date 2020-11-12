import org.junit.Test;
import static org.junit.Assert.*;
public class SolveEquationTest {

    SolveEquation solve = new SolveEquation();

    @Test
    public void test1() {
        double a = 0, b = 0, c = 0;
        String result = solve.solveEquation(a,b,c);
        String expResult = "countless solutions";
        assertEquals(expResult, result);
    }

    @Test
    public void test2() {
        double a = 0, b = 2, c = 0;
        String result = solve.solveEquation(a,b,c);
        String expResult = "0.0";
        assertEquals(expResult, result);
    }

    @Test
    public void test3() {
        double a = 0, b = 0, c = 4;
        String result = solve.solveEquation(a,b,c);
        String expResult = "no solution";
        assertEquals(expResult, result);
    }

    @Test
    public void test4() {
        double a = 0, b = 2, c = -4;
        String result = solve.solveEquation(a,b,c);
        String expResult = "2.0";
        assertEquals(expResult, result);
    }

    @Test
    public void test5() {
        double a = 3, b = 19, c = 13;
        String result = solve.solveEquation(a,b,c);
        String expResult = "-5.553;-0.7804";
        assertEquals(expResult, result);
    }

    @Test
    public void test6() {
        double a = 1, b = -2, c = 9;
        String result = solve.solveEquation(a,b,c);
        String expResult = "no solution";
        assertEquals(expResult, result);
    }

    @Test
    public void test7() {
        double a = 1, b = -2, c = 1;
        String result = solve.solveEquation(a,b,c);
        String expResult = "1.0";
        assertEquals(expResult, result);
    }

}
