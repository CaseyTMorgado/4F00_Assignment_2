package Math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaylorSeriesTest {
    private TaylorSeries taylorSeries = new TaylorSeries();


    @Test
    public void sin() {
        double sin = taylorSeries.sin(1, 10);

        assertEquals(Math.sin(1), sin,0);
    }

    @Test
    public void cos() {
        double cos = taylorSeries.cos(1, 10);

        assertEquals(Math.cos(1), cos,0);
    }

    @Test
    public void tan() {
        double tan = taylorSeries.tan(1, 10);

        assertEquals(Math.tan(1), tan,0);
    }

    @Test
    public void sec() {
        double sec = taylorSeries.sec(1, 10);

        assertEquals(1/Math.cos(1), sec,0);
    }

    @Test
    public void csc() {
        double csc = taylorSeries.csc(1, 10);

        assertEquals(1/Math.sin(1), csc,0);
    }

    @Test
    public void cot() {
        double cot = taylorSeries.cot(1, 10);

        assertEquals(1/Math.tan(1), cot,0);
    }

    @Test
    public void arcsin() {
        double arcsin = taylorSeries.arcsin(1, 10);

        assertEquals(Math.asin(1), arcsin,0);
    }

    @Test
    public void arccos() {
        double arccos = taylorSeries.arccos(1, 10);

        assertEquals(Math.acos(1), arccos,0);
    }

    @Test
    public void arctan() {
        double arctan = taylorSeries.arctan(1, 10);

        assertEquals(Math.atan(1), arctan,0);
    }




    @Test
    public void factorial() {
        int expected = 120;
        int actual = taylorSeries.factorial(5);
        assertEquals(actual, expected);
    }

    @Test
    public void exp() {
        String str= "I am done with Junit setup";
        double actual = taylorSeries.exp(2, 3);
        double expected = 8;
        assertEquals(expected, actual, 0);
    }
}

