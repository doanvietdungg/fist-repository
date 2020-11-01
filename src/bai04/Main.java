package bai04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        StackOfIntergers stack = new StackOfIntergers(n);
        for (int i = 2; i <= n; i++) {
            if (nt(i)) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {            
            System.out.print(stack.pop() +" ");
        }
    }

    private static boolean nt(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
