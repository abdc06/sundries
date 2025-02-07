package org.epari.demo.common.account.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Data
public class PrincipalDetail implements UserDetails, OAuth2User {

    private Account account;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public PrincipalDetail(Account account, Collection<? extends GrantedAuthority> authorities) {
        this.account = account;
        this.authorities = authorities;
    }

    public PrincipalDetail(Account account, Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes) {
        this.account = account;
        this.authorities = authorities;
        this.attributes = attributes;
    }

    // info 에 들어가는 것들이 토큰에 들어가는 데이터
    public Map<String, Object> getAccountInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("name", account.getName());
        info.put("email", account.getEmail());
        info.put("role", account.getRole());
        return info;
    }

    @Override
    public String getName() {
        return account.getEmail();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
