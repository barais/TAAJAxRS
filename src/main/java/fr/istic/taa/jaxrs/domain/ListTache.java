package fr.istic.taa.jaxrs.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.jdbc.Util;


@Entity
public class ListTache {


    long id;
    String name;
    Date dateCreation;

    Utilisateur owner;
    List<Tache> taches;

    public ListTache(long id, String name, Date dateCreation, Utilisateur owner, List<Tache> taches) {
        this.id = id;
        this.name = name;
        this.dateCreation = dateCreation;
        this.owner = owner;
        this.taches = taches;
    }

    @ManyToOne
    @JsonIgnore
    public Utilisateur getOwner() {
        return this.owner;
    }

    public void setOwner(Utilisateur owner) {
        this.owner = owner;
    }

    @OneToMany
    @JoinColumn(name = "ListTachId")
    public List<Tache> getTaches() {
        return this.taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    public ListTache owner(Utilisateur owner) {
        this.owner = owner;
        return this;
    }

    public ListTache taches(List<Tache> taches) {
        this.taches = taches;
        return this;
    }

    public ListTache() {
    }

    public ListTache(long id, String name, Date dateCreation) {
        this.id = id;
        this.name = name;
        this.dateCreation = dateCreation;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public ListTache id(long id) {
        this.id = id;
        return this;
    }

    public ListTache name(String name) {
        this.name = name;
        return this;
    }

    public ListTache dateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListTache)) {
            return false;
        }
        ListTache listTache = (ListTache) o;
        return id == listTache.id && Objects.equals(name, listTache.name) && Objects.equals(dateCreation, listTache.dateCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateCreation);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", dateCreation='" + getDateCreation() + "'" +
            "}";
    }
}