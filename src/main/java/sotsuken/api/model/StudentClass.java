package sotsuken.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import sotsuken.api.model.exception.ClassNameValidationException;

@Entity
@Table(name = "classes")
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public StudentClass() {
    }

    public StudentClass(Long id, String name) {
        classNameValidation(name);
        this.id = id;
        this.name = name;
    }

    private static void classNameValidation(String name) {
        //  nameは1~16文字
        if ( ! (1 <= name.length() && name.length() <= 16)) {
            throw new ClassNameValidationException();
        }

        // nameは一行からなる
        if ( ! (name.matches(".*\\v.*"))) { // 改行に類する空白文字が文字列に含まれているか確認している
            throw new ClassNameValidationException();
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        classNameValidation(newName);
        this.name = newName;
    }
}
