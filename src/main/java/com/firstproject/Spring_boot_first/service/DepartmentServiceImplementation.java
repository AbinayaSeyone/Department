package com.firstproject.Spring_boot_first.service;

import com.firstproject.Spring_boot_first.entity.Department;
import com.firstproject.Spring_boot_first.error.DepartmentNotFoundException;
import com.firstproject.Spring_boot_first.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class DepartmentServiceImplementation implements DepartmentService
{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment( Department department )
    {
        return departmentRepository.save( department );
    }

    @Override
    public List<Department> fetchDepartmentList()
    {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById( Long departmentId ) throws DepartmentNotFoundException
    {
        Optional<Department> department= departmentRepository.findById( departmentId );
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById( Long departmentId )
    {
        departmentRepository.deleteById( departmentId );
    }

    @Override
    public Department updateDepartment( Long departmentId, Department department )
    {
        Department depDB = departmentRepository.findById( departmentId ).get();
        if( Objects.nonNull( department.getDepartmentName() ) && !"".equalsIgnoreCase( department.getDepartmentName() ) )
        {
            depDB.setDepartmentName( department.getDepartmentName() );
        }
        if( Objects.nonNull( department.getDepartmentAddress() ) && !"".equalsIgnoreCase( department.getDepartmentAddress() ) )
        {
            depDB.setDepartmentAddress( department.getDepartmentAddress() );
        }
        if( Objects.nonNull( department.getDepartmentCode() ) && !"".equalsIgnoreCase( department.getDepartmentCode() ) )
        {
            depDB.setDepartmentCode( department.getDepartmentCode() );
        }

        return departmentRepository.save( depDB );
    }

    @Override
    public Department fetchDepartmentByName( String departmentName )
    {
        return departmentRepository.findByDepartmentNameIgnoreCase( departmentName );
    }

    @Override
    public Set<String> fetchDistinctDepartmentByName()
    {
        Set<String> distinctDepartmentNames = new HashSet<>();

        List<Department> departments = departmentRepository.findAll();
        for( int i = 0; i < departments.size(); i++ )
        {
            Department currentDepartment = departments.get( i );
            int count = 0;
            for( int j = i + 1; j < departments.size() - i; j++ )
            {

                if( ( currentDepartment.getDepartmentName().equals( departments.get( j ).getDepartmentName() ) ) )
                {
                    count++;
                }
            }
            if( count == 0 )
            {
                distinctDepartmentNames.add( currentDepartment.getDepartmentName() );

            }
        }
        return distinctDepartmentNames;
    }
}

    /*@Override
    public void fetchDistinctDepartmentByName() {
        List<Department> departments = departmentRepository.findAll();

        // Use a set to store distinct department names
        Set<String> distinctDepartmentNames = new HashSet<>();

        for(int i = 0; i < departments.size(); i++) {
            Department currentDepartment = departments.get(i);

            // Check if the department name is not in the set, then add it and print
            if (distinctDepartmentNames.add(currentDepartment.getDepartmentName())) {
                System.out.println(currentDepartment.getDepartmentName());
            }
        }
    }*/


