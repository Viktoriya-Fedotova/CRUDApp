package main.java.com.viktoriya_fedotova;

import java.io.Serializable;
import java.util.Objects;

public class Label implements Serializable {

    private Long id;
    private String name;
    String fullName;

    protected Label(Long id, String name) {
        this.id = id;
        this.name = name;
        this.fullName = id + ". " + name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ". " + name + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(id, label.id) &&
                Objects.equals(name, label.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
