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
chuyển từ hệ cơ số 10 sang hệ cơ số bất kì (1<b<36)
*/
public class Bai9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StackOfChars stk = new StackOfChars(100);
        System.out.println("Nhập số n ở hệ cơ số 10: ");
        int n = in.nextInt();
        int m = n;
        System.out.println("Nhập hệ cơ số cần chuyển sang: ");
        int a = in.nextInt();
        
        while(n>0){
            int temp = n%a;
            n/=a;
            if(temp>=0 && temp<=9) 
                stk.push((char)(temp+'0'));
            if(temp>9){
                temp-=10;
                stk.push((char)(temp+'A'));
            }
        }
        
        System.out.println("Số " + m + " ở hệ cơ số " + a + " là: ");
        while(!stk.isEmpty()){
            System.out.print(stk.pop());
        }
        System.out.println();
    }
}
