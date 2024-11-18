package sotsuken.api.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth/")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    SecurityContextRepository securityContextRepository;

    @PostMapping("/login")
    public LoginResponse login(
            @AuthenticationPrincipal UserDetails userDetails,
            HttpSession session,
            @RequestBody LoginRequest loginRequest,
            HttpServletRequest request,
            HttpServletResponse response) {
        
        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.id(), loginRequest.password());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        securityContextRepository.saveContext(context, request, response);

        return new LoginResponse(session.getId());
    }

    public record LoginRequest(
            String id,
            String password) {
    }

    public record LoginResponse(
            String token) {
    }
}
