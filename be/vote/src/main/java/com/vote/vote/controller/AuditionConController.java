package com.vote.vote.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.vote.vote.config.CustomUserDetails;
import com.vote.vote.db.dto.Audition;
import com.vote.vote.db.dto.AuditionCon;
import com.vote.vote.db.dto.AuditionResult;
import com.vote.vote.repository.AuditionConJpaRepository;

@Controller
public class AuditionConController {
	
	@Autowired
	AuditionConJpaRepository auditionConRepository;
	
	@RequestMapping("/audition_con/list")
	public String list(Model model) { // 2~ n
		model.addAttribute("auditionconlist",auditionConRepository.findAll());
		return "/audition_con/list";
	}
	

	@RequestMapping("/audition_con/listm")
	public String listmm(@Valid AuditionCon auditionCon, Integer rid, Model model ) { // only 1
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUserDetails sessionUser = (CustomUserDetails)principal;
        
//        System.out.println(sessionUser.getR_ID());
//        AuditionCon auditioncon = auditionConRepository.findByRid(sessionUser.getR_ID());
//        
//        
//		System.out.println(auditioncon.toString());
//		model.addAttribute("auditionconlistm",auditioncon);
//		
//		System.out.println(sessionUser.getR_ID()+"의 오디션 폼의 오디션 fk는"+auditioncon.getAuditionid());

				
		
		return "/audition_con/listm";
	
	}
	

	
	@GetMapping("/audition_con/read/{formid}")
	public String read(Model model, @PathVariable int formid){
		
		model.addAttribute("auditionCon", auditionConRepository.findByFormid(formid));
		AuditionCon auditioncon = auditionConRepository.findByFormid(formid);
		auditionConRepository.save(auditioncon);
		return "audition_con/read";
	}
	

	@GetMapping("/audition_con/form")
	public String form(Model model) {
		model.addAttribute("auditionCon",new AuditionCon());
		return "audition_con/form";
	}
	
	@PostMapping("/audition_con/form")
	public String form(@Valid AuditionCon auditionCon, BindingResult bindingResult, SessionStatus sessionStatus) {
		if(bindingResult.hasErrors()) {
			return "/audition_con/form";
		} else {
			auditionCon.setFdate(new Date());
			System.out.println(auditionCon.toString());
			auditionConRepository.save(auditionCon);
			sessionStatus.setComplete();
			return "redirect:/audition/complete";
		}
	}
	
	@GetMapping("/audition_con/update/{formid}")
	public String update(Model model, @PathVariable int formid){
		AuditionCon auditioncon = auditionConRepository.findByFormid(formid);
		model.addAttribute("auditionCon", auditioncon);		
		return "audition_con/update";
	}

	@PostMapping("/audition_con/update/{formid}")
	public String update(AuditionCon auditioncon, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return "/audition_con/update";
		} else {
			
			auditionConRepository.save(auditioncon).getFormid();
		return "redirect:/audition_con/list";
		}
	}	
	
	@GetMapping("/audition_con/serch")
	public String serch(@RequestParam(value="keyword") String keyword, Model model) {
		List<AuditionCon> auditioncon = auditionConRepository.findByConfirm(keyword);
		
				model.addAttribute("auditionconlist", auditioncon);
				
				return "audition_con/list";
	}

	
}