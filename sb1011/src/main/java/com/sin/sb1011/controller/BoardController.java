package com.sin.sb1011.controller;


import com.sin.sb1011.dto.BoardDto;
import com.sin.sb1011.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;


	@GetMapping("/")
	public String index() {
		return "redirect:/board/openBoardList.do";
	}

	@PostMapping("/board/saveBoard.do")
	public String saveBoard(@RequestParam("title") String title,
							@RequestParam("contents") String contents,
							@RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
							@RequestParam(value = "boardIdx", required = false) Long boardIdx,
			Model model) throws Exception {
		String imagePath = null;
		if (imageFile != null && !imageFile.isEmpty()) {
			String originalFilename = imageFile.getOriginalFilename();
			String newFilename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + originalFilename;

			String uploadDir = "src/main/resources/static/uploads";
			File dir = new File(uploadDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			imageFile.transferTo(new File(uploadDir + newFilename));
			imagePath = "/uploads/" + newFilename;
		}
		BoardDto board = new BoardDto();
		board.setTitle(title);
		board.setContents(contents);
		board.setImagePath(imagePath);

		if (boardIdx == null) {
			boardService.insertBoard(board);
		}else{
			board.setBoardIdx(boardIdx);;
			boardService.updateBoard(board);
		}

		return "redirect:/board/openBoardList.do";
	}


	@GetMapping("/board/openBoardList.do")
	public String openBoardList(Model model)  throws Exception{

		List<BoardDto> list = boardService.selectBoardList();
		model.addAttribute("list", list);
		return "/board/BoardList";
	}
	
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception{
		return "/board/boardWrite";
	}
	
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception{

		boardService.insertBoard(board);
		return "redirect:/board/openBoardList.do";
	}

	@GetMapping("/board/openBoardDetail.do")
	public String openBoardDetail(@RequestParam int boardIdx, Model model) throws Exception{
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		model.addAttribute ("board", board);
		
		return "/board/boardDetail";
	}
	@GetMapping("/board/openBoardView.do")
	public String openBoardView(@RequestParam int boardIdx, Model model) throws Exception{
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		model.addAttribute ("board", board);

		return "/board/boardView";
	}

	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDto board) throws Exception{

		boardService.updateBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/openBoardList.do";
	}
}
