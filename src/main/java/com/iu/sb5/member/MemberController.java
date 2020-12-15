package com.iu.sb5.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping("memberLogin")
	public String getMemberLogin(MemberVO memberVO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		MemberVO member =	memberService.getMemberLogin(memberVO);
		
		if(memberVO !=null) {
			System.out.println("login 성공 ---------");
			session.setAttribute("member", member);
			return "redirect:../";
		}else {
			System.out.println("login 실패 ---------");
		}
		return null;
	}
	
	
	@GetMapping("memberLogin")
	public void getMemberLogin() throws Exception{
		
	}
	@GetMapping("memberLogout")
	public String setMemberLogout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}
}
