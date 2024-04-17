package com.backend.project.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "Users_urls")
public class UsersUrls {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private long userId;

    private long urlId;

    public UsersUrls(){}

    public UsersUrls(long userId, long urlId) {
        this.userId = userId;
        this.urlId = urlId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUrlId() {
        return urlId;
    }

    public void setUrlId(long urlId) {
        this.urlId = urlId;
    }

    

}
