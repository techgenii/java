public class Factorial {

    // recursive declaration of method factorial
    // Speed: Θ(n), Storage: O(?)
    public static long factorial(long number) {
        // base cases: 0! = 1 and 1! = 1
        if (number == 1 || number == 0)
            return 1;
        else
            // recursion step
            return (number * factorial(number - 1));
    }

    // non-recursive declaration of method factorial
    // Speed: Θ(n), Storage: O(?)
    public static long factorialF(long number) {
         long numRet = 1;

        // error condition
        if (number < 0)
            return -1;

        // base cases: 0! = 1 and 1! = 1
        if (number == 0 || number == 1)
            return 1;

        // for-loop step
        for (int i=2; i <= number; i++)  {
            numRet *= i;
        }

        return (numRet);
    }

    public static void main(String[] args) {
        int loopMax = 10;
        System.out.println("Factorial Code!");

        // Factorial Recursive
        System.out.println("-- Factorial Recursive --");
        for (int counter = 0; counter <= loopMax; counter++)
            System.out.printf("%d! = %d\n", counter, factorial(counter));

       // Factorial Non-Recursive
       System.out.println("-- Factorial Non-Recursive --");
       for (int counter = 0; counter <= loopMax; counter++)
           System.out.printf("%d! = %d\n", counter, factorialF(counter));
    }
}
