package com.api.doc.easy.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "application")
public class ApplicationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    @Column(name = "name", nullable = false)
    private String name;

    public ApplicationItem() {
    }

    public ApplicationItem(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationItem that = (ApplicationItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ApplicationItem{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}