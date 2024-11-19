package sotsuken.api.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sotsuken.api.model.Class;
import sotsuken.api.repository.ClassRepository;
import sotsuken.api.teacher.controller.ClassResponse;

@Service
public class CreateClassesUseCase {

    @Autowired
    ClassRepository classRepository;
    
    public ClassResponse handle(String user_id, String className) {
        Class newClass = new Class(null, className);
        Class savedClass = classRepository.save(newClass);

        return new ClassResponse(savedClass.getId(), savedClass.getName());
    }
}
