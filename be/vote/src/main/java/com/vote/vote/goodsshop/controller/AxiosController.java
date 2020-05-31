package com.vote.vote.goodsshop.controller;

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
    @Autowired
    Asdf asdf;
    
    @RequestMapping("/shop/index/axios")
	@ResponseBody
	public JSONArray react() {
		List<Prd> prd = asdf.asdf();
		JSONArray json = new JSONArray();
		for(Prd prd2:prd){
			JSONObject obj = new JSONObject();
			obj.put("name", prd2.getP_NAME());
			obj.put("price", prd2.getP_PRICE());
			obj.put("img", prd2.getP_UPLOAD());
			json.add(obj);
		}
		return json;
	}
}