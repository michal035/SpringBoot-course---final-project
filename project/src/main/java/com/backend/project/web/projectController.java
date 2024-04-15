package com.backend.project.web;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Optional;
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


  @GetMapping("/index")
    public ModelAndView addUrl() {
        return new ModelAndView("index");
    }
    

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public String newBook(@RequestParam("url") String url, Model model) {
      model.addAttribute("url", url);
      
      String[] data_shortUrl;
      String domain;

      try {
        data_shortUrl = shortUrl.getShortUrl();
        domain = (url.split("//")[1]).split("/")[0];
      }catch(Exception e){
        return "Please provide full url";
      }
        
        Urls newUrl = new Urls(domain,url,data_shortUrl[0],data_shortUrl[1]);
        repository.save(newUrl);

        return data_shortUrl[0];

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

      System.out.println(shorturl);
      List<Urls> urls = repository.findByShortUrlCode(shorturl);
      if (!urls.isEmpty()) {
          Urls url = urls.get(0); 
          return new RedirectView(url.getOriginalUrl());
      } else {
        return new RedirectView("http://localhost:8080/login");
      }
  }
}


