package thigk2.nguyentandat.Practise_QuanLySanPham.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_san_pham")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_loai_sp")
    private String tenLoai;

    @OneToMany(mappedBy = "loaiSanPham")
    private List<SanPham> listSanPham;
    
    
	public LoaiSanPham() {
		super();
	}

	public LoaiSanPham(Integer id, String tenLoai, List<SanPham> listSanPham) {
		super();
		this.id = id;
		this.tenLoai = tenLoai;
		this.listSanPham = listSanPham;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<SanPham> getListSanPham() {
		return listSanPham;
	}

	public void setListSanPham(List<SanPham> listSanPham) {
		this.listSanPham = listSanPham;
	}

    
}
