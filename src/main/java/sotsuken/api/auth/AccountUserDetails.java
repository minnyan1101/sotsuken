package sotsuken.api.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import sotsuken.api.model.Account;

public class AccountUserDetails implements UserDetails {

    private Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    public String accountRole() {
        return "ROLE_" + this.account.getAccountType().name();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        return AuthorityUtils.createAuthorityList(this.accountRole());
    }

    @Override
    public String getPassword() {
        return account.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return account.getUserName();
    }
    
}
