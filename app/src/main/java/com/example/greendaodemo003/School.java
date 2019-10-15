package com.example.greendaodemo003;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class School {
    @Id
    private Long id;
    private String name;
    @Generated(hash = 2095953704)
    public School(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1579966795)
    public School() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
