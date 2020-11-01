package bai12;

import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Matrix {

    private float[][] a;

    public Matrix() {
        a = new float[3][3];
    }

    public Matrix(int row, int col) {
        a = new float[row][col];
    }

    public Matrix mul(Matrix m) {
        Matrix result = new Matrix(a.length, m.a[0].length);
        if (a[0].length == m.a.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < m.a[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        result.a[i][j] += a[i][k] * m.a[k][j];
                    }
                }
            }
        }
        return result;
    }

    public Matrix add(Matrix m) {
        Matrix result = new Matrix(a.length, a[0].length);
        if (a.length == m.a.length && a[0].length == m.a[0].length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    result.a[i][j] = a[i][j] + m.a[i][j];
                }
            }
        }
        return result;
    }

    public Matrix sub(Matrix m) {
        Matrix result = new Matrix(a.length, a[0].length);
        if (a.length == m.a.length && a[0].length == m.a[0].length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    result.a[i][j] = a[i][j] - m.a[i][j];
                }
            }
        }
        return result;
    }

    public float[][] neg() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = a[i][j] * -1;
            }
        }
        return a;
    }

    public Matrix transpose() {
        Matrix b = new Matrix(a[0].length, a.length);
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                b.a[i][j] = a[j][i];
            }
        }
        return b;
    }

    public void print() {
        for (float[] a1 : a) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a1[j] + " ");
            }
            System.out.println();
        }
    }

    public void input() {
        Scanner in = new Scanner(System.in);
        for (float[] a1 : a) {
            for (int j = 0; j < a[0].length; j++) {
                a1[j] = in.nextFloat();
            }
        }
    }
}
