package Math;

/**
 *
 */
public class TaylorSeries {



    public static double exp(float base, float n){
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

    public static int factorial(float num) {
        int result = 1;
        for (int i = 1; i <= num ; i++) {
            result *= i;
        }
        return result;
    }

    public static double sin(float x, int n){

        return 0;
    }
    public static double cos(float x, int n){

        return 0;
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
