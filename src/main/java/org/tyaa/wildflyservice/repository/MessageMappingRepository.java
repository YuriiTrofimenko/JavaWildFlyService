/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.wildflyservice.repository;

import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.tyaa.wildflyservice.entity.MessageMapping;
import org.tyaa.wildflyservice.entity.User;

/**
 *
 * @author Yurii
 */
@ApplicationScoped
public class MessageMappingRepository {
    
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public List<MessageMapping> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteria =
                criteriaBuilder.createQuery(MessageMapping.class);
        Root<MessageMapping> element = criteria.from(MessageMapping.class);
        return entityManager.createQuery(criteria).getResultList();
    }

    public MessageMapping getById(long id){
        logger.info("Get message mapping by id: " + id);
        return entityManager.find(MessageMapping.class, id);
    }

    public List<MessageMapping> getByFromId(User from_id){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteria =
                criteriaBuilder.createQuery(MessageMapping.class);
        Root<MessageMapping> element = criteria.from(MessageMapping.class);
        return entityManager.createQuery(criteria).getResultList();
    }
}
