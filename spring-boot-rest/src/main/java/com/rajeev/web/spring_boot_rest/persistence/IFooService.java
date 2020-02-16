package com.rajeev.web.spring_boot_rest.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rajeev.web.spring_boot_rest.persistence.IOperations;
import com.rajeev.web.spring_boot_rest.persistence.Foo;

public interface IFooService extends IOperations<Foo> {
    
    Page<Foo> findPaginated(Pageable pageable);

}