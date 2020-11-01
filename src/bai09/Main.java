package bai09;

import bai07.StackOfChars;
import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = n;
        int b = scanner.nextInt();
        StackOfChars st = new StackOfChars(100);
        while (n > 0) {
            char c = 0;
            int tmp = n % b;
            if (b == 16) {
                if (tmp == 10) {
                    c = 'A';
                } else if (tmp == 11) {
                    c = 'B';
                } else if (tmp == 12) {
                    c = 'C';
                } else if (tmp == 13) {
                    c = 'D';
                } else if (tmp == 14) {
                    c = 'E';
                } else if (tmp == 15) {
                    c = 'F';
                } else if (tmp >= 0 && tmp < 10) {
                    c = (char) (tmp + 48);
                }
            } else {
                c = (char) (tmp + 48);
            }
            n /= b;
            st.push(c);
        }
        if (m == 2 || m == 10 || m == 16) {
            while (!st.isEmpty()) {
                System.out.print(st.pop());
            }
        } else {
            System.out.print(Integer.toString(m, b).toUpperCase());
        }
        System.out.println();
    }
}
