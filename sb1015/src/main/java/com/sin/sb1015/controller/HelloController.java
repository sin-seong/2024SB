package com.sin.sb1015.controller;

import com.sin.sb1015.dto.DataObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
public class HelloController {
//    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("msg", "Welcom World Now Name go");
        return "index";
    }
    @PostMapping("/")
    public String helloPost(@RequestParam("text1") String name, Model model) {
        model.addAttribute("value", name);
        model.addAttribute("msg", "유 네임 이즈 :"+ name);
        return "index";
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("msg", "message1 <hr/>message2<br/>message3");
        DataObject obj = new DataObject(123,"lee", "lee@flower");
        model.addAttribute("object",obj);
        return "index";
    }
    @GetMapping("/id/{id}")
    public String index(@PathVariable("id") int id,
                        Model model){
        model.addAttribute("id",id);
        model.addAttribute("check", id>=0);
        model.addAttribute("trueVal","POSITIVE!");
        model.addAttribute("falseVal","NEGATIVE...");
        DataObject obj = new DataObject(123,"lee", "lee@flower");
        model.addAttribute("object",obj);
        return "index";
    }

    @RequestMapping("/month/{month}")
    public ModelAndView index(@PathVariable int month,
                              ModelAndView mav) {
        mav.setViewName("index2");
        int m = Math.abs(month) % 12;
        m = m == 0 ? 12 : m;
        mav.addObject("month",m);
        mav.addObject("check",Math.floor(m/3));
        return mav;
    }

    @GetMapping("/index3")
    public ModelAndView index3(ModelAndView mav) {
        mav.setViewName("index3");
        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(new String[]{"pack","pack@uamada","090-999-9999"});
        data.add(new String[]{"lee","lee@flowe","080-888-8888"});
        data.add(new String[]{"choi","choi@happy","080-888-888"});
        mav.addObject("data",data);
        return mav;
    }
    @GetMapping("/index4")
    public ModelAndView index4(ModelAndView mav) {
        mav.setViewName("index4");
        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(new String[]{"pack","pack@uamada","090-999-9999"});
        data.add(new String[]{"lee","lee@flowe","080-888-8888"});
        data.add(new String[]{"choi","choi@happy","080-888-888"});
        mav.addObject("data",data);
        return mav;
    }
    @RequestMapping("/tax/{tax}")
    public ModelAndView index5(@PathVariable int tax, ModelAndView mav) {
        mav.setViewName("index5");
        mav.addObject("tax",tax);
        return mav;
    }
}
