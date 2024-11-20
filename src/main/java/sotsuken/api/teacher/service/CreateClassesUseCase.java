package sotsuken.api.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sotsuken.api.model.StudentClass;
import sotsuken.api.repository.StudentClassRepository;
import sotsuken.api.teacher.controller.StudentClassResponse;

@Service
public class CreateClassesUseCase {

    @Autowired
    StudentClassRepository studentClassRepository;
    
    public StudentClassResponse handle(String user_id, String className) {
        StudentClass newClass = new StudentClass(null, className);
        StudentClass savedClass = studentClassRepository.save(newClass);

        return new StudentClassResponse(savedClass.getId(), savedClass.getName());
    }
}
