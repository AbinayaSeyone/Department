package com.firstproject.Spring_boot_first.service;

import com.firstproject.Spring_boot_first.entity.Department;
import com.firstproject.Spring_boot_first.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Set;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> fetchDepartmentList();
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;
    public void deleteDepartmentById(Long departmentId);
    public Department updateDepartment(Long departmentId, Department department);
    public Department fetchDepartmentByName(String departmentName);
    public Set<String> fetchDistinctDepartmentByName( );
}
