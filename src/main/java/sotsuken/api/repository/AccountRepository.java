package sotsuken.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sotsuken.api.model.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
    
}
