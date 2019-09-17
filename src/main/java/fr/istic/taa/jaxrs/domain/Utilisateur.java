package fr.istic.taa.jaxrs.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name="tousleusesbyfirstname",
    query = "select u from Utilisateur as u where u.firstname=:fistname")
})
public class Utilisateur{


    
    String email;
    String name;
    String firstname;

    List<ListTache> listesTaches;


    @OneToMany(mappedBy = "owner")
    public List<ListTache> getListesTaches() {
        return this.listesTaches;
    }

    public void setListesTaches(List<ListTache> listesTaches) {
        this.listesTaches = listesTaches;
    }


    public Utilisateur() {
    }


    
    @Id
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Utilisateur email(String email) {
        this.email = email;
        return this;
    }

    public Utilisateur name(String name) {
        this.name = name;
        return this;
    }

    public Utilisateur firstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Utilisateur)) {
            return false;
        }
        Utilisateur Utilisateur = (Utilisateur) o;
        return Objects.equals(email, Utilisateur.email) && Objects.equals(name, Utilisateur.name) && Objects.equals(firstname, Utilisateur.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, firstname);
    }

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", name='" + getName() + "'" +
            ", firstname='" + getFirstname() + "'" +
            "}";
    }

}