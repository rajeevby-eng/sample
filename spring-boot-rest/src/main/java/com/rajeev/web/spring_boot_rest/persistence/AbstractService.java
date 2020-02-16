package com.rajeev.web.spring_boot_rest.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rajeev.web.spring_boot_rest.persistence.IOperations;
import com.google.common.collect.Lists;

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

    // read - one

    @Transactional(readOnly = true)
    public T findById(final long id) {
        return getDao().findById(id).get();
    }

    // read - all

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    public Page<T> findPaginated(Pageable pageable) {
        return getDao().findAll(pageable);
    }

    // write
    
    public T create(final T entity) {
        return getDao().save(entity);
    }
    
    public T update(final T entity) {
        return getDao().save(entity);
    }

    public void delete(final T entity) {
        getDao().delete(entity);
    }

    public void deleteById(final long entityId) {
        getDao().deleteById(entityId);
    }

    protected abstract PagingAndSortingRepository<T, Long> getDao();

}