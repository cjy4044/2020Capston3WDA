package com.vote.vote.controller;

import java.util.Date;

import javax.validation.Valid;

import com.vote.vote.db.dto.Audience;
import com.vote.vote.repository.AudienceJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/audience")
public class AudienceController {

    @Autowired
    AudienceJpaRepository audienceJpaRepository;


    //리스트
    @RequestMapping(value = { "/", "/list" })
    public String audience(Model model, @PageableDefault Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "applyId"));
        model.addAttribute("list", audienceJpaRepository.findAll(pageable));
        System.out.println(audienceJpaRepository.findAll(pageable));
        return "audience/list2";
    }


    //게시글 보기
    @RequestMapping("/read/{applyId}")
    public String read(Model model, @PathVariable int applyId) {
        model.addAttribute("audience", audienceJpaRepository.findById(applyId));
        Audience audience = audienceJpaRepository.findById(applyId);
        audience.setAViewCount(audience.getAViewCount() + 1);
        audienceJpaRepository.save(audience);
        return "audience/read";
    }


    //게시글 업로드
    @GetMapping("/create")
	public String upload(Model model){
		model.addAttribute("audience", new Audience());
		return "audience/create";
	}
    
    @PostMapping("/create")
	public String upload(@Valid Audience audience,  BindingResult bindingResult,  SessionStatus sessionStatus){
		if (bindingResult.hasErrors()) {
			return "audience/create";
		} else {
        audience.setADate(new Date());
		audienceJpaRepository.saveAndFlush(audience);
		sessionStatus.setComplete();
		return "redirect:/";
		}
    }
    

    //삭제
    // @GetMapping("/delete/{applyId}")
	// public String delete(@PathVariable int applyId, Model model){
	// 	model.addAttribute("applyId", applyId);
	// 	return "/delete";
	// }

	@PostMapping("/{applyId}")
	public String delete(@PathVariable int applyId){
		audienceJpaRepository.deleteById(applyId);
		return "redirect:/audience/";
	}

}