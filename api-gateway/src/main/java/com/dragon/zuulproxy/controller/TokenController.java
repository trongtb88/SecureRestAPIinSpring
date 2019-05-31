package com.dragon.zuulproxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class TokenController {

	 /**
    *
    * @param token
    * @return boolean.
    * if request reach here it means it is a valid token.
    */
   @PostMapping("/valid/token")
   @ResponseBody
   public Boolean isValidToken (@RequestHeader(value="Authorization") String token) {
       return true;
   }
}
