package Math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaylorSeriesTest {

    @Test
    public void sin() {
        double x = 2;
        double sin = TaylorSeries.sin(x,3);

        //the expected value below is because calculated by running the taylor series for sin three times
        //this is ran three times because as we approach infinity, the calculation becomes much larger and
        //the result no longer fits in a double
        //the calculated value is not close to sin as we are only running the loop three times
        //as we increase the number of times the loop is ran, then the closer to sine our function will
        //become
        double expected = x - (TaylorSeries.exp(x, 3)/TaylorSeries.factorial(3)) +
                (TaylorSeries.exp(x, 5)/TaylorSeries.factorial(5)) -
                (TaylorSeries.exp(x, 7)/TaylorSeries.factorial(7));

        assertEquals(expected, sin,0);

    }

    @Test
    public void cos() {
        double x = 1;
        double actual = TaylorSeries.cos(x, 3);

        //the expected value below is because calculated by running the taylor series for cos three times
        //this is ran three times because as we approach infinity, the calculation becomes much larger and
        //the result no longer fits in a double
        //the calculated value is not close to sin as we are only running the loop three times
        //as we increase the number of times the loop is ran, then the closer to sine our function will
        //become
        double expected = 1 - (TaylorSeries.exp(x, 2)/TaylorSeries.factorial(2)) +
                (TaylorSeries.exp(x, 4)/TaylorSeries.factorial(4)) -
                (TaylorSeries.exp(x, 6)/TaylorSeries.factorial(6));

        assertEquals(expected, actual,0);
    }

    @Test
    public void tan() {
        double x = 1;
        double tan = TaylorSeries.tan(x, 3);
        double expected = (x - (TaylorSeries.exp(x, 3)/TaylorSeries.factorial(3)) +
                (TaylorSeries.exp(x, 5)/TaylorSeries.factorial(5)) -
                (TaylorSeries.exp(x, 7)/TaylorSeries.factorial(7)))
                /
                (1 - (TaylorSeries.exp(x, 2)/TaylorSeries.factorial(2)) +
                (TaylorSeries.exp(x, 4)/TaylorSeries.factorial(4)) -
                (TaylorSeries.exp(x, 6)/TaylorSeries.factorial(6)));

        assertEquals(expected, tan,0);
    }

    @Test
    public void sec() {
        double x = 1;
        double sec = TaylorSeries.sec(x, 3);
        double expected = 1/(1 - (TaylorSeries.exp(x, 2)/TaylorSeries.factorial(2)) +
                (TaylorSeries.exp(x, 4)/TaylorSeries.factorial(4)) -
                (TaylorSeries.exp(x, 6)/TaylorSeries.factorial(6)));

        assertEquals(expected, sec,0);
    }

    @Test
    public void csc() {
        double x = 1;
        double csc = TaylorSeries.csc(x, 3);
        double expected = 1/(x - (TaylorSeries.exp(x, 3)/TaylorSeries.factorial(3)) +
                (TaylorSeries.exp(x, 5)/TaylorSeries.factorial(5)) -
                (TaylorSeries.exp(x, 7)/TaylorSeries.factorial(7)));

        assertEquals(expected, csc,0);
    }

    @Test
    public void cot() {
        double x = 1;
        double cot = TaylorSeries.cot(x, 3);
        double expected = 1/((x - (TaylorSeries.exp(x, 3)/TaylorSeries.factorial(3)) +
                (TaylorSeries.exp(x, 5)/TaylorSeries.factorial(5)) -
                (TaylorSeries.exp(x, 7)/TaylorSeries.factorial(7)))
                /
                (1 - (TaylorSeries.exp(x, 2)/TaylorSeries.factorial(2)) +
                        (TaylorSeries.exp(x, 4)/TaylorSeries.factorial(4)) -
                        (TaylorSeries.exp(x, 6)/TaylorSeries.factorial(6))));

        assertEquals(expected, cot,0);
    }

    @Test
    public void arcsin() {
        double x = 1;
        double arcsin = TaylorSeries.arcsin(x, 100000);
        double expected = (TaylorSeries.PI/2);
        assertEquals(expected, arcsin,0);
    }

    @Test
    public void arccos() {
        double x = 1;
        double arccos = TaylorSeries.arccos(x, 100000);
        double expected = 0;
        assertEquals(expected, arccos,0);
    }

    @Test
    public void arctan() {
        double x = 1;
        double arctan = TaylorSeries.arctan(x, 1000);
        double expected = (TaylorSeries.PI/4);
        assertEquals(expected, arctan,0);
    }

    @Test
    public void factorial() {
        double expected = 120;
        double actual = TaylorSeries.factorial(5);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void exp() {
        double actual = TaylorSeries.exp(2, 3);
        double expected = 8;
        assertEquals(expected, actual, 0);
    }
}

