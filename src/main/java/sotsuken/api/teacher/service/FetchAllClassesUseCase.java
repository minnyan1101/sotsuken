package sotsuken.api.teacher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sotsuken.api.model.Class;
import sotsuken.api.repository.ClassRepository;
import sotsuken.api.teacher.controller.ClassResponse;

@Service
public class FetchAllClassesUseCase {
    
    @Autowired
    ClassRepository classRepository;

    public List<ClassResponse> handle(String userId) {
        List<Class> classes = classRepository.findAll();

        List<ClassResponse> res = new ArrayList<>();
        for (Class clazz: classes) {
            res.add(new ClassResponse(clazz.getId(), clazz.getName()));
        }
        return res;
    }
}
