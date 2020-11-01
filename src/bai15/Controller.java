package bai15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Dao Cong Binh
 */
public class Controller {

    private FileWriter fileWriter;
    private PrintWriter printWriter;

    public void writeToFile(SinhVien sinhVien, String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            printWriter = new PrintWriter(fileWriter);
            try {
                printWriter.println(sinhVien.getMaSV());
                printWriter.println(sinhVien.getTen());
                printWriter.println(sinhVien.getLop());
                printWriter.println(sinhVien.getDtb());
            } finally {
                printWriter.close();
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Lỗi mở file!");
            e.printStackTrace();
        }
    }

    public void writeFileSX(SinhVien sinhVien, String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            printWriter = new PrintWriter(fileWriter);
            try {
                printWriter.println(sinhVien.getMaSV() + " " + sinhVien.getTen()
                        + " " + sinhVien.getLop() + " " + sinhVien.getDtb());
            } finally {
                printWriter.close();
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Lỗi mở file!");
            e.printStackTrace();
        }
    }

    public void writeFileXL(SinhVien sinhVien, String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            printWriter = new PrintWriter(fileWriter);
            try {
                printWriter.println(sinhVien.getMaSV() + "|" + sinhVien.getTen()
                        + "|" + sinhVien.getLop() + "|" + sinhVien.getDtb() + "|" + sinhVien.getXl());
            } finally {
                printWriter.close();
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Lỗi mở file!");
            e.printStackTrace();
        }
    }

    public ArrayList<SinhVien> readFileXL(String fileName) {
        ArrayList<SinhVien> list = new ArrayList<>();

        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner in = new Scanner(file);
            try {
                while (in.hasNextLine()) {
                    String data = in.nextLine();
                    SinhVien s = taoSinhVien(data);
                    list.add(s);
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

    public SinhVien taoSinhVien(String data) {
        String[] datas = data.split("\\|");
        SinhVien sv = new SinhVien(datas[0], datas[1], datas[2], Double.parseDouble(datas[3]));
        return sv;
    }

    public ArrayList<SinhVien> readFromFile(String fileName) {
        ArrayList<SinhVien> list = new ArrayList<>();

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
                            SinhVien sv = new SinhVien(arr.get(0),
                                    chuanHoa(arr.get(1)),
                                arr.get(2).toUpperCase(), Double.parseDouble(arr.get(3)));
                            list.add(sv);
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
        } catch (Exception e) {
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
        String maSV = arr.get(0);
        String ten = arr.get(1);
        String lop = arr.get(2);
        if (!arr.get(3).matches("^[0-9]+\\.{0,1}[0-9]{0,}")) {
            return false;
        }
        double dtb = Double.parseDouble(arr.get(3));
        if (!maSV.matches("\\d{4}") || maSV.length() == 0) {
            return false;
        }
        int ma = Integer.parseInt(maSV);
        if (ma < 1000 || ma > 9999) {
            return false;
        }
        if (!lop.matches("^D\\d{2}[A-Z]{4}\\d{2}-B$") || lop.length() == 0) {
            return false;
        }
        if (dtb < 0 || dtb > 10) {
            return false;
        }
        String[] strings = ten.trim().split(" ");
        if (ten.length() == 0 || strings.length < 2) {
            return false;
        }
        return true;
    }

    public ArrayList<SinhVien> filterandSortByClass(ArrayList<SinhVien> list, String lop) {
        ArrayList<SinhVien> result = new ArrayList<>();
        for (SinhVien s : list) {
            if (lop.equals(s.getLop())) {
                result.add(s);
            }
        }
        result.sort(new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if (o1.getDtb() > o2.getDtb()) {
                    return -1;
                }
                return 1;
            }
        });
        return result;
    }

    public void sortByName(ArrayList<SinhVien> list) {
        list.sort(new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                String fullName1 = o1.getTen().trim();
                String fullName2 = o2.getTen().trim();
                String name1 = fullName1.substring(fullName1.lastIndexOf(" "));
                String name2 = fullName2.substring(fullName2.lastIndexOf(" "));
                if (name1.compareTo(name2) == 0) {
                    return fullName1.compareTo(fullName2);
                }
                return name1.compareTo(name2);
            }
        });
    }

    private static String chuanHoa(String s) {
        s = s.toLowerCase();
        String res = "";
        StringTokenizer a = new StringTokenizer(s, "\t\\ ", false);
        while (a.hasMoreTokens()) {            
            String a1 = a.nextToken();
            a1 = a1.trim();
            res += Character.toUpperCase(a1.charAt(0)) + a1.substring(1) + " ";
        }
        return res;
    }
}
