package com.zhiwang.restapi.dao;

import com.zhiwang.restapi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entitymanager

    private final EntityManager entityManager;
    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list

        //return the results
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {

        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {

        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);

        entityManager.remove(theEmployee);

    }


}
