package Math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaylorSeriesTest {
//    private TaylorSeries TaylorSeries = new TaylorSeries();


    @Test
    public void sin() {
        double sin = TaylorSeries.sin(1, 10);

        assertEquals(Math.sin(1), sin,0);
    }

    @Test
    public void cos() {
        double cos = TaylorSeries.cos(1, 10);

        assertEquals(Math.cos(1), cos,0);
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
        int expected = 120;
        int actual = TaylorSeries.factorial(5);
        assertEquals(actual, expected);
    }

    @Test
    public void exp() {
        double actual = TaylorSeries.exp(2, 3);
        double expected = 8;
        assertEquals(expected, actual, 0);
    }
}

