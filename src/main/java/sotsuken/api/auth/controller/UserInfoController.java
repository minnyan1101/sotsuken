package sotsuken.api.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sotsuken.api.model.Account;
import sotsuken.api.model.AccountType;
import sotsuken.api.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/auth")
public class UserInfoController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/userinfo")
    public UserInfoResponse fetchUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        
        Account account = accountRepository.findById(userDetails.getUsername()).orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));
        
        return new UserInfoResponse(
            userDetails.getUsername(),
            account.getAccountType()
        );
    }
    
    public record UserInfoResponse(
        String id,
        AccountType role
    ) {
    }
}
