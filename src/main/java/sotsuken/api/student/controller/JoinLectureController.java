package sotsuken.api.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import sotsuken.api.student.service.JoinLectureUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/student/join")
@Tag(name = "Student API")
public class JoinLectureController {

    @Autowired
    JoinLectureUseCase joinLectureUseCase;

    @PostMapping("")
    @Operation(summary = "学生が講義に参加", description = "学生が読み取った授業ID、講義IDとjoinCodeを利用して講義に参加します。")
    public JoinStatusResponse joinLecture(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody JoinLectureRequest request) {
        
        
        return joinLectureUseCase.handle(userDetails.getUsername(), request.subjectId, request.lectureId, request.joinCode);
    }

}
