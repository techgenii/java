public class Optimize {

    // Raise x to the power n
    // Speed:   , Size:
    static double power(double x, int n) {
        if (n > 1)
            return (x * power(x, n - 1)); // Recursive call
        else if (n < 0)
            return (1.0 / power(x, -n)); // Negative power of x
        else
            return x;
    }

    // Raise x to the power n
    // Speed: O(n)   , Size:
    public static double powerF(int x, int n)
    {
        double result = 1.0;
        int iExp = n;
        boolean iNegative = false;

        // check if exponent (n) is negative
        if (iExp < 0) {
            iExp *= -1;
            iNegative = true;
        }

        // multiply x (the base) n times
        // store it in the result
        for (int i = 0; i < iExp; i++)
            result *= x;

        // if negative, then 1/result = 1/x^n, else return result = x^n
        return (iNegative ? (1/result) : result) ;
    }


    public static void main(String[] args) {
        int x = 5;

        System.out.println("Power!");

        //power - recursive
        System.out.println("----- Power: Recursive -----");
        System.out.println(x + " to the power 4 is " + power(x, 4));
        System.out.println("7 to the power 5 is " + power(7, 5));
        System.out.println("7 to the power 0 is " + power(7, 0));
        System.out.println("10 to the power -2 is " + power(10, -2));
        System.out.println("5 to the power -4 is " + power(5, -4));

        //power - Non-recursive
        System.out.println("----- Power: Non-Recursive -----");
        System.out.println(x + " to the power 4 is " + powerF(x, 4));
        System.out.println("7 to the power 5 is " + powerF(7, 5));
        System.out.println("7 to the power 0 is " + powerF(7, 0));
        System.out.println("10 to the power -2 is " + powerF(10, -2));
        System.out.println("5 to the power -4 is " + powerF(5, -4));

    }
}
