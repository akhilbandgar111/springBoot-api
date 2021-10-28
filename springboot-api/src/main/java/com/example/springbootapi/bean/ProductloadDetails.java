package com.example.springbootapi.bean;

import org.springframework.stereotype.Component;

@Component
public class ProductloadDetails
{
	private int loadId;
	private String loadingPoint;
	private String unloadingPoint;
	private String productType;
	private String truckType;
	private int noOfTrucks;
	private float weight;
	private String optional;
	private String date;
	private String shipperId;

	public int getLoadId()
	{
		return loadId;
	}

	public void setLoadId(int loadId)
	{
		this.loadId = loadId;
	}

	public String getLoadingPoint()
	{
		return loadingPoint;
	}

	public void setLoadingPoint(String loadingPoint)
	{
		this.loadingPoint = loadingPoint;
	}

	public String getUnloadingPoint()
	{
		return unloadingPoint;
	}

	public void setUnloadingPoint(String unloadingPoint)
	{
		this.unloadingPoint = unloadingPoint;
	}

	public String getProductType()
	{
		return productType;
	}

	public void setProductType(String productType)
	{
		this.productType = productType;
	}

	public String getTruckType()
	{
		return truckType;
	}

	public void setTruckType(String truckType)
	{
		this.truckType = truckType;
	}

	public int getNoOfTrucks()
	{
		return noOfTrucks;
	}

	public void setNoOfTrucks(int noOfTrucks)
	{
		this.noOfTrucks = noOfTrucks;
	}

	public float getWeight()
	{
		return weight;
	}

	public void setWeight(float weight)
	{
		this.weight = weight;
	}

	public String getOptional()
	{
		return optional;
	}

	public void setOptional(String optional)
	{
		this.optional = optional;
	}

	public String getShipperId()
	{
		return shipperId;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public void setShipperId(String shipperId)
	{
		this.shipperId = shipperId;
	}

	@Override
	public String toString()
	{
		return "Payload [loadingPoint=" + loadingPoint + ", unloadingPoint=" + unloadingPoint + ", productType=" + productType + ", truckType="
				+ truckType + ", noOfTrucks=" + noOfTrucks + ", weight=" + weight + ", optional=" + optional + ", Date=" + date + ", shipperId="
				+ shipperId + "]";
	}

}
