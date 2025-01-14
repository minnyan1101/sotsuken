package sotsuken.api.teacher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sotsuken.api.model.Teacher;
import sotsuken.api.repository.TeacherRepository;
import sotsuken.api.teacher.controller.TeacherResponse;



@Service
public class FetchAllTeachersUseCase {

    @Autowired
    TeacherRepository teacherRepository;

    public List<TeacherResponse> handle() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherResponse> res = new ArrayList<>();
        for (Teacher teacher: teachers) {
            res.add(new TeacherResponse(teacher.getId(), teacher.getName()));
        }

        return res;
    }
}
