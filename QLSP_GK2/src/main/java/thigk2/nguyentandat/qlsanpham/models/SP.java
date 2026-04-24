package thigk2.nguyentandat.qlsanpham.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sp")
public class SP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_sp", nullable = false)
    private String tenSp;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "loai_id")
    private LoaiSP loaiSP;

    // Getters và Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTenSp() { return tenSp; }
    public void setTenSp(String tenSp) { this.tenSp = tenSp; }
    public Double getGia() { return gia; }
    public void setGia(Double gia) { this.gia = gia; }
    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
    public LoaiSP getLoaiSP() { return loaiSP; }
    public void setLoaiSP(LoaiSP loaiSP) { this.loaiSP = loaiSP; }
}
