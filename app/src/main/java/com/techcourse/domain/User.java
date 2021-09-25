package com.techcourse.domain;

import com.techcourse.exception.UnauthorizedException;
import java.util.Objects;

public class User {

    private Long id;
    private String account;
    private String password;
    private String email;

    public User(String account, String password, String email) {
        this(null, account, password, email);
    }

    public User(Long id, String account, String password, String email) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
    }

    public static User generateId(Long id, User user) {
        return new User(id, user.account, user.password, user.email);
    }

    public void checkPassword(String password) {
        if (!this.password.equals(password)) {
            throw new UnauthorizedException();
        }
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
