package sotsuken.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Class {
    @Id
    private Long id;
    private String name;

    public Class(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
