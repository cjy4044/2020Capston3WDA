package com.vote.vote.goodsshop.controller;

import com.vote.vote.repository.Asdf;
import com.vote.vote.repository.PrdCateDJpaRepository;
import com.vote.vote.repository.PrdJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

		
		System.out.println(asdf.asdf());
		
		model.addAttribute("cate2", prdCateDJpaRepository.findCategory_dByCategory(2));
		model.addAttribute("cate3", prdCateDJpaRepository.findCategory_dByCategory(3));
		model.addAttribute("cate4", prdCateDJpaRepository.findCategory_dByCategory(4));
		model.addAttribute("cate5", prdCateDJpaRepository.findCategory_dByCategory(5));
		model.addAttribute("cate6", prdCateDJpaRepository.findCategory_dByCategory(6));
		return "shop/index";

	}

	@RequestMapping("/shop/cart")
	public String cart() {
		return "shop/cart";
	}
}