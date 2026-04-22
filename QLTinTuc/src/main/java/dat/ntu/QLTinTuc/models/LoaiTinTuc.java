package dat.ntu.QLTinTuc.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_tin")
public class LoaiTinTuc {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ten_loai", nullable = false, columnDefinition = "nvarchar(255)")
    private String tenLoai;

    @OneToMany(mappedBy = "loaiTin", cascade = CascadeType.ALL)
    private List<TinTuc> danhSachTinTuc;

    public LoaiTinTuc() {}

    public LoaiTinTuc(Integer id, String tenLoai) {
        this.id = id;
        this.tenLoai = tenLoai;
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

	public List<TinTuc> getDanhSachTinTuc() {
		return danhSachTinTuc;
	}

	public void setDanhSachTinTuc(List<TinTuc> danhSachTinTuc) {
		this.danhSachTinTuc = danhSachTinTuc;
	}
}