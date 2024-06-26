package com.backend.project.web;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.backend.project.util.shortUrl;
import com.backend.project.util.isSignedIn;
import com.backend.project.domain.Urls;
import com.backend.project.domain.User;
import com.backend.project.domain.UrlsRepository;
import com.backend.project.domain.UserRepository;
import com.backend.project.domain.UsersUrls;
import com.backend.project.domain.UsersUrlsRepository;


@RestController
public class projectController {

  @Autowired
  private UrlsRepository repository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UsersUrlsRepository userUrlsRepository;

  @Autowired
    private BCryptPasswordEncoder passwordEncoder;


  @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }


  //landing page 
  @GetMapping("/index")
    public  ModelAndView addUrl() {
      boolean isSingedIn_ = isSignedIn.isUserLoggedIn();
      
      ModelAndView indexView = new ModelAndView("index");
      indexView.addObject("isSignedIn", isSingedIn_);

      return indexView;
    }
    

    //create new shortened url 
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView newUrl(@RequestParam("url") String url, Model model) {
      model.addAttribute("url", url);
      
      String[] data_shortUrl;
      String domain;

      // custom function returns the short URL
      try {
        data_shortUrl = shortUrl.getShortUrl();
        domain = (url.split("//")[1]).split("/")[0];
      }catch(Exception e){
        //return "Please provide full url";  // There would need to be page for this 
        return new ModelAndView("index");
      }
        
        Urls newUrl = new Urls(domain,url,data_shortUrl[0],data_shortUrl[1]);
        repository.save(newUrl);

        // If user is signed in the created url will be associated with his account 
        boolean isSingedIn_ = isSignedIn.isUserLoggedIn();
        if(isSingedIn_ == true) {
          Long urlId = newUrl.getId();
          long userId = userRepository.findByUsername(isSignedIn.getCurrentUsername()).getId();
          
          userUrlsRepository.save(new UsersUrls(userId,urlId));
        }


        ModelAndView indexView = new ModelAndView("index");
        indexView.addObject("isSignedIn", isSingedIn_);
        indexView.addObject("newUrl", data_shortUrl[0]);
  
        return indexView;
        //return data_shortUrl[0];

    } 


    //Page where users can manage their short urls 
    @GetMapping("/user")
    public  ModelAndView userPage() {
      boolean isSingedIn_ = isSignedIn.isUserLoggedIn();
      
      if(isSingedIn_ == true){

        long userId = userRepository.findByUsername(isSignedIn.getCurrentUsername()).getId();
        List<UsersUrls> userUrlsList = userUrlsRepository.findByUserId(userId);

        List<Long> urlIds = userUrlsList.stream()
                                .map(UsersUrls::getUrlId)
                                .collect(Collectors.toList());
        Iterable<Urls> urls = repository.findByIdIn(urlIds);
        

        ModelAndView userView = new ModelAndView("userPage");
        userView.addObject("list_of_books", urls);
        userView.addObject("isSignedIn", isSingedIn_);
        
        return userView;

      }else{

        // for now - need to add a fail screen
        ModelAndView userView = new ModelAndView("userPage");
        userView.addObject("isSignedIn", isSingedIn_);
  
        return userView;
      }
    }


  @GetMapping("/")
  RedirectView catch_() {
    return new RedirectView("/index");
  }
 

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public RedirectView deleteStudent(@PathVariable("id") Long id, Model model) {
    	repository.deleteById(id);

      return new RedirectView("/user");
    }


  // catching all of the requests to non-existent endpoints and if such shorturl exists redirecting users to their destinations
  @GetMapping("/{shorturl}")
  public RedirectView handleCommand(@PathVariable("shorturl") String shorturl,
                              @RequestParam Map<String, String> params) {
      System.out.println(shorturl);
      List<Urls> urls = repository.findByShortUrlCode(shorturl);
      if (!urls.isEmpty()) {
          Urls url = urls.get(0); 
          return new RedirectView(url.getOriginalUrl());
      } else {
        return new RedirectView("/index");
      }
  }


  @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    cookie.setMaxAge(0);
                    cookie.setPath(request.getContextPath()); 
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        return new RedirectView("/index"); 
    }


    @PostMapping("/signup")
    public RedirectView signup(@RequestParam String username, @RequestParam String password) {
     
      // There should be a check if user exists 
      User newUser = new User();
      newUser.setUsername(username);

      newUser.setPassword(passwordEncoder.encode(password));
      newUser.setRole("user");
      userRepository.save(newUser);

      return new RedirectView("/login");                                                   
    }


    @GetMapping("/signup")
    public  ModelAndView signup() {
      ModelAndView indexView = new ModelAndView("signup");
      return indexView;
    }
}


