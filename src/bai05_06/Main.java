package bai05_06;

import bai04.StackOfIntergers;
import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackOfIntergers st = new StackOfIntergers();
        // yeu cau Bai05
        System.out.println("Phân tích thừa số nguyên tố");
        int n = scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {                
                st.push(i);
                n /= i;
            }
        }
        while (!st.isEmpty()) {            
            System.out.print(st.pop() + " ");
        }
        System.out.println();
        // yeu cau Bai06
        System.out.println("Đổi một số nguyên bất kỳ sang cơ số 2");
        long m = scanner.nextLong();
        while (m > 0) {            
            st.push((int) (m % 2));
            m /= 2;
        }
        while (!st.isEmpty()) {            
            System.out.print(st.pop());
        }
        System.out.println();
    }
}
