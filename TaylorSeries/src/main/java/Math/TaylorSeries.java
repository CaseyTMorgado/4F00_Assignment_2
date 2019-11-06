package Math;

/**
 *
 */
public class TaylorSeries {



    public static double exp(double base, double n){
        float total = 0;
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

    public static double factorial(int num) {
        double result = 1;
        for (int i = 1; i <= num ; i++) {
            result *= i;
        }
        return result;
    }

    public static double sin(double x, int n){
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

    public static double cos(double x, int n){
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

    public static double tan(float x, int n){

        return 0;
    }

    public static double arcsin(float x, int n){

        return 0;
    }

    public static double arccos(float x, int n){

        return 0;
    }

    public static double arctan(float x, int n){

        return 0;
    }

    public static double sec(float x, int n){

        return 0;
    }

    public static double csc(float x, int n){

        return 0;
    }

    public static double cot(float x, int n){

        return 0;
    }

}
