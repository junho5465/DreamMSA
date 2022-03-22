package com.dream.manage.controller;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dream.manage.dto.ManageDto;
import com.dream.manage.service.ManageService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@Slf4j
public class ManageController {
	private ManageService service;

	@RolesAllowed({ "ADMIN" })
	@GetMapping("/register")
	public String register(Principal principal, Model model) {
		JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
		log.info("toString : " + token.getTokenAttributes().toString());
		model.addAttribute("list", token.getTokenAttributes());
		return "register";
	}

	@RolesAllowed({ "ADMIN" })
	@PostMapping("/register")
	public String register(@ModelAttribute("dto") ManageDto dto) {
		log.info("而⑦듃濡ㅻ윭 �떆�옉" + dto.getDescription());
		service.register(dto);
		log.info("而⑦듃濡ㅻ윭 �걹");
		return "/regist_success";
	}

	@PostMapping("/modify")
	public String modify() {
		return "asd";
	}

	@GetMapping("/delete")
	public String delete() {
		return "asd";
	}

//	@RequestMapping("/")
//	public String main(Authentication authentication) {
//
//		if (authentication != null) {
//			System.out.println("���엯�젙蹂� : " + authentication.getClass());
//			
//			// �꽭�뀡 �젙蹂� 媛앹껜 諛섑솚
//			WebAuthenticationDetails web = (WebAuthenticationDetails)authentication.getDetails();
//			System.out.println("�꽭�뀡ID : " + web.getSessionId());
//			System.out.println("�젒�냽IP : " + web.getRemoteAddress());
//
//			// UsernamePasswordAuthenticationToken�뿉 �꽔�뿀�뜕 UserDetails 媛앹껜 諛섑솚
//			UserDetails userVO = (UserDetails) authentication.getPrincipal();
//			System.out.println("ID�젙蹂� : " + userVO.getUsername());
//			return userVO.getUsername();
//		}
//		
//		return "fail";
//	}
}
