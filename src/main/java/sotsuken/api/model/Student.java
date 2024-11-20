package sotsuken.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class studentClass;

    public Student() {
    }

    public Student(String id, String name, Class studentClass) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Class getStudentClass() {
        return studentClass;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changeClass(Class newClass) {
        this.studentClass = newClass;
    }

    public String getClassName() {
        return this.studentClass.getName();
    }

    public Long getClassId() {
        return this.studentClass.getId();
    }
}
