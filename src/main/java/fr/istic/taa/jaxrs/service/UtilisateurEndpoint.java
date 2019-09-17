/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.istic.taa.jaxrs.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.jaxrs.dao.DaoUtilisateur;
import fr.istic.taa.jaxrs.domain.Utilisateur;

@Path("/api")
public class UtilisateurEndpoint {
 
    private static final Logger logger = Logger.getLogger(UtilisateurEndpoint.class.getName());

    DaoUtilisateur daouser;

    public UtilisateurEndpoint() {

        this.daouser = new DaoUtilisateur();

    }

    @GET
    @Path("/test")
    public String helloWorld() {
        return "hello";
    }

    @GET
    @Path("/user/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Utilisateur getUser(@PathParam("userid") String id) {
        Utilisateur u = this.daouser.findById(id);
        return u;
    }

    @GET
    @Path("/user/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getUtilisateur() {
        return this.daouser.findAll();
    }

    @POST
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Utilisateur createUtilisateur(Utilisateur u) {

        return this.daouser.save(u);

    }

}
