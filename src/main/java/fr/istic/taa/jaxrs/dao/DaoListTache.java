package fr.istic.taa.jaxrs.dao;

import java.util.List;

import fr.istic.taa.jaxrs.domain.ListTache;
import fr.istic.taa.jaxrs.domain.Utilisateur;

public class DaoListTache{

	public ListTache findById(long idListTache) {
		return EntityManagerHelper.getEntityManager().find(ListTache.class, idListTache);
	}
    public ListTache save(ListTache t) {
        EntityManagerHelper.beginTransaction();
        if (t.getId() != 0) {
            EntityManagerHelper.getEntityManager().merge(t);

        } else {
            EntityManagerHelper.getEntityManager().persist(t);

        }
        EntityManagerHelper.commit();
        return t;

    }

    public void delete(long id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();        
    }



	public List<ListTache> getAll4User(Utilisateur u) {
        
        String s = "select lt from ListTache as lt "
                + "where lt.owner = :user";

        return EntityManagerHelper.getEntityManager().createQuery(s,ListTache.class).setParameter("user", u)
                .getResultList();

        
	}

	public List<ListTache> findAll() {
		String s = "select lt from ListTache as lt";

        return EntityManagerHelper.getEntityManager().createQuery(s,ListTache.class)
                .getResultList();
	}

}