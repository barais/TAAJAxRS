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

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.jaxrs.dao.DaoListTache;
import fr.istic.taa.jaxrs.dao.DaoTache;
import fr.istic.taa.jaxrs.dao.DaoUtilisateur;
import fr.istic.taa.jaxrs.domain.ListTache;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.dto.ListTacheDTO;

@Path("/api")
public class ListTacheEndpoint {

    private static final Logger logger = Logger.getLogger(UtilisateurEndpoint.class.getName());

    DaoListTache daolisteTache;
    DaoTache daoTache;
    DaoUtilisateur daouser;

    public ListTacheEndpoint() {

        this.daoTache = new DaoTache();
        this.daolisteTache = new DaoListTache();
        this.daouser = new DaoUtilisateur();

    }


    @GET
    @Path("/listtache/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ListTache> getListTasks(@PathParam("userid") String id) {
        Utilisateur u = this.daouser.findById(id);
        return this.daolisteTache.getAll4User(u);
    }

    @GET
    @Path("/listtache/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ListTache> getListTasks() {
        return this.daolisteTache.findAll();
    }

    @POST
    @Path("/listtache")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ListTache createListTask(ListTacheDTO listtache) {

        ListTache t = new ListTache();
        t.setName(listtache.getNom());
        t.setDateCreation(Date.valueOf(LocalDate.now()));
        this.daolisteTache.save(t);
        Utilisateur u = this.daouser.findById(listtache.getIduser());
        u.getListesTaches().add(t);
        t.setOwner(u);
        this.daouser.save(u);
        return t;
    }


}
