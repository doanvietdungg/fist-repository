package bai08;

import bai07.StackOfChars;
import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    static int pri(char c) {
        return switch (c) {
            case '^' ->
                3;
            case '*', '/' ->
                2;
            case '+', '-' ->
                1;
            default ->
                -1;
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StackOfChars st = new StackOfChars(100);
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                res += s.charAt(i);
            } else if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (!st.isEmpty() && st.peak() != '(') {
                    char c = st.pop();
                    res += c;
                    if (st.peak() == '(') {
                        st.pop();
                    }
                }
            } else {
                while (!st.isEmpty() && pri(st.peak()) >= pri(s.charAt(i))) {
                    char c = st.pop();
                    res += c;
                }
                st.push(s.charAt(i));
            }
        }
        while (!st.isEmpty()) {
            char c = st.pop();
            if (c != '(' && c != ')') {
                res += c;
            }
        }
        System.out.println(res);
    }
}
