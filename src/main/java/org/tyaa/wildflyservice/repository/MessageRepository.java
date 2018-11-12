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
import org.tyaa.wildflyservice.entity.Message;

/**
 *
 * @author Yurii
 */
@ApplicationScoped
public class MessageRepository {
    
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public Message getById(long id){
        logger.info("Get message by id: " + id);
        return entityManager.find(Message.class, id);
    }

    public List<Message> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> criteria = criteriaBuilder.createQuery(Message.class);
        Root<Message> element = criteria.from(Message.class);
        return entityManager.createQuery(criteria).getResultList();
    }
}
