package com.example.springbootapi.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapi.UUIDGenerator;
import com.example.springbootapi.bean.ProductloadDetails;
import com.example.springbootapi.controller.ProductLoadController;
import com.example.springbootapi.service.ProductLoadServiceInterface;

@RestController
public class ProductLoadControllerImpl implements ProductLoadController
{
	@Autowired
	private ProductLoadServiceInterface serviceinterface;

	@Override
	public String save(@RequestBody ProductloadDetails productloaddetails)
	{
		productloaddetails.setShipperId(UUIDGenerator.getUUID());
		serviceinterface.save(productloaddetails);
		return "loads details added successfully";
	}

	@Override
	public ProductloadDetails getProductDetailsByID(@PathVariable("loadId") int loadId)
	{
		return serviceinterface.getProductDetailsByID(loadId);
	}

	@Override
	public List<ProductloadDetails> getProductDetails(@RequestParam(name = "shipperId") String shipperId)
	{
		return serviceinterface.getProductDetails(shipperId);
	}

	@Override
	public void UpdateProductloadDetails(@PathVariable("loadId") int loadId, @RequestBody ProductloadDetails productloaddetails)
	{
		serviceinterface.UpdateProductloadDetails(loadId, productloaddetails);
	}

	@Override
	public void DeleteProductloadDetailsRecord(@PathVariable("loadId") int loadId)
	{
		serviceinterface.DeleteProductloadDetailsRecord(loadId);
	}
}
