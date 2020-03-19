package com.shopping01.controller;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shopping01.domain.returnVO;
import com.shopping01.domain.userVO;
import com.shopping01.service.userService;

@RestController
@RequestMapping(value = "/*")
public class userController {
	
	 static Logger logger = LoggerFactory.getLogger(userController.class);

	   @Autowired	
	   userVO userVO;
	   
	   @Autowired
	   userService userService;
	   
	   @RequestMapping(value = "/signup", method = RequestMethod.POST)
	   public ResponseEntity<returnVO> signInfo(@RequestBody userVO signVO) {
	      returnVO reVO = new returnVO();
	      ResponseEntity<returnVO> resEntity;

	      reVO = userService.addUser(signVO);
	      resEntity = new ResponseEntity<returnVO>(reVO, HttpStatus.OK);
	      return resEntity;
	   }
	   
	   @RequestMapping(value = "/login", method = RequestMethod.GET)
	   public ResponseEntity<returnVO> userInfo(@RequestBody userVO loginVO) {
	      returnVO reVO = new returnVO();
	      ResponseEntity<returnVO> resEntity;

	      reVO = userService.loginUser(loginVO);
	      resEntity = new ResponseEntity<returnVO>(reVO, HttpStatus.OK);
	      return resEntity;
	   }



}
