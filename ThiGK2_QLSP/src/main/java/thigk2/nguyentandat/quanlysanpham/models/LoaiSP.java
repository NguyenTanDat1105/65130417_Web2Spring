package thigk2.nguyentandat.quanlysanpham.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "loai_sp")
public class LoaiSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_loai_sp")
    private String tenLoai;

    @OneToMany(mappedBy = "loaiSanPham")
    @JsonIgnore
    private List<SP> listSP;
    
    
	public LoaiSP() {
		super();
	}

	public LoaiSP(Integer id, String tenLoai, List<SP> listSanPham) {
		super();
		this.id = id;
		this.tenLoai = tenLoai;
		this.listSP = listSanPham;
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

	public List<SP> getListSanPham() {
		return listSP;
	}

	public void setListSanPham(List<SP> listSP) {
		this.listSP = listSP;
	}

    
}
