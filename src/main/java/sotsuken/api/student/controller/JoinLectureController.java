package sotsuken.api.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sotsuken.api.student.service.JoinLectureUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/student/join")
public class JoinLectureController {

    @Autowired
    JoinLectureUseCase joinLectureUseCase;

    @PostMapping("")
    public JoinStatusResponse joinLecture(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody JoinLectureRequest request) {
        
        
        return joinLectureUseCase.handle(userDetails.getUsername(), request.subjectId, request.lectureId, request.joinCode);
    }

}
