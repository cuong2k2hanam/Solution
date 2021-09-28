// Import your library
// Do not change the name of the Solution class
public class Solution {
    // Type your main code here
    private int numerator = 0;
    private int denominator = 1;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int n) {
        numerator = n;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int n) {
        denominator = n;
    }

    /**
     * GCD two numbers.
     */
    public int gcd(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        while (a != 0 && b != 0) {
            if (a >= b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a != 0 ? a : b;
    }

    /**
     *reduce solution.
     */
    public Solution reduce() {
        int GCD = gcd(numerator, denominator);
        numerator /= GCD;
        denominator /= GCD;
        return this;
    }


    public Solution() {
        denominator = 1;
        numerator = 0;
    }

    /**
     *constructor solution with param.
     */
    public Solution(int n, int d) {
        if (d != 0) {
            this.numerator = n;
            this.denominator = d;
        }
        this.reduce();
    }

    /**
     * add.
     */
    public Solution add(Solution s) {
        denominator = denominator * s.getDenominator();
        numerator = numerator * s.getDenominator() + s.getNumerator() * denominator;
        return this.reduce();
    }

    /**
     *subtract.
     */
    public Solution subtract(Solution s) {
        denominator = denominator * s.getDenominator();
        numerator = numerator * s.getDenominator() - s.getNumerator() * denominator;
        return this.reduce();
    }

    /**
     *multiply.
     */
    public Solution multiply(Solution s) {
        denominator *= s.getDenominator();
        numerator *= s.getNumerator();
        return this.reduce();
    }

    /**
     *divide.
     */
    public  Solution divide(Solution s) {
        if (s.getNumerator() == 0) {
            return this;
        } else {
            numerator *= s.getDenominator();
            denominator *= s.getNumerator();
        }
        return this.reduce();
    }

    /**
     *competition.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            other = other.reduce();
            if (other.getNumerator() == numerator && other.getDenominator() == denominator) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}