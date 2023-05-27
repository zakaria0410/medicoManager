package com.medicoManager.settingsservice.repository;


import com.medicoManager.settingsservice.model.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Component
public class GenericSearchRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public <T> List<T> executeDynamicQueryForString(Class<T> className, String conditionColumn, Object conditionValue) {
        String jpql = "SELECT t FROM " + className.getName() + " t WHERE t." + conditionColumn + " = :value";
        if(conditionValue instanceof String)jpql = "SELECT t FROM " + className.getName() + " t WHERE t." + conditionColumn + " LIKE '%" + conditionValue + "%'";
        Query query = entityManager.createQuery(jpql);

        if(!(conditionValue instanceof String))    query.setParameter("value", conditionValue);
        return query.getResultList();
    }


}