// package com.backend.project;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import java.util.Optional;
// import java.util.stream.Collectors;
// import java.util.List;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.backend.project.domain.Urls;
// import com.backend.project.domain.User;
// import com.backend.project.domain.UrlsRepository;
// import com.backend.project.domain.UserRepository;
// import com.backend.project.domain.UsersUrls;
// import com.backend.project.domain.UsersUrlsRepository;
// import com.backend.project.util.shortUrl;


// @SpringBootTest
// public class RepositoryTests {

//     @Autowired
//     private UrlsRepository repository;
  
//     @Autowired
//     private UserRepository userRepository;
  
//     @Autowired
//     private UsersUrlsRepository userUrlsRepository;
    
    
//     @Test
//     public void createAndRemoveUrl() {

//         String url = "https://twitter.com/home";
//         String[] dataShortUrl = shortUrl.getShortUrl();
//         String domain = (url.split("//")[1]).split("/")[0];

//         Urls testUrl = new Urls(domain,url,dataShortUrl[0],dataShortUrl[1]);
//         repository.save(testUrl);
//         repository.deleteById(testUrl.getId());

//     }




//     @Test
//     public void getUserUrls() {

//         long userId = 1;
//         List<UsersUrls> userUrlsList = userUrlsRepository.findByUserId(userId);

//         List<Long> urlIds = userUrlsList.stream()
//                                 .map(UsersUrls::getUrlId)
//                                 .collect(Collectors.toList());
//         Iterable<Urls> urls = repository.findByIdIn(urlIds);

//     }


// }
