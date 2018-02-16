package edu.nju.ise.model;

/**
 * @author Hermit
 * @version 1.0 2018/02/14
 * */
public class Department {

    private Long id;
    private String name;

    public Department() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
