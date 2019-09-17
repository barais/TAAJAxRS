package fr.istic.taa.jaxrs.dao;

import java.util.List;

import org.slf4j.helpers.Util;

import fr.istic.taa.jaxrs.domain.Utilisateur;

public class DaoUtilisateur {

    public Utilisateur findById(String id) {
        return EntityManagerHelper.getEntityManager().find(Utilisateur.class, id);

    }

    public List<Utilisateur> findByName(String name) {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u where u.name = :name", Utilisateur.class)
                .setParameter("name", name).getResultList();

    }


    public List<Utilisateur> findByFirstname(String firstname) {
        return EntityManagerHelper.getEntityManager().createNamedQuery("tousleusesbyfirstname", Utilisateur.class)
                .setParameter("fistname", firstname).getResultList();

    }

    public Utilisateur save(Utilisateur u ){
        EntityManagerHelper.beginTransaction();
        if (u.getEmail() != null) {
            EntityManagerHelper.getEntityManager().merge(u);

        } else {
            EntityManagerHelper.getEntityManager().persist(u);

        }
        EntityManagerHelper.commit();
        return u;

    }

    public void delete(String id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();        
    }

	public List<Utilisateur> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u", Utilisateur.class)
        .getResultList();
	}


}