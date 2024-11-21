package sotsuken.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import sotsuken.api.model.exception.TeacherIdValidationException;
import sotsuken.api.model.exception.TeacherNameValidationException;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    private String id;
    private String name;

    public Teacher() {
    }

    public Teacher(String id, String name) {
        idValidation(id);
        nameValidation(name);
        this.id = id;
        this.name = name;
    }

    private static void idValidation(String id) {
        // idは2~32文字であること
        if ( ! (2 <= id.length() && id.length() <= 32)) {
            throw new TeacherIdValidationException();
        }

        // idの頭文字がS（大文字）である
        if ( ! id.startsWith("S")) {
            throw new TeacherIdValidationException();
        }

        // idの頭文字以降は数字のみで構成される
        if ( ! id.matches("^S[0-9]+$")) {
            throw new TeacherIdValidationException();
        }
    }

    private static void nameValidation(String name) {
        //  nameは1~16文字
        if ( ! (1 <= name.length() && name.length() <= 16)) {
            throw new TeacherNameValidationException();
        }

        // nameは一行からなる
        if ( ! (name.matches(".*\\v.*"))) { // 改行に類する空白文字が文字例に含まれているか確認している
            throw new TeacherNameValidationException();
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        nameValidation(newName);
        this.name = newName;
    }
}
