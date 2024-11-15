package sotsuken.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Class studentClass;

    public Student(Long id, String name, Class studentClass) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Class getStudentClass() {
        return studentClass;
    }
}
