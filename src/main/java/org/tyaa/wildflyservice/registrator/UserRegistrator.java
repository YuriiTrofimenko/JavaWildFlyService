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
import org.tyaa.wildflyservice.entity.User;

/**
 *
 * @author Yurii
 */
@Stateless
public class UserRegistrator {
    
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(User item) {
        logger.info("Created message mapping: " + item);
        entityManager.merge(item);
    }

    public void  update (User item){
        logger.info("Updated message mapping: " + item);
        entityManager.merge(item);
    }

    public void delete (User item){
        logger.info("Deleted message mapping: " + item);
        entityManager.remove(item);
    }
}
