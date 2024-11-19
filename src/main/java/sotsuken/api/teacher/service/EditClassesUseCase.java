package sotsuken.api.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import sotsuken.api.model.Class;
import sotsuken.api.repository.ClassRepository;
import sotsuken.api.teacher.controller.ClassResponse;

@Service
public class EditClassesUseCase {
    
    @Autowired
    ClassRepository classRepository;

    public ClassResponse handle(String userId, Long classId, String className) {
        Class editClass = classRepository.findById(classId).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        editClass.changeName(className);

        Class savedClass = classRepository.save(editClass);

        return new ClassResponse(savedClass.getId(), savedClass.getName());
    }
}
