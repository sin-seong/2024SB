package com.sin.sb1029.controller;

import com.sin.sb1029.entity.Notice;
import com.sin.sb1029.service.NoticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
//@RequestMapping("/board")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/")
    public String index() {
        return "redirect:/board/openBoardList.do";
    }

    @GetMapping("/board/openBoardList.do")
    public String openBoardList(Model model,@PageableDefault(page = 0,size=7)Pageable pageable) throws  Exception {
        Page<Notice> boardPage = noticeService.findAllBoards(pageable);
//        final int start = (int) pageable.getOffset();
//        final int end = Math.min((start + pageable.getPageSize()), boardPage.size());
//        final Page<Notice> page = new PageImpl<>(boardPage.subList(start, end), pageable,boardPage.size());
        model.addAttribute("list", boardPage);


        return "board/boardList";
    }
    @RequestMapping("/board/openBoardWrite.do")
    public String openBoardWrite() throws Exception{
        return "board/boardWrite";
    }
    @PostMapping("/board/insertBoard.do")
    public String insertBoard(@ModelAttribute Notice notice) throws Exception {
        noticeService.save(notice); // 저장 로직 호출
        return "redirect:/board/openBoardList.do";
    }

    @GetMapping("/board/openBoardDetail.do")
    public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {
        ModelAndView mv = new ModelAndView("board/boardDetail");
        Notice notice = noticeService.findById(boardIdx); // ID로 공지사항 조회
        mv.addObject("board", notice);
        return mv;
    }

    @PostMapping("/board/updateBoard.do")
    public String updateBoard(@ModelAttribute Notice notice) throws Exception {
        noticeService.update(notice); // 업데이트 메서드 호출
        return "redirect:/board/openBoardList.do";
    }

    @PostMapping("/board/deleteBoard.do")
    public String deleteBoard(@RequestParam int boardIdx) throws Exception {
        noticeService.delete(boardIdx); // 삭제 메서드 호출
        return "redirect:/board/openBoardList.do";
    }
}
