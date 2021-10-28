package com.example.springbootapi.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springbootapi.bean.ProductloadDetails;

public interface ProductLoadController
{
	@RequestMapping(value = "/load/{loadId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductloadDetails getProductDetailsByID(@PathVariable("loadId") int loadId);

	@RequestMapping(value = "/load", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductloadDetails> getProductDetails(@RequestParam(name = "shipperId") String shipperId);

	@RequestMapping(value = "/load", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String save(ProductloadDetails productDetails);

	@RequestMapping(value = "/load/{loadId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void UpdateProductloadDetails(@PathVariable("loadId") int loadId, @RequestBody ProductloadDetails productloaddetails);

	@RequestMapping(value = "/load/{loadId}", method = RequestMethod.DELETE)
	public void DeleteProductloadDetailsRecord(@PathVariable("loadId") int loadId);
}
