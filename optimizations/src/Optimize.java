public class Optimize {

    // non-recursive declaration of method factorial
    public static long factorial(long number) {
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

    // Raise x to the power n
    public static double dpower(int x, int n)
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

    // non-recursive declaration of method fibonacci
    public static int fibonacci(int number) {

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

    // Fibbonacci - pure math formula
    static public double getFibonacci(int n) {
        // Golden Ration Calculation
        double f1 = Math.pow(((1 + Math.sqrt(5)) / 2.0), n);  // Golden Ratio : GR^n
        double f2 = Math.pow(((1 - Math.sqrt(5)) / 2.0), n);  // Golden Ratio Conjugate : (-GR^-n)

        // Fib(x) = GR^n - (-GR^-n) / Square Root (5)
        return Math.floor((f1 - f2) / Math.sqrt(5));
    }

    // Towes of Hanoi
    public static void doTowers(long iDisk) {
        int m;
        System.out.println("Total Disks = " + iDisk);
        for (m=1; m < (1 << iDisk); m++)
        {
            long p1 = ((m&m-1)%3) + 1;
            long p2 = (((m|m-1)+1)%3) + 1;
            int dsk = ctz(m) + 1;
            System.out.printf("Move Disk %d ", dsk);
            System.out.printf("from Peg %d to Peg %d\n", p1, p2);
        }
        System.out.println("Done!");
    }

    public static int ctz(long x) {
        int n = 0;

        x = ~x & (x - 1);
        while(x != 0) {
            n = n + 1;
            x = x >> 1;
        }
        return n;
    }

    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean permutation(String s, String t) {
        if (s.length() != t.length())
            return false;
        return sort(s).equals(sort(t));
    }

    // find all permutations of a string
    public static void permuteString(String beginningString, String endingString) {
        if (endingString.length() <= 1)
            System.out.println(beginningString + endingString);
        else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                    permuteString(beginningString + endingString.charAt(i), newString);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    // swapping two characters in a string
    private static String swapChars(String str, int lIdx, int rIdx) {
        StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(lIdx), r = sb.charAt(rIdx);
        sb.setCharAt(lIdx, r);
        sb.setCharAt(rIdx, l);
        return sb.toString();
    }


    public static void main(String[] args) {
        int x = 5;

        System.out.println("Hello World!");

        //power - Non-recursive
        System.out.println(x + " to the power 4 is " + dpower(x, 4));
        System.out.println("7 to the power 5 is " + dpower(7, 5));
        System.out.println("7 to the power 0 is " + dpower(7, 0));
        System.out.println("10 to the power -2 is " + dpower(10, -2));
        System.out.println("5 to the power -4 is " + dpower(5, -4));

        // Factorial
        System.out.println("-- Factorial Non-Recursive --");
       for (int counter = 0; counter <= 10; counter++)
           System.out.printf("%d! = %d\n", counter, factorial(counter));

        // Fibonacci numbers
        System.out.println("-- Fibonnaci numbers Non-Recursive --");
        for (int counter = 0; counter <= 20; counter++)
            System.out.printf("Fibonacci of %d is: %d\n", counter, fibonacci(counter));

        // Fibonacci numbers
        System.out.println("-- Fibonnaci numbers Math Calc --");
        for (int counter = 0; counter <= 20; counter++) {
            int i = (int) getFibonacci(counter);
            System.out.printf("Fibonacci of %d is: %d\n", counter, i);
        }

        // Towers of Hanoi
        System.out.println("-- Towers of Hanoi --");
        doTowers(3);
        doTowers(4);
        doTowers(5);

        // Permute String
        System.out.println("-- Permute String - Recursive --");
        permuteString("", "DOG");
        permuteString("", "CAT");
        permuteString("", "ABCDEFG");
        System.out.println("-- Permute String - Non-Recursive --");
    }
}
