/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Matrix {
    private float[][] a;

    public Matrix() {
        a = new float[3][3];
    }
    
    public Matrix(int rows, int columns) {
        a = new float[rows][columns];
    }

    public int getRow() {
        return a.length;
    }
    public int getColumn() {
        return a[0].length;
    }
    
    public boolean checkInAddAndSub(Matrix m) {
        return (this.getRow()==m.getRow()&& this.getColumn()==m.getColumn());
    }
    public boolean checkInMul(Matrix m) {
        return (this.getColumn()==m.getRow());
    }
    
    public Matrix add(Matrix m) {
        boolean check=false;
        Matrix resAdd = new Matrix(this.getRow(), this.getColumn());
        if(this.checkInAddAndSub(m)){
            check=true;
            for(int i=0;i<this.getRow();i++){
                for(int j=0;j<this.getColumn();j++){
                    resAdd.a[i][j] = this.a[i][j]+m.a[i][j];
                }
            }
        }
        return resAdd;
    }
    
    public Matrix sub(Matrix m) {
        Matrix resSub = new Matrix(this.getRow(), this.getColumn());
        if(this.checkInAddAndSub(m)){
            for(int i=0;i<this.getRow();i++){
                for(int j=0;j<this.getColumn();j++){
                    resSub.a[i][j] = this.a[i][j]-m.a[i][j];
                }
            }
        }
        return resSub;
    }
    
    public Matrix neg() {
        Matrix neg = new Matrix(this.getRow(), this.getColumn());
        for(int i=0;i<this.getRow();i++){
            for(int j=0;j<this.getColumn();j++){
                neg.a[i][j] = -this.a[i][j];
            }
        }
        return neg;
    }
    
    public Matrix transpose() {
        Matrix tran = new Matrix(this.getColumn(), this.getRow());
        for(int i=0;i<this.getRow();i++){
            for(int j=0;j<this.getColumn();j++){
                tran.a[j][i] = this.a[i][j];
            }
        }
        return tran;
    }
    
    public Matrix mul(Matrix m) {
        Matrix resMul = new Matrix(this.getRow(), m.getColumn());
        if(this.checkInMul(m)){
            for(int i=0;i<this.getRow();i++){
                for(int j=0;j<this.getRow();j++){
                    for(int k=0;k<this.getColumn();k++){
                        resMul.a[i][j] += this.a[i][k]*m.a[k][j];
                    }
                }
            }
        }
        return resMul;
    }
    
    public void init() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập ma trận: ");
        for(int i=0;i<this.getRow();i++){
            for(int j=0;j<this.getColumn();j++){
                this.a[i][j] = in.nextFloat();
            }
        }
    }
    
    public void print() {
        for(int i=0;i<this.getRow();i++){
            for(int j=0;j<this.getColumn();j++){
                System.out.print(this.a[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
