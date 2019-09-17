package fr.istic.taa.jaxrs.dao;

import java.util.Date;
import java.util.List;

import fr.istic.taa.jaxrs.domain.ListTache;
import fr.istic.taa.jaxrs.domain.Tache;
import fr.istic.taa.jaxrs.domain.Utilisateur;

public class DaoTache {


    public Tache findById(long idListTache) {
		return EntityManagerHelper.getEntityManager().find(Tache.class, idListTache);
	}

    public Tache save(Tache t) {
        EntityManagerHelper.beginTransaction();
        if (t.getId() != 0) {
            EntityManagerHelper.getEntityManager().merge(t);

        } else {
            EntityManagerHelper.getEntityManager().persist(t);

        }
        EntityManagerHelper.commit();
        return t;

    }

    public List<Tache> getAllForUser(Utilisateur u, Date debut, Date fin) {

        String s = "select distinct lt.taches from ListTache as lt join lt.taches as t "
                + "where lt.owner = :user and t.dateEcheance between :debut and :fin";

        return EntityManagerHelper.getEntityManager().createQuery(s).setParameter("user", u)
                .setParameter("debut", debut).setParameter("fin", fin).getResultList();
    }


    public void delete(long id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();        
    }

	public List<Tache> getAll4User(Utilisateur u) {
        
        String s = "select distinct lt.taches from ListTache as lt "
                + "where lt.owner = :user";

        return EntityManagerHelper.getEntityManager().createQuery(s).setParameter("user", u)
                .getResultList();

        
	}

	public List<Tache> findAll() {
		String s = "select t from Tache as t";

        return EntityManagerHelper.getEntityManager().createQuery(s,Tache.class)
                .getResultList();
	}
}