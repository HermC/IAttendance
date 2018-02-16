package edu.nju.ise.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private static final long serialVersionID = 1L;

    private Long id;
    private String authority;
    private String authorityName;

    public Authority() {}

    public Authority(Long id, String authority, String authorityName) {
        this.id = id;
        this.authority = authority;
        this.authorityName = authorityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
}
