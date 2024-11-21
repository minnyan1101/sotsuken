package sotsuken.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import sotsuken.api.model.exception.StudentIdValidationExseption;
import sotsuken.api.model.exception.StudentNameValidationException;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private StudentClass studentClass;

    public Student() {
    }

    public Student(String id, String name, StudentClass studentClass) {
        idValidation(id);
        nameValidation(name);
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
    }

    private static void idValidation(String id) {
        // idは2～32文字であること
        if ( ! (2 <= id.length() && id.length() <= 32 )) {
            throw new StudentIdValidationExseption();
        }

        // idの頭文字がS（大文字）である
        if ( ! id.startsWith("S")) {
            throw new StudentIdValidationExseption();
        }

        // idの頭文字以降は数字のみで構成される
        if ( ! id.matches("^S[0-9]+$")) {
            throw new StudentIdValidationExseption();
        }
    }

    private static void nameValidation(String name) {
        // nameは1～16文字
        if ( ! (1 <= name.length() && name.length() <= 16)) {
            throw new StudentNameValidationException();
        }

        // nameは1行からなる
        if ( ! (name.matches(".*\\v.*"))) { // 改行に類する空白文字が文字列に含まれているか確認している
            throw new StudentNameValidationException();
        } 
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void changeName(String newName) {
        nameValidation(newName);
        this.name = newName;
    }

    public void changeClass(StudentClass newClass) {
        this.studentClass = newClass;
    }

    public String getClassName() {
        return this.studentClass.getName();
    }

    public Long getClassId() {
        return this.studentClass.getId();
    }
}
