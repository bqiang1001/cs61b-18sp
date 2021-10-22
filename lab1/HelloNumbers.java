public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0, tot = 0;
        while (x < 10) {
            System.out.print(tot + " ");
            tot += ++x;
        }
    }
}
