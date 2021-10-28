package com.example.springbootapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootapi.bean.ProductloadDetails;
import com.example.springbootapi.dao.ProductLoadDao;
import com.example.springbootapi.service.ProductLoadServiceInterface;

@Service
public class ProductLoadServiceInterfaceImpl implements ProductLoadServiceInterface
{
	@Autowired
	private ProductLoadDao productLoadDao;

	@Override
	public void save(ProductloadDetails productloaddetails)
	{
		productLoadDao.save(productloaddetails);
	}

	@Override
	public ProductloadDetails getProductDetailsByID(int loadId)
	{
		return productLoadDao.getProductDetailsByID(loadId);
	}

	@Override
	public List<ProductloadDetails> getProductDetails(String shipperId)
	{
		return productLoadDao.getProductDetails(shipperId);
	}

	@Override
	public void UpdateProductloadDetails(int loadId, ProductloadDetails productloaddetails)
	{
		productLoadDao.UpdateProductloadDetails(loadId, productloaddetails);
	}

	@Override
	public void DeleteProductloadDetailsRecord(int loadId)
	{
		productLoadDao.DeleteProductloadDetailsRecord(loadId);
	}
}
