package com.vote.vote.controller;

import java.security.Principal;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vote.vote.db.dto.Program;
import com.vote.vote.repository.ProgramJpaRepository;

@Controller
@RequestMapping("/community")
public class CommunityController {

	@Autowired
	ProgramJpaRepository programRepository;
	
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
		System.out.println("프로그램 json 넘김");
		return result;
	}
	
	
}