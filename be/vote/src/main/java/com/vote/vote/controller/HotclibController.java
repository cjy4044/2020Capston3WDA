package com.vote.vote.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.vote.vote.config.CustomUserDetails;
import com.vote.vote.db.dto.Hotclib;
import com.vote.vote.db.dto.Member;
import com.vote.vote.db.dto.ProgramManager;
import com.vote.vote.db.dto.Reply;
import com.vote.vote.db.dto.Rfile;
import com.vote.vote.repository.HotclibRepository;
import com.vote.vote.repository.MemberJpaRepository;
import com.vote.vote.repository.ProgramManagerJpaRepository;
import com.vote.vote.repository.ReplyRepository;
import com.vote.vote.repository.RfileRepository;
import com.vote.vote.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HotclibController {
	
	@Autowired
	private HotclibRepository hotclibRepository;

	@Autowired
	private StorageService storageService;

	@Autowired
	private ReplyRepository replyRepository;

	@Autowired
	private RfileRepository rfileRepository;

	@Autowired
	private MemberJpaRepository memberRepository;

	@Autowired
	private ProgramManagerJpaRepository pmRepository;
	
	@GetMapping("/hotclib")
	public String hotclib(Model model, @PageableDefault Pageable pageable){
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); 
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "hotclibid"));
		model.addAttribute("hotclibList", hotclibRepository.findAll(pageable));
		model.addAttribute("rfiles", rfileRepository.findAll());
		return "hotclib/list";
	}

	@GetMapping("/hotclib/read/{hotclibid}")
	public String read(Model model, @PathVariable int hotclibid){
		model.addAttribute("hotclib", hotclibRepository.findById(hotclibid));
		List<Reply> reply = replyRepository.findByHotclibid(hotclibid);
		model.addAttribute("replyList", reply);
	//	List<Rfile> rfile = rfileRepository.findByHotclibid(hotclibid);
	//	model.addAttribute("rfileList", rfile);
		Hotclib hotclib = hotclibRepository.findById(hotclibid);
		hotclib.setHviewcount(hotclib.getHviewcount() + 1);
		hotclibRepository.save(hotclib);
		return "hotclib/read";
	}

	@PostMapping("/hotclib/read/{hotclibid}/{replyid}")
	public String read(Reply reply, 
	@PathVariable int replyid,
	 BindingResult bindingResult, 
	SessionStatus sessionStatus){
		 if (bindingResult.hasErrors()) {
		 	return "hotclib/read/{hotclibid}";
		 } else {
			
		 reply.setR_date(new Date());	
		 replyRepository.save(reply);
		 replyRepository.deleteById(replyid);
		 sessionStatus.setComplete();
		return "redirect:/hotclib/read/{hotclibid}";
		}
	}

	@GetMapping("/hotclib/upload")
	public String upload(Model model){
		model.addAttribute("hotclib", new Hotclib());
		return "hotclib/upload";
	}

	@PostMapping("/hotclib/upload")
	public String upload(
		
		@RequestParam(name="filename") MultipartFile filename,
		@RequestParam(name="hotclibid", required = false) Integer hotclibid,
		Model model,
		RedirectAttributes redirAttrs,
		Hotclib hotclib,
		BindingResult bindingResult, 
		SessionStatus sessionStatus,
		Principal principal){
			
			String userid = principal.getName(); 
			Member member = memberRepository.findByUserid(userid); 
			int r_id = member.getNo();
			hotclib.setNo(r_id);
		if (bindingResult.hasErrors()) {
			return "hotclib/upload";
		} else {
			
		Rfile rfile = new Rfile();
		storageService.store(filename);
		String filenamePath = StringUtils.cleanPath(filename.getOriginalFilename());
		//int hotclibid = hotclib.getHotclibid();
		//hotclibRepository.findById(hotclibid);
		
		ProgramManager pm = pmRepository.findById(r_id);
		int programId = pm.getProgramId();
		
		
		System.out.println(programId);
		
		hotclib.setProgramid(programId);
		
		hotclibRepository.saveAndFlush(hotclib);  // 저장하고 커밋까지 Flush
				
		rfile.setHotclibid(hotclib.getHotclibid());
		rfile.setFilename(filenamePath); 
		
		System.out.println(rfile.toString());
		

		hotclib.setH_date(new Date());	
		
		rfileRepository.saveAndFlush(rfile);
		sessionStatus.setComplete();
		return "redirect:/hotclib";
		}
	
	}
	// @GetMapping("/hotclib/fileuplad")
	// public String fileupload(Model model){
	// 	model.addAttribute("rfiles", new Rfile());
	// 	return "hotclib/fileupload";
	// }

	// @PostMapping("/hotclib/fileupload")
	// public String fileupload(
	// 	@RequestParam(name="filename") MultipartFile filename,
	// 	@RequestParam(name="hotclibid", required = false) Integer hotclibid,
	// 	Model model,
	// 	RedirectAttributes redirAttrs){
			
	// 	Rfile rfile = new Rfile();
	// 	storageService.store(filename);
	// 	String filenamePath = StringUtils.cleanPath(filename.getOriginalFilename());

	// 	rfile.setHotclibid(hotclibid);
	// 	rfile.setFilename(filenamePath); 
		
	// 	System.out.println(rfile.toString());
	// 	rfileRepository.saveAndFlush(rfile);
	// 	return "redirect:/hotclib";
	// }
 
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
