package com.vote.vote.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vote.vote.db.dto.Company;
import com.vote.vote.db.dto.Member;
import com.vote.vote.repository.CustomCompanyRepository;
import com.vote.vote.repository.CustomMemberRepository;
import com.vote.vote.repository.MemberJpaRepository;
import com.vote.vote.service.StorageService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	
	@Autowired
	private MemberJpaRepository memberRepository;
	
	@Autowired  
	private StorageService storageService; 
	
	@Autowired
	private CustomMemberRepository customRepository;
	
	@Autowired
	private CustomCompanyRepository customCompanyRepository;
	
	//개인정보
	@RequestMapping(value={"","/"})
	public String index(Principal user, RedirectAttributes redirAttrs) {        
		
        return "userInfo/index";
       	}
	
	@RequestMapping(value={"/axios","/axios/"})
	@ResponseBody
	public JSONArray indexAxios(Principal user, Model model){
			
		Member member = memberRepository.findByUserid(user.getName());
		
		JSONArray json = new JSONArray();
		JSONObject memberData = new JSONObject();
	
		//카카오톡 유저인지? 일반 유저인지?
		if(member.getPassword()==null) {
			memberData.put("kakao", "1");
			memberData.put("r_id", member.getNo());
			memberData.put("username", member.getName());
			memberData.put("nickname", member.getNickname());
			memberData.put("userid", member.getUserid());
			memberData.put("profile", member.getProfile());
			memberData.put("gender", member.getGender());
			memberData.put("birth", member.getBirth());
			memberData.put("phone", member.getPhone());
			memberData.put("joindate", member.getJoindate());
			memberData.put("addr", member.getAddr());
			memberData.put("addr2", member.getAddr2());
			memberData.put("point", member.getPoint());
			memberData.put("role", member.getRole());
			
			System.out.println(member.getBirth());
//			memberData.put("r_id", member.getNo());
//			memberData.put("username", member.getName());
//			memberData.put("joindate", member.getJoindate());
//			memberData.put("userid", member.getUserid());
//			memberData.put("profile", member.getProfile());
//			memberData.put("phone", member.getPhone());
			
		}else {
			memberData.put("kakao", "0");
			memberData.put("r_id", member.getNo());
			memberData.put("password", member.getPassword());
			memberData.put("username", member.getName());
			memberData.put("nickname", member.getNickname());
			memberData.put("userid", member.getUserid());
			memberData.put("profile", member.getProfile());
			memberData.put("gender", member.getGender());
			memberData.put("birth", member.getBirth());
			memberData.put("phone", member.getPhone());
			memberData.put("joindate", member.getJoindate());
			memberData.put("addr", member.getAddr());
			memberData.put("addr2", member.getAddr2());
			memberData.put("point", member.getPoint());
			memberData.put("role", member.getRole());
			
		}
			
			json.add(memberData);
		
				
		return json;
	}
	 @RequestMapping(value="/userUpdate", method=RequestMethod.POST)
	    public String updateOk(Member cc, RedirectAttributes redirAttrs, Principal principal,
	    		@RequestParam(name="profile2") MultipartFile file){
	       	
	    	System.out.println("test:"+cc.toString());
	    	String thumbnailPath = cc.getProfile();  // 프로필사진 변동안했을때 그대로 두기위해서
	    	String url = "/uploads/";

	    	if(!file.isEmpty()) { // 프로필사진 변경을 했을시 
	    		
	    		System.out.println("넘어온 파일없다 마");
	    		storageService.store(file);
	    		String thumbnailPath2 = StringUtils.cleanPath(file.getOriginalFilename());
	    		thumbnailPath = url.concat(thumbnailPath2);
	   	
	    	}
	    
	    	
	 	memberRepository.userUpdate(cc.getPassword(), cc.getName(), cc.getGender(), cc.getBirth(), 
		 			cc.getNickname(), cc.getAddr(), cc.getAddr2(),thumbnailPath, cc.getNo());

		
	            return "redirect:/userInfo";
	        

	    }
	 //회원정보
		@RequestMapping(value={"/allUser"})
		public String allUser(Principal user, RedirectAttributes redirAttrs) {        
			
	        return "userInfo/alluser";
	       	}
		
	 @RequestMapping(value={"/axios2","/axios2/"}) //사용자정보
		@ResponseBody
		public JSONArray indexAxios(Principal user, @PageableDefault Pageable pageable, Model model){
				
			List<Member> members = customRepository.findAll(pageable);
		
			long count = customRepository.CountAll();

			System.out.println("pageable : " + pageable);

			System.out.println("getOffset : " + pageable.getOffset());

			JSONArray json = new JSONArray();

			for( Member member : members){
				JSONObject memberData = new JSONObject();
				memberData.put("r_id", member.getNo());
				memberData.put("username", member.getName());
				memberData.put("nickname", member.getNickname());
				memberData.put("userid", member.getUserid());
				memberData.put("profile", member.getProfile());
				memberData.put("gender", member.getGender());
				memberData.put("birth", member.getBirth());
				memberData.put("phone", member.getPhone());
				memberData.put("joindate", member.getJoindate());
				memberData.put("addr", member.getAddr());
				memberData.put("addr2", member.getAddr2());
				memberData.put("point", member.getPoint());
				memberData.put("role", member.getRole());
				
				json.add(memberData);
			}
			json.add(count);
					
			return json;
		}
	 
	 //회사정보
		@RequestMapping(value={"/allCompany"})
		public String allCompany() {        
			
	        return "userInfo/allCompany";
	       	}
		
		 @RequestMapping(value={"/axios3","/axios3/"}) //사용자정보
			@ResponseBody
			public JSONArray companyAxios(Principal user, @PageableDefault Pageable pageable, Model model){
					
				List<Company> companies = customCompanyRepository.findAll(pageable);
			
				long count = customCompanyRepository.CountAll();

				System.out.println("pageable : " + pageable);

				System.out.println("getOffset : " + pageable.getOffset());

				JSONArray json = new JSONArray();

				for( Company company : companies){
					JSONObject companyData = new JSONObject();
					
					companyData.put("c_id", company.getId());
					companyData.put("r_id", company.getRid());
					companyData.put("c_name", company.getCname());
					companyData.put("c_content", company.getCcontent());
					companyData.put("c_reader", company.getCreader());
					companyData.put("c_phone", company.getCphone());
					companyData.put("c_program", company.getCprogram());
					companyData.put("c_category", company.getCcategory());
					companyData.put("c_startdate", company.getCstartdate());
					companyData.put("c_enddate", company.getCenddate());
					companyData.put("c_budget", company.getCbudget());
					companyData.put("c_confirm", company.getCconfirm());

					
					json.add(companyData);
				}
				json.add(count);
						
				return json;
			}

}