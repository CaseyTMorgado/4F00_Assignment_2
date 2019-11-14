package Math;

public class TaylorSeries {

    public static final double E = 2.718281828459045D;
    static final double PI = 3.141592653589793D;
    private static final double DEGREES_TO_RADIANS = 0.017453292519943295D;
    private static final double RADIANS_TO_DEGREES = 57.29577951308232D;

    static double exp(double base, double n) {
        if (n == 0) {
            return 1;
        } else {
            double result = 1;
            for (int i = 0; i < n; i++) {
                result = result * base;
            }
            return result;
        }
    }

    static int factorial(int num) {
        if (num < 0) { //negative num
            num = num * -1; //make number positive
            int result = 1;
            for (int i = 1; i <= num; i++) {
                result *= i;
            }
            result = result * -1;
            return result;
        } else {
            int result = 1;
            for (int i = 1; i <= num; i++) {
                result *= i;
            }
            return result;
        }

    }

    static double sin(double x, int n) {
        if (x % PI == 0) {
            return 0;
        } else if (x % (3 * PI / 2) == 0) {
            return -1;
        } else if (x % (PI / 2) == 0) {
            return 1;
        } else {
            double result = x;
            int exponent = 3;

            for (int i = 1; i <= n; i++) {

                double numerator = exp(x, exponent);
                double denominator = factorial(exponent);
                double current = numerator / denominator;

                if (i % 2 == 0) {
                    result += current;
                } else {
                    result -= current;
                }

                exponent = exponent + 2;
            }
            return result;
        }
    }

    static double sin(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }
        return sin(x, precision);
    }

    static double cos(double x, int n) {
        if (x % (2 * PI) == 0 || x == 0) {
            return 1;
        } else if (x % PI == 0) {
            return -1;
        } else if (x % (PI / 2) == 0) {
            return 0;
        } else {
            double result = 1;
            int exponent = 2;

            for (int i = 1; i <= n; i++) {

                double numerator = exp(x, exponent);
                double denominator = factorial(exponent);
                double current = numerator / denominator;

                if (i % 2 == 0) {
                    result += current;
                } else {
                    result -= current;
                }

                exponent = exponent + 2;
            }
            return result;
        }
    }

    static double cos(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }
        return cos(x, precision);
    }

    static double tan(double x, int n) {
        double result = sin(x, n) / cos(x, n);
        double diff = x % (PI / 2);
        boolean numberIsInValid = (diff == 0);

        if (numberIsInValid) {
            return Double.MIN_VALUE;
        } else
            return result;
    }

    static double tan(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }
        return tan(x, precision);
    }

    static double sec(double x, int n) {
        return (1 / cos(x, n));
    }

    static double sec(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }
        return sec(x, precision);
    }

    static double csc(double x, int n) {
        return (1 / sin(x, n));
    }

    static double csc(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }
        return csc(x, precision);
    }

    static double cot(double x, int n) {
        return (1 / tan(x, n));
    }

    static double cot(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }
        return cot(x, precision);
    }

    static double arcsin(double x, int n) {
        double result = x;
        int factor;
        double multiplierNumerator = 1;
        double multiplierDenominator = 2;
        double multiplier = multiplierNumerator / multiplierDenominator;

        for (int i = 1; i <= n; i++) {
            factor = 2 * (i) + 1;
            double numerator = exp(x, factor);
            double denominator = factor;
            double current = multiplier * (numerator / denominator);

            result += current;
            multiplierNumerator += 2;
            multiplierDenominator += 2;
            multiplier = multiplier * (multiplierNumerator / multiplierDenominator);
        }
        return result;
    }

    static double arcsin(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }
        return arcsin(x, precision);
    }

    static double arccos(double x, int n) {
        return (PI / 2) - arcsin(x, n);
    }

    static double arccos(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }
        return arccos(x, precision);
    }

    private static double arctanOne(double x, int n) {
        double result = x;
        int factor;

        for (int i = 1; i <= n; i++) {
            factor = 2 * (i) + 1;
            double numerator = exp(x, factor);
            double denominator = factor;
            double current = numerator / denominator;

            if (i % 2 == 0) {
                result += current;
            } else {
                result -= current;
            }
        }
        return result;
    }

    private static double arctanTwo(double x, int n) {
        double result;
        if (x <= -1)
            result = -PI / 2 - 1 / x;
        else
            result = PI / 2 - 1 / x;

        int factor;

        for (int i = 1; i <= n; i++) {
            factor = 2 * (i) + 1;
            double denominator = factor * exp(x, factor);
            double current = 1 / denominator;

            if (i % 2 == 0) {
                result -= current;
            } else {
                result += current;
            }
        }
        return result;
    }

    static double arctan(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }

        if (x > -1 && x < 1)
            return arctanOne(x, precision);
        else
            return arctanTwo(x, precision);
    }

    static double arcsec(double x, int n) {
        return (arccos((1 / x), n));
    }

    static double arcsec(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }
        return arcsec(x, precision);
    }

    static double arccsc(double x, int n) {
        return (arcsin((1 / x), n));
    }

    static double arccsc(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);
        }
        return arccsc(x, precision);
    }

    static double arccot(double x, int precision, boolean degrees) {
        if (degrees) {
            x = toRadians(x);

        }

        if (x > -1 && x < 1)
            return (PI / 2 - arctanOne(x, precision));
        else
            return (PI / 2 - arctanTwo(x, precision));
    }

    static double toRadians(double degrees) {
        return degrees * DEGREES_TO_RADIANS;
    }

    static double toDegrees(double radians) {
        return radians * RADIANS_TO_DEGREES;
    }

    static double sqrRoot(double x) {
        if (x == 0 || x == 1) {
            return x;
        } else {
            double low = 0;
            double high = x;
            double middle = -1;

            for (int i = 0; i < 1000; i++) {
                middle = (low + high) / 2;
                if (middle * middle == x) {
                    return middle;
                }
                if (middle * middle > x) {
                    high = middle;
                } else {
                    low = middle;
                }
            }
            return middle;
        }
    }

}
