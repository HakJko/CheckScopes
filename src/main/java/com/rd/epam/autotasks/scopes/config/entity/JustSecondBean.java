package com.rd.epam.autotasks.scopes.config.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;

@Component
public class JustSecondBean {

    private int id;

    public JustSecondBean(int id) {
        this.id = id;
    }

    @PostConstruct
    public void init() {

    }

    @PreDestroy
    public static void destroy() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JustSecondBean that = (JustSecondBean) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "[obj " + id + ']';
    }
}
