public class la {
    public static void main(String[] args) {
        int n=24;
        int i=2;
        while(n) if ((n % i) == 0) {
            System.out.println(i + "--");
            n = n / i;
        } else i++;

    }
}
