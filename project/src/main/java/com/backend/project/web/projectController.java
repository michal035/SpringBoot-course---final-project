package com.backend.project.web;

import java.util.Map;
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
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import com.backend.project.util.shortUrl;
import com.backend.project.domain.Urls;
import com.backend.project.domain.UrlsRepository;



@RestController
public class projectController {


  @Autowired
  private UrlsRepository repository;


  @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }


  @GetMapping("/add")
    public ModelAndView addUrl() {
        return new ModelAndView("addUrl");
    }
    

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public String newBook(@RequestParam("url") String url, Model model) {
      model.addAttribute("url", url);
      
      String shortUrl_;
      String domain;

      try {
        shortUrl_ = shortUrl.getShortUrl();
        domain = (url.split("//")[1]).split("/")[0];
      }catch(Exception e){
        return "Please provide full url";
      }
        
        Urls newUrl = new Urls(domain,url,shortUrl_);
        repository.save(newUrl);

        return shortUrl_;

    } 



  @GetMapping("/")
  String test() {
    return "test";
  }

  @GetMapping("/test")
  String test2() {
    return "test";
  }


  @GetMapping("/{shorturl}")
  public RedirectView handleCommand(@PathVariable("shorturl") String shorturl,
                              @RequestParam Map<String, String> params) {
  
      //return "Endpoint: " + shorturl;
      return new RedirectView("http://www.google.com");
  }

}

