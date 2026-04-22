package dat.ntu.QLTinTuc.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tin_tuc")
public class TinTuc {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "tieu_de", nullable = false, columnDefinition = "nvarchar(255)")
    private String tieuDe;
    
    @Column(name = "noi_dung", columnDefinition = "text")
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "loai_tin_id")
    private LoaiTinTuc loaiTin;

    // --- Constructors ---
    public TinTuc() {}

    public TinTuc(Integer id, String tieuDe, String noiDung, LoaiTinTuc loaiTin) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.loaiTin = loaiTin;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public LoaiTinTuc getLoaiTin() {
		return loaiTin;
	}

	public void setLoaiTin(LoaiTinTuc loaiTin) {
		this.loaiTin = loaiTin;
	}   
}
