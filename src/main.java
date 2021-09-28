public class main {
    public static void main(String[] args) {
        Solution s1 = new Solution(9, 2);
        Solution s2 = new Solution(4, 3);
        Solution s3 = new Solution();
        System.out.printf("%d/%d - %d/%d = ", s1.getNumerator(),s1.getDenominator(),s2.getNumerator(),s2.getDenominator());
        s1.subtract(s2);
        System.out.printf("%d/%d", s1.getNumerator(), s1.getDenominator());
    }
}
