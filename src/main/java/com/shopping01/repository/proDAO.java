package com.shopping01.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.shopping01.domain.bannerVO;
import com.shopping01.domain.basketVO;
import com.shopping01.domain.productInfoVO;
import com.shopping01.domain.productVO;

public interface proDAO {

	bannerVO selectBanner(bannerVO banVO) throws DataAccessException;

	List<productVO> selectProduct(productVO pVO) throws DataAccessException;

	List<basketVO> selectBasket(int userId) throws DataAccessException;

	int insertBasket(basketVO insertBasketVO) throws DataAccessException;

	int deleteBasket(basketVO deleteBasketVO) throws DataAccessException;

	List<productInfoVO> selectProductInfo(int productId) throws DataAccessException;

	List<basketVO> selectBasketInfo() throws DataAccessException;

}
