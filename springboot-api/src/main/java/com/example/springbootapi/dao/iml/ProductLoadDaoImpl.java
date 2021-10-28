package com.example.springbootapi.dao.iml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springbootapi.bean.ProductloadDetails;
import com.example.springbootapi.dao.ProductLoadDao;
import com.example.springbootapi.util.DBConnection;
import com.example.springbootapi.util.ProductConstant;

@Repository
public class ProductLoadDaoImpl implements ProductLoadDao

{
	@Override
	public void save(ProductloadDetails productloaddetails)
	{
		Connection con = null;

		try
		{
			con = DBConnection.getConnection();
			String sql = "insert into product_load_details(loading_Point,unloading_Point,product_Type,truck_Type,noOf_Trucks,weight,optional,shipper_Id,Date,is_deleted)values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, productloaddetails.getLoadingPoint());
			pst.setString(2, productloaddetails.getUnloadingPoint());
			pst.setString(3, productloaddetails.getProductType());
			pst.setString(4, productloaddetails.getTruckType());
			pst.setInt(5, productloaddetails.getNoOfTrucks());
			pst.setFloat(6, productloaddetails.getWeight());
			pst.setString(7, productloaddetails.getOptional());
			pst.setString(8, productloaddetails.getShipperId());
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			Date utilDate = formatter1.parse(productloaddetails.getDate());
			pst.setDate(9, new java.sql.Date(utilDate.getTime()));
			pst.setInt(10, 0);
			pst.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public ProductloadDetails getProductDetailsByID(int loadId)
	{
		Connection con = null;
		try
		{
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			String sql = "Select loading_Point,unloading_Point,product_Type,truck_Type,noOf_Trucks,weight,optional,shipper_Id,Date from 	product_load_details where load_Id=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, loadId);
			ResultSet rs = stm.executeQuery();
			ProductloadDetails productloaddetails = new ProductloadDetails();

			while (rs.next())
			{
				productloaddetails.setLoadingPoint(rs.getString(ProductConstant.LOADING_POINT));
				productloaddetails.setUnloadingPoint(rs.getString(ProductConstant.UNLOADING_POINT));
				productloaddetails.setProductType(rs.getString(ProductConstant.PRODUCT_TYPE));
				productloaddetails.setTruckType(rs.getString(ProductConstant.TRUCK_TYPE));
				productloaddetails.setNoOfTrucks(rs.getInt(ProductConstant.NOOF_TRUCKS));
				productloaddetails.setWeight(rs.getInt(ProductConstant.WEIGHT));
				productloaddetails.setOptional(rs.getString(ProductConstant.OPTIONAL));
				productloaddetails.setShipperId(rs.getString(ProductConstant.SHIPPER_ID));
				productloaddetails.setDate(rs.getString(ProductConstant.DATE));
			}
			return productloaddetails;

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<ProductloadDetails> getProductDetails(String shipperId)
	{
		Connection con = null;
		List<ProductloadDetails> list = new ArrayList<>();
		try
		{
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			String sql = "Select loading_Point,unloading_Point,product_Type,truck_Type,noOf_Trucks,weight,optional,shipper_Id,Date from 	product_load_details where shipper_Id=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, shipperId);
			ResultSet rs = stm.executeQuery();

			while (rs.next())
			{
				ProductloadDetails productloaddetails = new ProductloadDetails();
				productloaddetails.setLoadingPoint(rs.getString(ProductConstant.LOADING_POINT));
				productloaddetails.setUnloadingPoint(rs.getString(ProductConstant.UNLOADING_POINT));
				productloaddetails.setProductType(rs.getString(ProductConstant.PRODUCT_TYPE));
				productloaddetails.setTruckType(rs.getString(ProductConstant.TRUCK_TYPE));
				productloaddetails.setNoOfTrucks(rs.getInt(ProductConstant.NOOF_TRUCKS));
				productloaddetails.setWeight(rs.getInt(ProductConstant.WEIGHT));
				productloaddetails.setOptional(rs.getString(ProductConstant.OPTIONAL));
				productloaddetails.setShipperId(rs.getString(ProductConstant.SHIPPER_ID));
				productloaddetails.setDate(rs.getString(ProductConstant.DATE));
				list.add(productloaddetails);
			}
			return list;

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void UpdateProductloadDetails(int loadId, ProductloadDetails productloaddetails)
	{
		Connection con = null;

		try
		{
			con = DBConnection.getConnection();
			String sql = "UPDATE product_load_details SET  loading_point=?, unloading_point=?, product_type=?, truck_type=?, noof_trucks=?, weight=?, optional=?, shipper_id=?, date=? WHERE load_id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, productloaddetails.getLoadingPoint());
			pst.setString(2, productloaddetails.getUnloadingPoint());
			pst.setString(3, productloaddetails.getProductType());
			pst.setString(4, productloaddetails.getTruckType());
			pst.setInt(5, productloaddetails.getNoOfTrucks());
			pst.setFloat(6, productloaddetails.getWeight());
			pst.setString(7, productloaddetails.getOptional());
			pst.setString(8, productloaddetails.getShipperId());
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
			Date utilDate = formatter1.parse(productloaddetails.getDate());
			pst.setDate(9, new java.sql.Date(utilDate.getTime()));
			pst.setInt(10, loadId);
			pst.executeUpdate();

		} catch (Exception e)
		{

			e.printStackTrace();
		}
	}

	@Override
	public void DeleteProductloadDetailsRecord(int loadId)
	{
		Connection con = null;
		try
		{
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			String sql = "update product_load_details set is_deleted=? where load_id=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, 1);
			stm.setInt(2, loadId);
			stm.executeUpdate();
			con.commit();
		} catch (SQLException e)
		{
			try
			{
				con.rollback();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
