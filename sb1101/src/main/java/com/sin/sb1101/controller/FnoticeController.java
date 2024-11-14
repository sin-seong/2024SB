package com.sin.sb1101.controller;

import com.sin.sb1101.dto.Comment;
import com.sin.sb1101.dto.Fnotice;
import com.sin.sb1101.dto.Sign;
import com.sin.sb1101.repository.FnoticeRepository;
import com.sin.sb1101.repository.SignRepository;
import com.sin.sb1101.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class FnoticeController {

    @Autowired
    private FnoticeRepository fnoticeRepository;

    @Autowired
    private SignRepository signRepository;
    @Autowired
    private CommentService commentService;

    @GetMapping("/fnotice")
    public String fnoticeList(Model model, HttpSession session) {
        List<Fnotice> fnoticeList = fnoticeRepository.findAll();  // 게시글 목록을 가져옴
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = date.format(formatter);
        model.addAttribute("formattedDate", formattedDate);
        model.addAttribute("fnotice", fnoticeList);
        return "view/fnoticeList";
    }

    @GetMapping("/fnoticewrite")
    public String fnoticewrite() {
        return "view/fnoticeWrite";
    }
    @PostMapping("/fnInsert")
    public String fnInsert(@ModelAttribute Fnotice fnotice,
                           HttpSession session, RedirectAttributes redirectAttributes) {
        Sign user = (Sign) session.getAttribute("user");

        if(user == null) {
            redirectAttributes.addFlashAttribute("loginMessage", "로그인이 필요합니다. 로그인 후 다시 시도해주세요.");
            return "redirect:/login";
        }


        fnotice.setUsername(user.getUsername());  // 로그인된 유저네임을 작성자로 설정
        fnotice.setHitCnt(0);  // 초기 조회수 0으로 설정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm");
        String formattedDate = LocalDateTime.now().format(formatter);
        fnotice.setDate(LocalDateTime.parse(formattedDate, formatter));

        // 게시글 저장
        fnoticeRepository.save(fnotice);

        return "redirect:fnotice";

    }
    @GetMapping("/fnotice/{id}")
    public String fnoticeDetail(@PathVariable("id") Long id, Model model, HttpSession session) {
        Fnotice fnotice = fnoticeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id"));
        fnotice.setHitCnt(fnotice.getHitCnt() + 1);
        fnoticeRepository.save(fnotice);
        Sign user = (Sign) session.getAttribute("user");

        if(user != null) {
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());
        }
// 세션 값 확인하기 (컨트롤러에서)
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");



        model.addAttribute("fnotice", fnotice);
        model.addAttribute("username", username);
        model.addAttribute("role", role);
        return "view/fnoticeDetail";
    }
    @PostMapping("/fnotice/{id}/comment")
    public String addComent(@PathVariable Long id, @RequestParam String content,
                            HttpSession session){

        String username = (String) session.getAttribute("username");

        // 로그인하지 않은 경우 처리
        if (username == null) {
            return "redirect:/login";  // 로그인 페이지로 리다이렉트
        }
        Fnotice fnotice = fnoticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        Comment comment = new Comment();
        comment.setFnotice(fnotice);
        comment.setContent(content);
        comment.setUsername(username);
        comment.setCreatedAt(LocalDateTime.now());

        commentService.addComment(comment);
        return "redirect:/fnotice/" + id;
    }
}
