package sotsuken.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    private String userName;
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    public Account() {
    }
    public Account(String userName, String passwordHash, AccountType accountType) {
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.accountType = accountType;
    }
    public String getUserName() {
        return userName;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public AccountType getAccountType() {
        return accountType;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public boolean isStudent() {
        return this.accountType.equals(AccountType.STUDENT);
    }

    public boolean isTeacher() {
        return this.accountType.equals(AccountType.TEACHER);
    }
    
}
