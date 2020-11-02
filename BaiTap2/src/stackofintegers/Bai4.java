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
public class Bai4 {
    public static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++)
            if(n%i==0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StackOfIntegers stk = new StackOfIntegers();
        int n = in.nextInt();
        for(int i=2;i<n;i++){
            if(isPrime(i)) 
                stk.push(i);   
        }
        System.out.println("Các số nguyên tố nhỏ hơn n là: ");
        while(!stk.isEmpty()){
            System.out.print(stk.pop() + " ");
        }
        System.out.println();
    }
}
