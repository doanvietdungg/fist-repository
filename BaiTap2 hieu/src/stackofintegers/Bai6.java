/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackofintegers;

/**
 *
 * @author Admin
 */
import java.util.*;
public class Bai6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StackOfIntegers stk = new StackOfIntegers();
        int n = in.nextInt();
        int temp=n;
        
        while(temp>0){
            stk.push(temp%2);
            temp/=2;
        }
        
        System.out.println("Số " + n + " ở hệ cơ số 2 là: ");
        while(!stk.isEmpty()){
            System.out.print(stk.pop());
        }
        System.out.println();
    }
}
