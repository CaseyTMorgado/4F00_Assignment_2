package Math;

/**
 *
 */
public class TaylorSeries {


    public TaylorSeries() {
    }

    public double exp(float base, float n){
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

    public int factorial(float num) {
        int result = 1;
        for (int i = 1; i <= num ; i++) {
            result *= i;
        }
        return result;
    }

    public double sin(float x, int n){

        return 0;
    }
    public double cos(float x, int n){

        return 0;
    }

    public double tan(float x, int n){

        return 0;
    }

    public double arcsin(float x, int n){

        return 0;
    }

    public double arccos(float x, int n){

        return 0;
    }

    public double arctan(float x, int n){

        return 0;
    }

    public double sec(float x, int n){

        return 0;
    }

    public double csc(float x, int n){

        return 0;
    }

    public double cot(float x, int n){

        return 0;
    }

}
