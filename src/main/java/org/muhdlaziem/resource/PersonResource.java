package org.muhdlaziem.resource;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import org.muhdlaziem.entity.PersonEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonResource {

    @Inject
    EntityManager em;

    @Inject
    TransactionManager tm;
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createPerson(JsonObject jsonObject) throws SystemException {
        try{
            PersonEntity personEntity = new PersonEntity();
            personEntity.setName(jsonObject.getString("name"));
            personEntity.setAge(jsonObject.getInteger("age"));
            personEntity.setIcNo(jsonObject.getString("icNo"));
            personEntity.setStatus(jsonObject.getString("status"));

            em.persist(personEntity);
            return Response.ok(personEntity).build();
        }
        catch (Exception e){
            tm.setRollbackOnly();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
