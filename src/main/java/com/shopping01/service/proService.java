package com.shopping01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.shopping01.domain.bannerVO;
import com.shopping01.domain.basketVO;
import com.shopping01.domain.productInfoVO;
import com.shopping01.domain.productVO;
import com.shopping01.domain.returnVO;
import com.shopping01.domain.tokenVO;
import com.shopping01.repository.proDAOimpl;

@Repository
public class proService {

	@Autowired
	proDAOimpl proDAO;
	
	@Autowired
	private userService userService;
	
	int bannerPageNum = 1;
	int proPageNum = 0;

	public bannerVO selectBanner(bannerVO banVO) throws DataAccessException {
		return proDAO.selectBanner(banVO);
	}

	public List<productVO> selectProduct(productVO pVO) throws DataAccessException {
		return proDAO.selectProduct(pVO);
	}

	public List<basketVO> selectBasket(int userId) throws DataAccessException {
		return proDAO.selectBasket(userId);
	}

	public int insertBasket(basketVO insertBasketVO) throws DataAccessException {
		return proDAO.insertBasket(insertBasketVO);
	}

	public int deleteBasket(basketVO deleteBasketVO) throws DataAccessException {
		return proDAO.deleteBasket(deleteBasketVO);
	}

	public List<productInfoVO> selectProductInfo(int productId) throws DataAccessException {
		return proDAO.selectProductInfo(productId);
	}

	public List<basketVO> selectBasketInfo() throws DataAccessException {
		return proDAO.selectBasketInfo();
	}
	
	public basketVO checkBasket(String token,int proId) {
		basketVO result = new basketVO();
		tokenVO selectToken = new tokenVO();
		selectToken = userService.selectUserbyToken(token);
		Integer userId = selectToken.getUserId();
		result.setUserId(userId);
		result.setProductId(proId);
		return result;
	}

	public returnVO returnBanner(returnVO ReVO) {
		bannerVO BannerVO = new bannerVO();
		if (bannerPageNum > 5) {
			bannerPageNum = 1;
		}
		BannerVO.setBannerId(bannerPageNum);
		BannerVO = selectBanner(BannerVO);
		bannerPageNum = bannerPageNum + 1;

		ReVO.setCode("200");
		ReVO.setMessage("Banner");
		ReVO.setData(BannerVO);

		return ReVO;
	}


	public returnVO ProductList(String userToken,int pageNum) {
//page넘버를 파라메터로 받아와서 해당 페이지 범위 출력하는 알고리즘.
		returnVO ReVO = new returnVO();
		productVO proVO = new productVO();
		tokenVO selectToken = new tokenVO();
		selectToken = userService.selectUserbyToken(userToken);
		Integer userId = selectToken.getUserId();
		
		List<basketVO> basketList = new ArrayList<basketVO>();
		List<productVO> resultList = new ArrayList<productVO>();
		if (pageNum == 1) {
			proPageNum = 0;
		}
		else {
			proPageNum = (pageNum-1)*6;
		}
		proVO.setProductId(proPageNum);
		resultList = selectProduct(proVO);
		if (userId != null) {
			basketList = selectBasket(userId);
			for (basketVO basVO : basketList) {
				for (productVO indexVO : resultList) {
					proPageNum = indexVO.getProductId();
					if (indexVO.getBasket() == null) {
						indexVO.setBasket("장바구니담기");
					}
					if (basVO.getProductId() == indexVO.getProductId()) {
						indexVO.setBasket("장바구니보기");
					}
				}
			}
		} else {
			for (productVO indexVO : resultList) {
				proPageNum = indexVO.getProductId();
			}
		}
		ReVO.setCode("200");
		ReVO.setMessage("proList");
		ReVO.setData(resultList);
		return ReVO;
	}

	public returnVO InsertBasketVO(basketVO paramVO) {
		returnVO ReVO = new returnVO();
		int result;
		result = insertBasket(paramVO);
		if (result == 1) {
			ReVO.setCode("200");
			ReVO.setMessage("Success");
			ReVO.setData("입력완료");
		} else {
			ReVO.setCode("500");
			ReVO.setMessage("Error");
			ReVO.setData("입력실패, 잠시후 다시 시도하여 주십시오");
		}
		return ReVO;
	}

	public returnVO DeleteBasketVO(basketVO paramVO) {
		returnVO ReVO = new returnVO();
		int result;
		result = deleteBasket(paramVO);
		if (result == 1) {
			ReVO.setCode("200");
			ReVO.setMessage("Success");
			ReVO.setData("삭제완료");
		} else {
			ReVO.setCode("500");
			ReVO.setMessage("Error");
			ReVO.setData("삭제실패, 잠시후 다시 시도하여 주십시오");
		}
		return ReVO;
	}

	public returnVO ProductInfo(int proId,String userToken) {

		returnVO ReVO = new returnVO();
		productVO proVO = new productVO();
		List<basketVO> basketList = new ArrayList<basketVO>();
		List<productInfoVO> resultInfoList = new ArrayList<productInfoVO>();
		tokenVO selectToken = new tokenVO();
		selectToken = userService.selectUserbyToken(userToken);
		Integer userId = selectToken.getUserId();
		basketList = selectBasket(userId);
		proVO.setProductId(proPageNum);
		resultInfoList = selectProductInfo(proId);
		System.out.println(resultInfoList);
		for (basketVO basVO : basketList) {
			for (productInfoVO indexVO : resultInfoList) {
				if (indexVO.getBasket() == null) {
					indexVO.setBasket("장바구니담기");
				}
				if (basVO.getProductId() == indexVO.getProductId()) {
					indexVO.setBasket("장바구니보기");
					System.out.println("if문실행완료");
				}
			}
		}
		ReVO.setCode("200");
		ReVO.setMessage("proList");
		ReVO.setData(resultInfoList);
		return ReVO;
	}

	public returnVO BasketInfo(int userId) {
		List<basketVO> resultList = new ArrayList<basketVO>();
		List<basketVO> returnList = new ArrayList<basketVO>();
		returnVO ReVO = new returnVO();
		resultList = selectBasketInfo();
		for (basketVO indexVO : resultList) {
			if (indexVO.getUserId() == userId) {
				returnList.add(indexVO);
			}
		}
		if (resultList != null) {
			ReVO.setCode("200");
			ReVO.setMessage("Success");
			ReVO.setData(returnList);
		} else {
			ReVO.setCode("500");
			ReVO.setMessage("Error");
			ReVO.setData("조회실패, 잠시후 다시 시도하여 주십시오");
		}
		return ReVO;
	}

}
