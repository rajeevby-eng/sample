package com.rajeev.web.spring_boot_rest.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajeev.web.spring_boot_rest.persistence.Foo;

public interface IFooDao extends JpaRepository<Foo, Long> {
    
}