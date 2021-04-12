package net.guides.springboot2.springboot2jpacrudexample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee2 {

	public Employee2(String name, String dantoc, String gioitinh, int sodienthoai, String quequan, Date ngaysinh,
			String macv, String matdhv, String mapb, int bacluong) {
		super();
		this.name = name;
		this.dantoc = dantoc;
		this.gioitinh = gioitinh;
		this.sodienthoai = sodienthoai;
		this.quequan = quequan;
		this.ngaysinh = ngaysinh;
		this.macv = macv;
		this.matdhv = matdhv;
		this.mapb = mapb;
		this.bacluong = bacluong;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "dantoc", nullable = false)
    private String dantoc;
	
	@Column(name = "gioitinh", nullable = false)
    private String gioitinh;
	
	@Column(name = "sodienthoai", nullable = false)
	private int sodienthoai;
	
	@Column(name = "quequan", nullable = false)
	private String quequan;
	
	@Column(name="ngaysinh", nullable = false)
	private Date ngaysinh;
	
	@Column(name = "macv", nullable = false)
	private String macv;
	
	@Column(name = "matdhv", nullable = false)
	private String matdhv;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDantoc() {
		return dantoc;
	}

	public void setDantoc(String dantoc) {
		this.dantoc = dantoc;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public int getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(int sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getMacv() {
		return macv;
	}

	public void setMacv(String macv) {
		this.macv = macv;
	}

	public String getMatdhv() {
		return matdhv;
	}

	public void setMatdhv(String matdhv) {
		this.matdhv = matdhv;
	}

	public String getMapb() {
		return mapb;
	}

	public void setMapb(String mapb) {
		this.mapb = mapb;
	}

	public int getBacluong() {
		return bacluong;
	}

	public void setBacluong(int bacluong) {
		this.bacluong = bacluong;
	}

	@Column(name = "mapb", nullable = false)
	private String mapb;
	
	@Column(name = "bacluong", nullable = false)
	private int bacluong;
	
	
	
//    @Override
//    public String toString() {
//        return "Employee [id=" + id + ", firstName=" + firstName + ", age=" + age + ",salary=" + salary + ",lastName=" + lastName + ", emailId=" + emailId
//       + "]";
//    }


}

