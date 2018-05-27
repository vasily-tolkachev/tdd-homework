package task1;

public class MathFunctions {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static long multiply(long a, long b) {
        return a * b;
    }

    public static long divide(long a, long b) {
        return a / b;
    }
}
