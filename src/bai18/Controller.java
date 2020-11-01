package bai18;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Controller {

    private FileWriter fileWriter;
    private PrintWriter printWriter;

    public ArrayList<MonHoc> readMHFromFile(String fileName) {
        ArrayList<MonHoc> list = new ArrayList<>();
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
                        if (checkInfor(arr)) {
                            MonHoc m = new MonHoc(Integer.parseInt(arr.get(0)),
                                    arr.get(1), arr.get(2), Integer.parseInt(arr.get(3)));
                            list.add(m);
                        }
                        arr.clear();
                    }
                }
            } finally {
                in.close();
            }

        } catch (Exception e) {
            System.out.println("Lỗi mở file!");
            e.printStackTrace();
        }
        return list;
    }

    public boolean checkInfor(ArrayList<String> arr) {
        for (String s : arr) {
            if (s.isEmpty()) {
                return false;
            }
        }
        ArrayList<String> r = new ArrayList<>();
        r.add("Cơ bản");
        r.add("Cơ sở ngành");
        r.add("Chuyên ngành");
        r.add("Kỹ năng mềm");
        String ma = arr.get(0);
        if (!ma.matches("\\d{4}") || ma.length() == 0) {
            return false;
        }
        int maMH = Integer.parseInt(arr.get(0));
        String ten = arr.get(1);
        String nhom = arr.get(2);
        if (!arr.get(3).matches("\\d{1}")) {
            return false;
        }
        int soTC = Integer.parseInt(arr.get(3));
        if (soTC >= 7 || soTC < 0) {
            return false;
        }
        if (r.indexOf(nhom) == -1) {
            return false;
        }
        return true;
    }

    public void writeToFile(MonHoc m, String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            printWriter = new PrintWriter(fileWriter);
            try {
                printWriter.println(m.getMaMon() + "  " + m.getTen() + "  "
                        + m.getNhom() + "  " + m.getSoTC());
            } finally {
                printWriter.close();
                fileWriter.close();
            }
        } catch (Exception e) {
            System.out.println("Lỗi mở file!");
            e.printStackTrace();
        }
    }

    public void sortByTC(ArrayList<MonHoc> list) {
        list.sort(new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                return (int) (o2.getSoTC() - o1.getSoTC());
            }
        });
    }

    public void sortByName(ArrayList<MonHoc> list) {
        list.sort(new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                return o1.getTen().compareTo(o2.getTen());
            }
        });
    }

    public ArrayList<MonHoc> locNhomMH(ArrayList<MonHoc> list, String nhom) {
        ArrayList<MonHoc> res = new ArrayList<>();
        for (MonHoc m : list) {
            if (m.getNhom().equals(nhom)) {
                res.add(m);
            }
        }
        sortByName(res);
        return res;
    }
}
