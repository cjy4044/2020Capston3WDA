package com.vote.vote.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vote.vote.config.CustomUserDetails;
import com.vote.vote.db.dto.Company;
import com.vote.vote.db.dto.Member;
import com.vote.vote.db.dto.Program;
import com.vote.vote.db.dto.ProgramManager;
import com.vote.vote.db.dto.Vote;
import com.vote.vote.db.dto.Voter;
import com.vote.vote.db.dto.VoterHash;
import com.vote.vote.repository.CompanyJpaRepository;
import com.vote.vote.repository.CustomCompanyRepository;
import com.vote.vote.repository.CustomMemberRepository;
import com.vote.vote.repository.CustomProgramRepository;
import com.vote.vote.repository.MemberJpaRepository;
import com.vote.vote.repository.ProgramJpaRepository;
import com.vote.vote.repository.ProgramManagerJpaRepository;
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
	private CompanyJpaRepository companyRepository;
	
	@Autowired
	private CustomCompanyRepository customCompanyRepository;
	
	@Autowired
	private ProgramJpaRepository programRepository;
	
	@Autowired
	private CustomProgramRepository customProgramRepository;
	
	@Autowired
	private ProgramManagerJpaRepository pmRepository;	
	
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
		 
		 @RequestMapping(value="/companyUpdate", method=RequestMethod.POST)
		    public String registerOk(Company cc){
		       	
			 System.out.println("DDD");
			 System.out.println("DDD"+cc.toString());
		    	return "redirect:/userInfo/allCompany";
		    

		    }
		 
		 @RequestMapping(value={"/companyConfirm","/companyConfirm/"},
				 method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE) 
		 @ResponseBody
			public JSONObject companyConfirm(@RequestBody JSONObject axiosData,
											 Principal user,
											 @Nullable Authentication authentication,
											 Program program,
											 ProgramManager pm
											){
		
			 CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
				

			 System.out.println(axiosData.get("select"));  // 관리자가 선택한 프로그램의 사업자번호
			 int data =  (int) axiosData.get("select");
			 JSONObject result = new JSONObject();
			 
			// 처음 투표하는 사람인지 확인하기 위한 voter
			Company company = customCompanyRepository.findByConfirm(data);
			String confirm = company.getCconfirm();
				if(confirm.equals("0")) { // 승인을 받은적이 없으면
					System.out.println("승인되지 않은 프로그램입니다.");
					
					Company cc = companyRepository.findById(data); // 해당 사업자번호의 회사정보를 찾는다.
					
					program.setCategory(cc.getCcategory());   //카테고리
					program.setImg("/img/defaultProfile.png"); //기본이미지
					program.setName(cc.getCprogram());            //프로그램명
					
					
					programRepository.saveAndFlush(program);       // program 테이블에 추가
					
					Program pi = customProgramRepository.findByPK(cc.getCprogram()); // 해당 프로그램의 번호를 가져옴
									
					System.out.println(""+cc.getRid()+"/"+pi.getId());
					pm.setId(cc.getRid());
					pm.setProgramId(pi.getId());
					
					pmRepository.saveAndFlush(pm); // 프로그램 권한자 등록
					
					customCompanyRepository.updateByConfirm(data); // 프로그램 confirm 1로 변경
					
					
					System.out.println(program.toString());
					
					
					result.put("message","승인완료 및 매니저권한을 부여하였습니다.");
					
					
				}else {
					result.put("errorMessage","이미 승인한 프로그램입니다.");
					System.out.println("이미 승인한 프로그램입니다.");
				}

		/*
		 * // 이미 확인된 회사인지 확인하기위한 Company company = customCompanyRepository.findOne();
		 * Voter voter = voterRepository.findByVoteIdAndMemberId(voteId,
		 * userDetails.getR_ID());
		 * 
		 * if(voter== null){// 처음 투표한 경우. Voter voter2 = new Voter();
		 * voter2.setMemberId(userDetails.getR_ID()); voter2.setState(0);
		 * voter2.setVoteId(voteId); voterRepository.saveAndFlush(voter2); }
		 * 
		 * // 밑에서 조건문에 사용하고 업데이트 하는 변수 voter3 Voter voter3 =
		 * voterRepository.findByVoteIdAndMemberId(voteId, userDetails.getR_ID());
		 * 
		 * 
		 * Vote vote = voteRepository.findById(voteId); String nowTime = getNowTime();
		 * if(!(Long.parseLong(nowTime) >= vote.getLongStartTime() &&
		 * Long.parseLong(nowTime)<vote.getLongEndTime())){
		 * result.put("message","해당 투표는 현재 진행중이지 않습니다."); } else if(vote.getVoteCanNum()
		 * > voter3.getState()){// 투표가 가능하면
		 * 
		 * System.out.println(voter3.getState()); ExecutorService es =
		 * Executors.newCachedThreadPool();
		 * 
		 * es.execute(() -> { try {
		 * 
		 * JSONObject message = klaytn.klaytnSend2(vote.getAddress(),
		 * Integer.parseInt(axiosData.get("select").toString()),Long.parseLong(nowTime))
		 * ;
		 * 
		 * VoterHash voterHash = new VoterHash();
		 * voterHash.setMemberId(userDetails.getR_ID()); voterHash.setVoteId(voteId);
		 * voterHash.setVoterId(voter3.getId());
		 * voterHash.setHash(message.get("hash").toString());
		 * 
		 * voter3.setState(voter.getState()+1);
		 * 
		 * voterRepository.saveAndFlush(voter3);//투표 완료.
		 * voterHashRepository.saveAndFlush(voterHash);
		 * 
		 * } catch (Exception e) {
		 * System.out.println("클레이튼 오류 발생: 클레이튼으로 선택 사항 전달&처리에서 문제발생."); } });
		 * 
		 * result.put("message","투표 참여에 성공하였습니다."); //
		 * result.put("hash",message.get("hash")); }else{// 이미 투표에 참여한 경우
		 * result.put("errorMessage","이미 투표를 완료했습니다."); }
		 */

				

				return result;
				
			}

}