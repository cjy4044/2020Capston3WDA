package com.vote.vote.goodsshop.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.vote.vote.db.dto.Prd;
import com.vote.vote.repository.Asdf;
import com.vote.vote.repository.PrdCateDJpaRepository;
import com.vote.vote.repository.PrdJpaRepository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class ShopController {

	@Autowired
	PrdJpaRepository prdRepository;
	@Autowired
	PrdCateDJpaRepository prdCateDJpaRepository;
	@Autowired
	Asdf asdf;
	@RequestMapping("/shop/index")
	public String index(Model model) {

		
		
		
		model.addAttribute("cate2", prdCateDJpaRepository.findCategory_dByCategory(2));
		model.addAttribute("cate3", prdCateDJpaRepository.findCategory_dByCategory(3));
		model.addAttribute("cate4", prdCateDJpaRepository.findCategory_dByCategory(4));
		model.addAttribute("cate5", prdCateDJpaRepository.findCategory_dByCategory(5));
		model.addAttribute("cate6", prdCateDJpaRepository.findCategory_dByCategory(6));
		return "shop/index";

	}

	@RequestMapping("/shop/cart")
	public String cart() {

		return "asdf";
	}

	@RequestMapping("/shop/cart/axios")
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