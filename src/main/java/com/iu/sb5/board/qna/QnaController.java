package com.iu.sb5.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb5.board.BoardVO;
import com.iu.sb5.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	//model.addAttribute("board", "qna")를 이렇게 변경가능, 모든메서드에 적용!!
	@ModelAttribute(name="board")
	public String getBoard() {
		return "qna";
	}
	
	@PostMapping("qnaWrite")
	public String setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception{
		int result = qnaService.setInsert(boardVO, files);
		return "redirect:./qnaList";
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert()throws Exception{
		ModelAndView mv= new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@GetMapping("qnaDelete")
	public ModelAndView setDelete(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result= qnaService.setDelete(boardVO);
		if(result>0) {
			mv.addObject("msg", "삭제 성공");
			mv.addObject("path", "./qnaList");
			
		}else {
			mv.addObject("msg", "삭제 실패");
			mv.addObject("path", "./");
		}
		mv.setViewName("common/result");
		return mv;
	}
	
	
	@PostMapping("qnaUpdate")
	public String setUpdate2(BoardVO boardVO) throws Exception {
		System.out.println("post update 옴");
		System.out.println(boardVO.getContents());
		int result = qnaService.setUpdate(boardVO);
		
		
		return "redirect:./qnaList";
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = qnaService.getOne(boardVO);
		mv.addObject("vo", boardVO);
	//	mv.addObject("board", "qna");
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardVO boardVO) throws Exception{
		boardVO = qnaService.getOne(boardVO);
		ModelAndView mv= new ModelAndView();
		mv.addObject("vo", boardVO);
	//	mv.addObject("board", "qna");
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		System.out.println("1:"+pager.getCurPage());
		ModelAndView mv= new ModelAndView();
		List<BoardVO> ar =qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
	//	mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
