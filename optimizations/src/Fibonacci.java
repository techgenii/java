public class Fibonacci {

    // recursive declaration of method fibonacci
    // Speed: O(n), Size:
    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1)) // base cases
            return number;
        else
            // recursion step
            return (fibonacci(number - 1) + fibonacci(number - 2));
    }

    // non-recursive declaration of method fibonacci
    // Speed: O(n), Size:
    public static int fibonacciF(int number) {

        switch (number) {
            case 0:
                // Fib 0 = 0
                return 0;
            case 1:
                // Fib 1 = 1
                return 1;
            default:
                // Fib(X) = Fib(X-1) + Fib(X-2)
                int x1 = 1;
                int x2 = 0;
                int sum = 0;

                for (int i = 2; i <= number; i++) {
                    sum = x1 + x2;
                    x2 = x1;
                    x1 = sum;
                }

                return sum;
        }
    }

    // Fibonacci - pure math formula - Based upon the Golden Ratio
    // Speed: O(1), Size:
    static public double getFibonacci(int n) {
        // Golden Ration Calculation
        double f1 = Math.pow(((1 + Math.sqrt(5)) / 2.0), n);  // Golden Ratio : GR^n
        double f2 = Math.pow(((1 - Math.sqrt(5)) / 2.0), n);  // Golden Ratio Conjugate : (-GR^-n)

        // Fib(x) = GR^n - (-GR^-n) / Square Root (5)
        return Math.floor((f1 - f2) / Math.sqrt(5));
    }

    public static void main(String[] args) {
        int loopMax = 20;
        System.out.println("Fibonnaci numbers!");

        // Fibonacci numbers
        System.out.println("-- Fibonnaci numbers --");
        for (int counter = 0; counter <= loopMax; counter++)
            System.out.printf("Fibonacci of %d is: %d\n", counter, fibonacci(counter));

        // Fibonacci numbers
        System.out.println("-- Fibonnaci numbers Non-Recursive --");
        for (int counter = 0; counter <= loopMax; counter++)
            System.out.printf("Fibonacci of %d is: %d\n", counter, fibonacciF(counter));

        // Fibonacci numbers
        System.out.println("-- Fibonnaci numbers Math Calc --");
        for (int counter = 0; counter <= loopMax; counter++) {
            int i = (int) getFibonacci(counter);
            System.out.printf("Fibonacci of %d is: %d\n", counter, i);
        }

    }
}
