package com.vote.vote.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.util.StringUtils;

import com.vote.vote.db.dto.Audition;
import com.vote.vote.db.dto.AuditionResult;
import com.vote.vote.repository.AuditionResultJpaRepository;
import com.vote.vote.repository.MemberJpaRepository;
import com.vote.vote.db.dto.Member;
import com.vote.vote.repository.ProgramManagerJpaRepository;
import com.vote.vote.service.StorageService;

@Controller
public class AuditionResultController {
	
	@Autowired
	AuditionResultJpaRepository auditionResultRepository;

	@Autowired
	private StorageService storageService;

	@Autowired
	private MemberJpaRepository memberRepository;

	@Autowired
	private ProgramManagerJpaRepository pmRepository;
	
//	@RequestMapping("/auditionresult/list")
//	public String list(Model model) {
//		model.addAttribute("auditionresultlist",auditionResultRepository.findAll());
//		return "auditionresult/list";
//	}
	
	@GetMapping("/auditionresult/list")
	public String result(Model model, @PageableDefault Pageable pageable){
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber()-1); 
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "resultid"));
		model.addAttribute("auditionresultlist", auditionResultRepository.findAll(pageable));
		return "auditionresult/list";
	}

	@GetMapping("/auditionresult/listuser")
	public String resultuser(Model model, @PageableDefault Pageable pageable){
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber()-1); 
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "resultid"));
		model.addAttribute("auditionresultlist", auditionResultRepository.findAll(pageable));
		return "auditionresult/listuser";
	}
	
	
	
	@GetMapping("/auditionresult/serch")
	public String serch(@RequestParam(value="keyword") String keyword, Model model) {
		List<AuditionResult> auditionresult = auditionResultRepository.findByRtitle(keyword);
		
				model.addAttribute("auditionresultlist", auditionresult);
				
				return "auditionresult/list";
	}
	

	@GetMapping("/auditionresult/read/{resultid}")
	public String read(Model model, @PathVariable int resultid){
		model.addAttribute("auditionResult", auditionResultRepository.findByResultid(resultid));
		AuditionResult auditionResult = auditionResultRepository.findByResultid(resultid);
		auditionResultRepository.save(auditionResult);
		return "auditionresult/read";
	}

	@GetMapping("/auditionresult/readuser/{resultid}")
	public String readuser(Model model, @PathVariable int resultid){
		model.addAttribute("auditionResult", auditionResultRepository.findByResultid(resultid));
		AuditionResult auditionResult = auditionResultRepository.findByResultid(resultid);
		auditionResultRepository.save(auditionResult);
		return "auditionresult/readuser";
	}
	
	
	@GetMapping("auditionresult/write")
	public String register(Model model) {
		model.addAttribute("auditionResult",new AuditionResult());
		return "auditionresult/write";
	}
	
	@PostMapping("/auditionresult/write")
	public String write(@Valid AuditionResult auditionResult, BindingResult bindingResult, SessionStatus sessionStatus,
			Principal principal, Model model, RedirectAttributes redirAttrs,
            @RequestParam(name = "filename") MultipartFile filename	) {
		
		
		if(bindingResult.hasErrors()) {
			return "/auditionresult/write";
		} else if(filename.isEmpty()) {
			auditionResult.setRdate(new Date());
			auditionResultRepository.save(auditionResult);
			sessionStatus.setComplete();
			return "redirect:/auditionresult/list";
		} else {
			
		    String filenamePath = StringUtils.cleanPath(filename.getOriginalFilename());
            Member member = memberRepository.findByUserid(principal.getName());
			
            // 게시글저장
            auditionResult.setRid(member.getNo());
//            audience.setADate(new Date());
            auditionResult.setRfile(filenamePath);
 
			auditionResult.setRdate(new Date());
			auditionResultRepository.saveAndFlush(auditionResult);

            // 파일 저장
            storageService.store(filename);
            // rfile.setApplyid(audience.getApplyId());
            // rfile.setFilename(filenamePath);
            // rfileRepository.saveAndFlush(rfile);
            sessionStatus.setComplete();
            System.out.println("게시글업로드완료");
            return "redirect:/auditionresult/list";
            
		}
	}

	// @PostMapping("/auditionresult/write")
	// public String write(@Valid AuditionResult auditionResult, BindingResult bindingResult, SessionStatus sessionStatus) {
	// 	if(bindingResult.hasErrors()) {
	// 		return "/auditionresult/wirte";
	// 	} else {
	// 		auditionResult.setRdate(new Date());
	// 		auditionResultRepository.save(auditionResult);
	// 		sessionStatus.setComplete();
	// 		return "redirect:/auditionresult/list";
	// 	}
	// }
	
	@GetMapping("/auditionresult/update/{resultid}")
	public String update(Model model, @PathVariable int resultid){
		AuditionResult auditionResult = auditionResultRepository.findByResultid(resultid);
		model.addAttribute("auditionResult", auditionResult);		
		return "auditionresult/update";
	}

	@PostMapping("/auditionresult/update/{resultid}")
	public String update(AuditionResult auditionResult, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return "/auditionresult/update";
		} else {
			auditionResult.setRmdate(new Date());
			auditionResultRepository.save(auditionResult).getResultid();
		return "redirect:/auditionresult/list";
		}
	}	
	
	@GetMapping("/auditionresult/delete/{resultid}")
	public String delete(@PathVariable int resultid, Model model){
		model.addAttribute("resultid", resultid);
		return "/auditionresult/delete";
	}
	
	@PostMapping("/auditionresult/{resultid}")
	public String delete(@PathVariable int resultid){
		AuditionResult auditionResult = auditionResultRepository.findByResultid(resultid);
				auditionResultRepository.delete(auditionResult);
		
		return "redirect:/auditionresult/list";
	}
	
	
	
	
}