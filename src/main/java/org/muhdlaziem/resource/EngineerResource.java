package org.muhdlaziem.resource;

import io.vertx.core.json.JsonObject;
import org.muhdlaziem.entity.EngineerEntity;
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

@Path("/engineer")
public class EngineerResource {

    @Inject
    EntityManager em;

    @Inject
    TransactionManager tm;
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createEngineer(JsonObject jsonObject) throws SystemException {
        try{
            EngineerEntity engineerEntity = new EngineerEntity();
            PersonEntity personEntity = PersonEntity.find("ic_no", jsonObject.getString("icNo")).firstResult();

            if(personEntity != null){
                engineerEntity.setPersonEntity(personEntity);
                engineerEntity.setCompany(jsonObject.getString("company"));
                engineerEntity.setDepartment(jsonObject.getString("department"));
                em.persist(engineerEntity);
                return Response.ok(engineerEntity).build();
            }
            else {
                return  Response.status(Response.Status.BAD_REQUEST).build();
            }

        }
        catch (Exception e){
            e.printStackTrace();
            tm.setRollbackOnly();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
