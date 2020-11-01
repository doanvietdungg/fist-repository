package bai17;

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

    private PrintWriter printWriter;
    private FileWriter fileWriter;

    public void writeToFile(Sach s, String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            printWriter = new PrintWriter(fileWriter);
            try {
                printWriter.println(s.getMaSach() + "  " + s.getTen() + "  "
                        + s.getChuyenNghanh() + "  " + s.getGia());
            } finally {
                printWriter.close();
                fileWriter.close();
            }
        } catch (Exception e) {
            System.out.println("Lỗi mở file!");
            e.printStackTrace();
        }
    }

    public ArrayList<Sach> readFile(String fileName) {
        ArrayList<Sach> result = new ArrayList<>();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner in = new Scanner(file);
            try {
                ArrayList<String> list = new ArrayList<>();
                while (in.hasNextLine()) {
                    list.add(in.nextLine());
                    if (list.size() == 4) {
                        if (checkInfor(list)) {
                            Sach s = new Sach(Integer.parseInt(list.get(0)),
                                    list.get(1), list.get(2),
                                    Double.parseDouble(list.get(3)));
                            result.add(s);
                        }
                        list.clear();
                    }
                }

            } finally {
                in.close();
            }
        } catch (Exception e) {
            System.out.println("Xảy ra lỗi!");
            e.printStackTrace();
        }
        return result;
    }

    public boolean checkInfor(ArrayList<String> list) {
        for (String s : list) {
            if (s.isEmpty()) {
                return false;
            }
        }
        String ma = list.get(0);
        if (!ma.matches("\\d{4}") || ma.length() == 0) {
            return false;
        }
        int maSach = Integer.parseInt(list.get(0));
        if (!list.get(3).matches("^[0-9]+\\.{0,1}[0-9]{0,}")) {
            return false;
        }
        double gia = Double.parseDouble(list.get(list.size() - 1));
        if (maSach < 1000 || maSach > 9999) {
            return false;
        }
        if (gia < 0) {
            return false;
        }
        return true;
    }

    public void sortByPrice(ArrayList<Sach> list) {
        list.sort(new Comparator<Sach>() {
            @Override
            public int compare(Sach o1, Sach o2) {
                return (int) (o2.getGia() - o1.getGia());
            }
        });
    }

    public void sortByName(ArrayList<Sach> list) {
        list.sort(new Comparator<Sach>() {
            @Override
            public int compare(Sach o1, Sach o2) {
                String name1 = o1.getTen().trim();
                String name2 = o2.getTen().trim();
                return name1.compareTo(name2);
            }
        });
    }

    public ArrayList<Sach> locChuyenNganh(ArrayList<Sach> list, String cn) {
        ArrayList<Sach> res = new ArrayList<>();
        for (Sach s : list) {
            if (s.getChuyenNghanh().equals(cn)) {
                res.add(s);
            }
        }
        sortByName(res);
        return res;
    }
}
