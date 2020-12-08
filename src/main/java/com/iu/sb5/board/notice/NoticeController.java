package com.iu.sb5.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb5.board.BoardVO;
import com.iu.sb5.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@PostMapping("noticeWrite")
	public String setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception{
		int result = noticeService.setInsert(boardVO, files);
		return "redirect:./noticeList";
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert()throws Exception{
		ModelAndView mv= new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardVO);
	
		if(result>0) {
			mv.addObject("msg", "삭제 성공");
			mv.addObject("path", "./noticeList");
			
		}else {
			mv.addObject("msg", "삭제 실패");
			mv.addObject("path", "./");
		}
		mv.setViewName("common/result");
		return mv;
	}
	
	
	@PostMapping("noticeUpdate")
	public String setUpdate2(BoardVO boardVO) throws Exception {
		
		int result = noticeService.setUpdate(boardVO);
		
		
		return "redirect:./noticeList";
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getOne(boardVO);
		mv.addObject("vo", boardVO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		
		return mv;
		
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardVO boardVO) throws Exception{
		ModelAndView mv= new ModelAndView();
		boardVO = noticeService.getOne(boardVO);
		
		mv.addObject("vo", boardVO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar= noticeService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "notice"); 
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	
}
