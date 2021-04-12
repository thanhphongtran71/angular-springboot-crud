package net.guides.springboot2.springboot2jpacrudexample.repository;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Employee, Long>{	
	Page<Employee> findAllBySalary (double salary, Pageable pageable);
	Page<Employee> findAllByAgeGreaterThan(int age, Pageable pageable);
	
	@Transactional
	@Modifying
	@Query(value="SELECT DISTINCT c.salary FROM employees c",nativeQuery = true)
	List<Double> findDistinctSalary();
}
