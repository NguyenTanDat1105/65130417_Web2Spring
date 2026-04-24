package thigk2.nguyentandat.qlsanpham.models;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "loai_sp")
public class LoaiSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_loai", nullable = false)
    private String tenLoai;

    @OneToMany(mappedBy = "loaiSP", cascade = CascadeType.ALL)
    @JsonIgnore 
    private List<SP> listSP;

    // Getters và Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTenLoai() { return tenLoai; }
    public void setTenLoai(String tenLoai) { this.tenLoai = tenLoai; }
    public List<SP> getListSP() { return listSP; }
    public void setListSP(List<SP> listSP) { this.listSP = listSP; }
}