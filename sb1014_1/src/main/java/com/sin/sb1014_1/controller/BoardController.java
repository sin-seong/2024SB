package com.sin.sb1014_1.controller;

import com.sin.sb1014_1.entity.Board;
import com.sin.sb1014_1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/")
    public String index(){
        return "redirect:/board/openBoardList.do";
    }
    @GetMapping("/board/opdenBoardList.do")
    public String opdenBoardList(Model model) throws Exception{
        List<Board> list = boardRepository.selectBoardList();
        model.addAttribute("list", list);
        return "board/boardlist";
    }
    @RequestMapping("/board/openBoardWrite.do")
    public String openBoardWrite() throws Exception{
        return "/board/boardWrite";
    }

    @RequestMapping("/board/insertBoard.do")
    public String insertBoard(Board board) throws Exception{

        boardRepository.insertBoard(board);
        return "redirect:/board/openBoardList.do";
    }

    @GetMapping("/board/openBoardDetail.do")
    public String openBoardDetail(@RequestParam int boardIdx, Model model) throws Exception{
        Board board = boardRepository.selectBoardDetail(boardIdx);
        model.addAttribute ("board", board);

        return "/board/boardDetail";
    }
    @GetMapping("/board/openBoardView.do")
    public String openBoardView(@RequestParam int boardIdx, Model model) throws Exception{
        Board board = boardRepository.selectBoardDetail(boardIdx);
        model.addAttribute ("board", board);

        return "/board/boardView";
    }

    @RequestMapping("/board/updateBoard.do")
    public String updateBoard(Board board) throws Exception{

        boardRepository.updateBoard(board);
        return "redirect:/board/openBoardList.do";
    }

    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(int boardIdx) throws Exception{
        boardRepository.deleteBoard(boardIdx);
        return "redirect:/board/openBoardList.do";
    }
}
