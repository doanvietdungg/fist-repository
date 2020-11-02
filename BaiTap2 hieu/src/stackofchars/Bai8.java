/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackofchars;
import java.util.*;
/**
 *
 * @author Admin
 */
/*
VD: A+(B+C)   -> ABC++
    ((A*B)+C) -> AB*C+
*/
public class Bai8 {
    public static int uuTien(char a){
        if(a=='^') return 5;
        if(a=='*' || a=='/') return 4;
	if(a=='+' || a=='-') return 3;
	return 2; //neu la dau ngoac
    }
    public static void main(String[] args) {
        StackOfChars stk = new StackOfChars();
        Scanner in = new Scanner(System.in);
        String res="";
        System.out.println("Nhập biểu thức ở dạng trung tố: ");
        String s = in.nextLine();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='A' && s.charAt(i)<='Z') res+=s.charAt(i);
            else if(s.charAt(i)>='a' && s.charAt(i)<='z') res+=s.charAt(i);
            else if(s.charAt(i)=='(') stk.push(s.charAt(i));
            else if(s.charAt(i)==')'){
                while(!stk.isEmpty() && stk.peak()!='('){
                    res+=stk.pop();
                }
                stk.pop();
            }
            else if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' ||
                    s.charAt(i)=='/' || s.charAt(i)=='^' ){
                while(!stk.isEmpty() && uuTien((char)stk.peak())>=uuTien(s.charAt(i))){
                    res+=stk.pop();
                }
                stk.push(s.charAt(i));
            }
        }
        while(!stk.isEmpty()){
            if(stk.peak()!='(') res+=stk.pop();
        }
        System.out.println("Biểu thức sau khi chuyển về hậu tố là: ");
        System.out.println(res);
    }
}
