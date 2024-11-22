package sotsuken.api.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sotsuken.api.model.StudentClass;
import sotsuken.api.repository.StudentClassRepository;
import sotsuken.api.teacher.controller.StudentClassResponse;

@Service
public class FetchAllClassesForRegistrationUseCase {
    
    @Autowired
    StudentClassRepository studentClassRepository;
    
    public List<StudentClassResponse> handle() {
        List<StudentClass> classes = studentClassRepository.findAll();
        List<StudentClassResponse> res = new ArrayList<>();

        for (StudentClass clazz: classes) {
            res.add(new StudentClassResponse(clazz.getId(), clazz.getName()));
        }

        return res;
    }
}
