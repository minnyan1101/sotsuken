package sotsuken.api.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sotsuken.api.auth.AccountUserDetails;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/auth")
public class UserInfoController {

    @GetMapping("/api/auth/userinfo")
    public UserInfoResponse fetchUserInfo(@AuthenticationPrincipal AccountUserDetails userDetails) {
        return new UserInfoResponse(
            userDetails.getUsername(),
            userDetails.accountRole()
        );
    }
    
    public record UserInfoResponse(
        String user_id,
        String role
    ) {
    }
}
