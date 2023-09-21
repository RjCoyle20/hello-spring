package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ryan Coyle
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles requests at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye now
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }
    // Handles request of the form /hello?name=LaunchCode
    // lives at hello/hello
  @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

// Handles requests of the form /hello/Launchcode
// lives at /hello/form
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";

    }
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
}


}
