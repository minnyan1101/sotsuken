package sotsuken.api.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/auth")
public class UserInfoController {

    @GetMapping("/userinfo")
    public UserInfoResponse fetchUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        return new UserInfoResponse(
            userDetails.getUsername()
        );
    }
    
    public record UserInfoResponse(
        String id
    ) {
    }
}
