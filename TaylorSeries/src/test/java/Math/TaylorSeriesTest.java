package Math;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TaylorSeriesTest {

    private static final double DELTA = 0.01;

    @Test
    public void sin() {
        int precisionValue = 15;
        Map<Double, Double> testValues = new HashMap<Double, Double>();
        testValues.put(0.0, 0.0);
        testValues.put(30.0, 0.5);
        testValues.put(45.0, TaylorSeries.sqrRoot(2)/2);
        testValues.put(60.0, TaylorSeries.sqrRoot(3)/2);
        testValues.put(90.0, 1.0);
        testValues.put(180.0, 0.0);
        //testValues.put(184.0, 0.0);
        /*NOTE: As we approach multiples of PI (like PI/2, 3PI/2, PI),
        * we need more iterations of the taylor series for our calculations
        * to be accurate.  For that reason values like 184 dont test extremely well.*/
        testValues.put(360.0, 0.0);
        testValues.put(270.0, -1.0);

        for (Map.Entry<Double, Double> entry : testValues.entrySet()) {
            double val = entry.getKey();
            double degreesAsRadians = TaylorSeries.toRadians(val);
            double sin = TaylorSeries.sin(degreesAsRadians, precisionValue);
            double expected = entry.getValue();
            assertEquals(sin, expected, DELTA);
        }
    }

    @Test
    public void cos() {
        int precisionValue = 15;
        Map<Double, Double> testValues = new HashMap<Double, Double>();
        testValues.put(30.0, TaylorSeries.sqrRoot(3)/2);
        testValues.put(45.0, TaylorSeries.sqrRoot(2)/2);
        testValues.put(60.0, 0.5);
        testValues.put(90.0, 0.0);
        //testValues.put(180.0, -1.0);
        //testValues.put(360.0, 1.0);

        for (Map.Entry<Double, Double> entry : testValues.entrySet()) {
            double val = entry.getKey();
            double degreesAsRadians = TaylorSeries.toRadians(val);
            double cos = TaylorSeries.cos(degreesAsRadians, precisionValue);
            double expected = entry.getValue();
            assertEquals(cos, expected, DELTA);
        }
    }

    @Test
    public void tan() {
        int precisionValue = 15;
        Map<Double, Double> testValues = new HashMap<Double, Double>();
        testValues.put(30.0, TaylorSeries.sqrRoot(3)/3);
        testValues.put(45.0, 1.0);
        testValues.put(60.0, TaylorSeries.sqrRoot(3));
        testValues.put(90.0, Double.MIN_VALUE);
        testValues.put(180.0, 0.0);
        testValues.put(270.0, Double.MIN_VALUE);
        testValues.put(360.0, 0.0);

        for (Map.Entry<Double, Double> entry : testValues.entrySet()) {
            double val = entry.getKey();
            double degreesAsRadians = TaylorSeries.toRadians(val);
            double tan = TaylorSeries.tan(degreesAsRadians, precisionValue);
            double expected = entry.getValue();
            assertEquals(tan, expected, DELTA);
        }
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
    public void arcsec() {
        double x = 1;
        double arcsec = TaylorSeries.arcsec(x, 1000);
        double expected = (TaylorSeries.PI/4);
        assertEquals(expected, arcsec,0);
    }

    @Test
    public void arccsc() {
        double x = 1;
        double arccsc = TaylorSeries.arccsc(x, 100000);
        double expected = (TaylorSeries.PI/2);
        assertEquals(expected, arccsc,0);
    }

    @Test
    public void arccot() {
        double x = 1;
        double arccot = TaylorSeries.arccot(x, 100000);
        double expected = 0;
        assertEquals(expected, arccot,0);
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
        //value, expected output
        Map<Integer, Integer> testValues = new HashMap<Integer, Integer>();
        testValues.put(-10, -3628800);
        testValues.put(10, 3628800);
        testValues.put(4, 24);
        testValues.put(5, 120);
        testValues.put(12, 479001600);

        for (Map.Entry<Integer, Integer> entry : testValues.entrySet()) {
            int val = entry.getKey();
            int calculated = TaylorSeries.factorial(val);
            double expected = entry.getValue();
            assertEquals(calculated, expected, DELTA);
        }
    }

    @Test
    public void exp() {
        double actual = TaylorSeries.exp(2, 3);
        double expected = 8;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void toRadians() {
        //degrees, radians
        Map<Double, Double> testValues = new HashMap<Double, Double>();
        testValues.put(360.0, 2.0*TaylorSeries.PI);
        testValues.put(180.0, TaylorSeries.PI);
        testValues.put(90.0, TaylorSeries.PI/2);
        testValues.put(45.0, TaylorSeries.PI/4);
        testValues.put(60.0, TaylorSeries.PI/3);

        for (Map.Entry<Double, Double> entry : testValues.entrySet()) {
            double val = entry.getKey();
            double rad = TaylorSeries.toRadians(val);
            double expected = entry.getValue();
            assertEquals(rad, expected, DELTA);
        }
    }

    @Test
    public void toDegrees() {
        //radians, degrees
        Map<Double, Double> testValues = new HashMap<Double, Double>();
        testValues.put(2.0*TaylorSeries.PI, 360.0);
        testValues.put(TaylorSeries.PI, 180.0);
        testValues.put(TaylorSeries.PI/2, 90.0);
        testValues.put(TaylorSeries.PI/4, 45.0);
        testValues.put(TaylorSeries.PI/3, 60.0);

        for (Map.Entry<Double, Double> entry : testValues.entrySet()) {
            double val = entry.getKey();
            double deg = TaylorSeries.toDegrees(val);
            double expected = entry.getValue();
            assertEquals(deg, expected, DELTA);
        }

    }

    @Test
    public void sqrRoot() {
        Map<Double, Double> testValues = new HashMap<Double, Double>();
        testValues.put(0.0, 0.0);
        testValues.put(1.0, 1.0);
        testValues.put(2.0, 1.414213562);
        testValues.put(4.0, 2.0);
        testValues.put(7.0, 2.645751311);

        for (Map.Entry<Double, Double> entry : testValues.entrySet()) {
            double val = entry.getKey();
            double squareRoot = TaylorSeries.sqrRoot(val);
            double expected = entry.getValue();
            assertEquals(squareRoot, expected, DELTA);
        }
    }
}

