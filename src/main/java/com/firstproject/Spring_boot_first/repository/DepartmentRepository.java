package com.firstproject.Spring_boot_first.repository;

import com.firstproject.Spring_boot_first.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);
//    public  List<String> findDistinctDepartmentName();
}


