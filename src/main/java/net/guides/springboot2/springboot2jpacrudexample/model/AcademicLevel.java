package net.guides.springboot2.springboot2jpacrudexample.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="nhanvien")
public class AcademicLevel {
	
    private Long id;
	private String tenTrinhDo;
	private String chuyenNganh;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "tentrinhdo", nullable = false)
	public String getTenTrinhDo() {
		return tenTrinhDo;
	}
	public void setTenTrinhDo(String tenTrinhDo) {
		this.tenTrinhDo = tenTrinhDo;
	}
	
	@Column(name = "chuyen_nganh", nullable = false)
	public String getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	
	
	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    // MapopedBy trỏ tới tên biến Address ở trong Person.
    //@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    //@ToString.Exclude // Khoonhg sử dụng trong toString()
    private Collection<Employee> employees;
}
