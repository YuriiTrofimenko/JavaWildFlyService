/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.wildflyservice.rest;

import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.tyaa.wildflyservice.entity.MessageMapping;
import org.tyaa.wildflyservice.registrator.MessageMappingRegistrator;
import org.tyaa.wildflyservice.repository.MessageMappingRepository;

/**
 *
 * @author Yurii
 */
@RequestScoped
@Path("/message-mapping")
public class MessageMappingREST {
    
    @Inject
    private Logger logger;

    @Inject
    private MessageMappingRegistrator registrator;

    @Inject
    private MessageMappingRepository repository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageMapping> getAll(){
        logger.info("Get full message mapping");
        return repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageMapping getById(@PathParam("id") long id){
        logger.info("Get mapping by Id: " + id );
        return repository.getById(id);
    }
}
