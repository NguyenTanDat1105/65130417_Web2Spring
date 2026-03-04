package models;

public class TuVung {
    private String tiengAnh;
    private String tiengViet;
    private String viDu;

    public TuVung(String tiengAnh, String tiengViet, String viDu) {
        this.tiengAnh = tiengAnh;
        this.tiengViet = tiengViet;
        this.viDu = viDu;
    }

    // Getters
    public String getTiengAnh() { return tiengAnh; }
    public String getTiengViet() { return tiengViet; }
    public String getViDu() { return viDu; }
}