package com.vote.vote.controller;

import java.security.Principal;
import java.util.ArrayList;

import com.vote.vote.repository.Asdf;
import com.vote.vote.repository.PrdCateDJpaRepository;
import com.vote.vote.repository.PrdJpaRepository;
import com.vote.vote.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.minidev.json.JSONArray;




@Controller
public class ShopController {

	@Autowired
	PrdJpaRepository prdRepository;
	@Autowired
	PrdCateDJpaRepository prdCateDJpaRepository;
	@Autowired
	Asdf asdf;
	
	@Autowired  
	private StorageService storageService; 
	
	
	@RequestMapping("/shop/index")
	public String index(Model model,Principal user) {
//		model.addAttribute("username",user.getName());
		
		return "shop/index";

	}

	@RequestMapping("/shop/cart")
	public String cart() {

		return "asdf";
	}
	@RequestMapping(value={"/shop/create","/shop/create/"})
	public String create(){// 상품 생성 뷰

		return "/shop/create";
	}
	@RequestMapping(value={"/shop/create/axios","/shop/create/axios/"})
	@ResponseBody
	public JSONArray createAxios(){// 상품 생성 뷰
		JSONArray datas = new JSONArray();

		

		return datas;
	}
	@RequestMapping(value={"/shop/store","/shop/store/"})// 상품저장
	public String store(@RequestParam("title") String title,
		@RequestParam("info1") String info1,
		@RequestParam("info2") String info2,
		@RequestParam("file1") MultipartFile file1,//대표이미지
		@RequestParam("file2") MultipartFile[] file2,//부가 이미지
		@Nullable @RequestParam("file3") MultipartFile[] file3 // 설명이미지
	 ){// 상품 생성 뷰
		ArrayList<String> fileName = new ArrayList<String>();
		
		storageService.store(file1);
		String file1Name= StringUtils.cleanPath(file1.getOriginalFilename());

		for(int i=0;i<file2.length;i++){
			storageService.store(file2[i]);   // 파일 저장
			fileName.add(StringUtils.cleanPath(file2[i].getOriginalFilename()));		// 파일 이름을 배열에 저장
		}

		for(int i=0;i<file3.length;i++){
			storageService.store(file3[i]);   // 파일 저장
			fileName.add(StringUtils.cleanPath(file3[i].getOriginalFilename()));		// 파일 이름을 배열에 저장
		}


		return "redirect:/userInfo";
	}

	// @RequestMapping("/shop/cart/axios")
	// @ResponseBody
	// public JSONArray react() {
	// 	List<Prd> prd = asdf.asdf();
	// 	JSONArray json = new JSONArray();
	// 	for(Prd prd2:prd){
	// 		JSONObject obj = new JSONObject();
	// 		obj.put("name", prd2.getP_NAME());
	// 		obj.put("price", prd2.getP_PRICE());
	// 		obj.put("img", prd2.getP_UPLOAD());
	// 		json.add(obj);
	// 	}
	// 	return json;
	// }
}