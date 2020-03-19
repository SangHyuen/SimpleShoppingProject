package com.shopping01.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.shopping01.domain.resultUserVO;
import com.shopping01.domain.returnVO;
import com.shopping01.domain.tokenVO;
import com.shopping01.domain.userVO;
import com.shopping01.repository.userDAOimpl;

//오프셋과 리미트를 사용해서 페이징 처리

@Repository
public class userService {

	@Autowired
	userDAOimpl userDAO;

	public int signup(userVO adduser) throws DataAccessException {
		return userDAO.signup(adduser);
	}

	public userVO selectUserbyEmail(String email) throws DataAccessException {
		return userDAO.selectUserbyEmail(email);
	}
	
	public int insertToken(tokenVO userTokenVO) throws DataAccessException {	
		return userDAO.insertToken(userTokenVO);
	}
	public tokenVO selectUserbyToken(String userToken) throws DataAccessException {
		
		return userDAO.selectUserbyToken(userToken);
	}

	public returnVO loginUser(userVO loginVO) {
		returnVO ReVO = new returnVO();
		userVO loginUser = new userVO();
		loginUser = selectUserbyEmail(loginVO.getEmail());
		resultUserVO reuser = new resultUserVO();
		if (loginUser != null) {
			if (loginUser.getPassword().equals(loginVO.getPassword())) {
				reuser.setUserId(loginUser.getUserId());
				reuser.setName(loginUser.getName());
				reuser.setEmail(loginUser.getEmail());
				reuser.setBirth(loginUser.getBirth());
				reuser.setGender(loginUser.getGender());
				ReVO.setCode("200");
				ReVO.setMessage("환영합니다 " + loginUser.getName() + "님");
				ReVO.setData(reuser);
			} else {
				ReVO.setCode("비밀번호 오류");
				ReVO.setMessage("로그인 정보가 올바르지 않습니다.");
			}
		} else {
			ReVO.setCode("No User");
			ReVO.setMessage("사용자 정보가 없습니다.");
		}
		return ReVO;
	}

	public returnVO addUser(userVO adduserVO) {
		returnVO reVO = new returnVO();
		String birth = adduserVO.getBirth();
		String age = birth.substring(0, 4);
		System.out.println("age = "+age);
		int intage = Integer.parseInt(age);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("year = "+year);
		int userAge = year - intage;
		userVO checkUser = new userVO();
		resultUserVO reuser = new resultUserVO();
		checkUser = userDAO.selectUserbyEmail(adduserVO.getEmail());
		if (checkUser != null) {
			reVO.setCode("Account Error");
			reVO.setMessage("Email중복입니다.");
		} else if (!adduserVO.getPassword().equals(adduserVO.getPasswordCheck())) {
			reVO.setCode("Password Error");
			reVO.setMessage("비밀번호가 일치하지 않습니다.");
		} else if (userAge < 7) {
			reVO.setCode("Age Error");
			reVO.setMessage("7세 미만은 가입할 수 없습니다.");
		} else {
			System.out.println(userAge);
			tokenVO userToken = new tokenVO();
			int result = signup(adduserVO);
			reVO.setCode("200");
			reVO.setMessage("회원가입성공");
			
			checkUser = userDAO.selectUserbyEmail(adduserVO.getEmail());
			userToken.setToken();
			userToken.setUserId(checkUser.getUserId());
			int tokenResult = insertToken(userToken);
			
			reuser.setName(checkUser.getName());
			reuser.setEmail(checkUser.getEmail());
			reuser.setBirth(checkUser.getBirth());
			reuser.setGender(checkUser.getGender());
			reVO.setData(reuser);
		}

		return reVO;
	}

}
