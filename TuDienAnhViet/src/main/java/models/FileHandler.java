package models;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    // Đọc dữ liệu
    public ArrayList<TuVung> readData() {
        ArrayList<TuVung> list = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    list.add(new TuVung(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
        return list;
    }

    // Ghi dữ liệu
    public void writeData(ArrayList<TuVung> list) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"))) {
            for (TuVung tv : list) {
                bw.write(tv.getTiengAnh() + "|" + tv.getTiengViet() + "|" + tv.getViDu());
                bw.newLine();
            }
            bw.flush(); // Đảm bảo dữ liệu được đẩy xuống file hoàn toàn
        } catch (IOException e) { e.printStackTrace(); }
    }
}