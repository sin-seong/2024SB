package com.sin.sb1018.controller;

import com.sin.sb1018.entity.Dept;
import com.sin.sb1018.entity.Emp;
import com.sin.sb1018.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {

    final EmpService empService;

    @GetMapping("/")
    public String index() {
        return "redirect:/list";
    }

//    @GetMapping("/{deptno}/{dname}")
//    public Dept index(@PathVariable int deptno, @PathVariable String dname) {
//        return empService.updateDept(deptno, dname);
//    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Dept> departments = empService.list();
        model.addAttribute("departments", departments);
        return "departments" ;
    }

    @PostMapping("/departments/add")
    public String insert(@RequestParam int deptno, @RequestParam String dname, @RequestParam String loc) {
        empService.insert(deptno, dname, loc);
        return "redirect:/list";
    }

    @GetMapping("/delete/{deptno}")
    public String delete(@PathVariable int deptno) {
        empService.delete(deptno);
    return "redirect:/list";
    }
    @GetMapping("/departments/add")
    public String showAddDeptPage() {
        return "dpetWrite";
    }
    @GetMapping("/emplist/{deptno}")
    public String empSelect(@PathVariable int deptno, Model model) {
        model.addAttribute("deptno", deptno);
        List<Emp> empList = empService.empSelect(deptno);
        if (empList.isEmpty()) {
            model.addAttribute("message", "해당 부서에 직원이 없습니다.");
        }

        model.addAttribute("empList", empList);
        return "emplist";
    }

}
