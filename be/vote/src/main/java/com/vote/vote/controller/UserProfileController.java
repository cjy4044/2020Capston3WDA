package com.vote.vote.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.vote.vote.db.dto.Member;
import com.vote.vote.db.dto.Vote;
import com.vote.vote.db.dto.Voter;
import com.kenai.jffi.Array;
import com.vote.vote.db.dto.Candidate;
import com.vote.vote.klaytn.Klaytn;
import com.vote.vote.repository.CandidateJpaRepository;
import com.vote.vote.repository.MemberJpaRepository;
import com.vote.vote.repository.VoteJpaRepository;
import com.vote.vote.repository.VoterJpaRepository;
import com.vote.vote.service.StorageService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//페이징
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/userProfile")
public class UserProfileController {

	@Autowired  
	private StorageService storageService; 

	@Autowired
	private MemberJpaRepository MemberRepository;

	@Autowired
	private VoteJpaRepository voteRepository;

	@Autowired
	private CandidateJpaRepository candidateRepository;

	@Autowired 
	private VoterJpaRepository voterRepository;


	public Klaytn klaytn = new Klaytn();

	@RequestMapping(value={"","/"}, method=RequestMethod.GET)
	public String index(@PageableDefault Pageable pageable) {

		return "userProfile/index";
	}
	@RequestMapping(value={"/axios","/axios/"})
	@ResponseBody
	public JSONArray indexAxios(Principal user){

		ArrayList<Vote> votes = voteRepository.findAll();
		ArrayList<Member> members = MemberRepository.findAll();
		
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

				
		return json;
	}
	

}