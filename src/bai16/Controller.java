package bai16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Controller {

    private PrintWriter printWriter;
    private FileWriter fileWriter;

    public ArrayList<MatHang> readFromFile(String fileName) {
        ArrayList<MatHang> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner in = new Scanner(file);
            try {
                ArrayList<String> arr = new ArrayList<>();
                while (in.hasNextLine()) {
                    arr.add(in.nextLine());
                    if (arr.size() == 4) {
                        if (checkInformation(arr)) {
                            MatHang mh = new MatHang(Integer.parseInt(arr.get(0)),
                                    arr.get(1), arr.get(2), Double.parseDouble(arr.get(3)));
                            list.add(mh);
                        }
                        arr.clear();
                    }
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            System.out.println("Xảy ra lỗi!");
            e.printStackTrace();
        }

        return list;
    }

    static boolean checkInformation(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).isEmpty()) {
                return false;
            }
        }
        String ma = arr.get(0);
        if (!ma.matches("\\d{4}") || ma.length() == 0) {
            return false;
        }
        int maHang = Integer.parseInt(ma);
        String ten = arr.get(1);
        double giaBan = Double.parseDouble(arr.get(3));
        if (maHang < 1000 || maHang > 9999) {
            return false;
        }
        if (giaBan < 0) {
            return false;
        }
        if (ten.length() == 0) {
            return false;
        }
        return true;
    }

    public void writeToFile(MatHang matHang, String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            printWriter = new PrintWriter(fileWriter);
            try {
                printWriter.println(matHang.getMaHang() + "|" + matHang.getTen()
                        + "|" + matHang.getNhom() + "|" + matHang.getGiaBan());
            } finally {
                printWriter.close();
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Lỗi mở file!");
            e.printStackTrace();
        }
    }

    public void sortByPrice(ArrayList<MatHang> list) {
        list.sort(new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
                return (int) (o2.getGiaBan() - o1.getGiaBan());
            }
        });
    }

    public void sortByName(ArrayList<MatHang> list) {
        list.sort(new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
                String name1 = o1.getTen().trim();
                String name2 = o2.getTen().trim();
                String[] n1 = name1.toLowerCase().split(" ");
                String[] n2 = name2.toLowerCase().split(" ");
                return n1[n1.length - 1].compareTo(n2[n2.length - 1]);
            }
        });
    }

    public ArrayList<MatHang> filterByGroup(ArrayList<MatHang> list, String nhom) {
        ArrayList<MatHang> res = new ArrayList<>();
        for (MatHang matHang : list) {
            if (matHang.getNhom().equals(nhom)) {
                res.add(matHang);
            }
        }
        sortByName(res);
        return res;
    }
}
