package com.shopping01.repository;

import org.springframework.dao.DataAccessException;

import com.shopping01.domain.resultUserVO;
import com.shopping01.domain.tokenVO;
import com.shopping01.domain.userVO;

public interface userDAO {

	int signup(userVO adduser) throws DataAccessException;

	userVO selectUserbyEmail(String email) throws DataAccessException;

	int insertToken(tokenVO userTokenVO) throws DataAccessException;

	tokenVO selectUserbyToken(String userToken) throws DataAccessException;

}
