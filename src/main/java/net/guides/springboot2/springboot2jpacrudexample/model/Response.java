package net.guides.springboot2.springboot2jpacrudexample.model;

import java.util.List;

public class Response {
	private List<Employee> employees;
	private int totalPages;
	private int pageNumber;
	private int pageSize;

	public Response() {
	}

	public Response(List<Employee> employees, int totalPages, int pageNumber, int pageSize) {
		this.employees = employees;
		this.totalPages = totalPages;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public Response(List<Employee> employees, int pageNumber, int pageSize) {
		this.employees = employees;
		
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalPages() {
		return this.totalPages;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageNumber() {
		return this.pageNumber;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return this.pageSize;
	}
}