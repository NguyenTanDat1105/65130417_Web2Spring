package thigk2.nguyentandat.Practise_QuanLySanPham.models;

import jakarta.persistence.*;

@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_sp")
    private String tenSp;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "loai_sp_id")
    private LoaiSanPham loaiSanPham;

	public SanPham() {
		super();
	}

	public SanPham(Integer id, String tenSp, Double gia, String moTa, LoaiSanPham loaiSanPham) {
		super();
		this.id = id;
		this.tenSp = tenSp;
		this.gia = gia;
		this.moTa = moTa;
		this.loaiSanPham = loaiSanPham;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public Double getGia() {
		return gia;
	}

	public void setGia(Double gia) {
		this.gia = gia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}
    
}
