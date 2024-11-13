package sotsuken.api.teacher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/students/join")
public class JoinLectureController {

    @PostMapping("")
    public JoinStatusResponse joinLecture(@RequestBody JoinLectureRequest request) {
        //TODO: process POST request
        
        return new JoinStatusResponse(request.subjectId, request.lectureId, "success");
    }
    
}


