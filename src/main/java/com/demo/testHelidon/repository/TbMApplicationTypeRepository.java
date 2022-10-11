package com.demo.testHelidon.repository;

import com.demo.testHelidon.entity.TbMApplicationType;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TbMApplicationTypeRepository extends BaseRepository<TbMApplicationType, String> {

    @PersistenceContext
    EntityManager entityManager;

    public List<TbMApplicationType> getAllData() {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<TbMApplicationType> cq = cb.createQuery(TbMApplicationType.class);
//        Root<TbMApplicationType> rootEntry = cq.from(TbMApplicationType.class);
//        CriteriaQuery<TbMApplicationType> all = cq.select(rootEntry);
//        TypedQuery<TbMApplicationType> allQuery = entityManager.createQuery(all);

        TypedQuery<TbMApplicationType> allQuery = entityManager.createNamedQuery("findAll", TbMApplicationType.class);
        return allQuery.getResultList();
    }
}
