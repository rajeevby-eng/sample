package com.rajeev.web.spring_boot_rest.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOperations<T extends Serializable> {

    // read - one

    T findById(final long id);

    // read - all

    List<T> findAll();

    Page<T> findPaginated(Pageable pageable);

    // write

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}