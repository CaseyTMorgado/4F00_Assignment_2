package Math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaylorSeriesTest {
//    private TaylorSeries TaylorSeries = new TaylorSeries();


    @Test
    public void sin() {
        double x = 2;
        double sin = TaylorSeries.sin(x);

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
        double actual = TaylorSeries.cos(x);

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
        double tan = TaylorSeries.tan(1, 10);

        assertEquals(Math.tan(1), tan,0);
    }

    @Test
    public void sec() {
        double sec = TaylorSeries.sec(1, 10);

        assertEquals(1/Math.cos(1), sec,0);
    }

    @Test
    public void csc() {
        double csc = TaylorSeries.csc(1, 10);

        assertEquals(1/Math.sin(1), csc,0);
    }

    @Test
    public void cot() {
        double cot = TaylorSeries.cot(1, 10);

        assertEquals(1/Math.tan(1), cot,0);
    }

    @Test
    public void arcsin() {
        double arcsin = TaylorSeries.arcsin(1, 10);

        assertEquals(Math.asin(1), arcsin,0);
    }

    @Test
    public void arccos() {
        double arccos = TaylorSeries.arccos(1, 10);

        assertEquals(Math.acos(1), arccos,0);
    }

    @Test
    public void arctan() {
        double arctan = TaylorSeries.arctan(1, 10);

        assertEquals(Math.atan(1), arctan,0);
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

