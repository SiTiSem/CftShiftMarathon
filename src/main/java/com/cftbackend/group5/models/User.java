package com.cftbackend.group5.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Email(message = "Email should be valid")
    private String email;

    @Column(nullable = false, columnDefinition="integer default 0")
    private Integer type=0;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private Set<Emails> emails = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Set<Emails> getEmails() {
        return emails;
    }

    public void setEmails(Set<Emails> emails) {
        this.emails = emails;

        for(Emails b : emails) {
            b.setUser(this);
        }
    }
}
