package com.vote.vote.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.vote.vote.config.CustomUserDetails;
import com.vote.vote.db.dto.Prd;
import com.vote.vote.db.dto.PrdCategory;
import com.vote.vote.db.dto.PrdCategoryD;
import com.vote.vote.db.dto.PrdColor;
import com.vote.vote.db.dto.PrdImage;
import com.vote.vote.db.dto.PrdOption;
import com.vote.vote.db.dto.PrdSize;
import com.vote.vote.db.dto.ProgramManager;
import com.vote.vote.repository.Asdf;
import com.vote.vote.repository.PrdCateDJpaRepository;
import com.vote.vote.repository.PrdCategoryDJpaRepository;
import com.vote.vote.repository.PrdCategoryJpaRepository;
import com.vote.vote.repository.PrdColorJpaRepository;
import com.vote.vote.repository.PrdImageJpaRepository;
import com.vote.vote.repository.PrdJpaRepository;
import com.vote.vote.repository.PrdOptionJpaRepository;
import com.vote.vote.repository.PrdSizeJpaRepository;
import com.vote.vote.repository.ProgramManagerJpaRepository;
import com.vote.vote.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@Autowired
	private PrdCategoryJpaRepository  prdCategoryRepository;

	@Autowired
	private PrdCategoryDJpaRepository prdCategoryDRepository;

	@Autowired
	private PrdColorJpaRepository prdColorRepository;

	@Autowired
	private PrdSizeJpaRepository prdSizeRepository;

	@Autowired
	private ProgramManagerJpaRepository pManagerRepository;

	@Autowired
	private PrdImageJpaRepository pImageRepository;

	@Autowired
	private PrdOptionJpaRepository pOptionRepository;
	
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
	public String store(
		@RequestParam("category") int category, //카테고리
		@RequestParam("categoryD") int categoryD, // 세부 카테고리
		@RequestParam("endTime") String endTime, // 판매 종료날짜
		@RequestParam("title") String title, // 상품명
		@RequestParam("info1") String info1, // 간단설명
		@RequestParam("info2") String info2, // 상세설명
		@RequestParam("price") int price, // 가격
		@RequestParam("stock") int stock, // 재고 
		@RequestParam("file1") MultipartFile file1,//대표이미지
		@RequestParam("file2") MultipartFile[] file2,//부가 이미지
		@Nullable @RequestParam("file3") MultipartFile[] file3, // 설명이미지endTime,
		@Nullable @RequestParam("optionColor") int[] optionColor,
		@Nullable @RequestParam("optionSize") int[] optionSize,
		@Nullable @RequestParam("optionTitle") String[] optionTitle,
		@Nullable @RequestParam("optionPrice") int[] optionPrice,
		@Nullable @RequestParam("optionStock") int[] optionStock,
		Principal user,
		Authentication authentication

	 ){// 상품 생성 뷰
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

		ProgramManager pManager = pManagerRepository.findById(userDetails.getR_ID());

		// 상품 저장

		Prd product = new Prd();

		product.setPROGRAM_ID(pManager.getProgramId());// 프로그램 id 
		product.setCATEGORY_ID(category);  // 카테고리 id
		product.setProduct_category_d(categoryD); // 세부 카테고리 id
		product.setP_MANAGER(userDetails.getR_ID()); // 매니저 아이디
		product.setP_NAME(title); // 상품명
		product.setP_CONTENT(info1); // 상품 간단 설묭
		product.setP_DETAIL(info2); // 상품 상세 설명
		product.setP_PRICE(price); // 상품 가격
		product.setP_STATE("0"); // 상품 판매 상태   (임시)
		product.setP_ENDDATE(endTime); // 상품 판매 종료 날짜
		
		prdRepository.saveAndFlush(product);


		// 상품 이미지 저장

		ArrayList<String> file2Name = new ArrayList<String>();
		ArrayList<String> file3Name = new ArrayList<String>();
		
		
		String file1Name= storageService.store2(file1);


		// // 파일 저장
		for(int i=0;i<file2.length;i++){
			file2Name.add(storageService.store2(file2[i]));		// 파일 저장 및 파일 이름을 배열에 저장
		}

		for(int i=0;i<file3.length;i++){
			file3Name.add(storageService.store2(file2[i]));		// 파일 저장 및 파일 이름을 배열에 저장
		}

		

		PrdImage prdImg = new PrdImage();
		prdImg.setProductId(product.getPRODUCT_ID());
		prdImg.setProductImage(file1Name);
		prdImg.setImageState("0");// 대표 이미지 0	
		pImageRepository.saveAndFlush(prdImg);

		for(String name: file2Name){
			PrdImage Img = new PrdImage();
			Img.setProductId(product.getPRODUCT_ID());
			Img.setProductImage(name);
			Img.setImageState("0");// 대표 이미지 0	
			pImageRepository.saveAndFlush(Img);
		}

		try{ // 상품 설명 이미지는 선택 사항
			if(file3Name != null){
				for(String name: file3Name){
					PrdImage Img = new PrdImage();
					Img.setProductId(product.getPRODUCT_ID());
					Img.setProductImage(name);
					Img.setImageState("0");// 대표 이미지 0	
					pImageRepository.saveAndFlush(Img);
				}
			}
			
		}catch(NullPointerException e){
			System.out.println("상품 설명 이미지 없음");
		}
		

		try{
			// 상품 옵션 저장

			if(optionColor != null){
				for(int i =0; i<optionColor.length; i++){
					PrdOption pOption = new PrdOption();
					pOption.setColorId(optionColor[i]);
					pOption.setSizeId(optionSize[i]);
					pOption.setProductId(product.getPRODUCT_ID());
					pOption.setoPrice(optionPrice[i]);
					pOption.setoTitle(optionTitle[i]);
					pOption.setpStock(optionStock[i]);
					pOptionRepository.saveAndFlush(pOption);
				}
			}
			
		}catch(NullPointerException e){
			System.out.println("상품 옵션 선택사항");
		}
		
		
		


		return "redirect:/userInfo";
	}

	@RequestMapping(value={"/shop/store/axios","/shop/store/axios/"})// 상품저장
	@ResponseBody
	public JSONArray categoryAxios(){// 상품 생성 뷰
		JSONArray categorys = new JSONArray();

		// 카테고리 가져옴.
		List<PrdCategory> category = prdCategoryRepository.findAll();
		List<PrdCategoryD> categoryD = prdCategoryDRepository.findAll();

		categorys.add(0,category);
		categorys.add(1,categoryD);

		//상품 옵션 가져옴

		List<PrdColor> color = prdColorRepository.findAll();
		List<PrdSize> size = prdSizeRepository.findAll();

		categorys.add(2,color);
		categorys.add(3,size);
		
		

		return categorys;
	}
}