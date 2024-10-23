//package com.sin.sb1018.controller;
//
//import com.sin.sb1018.entity.Dept;
//import com.sin.sb1018.service.EmpService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class TestController {
//
////    @Autowired
//    final EmpService empService;
//
//    @GetMapping("/{deptno}/{dname}")
//    public Dept index(@PathVariable int deptno, @PathVariable String dname) {
//        return empService.updateDept(deptno, dname);
//    }
//
//    @GetMapping("/list")
//    public List<Dept> list() {
//        return empService.list();
//    }
//
//    @GetMapping("/insert/{deptno}/{dname}/{loc}")
//    public String insert(@PathVariable int deptno, @PathVariable String dname, @PathVariable String loc) {
//        return empService.insert(deptno, dname, loc);
//    }
//
//    @GetMapping("/delete/{deptno}")
//    public Dept delete(@PathVariable int deptno) {
//         return empService.delete(deptno);
//
//    }
//}
