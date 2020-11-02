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
public class Bai5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StackOfIntegers stk = new StackOfIntegers();
        int n = in.nextInt();
        
        for(int i=2;i<Math.sqrt(n);i++){
            while(n%i==0){
                stk.push(i);
                n/=i;
            }
        }
        if(n>1) stk.push(n);
        
        System.out.println("Thừa số nguyên tố theo thứ tự ngược là: ");
        while(!stk.isEmpty()){
            System.out.print(stk.pop() + " ");
        }
        System.out.println();
    }
}
