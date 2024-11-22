package sotsuken.api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sotsuken.api.model.Account;
import sotsuken.api.repository.AccountRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("username Not Found"));
        return accountToUser(account);
    }

    private UserDetails accountToUser(Account account) {
        return User.builder()
            .username(account.getUserName())
            .password(account.getPasswordHash())
            .roles(account.getAccountType().name())
            .build();
    }

}