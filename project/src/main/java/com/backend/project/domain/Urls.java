package com.backend.project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "urls", indexes = {@Index(name = "domain_index", columnList = "domain")})
public class Urls {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String originalUrl;
    private String domain;
    private String shortUrl;
    private String shortUrlCode;

    public Urls(){}

    public Urls(String domain, String originalUrl, String shortUrl, String shortUrlCode){
        this.originalUrl = originalUrl;
        this.domain = domain;
        this.shortUrl = shortUrl;
        this.shortUrlCode = shortUrlCode;
    }

    public void setShortUrlCode(String code){
        this.shortUrlCode = code;
    }

    public String getShortUrlCode(){
        return this.shortUrlCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}