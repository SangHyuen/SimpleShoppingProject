package com.shopping01.controller;

import org.apache.ibatis.annotations.Param;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping01.domain.basketVO;
import com.shopping01.domain.returnVO;
import com.shopping01.service.proService;

@RestController
@RequestMapping(value = "/*")
public class proController {

	static Logger logger = LoggerFactory.getLogger(userController.class);

	@Autowired
	proService proService;


	@RequestMapping(value = "/clickbanner", method = RequestMethod.POST)
	public ResponseEntity<returnVO> banner() {
		returnVO reVO = new returnVO();
		ResponseEntity<returnVO> resEntity;

		reVO = proService.returnBanner(reVO);
		resEntity = new ResponseEntity<returnVO>(reVO, HttpStatus.OK);
		return resEntity;
	}

	@RequestMapping(value = "/proList", method = RequestMethod.GET)
	public ResponseEntity<returnVO> proList(@CookieValue(value = "Token", required = false) String userToken,
			@Param(value = "pageNum") int pageNum) {
		returnVO reVO = new returnVO();
		ResponseEntity<returnVO> resEntity;

		reVO = proService.ProductList(userToken,pageNum);
		resEntity = new ResponseEntity<returnVO>(reVO, HttpStatus.OK);
		return resEntity;
	}

	@RequestMapping(value = "/basket", method = RequestMethod.POST)
	public ResponseEntity<returnVO> insertBasket(@CookieValue(value = "Token") String userToken,
			@Param(value = "productId") int proID) {
		basketVO insertBasketVO = new basketVO();
		insertBasketVO = proService.checkBasket(userToken, proID);
		returnVO reVO = new returnVO();
		ResponseEntity<returnVO> resEntity;

		reVO = proService.InsertBasketVO(insertBasketVO);
		resEntity = new ResponseEntity<returnVO>(reVO, HttpStatus.OK);
		return resEntity;
	}

	@RequestMapping(value = "/basket", method = RequestMethod.DELETE)
	public ResponseEntity<returnVO> deleteBasket(@CookieValue(value = "Token") String userToken,
			@Param(value = "productId") int proID) {
		basketVO deleteBasketVO = new basketVO();
		deleteBasketVO = proService.checkBasket(userToken, proID);
		returnVO reVO = new returnVO();
		ResponseEntity<returnVO> resEntity;

		reVO = proService.DeleteBasketVO(deleteBasketVO);
		resEntity = new ResponseEntity<returnVO>(reVO, HttpStatus.OK);
		return resEntity;
	}

	@RequestMapping(value = "/proInfo", method = RequestMethod.GET)
	public ResponseEntity<returnVO> productInfo(@CookieValue(value = "Token") String userToken,
			@Param(value = "productId") int proID) {

		returnVO reVO = new returnVO();
		ResponseEntity<returnVO> resEntity;
		if (userToken .equals(null)) {
			reVO.setCode("404");
			reVO.setMessage("제품 상세보기는 로그인 하셔야 사용하실 수 있습니다");
			reVO.setData(null);
		} else {

			reVO = proService.ProductInfo(proID, userToken);
		}
		resEntity = new ResponseEntity<returnVO>(reVO, HttpStatus.OK);
		return resEntity;
	}
	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public ResponseEntity<returnVO> basketInfo(@CookieValue(value = "userId") int userID) {
		
		returnVO reVO = new returnVO();
		ResponseEntity<returnVO> resEntity;

		reVO = proService.BasketInfo(userID);
		resEntity = new ResponseEntity<returnVO>(reVO, HttpStatus.OK);
		return resEntity;
	}
	
}