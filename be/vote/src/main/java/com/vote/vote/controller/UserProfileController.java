package com.vote.vote.controller;

import java.security.Principal;
import java.util.List;

import com.vote.vote.db.dto.Member;
import com.vote.vote.repository.CustomMemberRepository;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
//페이징
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userProfile")
public class UserProfileController {

	@Autowired
	private CustomMemberRepository customRepository;
	


	@RequestMapping(value={"","/"}, method=RequestMethod.GET)
	public String index() {

		return "userProfile/index";
	}
	@RequestMapping(value={"/axios","/axios/"})
	@ResponseBody
	public JSONArray indexAxios(Principal user, @PageableDefault Pageable pageable, Model model){
			
		List<Member> members = customRepository.findAll(pageable);
	
		long count = customRepository.CountAll();

		System.out.println("pageable : " + pageable);

		System.out.println("getOffset : " + pageable.getOffset());

		// Page<Member> members = boardService.getBoardList(pageable);
		// model.addAttribute("boardList", members);
//		ArrayList<Member> members = MemberRepository.findAll();
//		long count = MemberRepository.CountAll();
//		long count2 = MemberRepository.CountAll("username","안녕");
		
//		System.out.println("count:"+count);
//		System.out.println("count2:"+count2);
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
	

}