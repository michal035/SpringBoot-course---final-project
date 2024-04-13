package com.backend.project.domain;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.backend.project.domain.Urls;
import java.util.List;
import java.util.Optional;

@Repository
public interface UrlsRepository extends CrudRepository<Urls, Long>{
    List<Urls> findByShortUrlCode(String originalUrl);
}
