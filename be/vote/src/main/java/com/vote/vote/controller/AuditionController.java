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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vote.vote.config.CustomUserDetails;
import com.vote.vote.db.dto.Audition;
import com.vote.vote.db.dto.AuditionCon;
import com.vote.vote.db.dto.Member;
import com.vote.vote.repository.AuditionConJpaRepository;
import com.vote.vote.repository.AuditionJpaRepository;
import com.vote.vote.repository.MemberJpaRepository;
import com.vote.vote.repository.ProgramManagerJpaRepository;
import com.vote.vote.service.StorageService;

@Controller
public class AuditionController {

	
	@Autowired
	AuditionJpaRepository auditionRepository;
	
	@Autowired
	private StorageService storageService;

	@Autowired
	private MemberJpaRepository memberRepository;

	@Autowired
	private ProgramManagerJpaRepository pmRepository;
	
//	@RequestMapping("/audition/list")
//	public String list(Model model) {
//		model.addAttribute("auditionlist",auditionRepository.findAll());
//		System.out.println(auditionRepository.findAll());
//		return "audition/list";
//	}

	@GetMapping("/audition/list")
	public String audition(Model model, @PageableDefault Pageable pageable){
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); 
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "auditionid"));
		model.addAttribute("auditionlist", auditionRepository.findAll(pageable));
		return "audition/list";
	}
	
	@RequestMapping("/audition/complete")
	public String com(Model model) {

		return "audition/complete";
	}
	

	
	@GetMapping("/audition/serch")
	public String serch(@RequestParam(value="keyword") String keyword, Model model) {
		List<Audition> audition = auditionRepository.findByAtitle(keyword);
		
				model.addAttribute("auditionlist", audition);
				
				return "audition/list";
	}

	


	@GetMapping("/audition/read/{auditionid}")
	public String read(Model model, @PathVariable int auditionid){
		model.addAttribute("audition", auditionRepository.findByAuditionid(auditionid));
		Audition audition = auditionRepository.findByAuditionid(auditionid);
		auditionRepository.save(audition);

		return "audition/read";
	}
	
	
	@GetMapping("/audition/write")
	public String register(Model model) {
		
		model.addAttribute("audition",new Audition());
		return "audition/write";
	}
	
//	@PostMapping("/audition/write")
//	public String write(@Valid Audition audition, BindingResult bindingResult, SessionStatus sessionStatus) {
//		
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        CustomUserDetails sessionUser = (CustomUserDetails)principal;
//		
//		if(bindingResult.hasErrors()) {
//			return "/audition/wirte";
//		} else {
//			
//			audition.setRid(sessionUser.getR_ID());
//			System.out.println(audition.toString());
//			auditionRepository.save(audition);
//			sessionStatus.setComplete();
//			return "redirect:/audition/list";
//		}
//	}
	
	@PostMapping("/audition/write")
	  public String write(
			  
			  SessionStatus sessionStatus,
	            Principal principal,			       
	            RedirectAttributes redirAttrs,
	            @RequestParam(name = "afile") MultipartFile afile,
	            @RequestParam(name= "atitle") String atitle,
	            @RequestParam(name= "acontent") String acontent,
	            @RequestParam(name= "acategory") String acategory
//	            @RequestParam(name= "") String ftitle,
//	            @RequestParam(name= "faddr") String faddr,
//	            @RequestParam(name= "feducation") String feducation,
//	            @RequestParam(name= "fgender") String fgender,
//	            @RequestParam(name= "fheight") String fheight,
//	            @RequestParam(name= "fweight") String fweight,
//	            @RequestParam(name= "fblood") String fblood,
//	            @RequestParam(name= "ffamily") String ffamily,
//	            @RequestParam(name= "fhobby") String fhobby,
//	            @RequestParam(name= "fability") String fability
	            ) {
				
				String fprofilePath = storageService.store2(afile); 
	            Member member = memberRepository.findByUserid(principal.getName());
//	            ProgramManager pm = pmRepository.findById(member.getNo());
	           // Audition audition = auditionRepository.findByAuditionid(member.getNo());
	           
	            			         
	            AuditionCon auditionCon = new AuditionCon();
	            Audition audition = new Audition(); 
	          
//	            auditionCon.setAuditionid(audition.getAuditionid());
	            audition.setRid(member.getNo());
	            audition.setAfile(fprofilePath);
	            audition.setAtitle(atitle);
	            audition.setAcontent(acontent);
	            audition.setAcategory(acategory);
//	            auditionCon.setFtitle(ftitle);
//	            auditionCon.setFaddr(faddr);
//	            auditionCon.setFeducation(feducation);
//	            auditionCon.setFgender(fgender);
//	            auditionCon.setFheight(fheight);
//	            auditionCon.setFweight(fweight);
//	            auditionCon.setFblood(fblood);
//	            auditionCon.setFfamily(ffamily); 
//	            auditionCon.setFhobby(fhobby);
//	            auditionCon.setFability(fability);
	                 
	            auditionRepository.saveAndFlush(audition);

	            // 파일 저장	       
	            sessionStatus.setComplete();
	            System.out.println("게시글업로드완료");
	            return "redirect:/audition/list";
	           
}
	

	@GetMapping("/audition/update/{auditionid}")
	public String update(Model model, @PathVariable int auditionid){
		Audition audition = auditionRepository.findByAuditionid(auditionid);
		model.addAttribute("audition", audition);		
		return "audition/update";
	}

	@PostMapping("/audition/update/{auditionid}")
	public String update(Audition audition, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return "/audition/update";
		} else {
			auditionRepository.save(audition).getAuditionid();
		return "redirect:/audition/list";
		}
	}	
	
	@GetMapping("/audition/delete/{auditionid}")
	public String delete(@PathVariable int auditionid, Model model){
		model.addAttribute("auditionid", auditionid);
		return "/audition/delete";
	}
	
	@PostMapping("/audition/{auditionid}")
	public String deletee(@PathVariable int auditionid){
		Audition audition = auditionRepository.findByAuditionid(auditionid);
				auditionRepository.delete(audition);
		
		return "redirect:/audition/list";
	}
	
	
}