package Math;

/**
 *
 */
public class TaylorSeries {

    public static final double E = 2.718281828459045D;
    static final double PI = 3.141592653589793D;
    private static final double DEGREES_TO_RADIANS = 0.017453292519943295D;
    private static final double RADIANS_TO_DEGREES = 57.29577951308232D;

    static double exp(double base, double n){
        if (n == 0) {
            return 1;
        }
        else {
            double result = 1;
            for (int i = 0; i < n; i++) {
                result = result * base;
            }
            return result;
        }
    }

    static double factorial(int num) {
        double result = 1;
        for (int i = 1; i <= num ; i++) {
            result *= i;
        }
        return result;
    }

    static double sin(double x, int n){
        double result = x;
        int exponent = 3;

        for (int i = 1; i <= n; i++) {

            double numerator = exp(x, exponent);
            double denominator = factorial(exponent);
            double current = numerator/denominator;

            if (i%2 == 0) {
                result += current;
            }
            else {
                result -= current;
            }

            exponent = exponent + 2;
        }
        return result;
    }

    static double cos(double x, int n){
        double result = 1;
        int exponent = 2;

        for (int i = 1; i <= n; i++) {

            double numerator = exp(x, exponent);
            double denominator = factorial(exponent);
            double current = numerator/denominator;

            if (i%2 == 0) {
                result += current;
            }
            else {
                result -= current;
            }

            exponent = exponent + 2;
        }
        return result;
    }

    static double tan(double x, int n){
        return (sin(x,n)/cos(x,n));
    }

    static double arcsin(double x, int n){
        double result = x;
        int factor;
        double multiplierNumerator = 1;
        double multiplierDenominator = 2;
        double multiplier = multiplierNumerator/multiplierDenominator;

        for (int i = 1; i <= n; i++) {
            factor = 2*(i)+1;
            double numerator = exp(x, factor);
            double denominator = factor;
            double current = multiplier * (numerator/denominator);

            result += current;
            multiplierNumerator +=2;
            multiplierDenominator +=2;
            multiplier = multiplier * (multiplierNumerator/multiplierDenominator);
        }
        return result;
    }

    static double arccos(double x, int n){
        return (PI/2)-arcsin(x,n);
    }

    static double arctan(double x, int n){
        double result = x;
        int factor;

        for (int i = 1; i <= n; i++) {
            factor = 2*(i)+1;
            double numerator = exp(x, factor);
            double denominator = factor;
            double current = numerator/denominator;

            if (i%2 == 0) {
                result += current;
            }
            else {
                result -= current;
            }
        }
        return result;
    }

    static double sec(double x, int n){
        return (1/cos(x,n));
    }

    static double csc(double x, int n){
        return (1/sin(x,n));
    }

    static double cot(double x, int n){
        return (1/tan(x,n));
    }

    static double arcsec(double x, int n){

        return 0;
    }

    static double arccsc(double x, int n){

        return 0;
    }

    static double arccot(double x, int n){
        return 0;
    }
}
