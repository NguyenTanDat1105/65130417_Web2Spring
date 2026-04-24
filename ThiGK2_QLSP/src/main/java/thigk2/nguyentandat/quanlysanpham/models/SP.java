package thigk2.nguyentandat.quanlysanpham.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "san_pham")
public class SP {
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

	private LoaiSP loaiSP;

	public SP() {
		super();
	}

	public SP(Integer id, String tenSp, Double gia, String moTa, LoaiSP loaiSP) {
		super();
		this.id = id;
		this.tenSp = tenSp;
		this.gia = gia;
		this.moTa = moTa;
		this.loaiSP = loaiSP;
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

	public LoaiSP getLoaiSanPham() {
		return loaiSP;
	}

	public void setLoaiSanPham(LoaiSP loaiSanPham) {
		this.loaiSP = loaiSanPham;
	}
    
}