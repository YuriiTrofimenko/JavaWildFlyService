/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.wildflyservice.registrator;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.tyaa.wildflyservice.entity.MessageMapping;

/**
 *
 * @author Yurii
 */
@Stateless
public class MessageMappingRegistrator {
    
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(MessageMapping item) {
        logger.info("Created message mapping: " + item);
        entityManager.merge(item);
    }

    public void  update (MessageMapping item){
        logger.info("Updated message mapping: " + item);
        entityManager.merge(item);
    }

    public void delete (MessageMapping item){
        logger.info("Deleted message mapping: " + item);
        entityManager.remove(item);
    }
}
