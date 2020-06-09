package com.vote.vote.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import com.vote.vote.db.dto.Audience;
import com.vote.vote.repository.AudienceJpaRepository;
import com.vote.vote.service.AudienceService;
import com.vote.vote.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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

  
    private AudienceService audienceService;
    @Autowired
    AudienceJpaRepository audienceJpaRepository;

    @Autowired  
	private StorageService storageService; 

    public AudienceController(AudienceService audienceService) {
        this.audienceService = audienceService;
    }

    //리스트
    @GetMapping(value = { "/", "/list" })
    public String audience(@PageableDefault Pageable pageable, Model model) {

        Page<Audience> boardList = audienceService.getBoardList(pageable);
        model.addAttribute("boardList", boardList);
        return "audience/list2";
    }


    //게시글 보기
    @RequestMapping("/read/{applyId}")
    public String read(Model model, @PathVariable int applyId) {
        model.addAttribute("audience", audienceJpaRepository.findById(applyId));
        Audience audience = audienceJpaRepository.findById(applyId);
        audience.setAViewCount(audience.getAViewCount() + 1);
        audienceJpaRepository.save(audience);
        return "audience/read2";
    }


    //게시글 업로드
    @GetMapping("/create")
	public String upload(Model model){
		model.addAttribute("audience", new Audience());
		return "audience/create2";
	}
    
    @PostMapping("/create")
	public String upload(@Valid Audience audience,  BindingResult bindingResult,  SessionStatus sessionStatus, Principal principal){
		if (bindingResult.hasErrors()) {
            System.out.println("야야");
			return "audience/create2";
		} else {
        System.out.println(principal.getName());
        audience.setRId(21);
        audience.setProgramId(1);
        audience.setADate(new Date());
		audienceJpaRepository.saveAndFlush(audience);
		sessionStatus.setComplete();
		return "redirect:/audience/list";
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