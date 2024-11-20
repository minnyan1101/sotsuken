package sotsuken.api.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import sotsuken.api.model.StudentClass;
import sotsuken.api.repository.StudentClassRepository;
import sotsuken.api.teacher.controller.StudentClassResponse;

@Service
public class EditClassesUseCase {
    
    @Autowired
    StudentClassRepository studentClassRepository;

    public StudentClassResponse handle(String userId, Long classId, String className) {
        StudentClass editClass = studentClassRepository.findById(classId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        editClass.changeName(className);

        StudentClass savedClass = studentClassRepository.save(editClass);

        return new StudentClassResponse(savedClass.getId(), savedClass.getName());
    }
}
