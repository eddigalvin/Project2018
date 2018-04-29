package com.example.shop.product;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class HomeController {

   // @RequestMapping("/")
   // public String index(){
    //    return "Hello World!";
  //  }
//}
//@RestController
	@RequestMapping("/")
public ModelAndView/*String*/ index () {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
    // return "index";
}
}