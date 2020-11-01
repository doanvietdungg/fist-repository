package bai07;

import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    static int tinh(char a, char b, char op) {
        int n = a - 48;
        int m = b - 48;
        switch (op) {
            case '+':
                return m + n;
            case '-':
                return n - m;
            case '*':
                return n * m;
            case '/':
                return n / m;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StackOfChars st = new StackOfChars(100);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                char b = st.pop();
                char op = st.pop();
                char a = st.pop();
                if (st.peak() == '(') {
                    st.pop();
                }
                int res = tinh(a, b, op);
                st.push((char) (res + 48));
            } else {
                st.push(s.charAt(i));
            }
        }
        System.out.println(st.peak() - 48);
    }
}
