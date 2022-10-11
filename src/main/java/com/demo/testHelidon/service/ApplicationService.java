package com.demo.testHelidon.service;

import com.demo.testHelidon.entity.TbMApplicationType;
import com.demo.testHelidon.repository.TbMApplicationTypeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ApplicationService {
    @Inject
    private TbMApplicationTypeRepository tbMApplicationTypeRepository;

    public List<TbMApplicationType> getAllApplicationType() {
        return tbMApplicationTypeRepository.getAllData();
    }
}
