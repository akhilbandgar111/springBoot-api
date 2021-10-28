package com.example.springbootapi.dao;

import java.util.List;

import com.example.springbootapi.bean.ProductloadDetails;

public interface ProductLoadDao
{
	public void save(ProductloadDetails payload);

	public ProductloadDetails getProductDetailsByID(int loadId);

	public List<ProductloadDetails> getProductDetails(String shipperId);

	public void UpdateProductloadDetails(int loadId, ProductloadDetails productloaddetails);

	public void DeleteProductloadDetailsRecord(int loadId);
}
