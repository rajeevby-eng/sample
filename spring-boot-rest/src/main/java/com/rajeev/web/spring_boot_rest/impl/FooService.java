package com.rajeev.web.spring_boot_rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rajeev.web.spring_boot_rest.persistence.IFooDao;
import com.rajeev.web.spring_boot_rest.persistence.Foo;
import com.rajeev.web.spring_boot_rest.persistence.IFooService;
import com.rajeev.web.spring_boot_rest.persistence.AbstractService;
import com.google.common.collect.Lists;

@Service
@Transactional
public class FooService extends AbstractService<Foo> implements IFooService {

    @Autowired
    private IFooDao dao;

    public FooService() {
        super();
    }

    // API

    @Override
    protected PagingAndSortingRepository<Foo, Long> getDao() {
        return dao;
    }

    // custom methods

    @Override
    public Page<Foo> findPaginated(Pageable pageable) {
    	System.out.println("find paginated: " + pageable);
        return dao.findAll(pageable);
    }
    
    // overridden to be secured

    @Override
    @Transactional(readOnly = true)
    public List<Foo> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

}
