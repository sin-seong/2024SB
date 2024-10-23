package com.sin.sb1015_2.controller;

import com.sin.sb1015_2.entity.MyData;
import com.sin.sb1015_2.repository.MyDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HeloController {
    final MyDataRepository repository;

    @GetMapping("/")
    public String index(
            @ModelAttribute("FormModel") MyData myData, Model model) {
//        model.addAttribute("msg", "this is sample content.");
        List<MyData> list = repository.findAll();
        model.addAttribute("datalist", list);
        return "index";
    }

    @PostMapping("/")
    public String form(MyData myData) {
        repository.save(myData);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, @ModelAttribute MyData myData, Model model) {
        Optional<MyData> myData1 = repository.findById(id);
        model.addAttribute("FormModel", myData1.get());
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute MyData myData) {
        repository.save(myData);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, @ModelAttribute MyData myData, Model model) {
        Optional<MyData> myData2 = repository.findById(id);
        model.addAttribute("FormModel", myData2.get());
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute MyData myData) {
        repository.delete(myData);
        return "redirect:/";
    }
}
