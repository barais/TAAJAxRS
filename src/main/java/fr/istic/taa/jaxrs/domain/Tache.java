package fr.istic.taa.jaxrs.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Tache{


    long id;
    String intitule;
    boolean done;
    Date dateEcheance;
    Date dateCreation;
    Date dateRealise;

    public Tache() {
    }

    public Tache(long id, String intitule, boolean done, Date dateEcheance, Date dateCreation, Date dateRealise) {
        this.id = id;
        this.intitule = intitule;
        this.done = done;
        this.dateEcheance = dateEcheance;
        this.dateCreation = dateCreation;
        this.dateRealise = dateRealise;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIntitule() {
        return this.intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public boolean isDone() {
        return this.done;
    }

    @Transient
    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateEcheance() {
        return this.dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateRealise() {
        return this.dateRealise;
    }

    public void setDateRealise(Date dateRealise) {
        this.dateRealise = dateRealise;
    }

    public Tache id(long id) {
        this.id = id;
        return this;
    }

    public Tache intitule(String intitule) {
        this.intitule = intitule;
        return this;
    }

    public Tache done(boolean done) {
        this.done = done;
        return this;
    }

    public Tache dateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
        return this;
    }

    public Tache dateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    public Tache dateRealise(Date dateRealise) {
        this.dateRealise = dateRealise;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tache)) {
            return false;
        }
        Tache tache = (Tache) o;
        return id == tache.id && Objects.equals(intitule, tache.intitule) && done == tache.done && Objects.equals(dateEcheance, tache.dateEcheance) && Objects.equals(dateCreation, tache.dateCreation) && Objects.equals(dateRealise, tache.dateRealise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, intitule, done, dateEcheance, dateCreation, dateRealise);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", intitule='" + getIntitule() + "'" +
            ", done='" + isDone() + "'" +
            ", dateEcheance='" + getDateEcheance() + "'" +
            ", dateCreation='" + getDateCreation() + "'" +
            ", dateRealise='" + getDateRealise() + "'" +
            "}";
    }
    


}