package com.shopping01.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.shopping01.domain.resultUserVO;
import com.shopping01.domain.tokenVO;
import com.shopping01.domain.userVO;


@Repository
public class userDAOimpl implements userDAO{
	
	@Autowired(required = true)
	private SqlSession sqlSession ;

	@Override
	public int signup(userVO adduser) throws DataAccessException {
		int addResult = sqlSession.insert("com.shopping01.mappers.userMapper.InsertUser",adduser);
		return addResult;
	}

	@Override
	public userVO selectUserbyEmail(String email) throws DataAccessException {
		userVO result  = sqlSession.selectOne("com.shopping01.mappers.userMapper.SelectUserbyEmail",email);
		return result;
	}
	
	@Override
	public int insertToken(tokenVO userTokenVO) throws DataAccessException {
		int addResult = sqlSession.insert("com.shopping01.mappers.userMapper.insertToken",userTokenVO);
		return addResult;
	}
	@Override
	public tokenVO selectUserbyToken(String userToken) throws DataAccessException {

		tokenVO result  = sqlSession.selectOne("com.shopping01.mappers.userMapper.selectUserbyToken",userToken);
		return result;
	}
}
	