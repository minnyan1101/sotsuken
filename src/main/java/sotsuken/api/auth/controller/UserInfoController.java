package sotsuken.api.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Auth API")
public class UserInfoController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/userinfo")
    @Operation(summary = "認証したアカウントの名前と権限を取得")
    public UserInfoResponse fetchUserInfo(@AuthenticationPrincipal UserDetails userDetails) {

        Account account = accountRepository.findById(userDetails.getUsername())
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        return new UserInfoResponse(
                userDetails.getUsername(),
                account.getAccountType());
    }

    public record UserInfoResponse(
            String id,
            AccountType role) {
    }
}
