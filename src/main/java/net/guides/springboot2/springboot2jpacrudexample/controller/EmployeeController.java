package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.model.Response;
import net.guides.springboot2.springboot2jpacrudexample.repository.CustomerRepository;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CustomerRepository customerRepository;
	// start panination
	
	@GetMapping("/pageable")
	public Page<Employee> retrieveCustomerWithPaging(@RequestParam(value = "page") int page, 
			
					String test = "hello jenkins";		 
							 
							 
							 
							 @RequestParam(value = "size") int size){
		int page1 = (int) page;
		int size1 = (int) size;
		Pageable requestedPage = PageRequest.of(page1, size1);
		Page<Employee> employees  = customerRepository.findAll(requestedPage);
		return employees;
	}
	
	@GetMapping("/custom/pageable")
	public Response  retrieveCustomer(@RequestParam(value = "salary") Double salary,
									@RequestParam(value = "page") int page,
									@RequestParam(value = "size") int size,
									@RequestParam(value = "agesorting") boolean agesorting,
									@RequestParam(value = "desc") boolean desc) {
		Page<Employee> employees = null;
		// not filtering with salary
				if(salary < 0) {
					// not sorting with age
					if(agesorting == false) {
						Pageable requestedPage = PageRequest.of(page, size);
						employees = customerRepository.findAll(requestedPage);
					}else {
						// sorting with age and ascending
						if(false == desc) {
							Pageable requestedPage = PageRequest.of(page, size, Sort.by("age"));
							employees  = customerRepository.findAll(requestedPage);
						}
						// sorting with age and descending
						else {
							Pageable requestedPage = PageRequest.of(page, size, 
														Sort.by("age").descending());
							employees  = customerRepository.findAll(requestedPage);
						}
					}
				// Filtering with salary
				} else {			
					// not sorting with age
					if(agesorting == false) {
						Pageable requestedPage = PageRequest.of(page, size);
						// fitering request
						employees = customerRepository.findAllBySalary(salary, requestedPage);	
					}else {
						// sorting with age and ascending
						if(false == desc) {
							Pageable requestedPage = PageRequest.of(page, size, Sort.by("age"));
							// filtering request
							employees  = customerRepository.findAllBySalary(salary, requestedPage);
						}
						// sorting with age and descending
						else {
							Pageable requestedPage = PageRequest.of(page, size, 
														Sort.by("age").descending());
							// filtering request
							employees  = customerRepository.findAllBySalary(salary, requestedPage);
						}
					}
				}
				
				Response res = new Response(employees.getContent(), employees.getTotalPages(),
						employees.getNumber(), employees.getSize());
				
				return res;
			}
				
	@GetMapping("/salaries")
	public List<Double> getListSalaries() {
		try {
//			System.out.println("hyhy");
//			System.out.println(customerRepository.findDistinctSalary().toArray());
			return customerRepository.findDistinctSalary();
		}catch(Exception e) {
			// Log errors to user monitoring
			System.out.println(e);
			return Arrays.asList();
		}
	}
	
	// end pagination
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
		throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Employee2> updateEmployee(@PathVariable(value = "id") Long employeeId,
//			@Valid @RequestBody Employee2 employeeDetails) throws ResourceNotFoundException{
//		Employee2 employee = employeeRepository.findById(employeeId)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//		employee.setEmailId(employeeDetails.getEmailId());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setFirstName(employeeDetails.getFirstName());
//		final Employee2 updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}
	@PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

	
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
	         throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		employeeRepository.delete(employee);
		Map<String, Boolean> reponse = new HashMap<>();
		reponse.put("deleted", Boolean.TRUE);
		return reponse;
	}
	
	
	
}
