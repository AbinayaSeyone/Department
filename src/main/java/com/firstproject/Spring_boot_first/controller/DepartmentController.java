package com.firstproject.Spring_boot_first.controller;

import com.firstproject.Spring_boot_first.entity.Department;
import com.firstproject.Spring_boot_first.error.DepartmentNotFoundException;
import com.firstproject.Spring_boot_first.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Set;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger( DepartmentController.class );
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info( "Inside saveDepartment of DepartmentController" );
        return departmentService.saveDepartment(department);
        //DepartmentService service=new DepartmentServiceImplementation();
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info( "Inside fetchDepartmentList of DepartmentController" );
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException
    {
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){

        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
    {
        return departmentService.fetchDepartmentByName( departmentName );
    }
    @GetMapping("/departments/dname")
    public Set<String> fetchDistinctDepartmentByName(){
         return departmentService.fetchDistinctDepartmentByName();
    }

}
