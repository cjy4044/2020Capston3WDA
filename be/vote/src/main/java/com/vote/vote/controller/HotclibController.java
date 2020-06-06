package com.vote.vote.controller;


import java.util.Date;
import java.util.List;



import com.vote.vote.config.CustomUserDetails;
import com.vote.vote.db.dto.Hotclib;
import com.vote.vote.db.dto.Member;
import com.vote.vote.repository.HotclibRepository;
import com.vote.vote.repository.MemberJpaRepository;
import com.vote.vote.repository.ReplyRepository;
import com.vote.vote.service.StorageService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class HotclibController {
	
	@Autowired
	private HotclibRepository hotclibRepository;

	@Autowired
	private StorageService storageService;

	@Autowired
	private MemberJpaRepository memberJpaRepository;

	@GetMapping("/hotclib")
	public String hotclib(Model model, @PageableDefault Pageable pageable){
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); 
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "hotclibid"));
		model.addAttribute("hotclibList", hotclibRepository.findAll(pageable));
		return "hotclib/list";
	}

	@GetMapping("/hotclib/read/{hotclibid}")
	public String read(Model model, @PathVariable int hotclibid){
		model.addAttribute("hotclib", hotclibRepository.findById(hotclibid));
		Hotclib hotclib = hotclibRepository.findById(hotclibid);
		hotclib.setHviewcount(hotclib.getHviewcount() + 1);
		hotclibRepository.save(hotclib);
		return "hotclib/read";
	}
	
	@GetMapping("/hotclib/upload")
	public String upload(Model model){
		model.addAttribute("hotclib", new Hotclib());
		return "hotclib/upload";
	}

	@PostMapping("/hotclib/upload")
	public String upload(Hotclib hotclib,
	 BindingResult bindingResult, 
	SessionStatus sessionStatus){
		if (bindingResult.hasErrors()) {
			return "hotclib/upload";
		} else {
		hotclib.setH_date(new Date());	
		hotclibRepository.save(hotclib);
		sessionStatus.setComplete();
		return "redirect:/hotclib";
		}
	}

 	@GetMapping("/hotclib/update/{hotclibid}")
	public String update(Model model, @PathVariable int hotclibid){
		Hotclib hotclib = hotclibRepository.findById(hotclibid);
		model.addAttribute("hotclib", hotclib);		
		return "hotclib/update";
	}

	@PostMapping("/hotclib/update/{hotclibid}")
	public String update(Hotclib hotclib, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return "hotclib/update";
		} else {
			hotclib.setH_mdate(new Date());
		hotclibRepository.save(hotclib).getHotclibid();
		return "redirect:/hotclib";
		}
	}	

	@GetMapping("/hotclib/delete/{hotclibid}")
	public String delete(@PathVariable int hotclibid,Model model){
		model.addAttribute("hotclibid", hotclibid);
		return "hotclib/delete";
	}

	@PostMapping("/hotclib/{hotclibid}")
	public String delete(@PathVariable int hotclibid){
		hotclibRepository.deleteById(hotclibid);
		return "redirect:/hotclib";
	}

	@GetMapping("/hotclib/search")
	public String search(@RequestParam(value="keyword") String keyword, Model model){
		List<Hotclib> hotclib = hotclibRepository.findByHtitle(keyword);
		model.addAttribute("hotcliblist", hotclib);
		return "hotclib/list";
	}
	
}
