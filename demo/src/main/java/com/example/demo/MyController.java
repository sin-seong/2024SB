package com.example.demo;

import com.example.demo.dao.ISimpleBbsDao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.Writer;

@Controller
public class MyController {

    @Autowired
    ISimpleBbsDao dao;

    @GetMapping("/")
    public String root() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", dao.listDao());
        return "list";

    }

    @GetMapping("/view")
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
        model.addAttribute("dto", dao.viewDao(sId));
        return "view";
    }

    @GetMapping("/writeForm")
    public String writeForm() {
        return "writeForm";
    }

    @PostMapping("/write")
    public String write(HttpServletRequest request) {
        dao.writeDao(request.getParameter("writer"),
                request.getParameter("title"),
                request.getParameter("content"));

        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        dao.deleteDao(request.getParameter("id"));
        return "redirect:/list";
    }

    @GetMapping("/writeForm2")
    public String writeForm2(String id, Model model) {
        model.addAttribute("dto", dao.viewDao(id));
        return "writeForm2";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest request) {
        dao.updateDao(request.getParameter("writer"),
                request.getParameter("title"),
                request.getParameter("content"),
                request.getParameter("id"));
        return "redirect:/list";
    }
}