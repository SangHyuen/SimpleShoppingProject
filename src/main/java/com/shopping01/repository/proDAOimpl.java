package com.shopping01.repository;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.shopping01.domain.bannerVO;
import com.shopping01.domain.basketVO;
import com.shopping01.domain.productInfoVO;
import com.shopping01.domain.productVO;


@Repository
public class proDAOimpl implements proDAO{
	
	@Autowired(required = true)
	private SqlSession sqlSession ;
	
	@Override
	public bannerVO selectBanner(bannerVO banVO) throws DataAccessException {
		bannerVO result  = sqlSession.selectOne("com.shopping01.mappers.proMapper.selectBanner",banVO.getBannerId());
		return result;
	}
	@Override
	public List<productVO> selectProduct(productVO pVO) throws DataAccessException {
		List<productVO> result  = sqlSession.selectList("com.shopping01.mappers.proMapper.selectProduct",pVO);
		return result;
	}
	@Override
	public List<basketVO> selectBasket(int userId) throws DataAccessException {
		List<basketVO> result  = sqlSession.selectList("com.shopping01.mappers.proMapper.selectBasket",userId);
		return result;
	}
	@Override
	public int insertBasket(basketVO insertBasketVO) throws DataAccessException {
		int result  = sqlSession.insert("com.shopping01.mappers.proMapper.insertBasket",insertBasketVO);
		return result;
	}
	@Override
	public int deleteBasket(basketVO deleteBasketVO) throws DataAccessException {
		int result  = sqlSession.delete("com.shopping01.mappers.proMapper.deleteBasket",deleteBasketVO);
		return result;
	}
	@Override
	public List<productInfoVO> selectProductInfo(int productId) throws DataAccessException {
		List<productInfoVO> result  = sqlSession.selectList("com.shopping01.mappers.proMapper.selectProductInfo",productId);
		return result;
	}
	@Override
	public List<basketVO> selectBasketInfo() throws DataAccessException {
		List<basketVO> result  = sqlSession.selectList("com.shopping01.mappers.proMapper.selectBasketInfo");
		return result;
	}


}
