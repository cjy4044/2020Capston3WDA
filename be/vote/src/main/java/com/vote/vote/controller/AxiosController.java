package com.vote.vote.controller;

import java.util.ArrayList;
import java.util.List;

import com.vote.vote.db.dto.Prd;
import com.vote.vote.repository.Asdf;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AxiosController {
    // @Autowired
	// Asdf asdf;
	// @Autowired
	// ProgramJpaRepository programjpa;
    
    // @RequestMapping("/shop/index/axios")
	// @ResponseBody
	// public JSONObject retrunprd() {
	// 	List<Prd> prdlist = asdf.asdf();
	// 	List<Program> prolist = programjpa.findAll();
		
	// 	JSONObject obj = new JSONObject();
	// 	JSONArray json = new JSONArray();
	// 	JSONArray json2 = new JSONArray();
	// 	JSONObject finalobj = new JSONObject();
		



	// 	for(Prd prdlist2:prdlist){	
	// 		obj = new JSONObject();	
	// 		obj.put("name", prdlist2.getP_NAME());
	// 		obj.put("price", prdlist2.getP_PRICE());
	// 		obj.put("img", prdlist2.getP_UPLOAD());	
	// 		json.add(obj);		
	// 	}
	// 	finalobj.put("prd", json);
		
		
	// 	for(Program prolist2:prolist){		
	// 		obj = new JSONObject();
	// 		obj.put("proname", prolist2.getName());
	// 		obj.put("proid", prolist2.getId());	
	// 		json2.add(obj);
	// 	}
	// 	finalobj.put("pro", json2);
		
	// 	System.out.println(finalobj);

	// 	return finalobj;
	// }
}