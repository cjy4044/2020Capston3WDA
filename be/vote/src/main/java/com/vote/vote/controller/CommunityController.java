package com.vote.vote.controller;


import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vote.vote.config.CustomUserDetails;
import com.vote.vote.db.dto.Company;
import com.vote.vote.db.dto.Hotclib;
import com.vote.vote.db.dto.Member;
import com.vote.vote.db.dto.Popular;
import com.vote.vote.db.dto.PopularBoard;
import com.vote.vote.db.dto.Program;
import com.vote.vote.db.dto.ProgramManager;
import com.vote.vote.db.dto.Vote;
import com.vote.vote.klaytn.Klaytn;
import com.vote.vote.repository.CompanyJpaRepository;
import com.vote.vote.repository.CustomPopularBoardRepository;
import com.vote.vote.repository.MemberJpaRepository;
import com.vote.vote.repository.PopularBoardJpaRepository;
import com.vote.vote.repository.PopularJpaRepository;
import com.vote.vote.repository.ProgramJpaRepository;
import com.vote.vote.repository.ProgramManagerJpaRepository;
import com.vote.vote.service.KakaoAPIService;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.minidev.json.JSONObject;

@Controller
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private MemberJpaRepository memberRepository;	

	@Autowired
	ProgramJpaRepository programRepository;
	
	@Autowired
	PopularJpaRepository popularRepository;
	
	@Autowired
	PopularBoardJpaRepository popularBoardRepository;
	
	@Autowired
	CustomPopularBoardRepository customPopularBoardRepository;
		
	@Autowired
	ProgramManagerJpaRepository pmRepository;
	
	
    @RequestMapping(value={"","/"})
	public String index() {
		// System.out.println("/ --> index");
		// if(user != null){
		// 	// UserDetails u = (UserDetails)user;
		// 	System.out.println(u);
		// }
    	    		
		return "community/index";
	}	
    
    @ResponseBody
	@RequestMapping(value={"/axios","/axios/"})
	public JSONArray createAxios() {
		
		JSONArray result = new JSONArray();

		List<Program> programList = programRepository.findAll();

		for(Program program : programList){
			JSONObject json = new JSONObject();
			json.put("id", program.getId());
			json.put("name",program.getName());
			json.put("img",program.getImg());
			result.add(json);
		}
		return result;
	}
    
    
		
    @RequestMapping(value={"/{program}","/{program}/"}, method = RequestMethod.GET)
  	public String detailIndex(@PathVariable("program") int programNum,Model model) {
    	
    	Program program = programRepository.findById(programNum);
    	model.addAttribute("programName", program.getName());
    	
		return "community/detailIndex";
	}	
    
    @RequestMapping(value={"/{program}/axios","/{program}/axios/"}, method = RequestMethod.GET) // 해당 프로그램 인기인 정보
  	@ResponseBody
  	public JSONObject detailProgramAxios(@PathVariable("program") int programNum ){
  	
      	//System.out.println(programNum);
      	
      	Program program = programRepository.findById(programNum);


  		JSONObject programData = new JSONObject();

  		programData.put("id", program.getId());
  		programData.put("name", program.getName());
  		programData.put("img", program.getImg());
  		programData.put("category", program.getCategory());
	
  	    return programData; 
  	   
      }
    
    @RequestMapping(value={"/{program}/popular/axios","/{program}/popular/axios/"}) // 해당 프로그램 인기인 정보
  	@ResponseBody
  	public JSONArray  popularAxios(@PathVariable("program") int programNum ){
  	
      	
      	List<Popular> populares = popularRepository.findByPid(programNum);


      	JSONArray json = new JSONArray();
		
		for( Popular popular : populares){
			JSONObject popularData = new JSONObject();
			
			popularData.put("id", popular.getId());
			popularData.put("name", popular.getName());
			popularData.put("img", popular.getImg());
			popularData.put("p_id", popular.getPid());

			json.add(popularData);
		}
	

		return json;
    
    }
    
    @RequestMapping(value={"/{program}/{popular}","/{program}/{popular}/"})
   	public String popularBoard(@PathVariable("program") int programNum,
   								@PathVariable("popular") int popularNum,Model model) {
     	
     	Program program = programRepository.findById(programNum);
     	Popular popular = popularRepository.findById(popularNum);
     	
     	model.addAttribute("popularName", popular.getName());
     	
   
     	
 		return "community/popularBoard";
 	}	
    
    @RequestMapping(value={"/{program}/{popular}/axios","/{program}/{popular}/axios"}) //사용자정보
	@ResponseBody
	public JSONArray popularBoardAxios(
			    @PathVariable("program") int programNum,
				@PathVariable("popular") int popularNum,
				
				@PageableDefault Pageable pageable, Model model){
	
    	
		List<PopularBoard> popularboards = customPopularBoardRepository.findById(popularNum,pageable);
	
		long count = customPopularBoardRepository.CountById(popularNum);
		
		//System.out.println(popularNum);
		//System.out.println(count);
		

		//System.out.println("pageable : " + pageable);

		//System.out.println("getOffset : " + pageable.getOffset());
		
		int gob;
		int rownum;
		
		if(pageable.getPageNumber()==0) {
			 gob = 0;
			
		}else {
			 gob = 10;
		}
		int i = 0;
		rownum = (int)count - (pageable.getPageNumber() * gob) ;
		
		//System.out.println(count-pageable.getPageNumber());
		
		JSONArray json = new JSONArray();
		Member member = new Member();
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUserDetails sessionUser = (CustomUserDetails)principal;
		
		
		for( PopularBoard popularBoard : popularboards){
			JSONObject popularBoardData = new JSONObject();
	
			member = memberRepository.findByNo(popularBoard.getRid());
			
			String nickname = member.getNickname();
			if(nickname==null) {
				nickname = member.getName();
			}
			popularBoardData.put("rownum",rownum-i);
			popularBoardData.put("id", popularBoard.getId());
			popularBoardData.put("nickname", nickname);
			popularBoardData.put("popular_id", popularBoard.getPopularid());
			popularBoardData.put("title", popularBoard.getTitle());
			popularBoardData.put("content", popularBoard.getContent());
			popularBoardData.put("date", popularBoard.getDate());
			popularBoardData.put("mdate", popularBoard.getMdate());
			popularBoardData.put("viewCount", popularBoard.getViewcount());
			popularBoardData.put("replyCount", popularBoard.getReplycount());
			popularBoardData.put("r_id", popularBoard.getRid());
			
			i++;
			json.add(popularBoardData);
		}
		json.add(sessionUser.getR_ID());			
		json.add(count);
		
		
		
		int countList= 10;
		int totalPage= (int)(count) / countList;
		
		if (count%countList>0) {
			
			totalPage++;
			
		}
				
		return json;
	}
    
    @RequestMapping(value={"/{program}/{popular}/{popularBoard}","/{program}/{popular}/{popularBoard}/"}) //프로그램>인기인>게시글내용
   	public String popularBoardView(@PathVariable("program") int programNum,
   								@PathVariable("popular") int popularNum,
   								@PathVariable("popularBoard") int BoardNum,Model model) {
     	
     	Program program = programRepository.findById(programNum);
     	Popular popular = popularRepository.findById(popularNum);
     	PopularBoard board = popularBoardRepository.findById(BoardNum);
     	  
//     	System.out.println(board.toString());
     	model.addAttribute("popularName", popular.getName());
          	
     //조회수카운트하기
     	//board.setViewcount(board.getViewcount()+1);
     	//popularBoardRepository.save(board);
     	
 		return "community/popularBoardView";
 	}	
    
    @RequestMapping(value={"/{program}/{popular}/{popularBoard}/axios"}, method = RequestMethod.GET) // 해당 프로그램 인기인 정보
  	@ResponseBody
  	public JSONObject popularBoardAxios(@PathVariable("program") int programNum,
										@PathVariable("popular") int popularNum,
										@PathVariable("popularBoard") int BoardNum,Model model ){
  	

      	ProgramManager pm = pmRepository.findByProgramId(programNum);
      	PopularBoard popularBoard = popularBoardRepository.findById(BoardNum);



  		JSONObject popularBoardData = new JSONObject();
  		
  		Member member = memberRepository.findByNo(popularBoard.getRid());
		member = memberRepository.findByNo(popularBoard.getRid());
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUserDetails sessionUser = (CustomUserDetails)principal;
		
		String nickname = member.getNickname();
		if(nickname==null) {
			nickname = member.getName();
		}
		popularBoardData.put("nickname", nickname);
  		popularBoardData.put("id", popularBoard.getId());
   		popularBoardData.put("popular_id", popularBoard.getPopularid());
  		popularBoardData.put("title", popularBoard.getTitle());
  		popularBoardData.put("content", popularBoard.getContent());
		popularBoardData.put("date", popularBoard.getDate());
		popularBoardData.put("mdate", popularBoard.getMdate());
		popularBoardData.put("viewCount", popularBoard.getViewcount());
		popularBoardData.put("replyCount", popularBoard.getReplycount());
		popularBoardData.put("r_id", popularBoard.getRid());	
		popularBoardData.put("sessionUser", sessionUser.getR_ID());	
		popularBoardData.put("sessionRole", sessionUser.getROLE());
		popularBoardData.put("managerId", pm.getId());
//		System.out.println("-----------------");
//		System.out.println(sessionUser.getR_ID());
//		System.out.println(sessionUser.getROLE());
//		System.out.println(pm.getId());
  	    return popularBoardData; 
  	    
      	
    	
  	   
      }
    
    @RequestMapping(value={"/{program}/{popular}/create"}) //프로그램>인기인>게시글작성
   	public String popularBoardCreate(@PathVariable("program") int programNum,
   									@PathVariable("popular") int popularNum,
   									
   									PopularBoard board,@RequestParam(name="file2") MultipartFile file,
   								Model model) {
     	
     	Program program = programRepository.findById(programNum);
     	Popular popular = popularRepository.findById(popularNum);
     	PopularBoard board2 = popularBoardRepository.findById(popularNum);
     	
     	SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
     	Date time = new Date();
        String time1 = format1.format(time);
     	//board.setDate(time1);
     	
     	System.out.println(board.toString());
     	
     	popularBoardRepository.saveAndFlush(board);
     	
     	
 		return "redirect:/community/{program}/{popular}";
 	}	
    
    
}