package com.exittest.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exittest.backend.dao.ProductDao;
import com.exittest.backend.dao.ServiceavailibilityDao;
import com.exittest.backend.model.Product;
import com.exittest.backend.model.Serviceavailibility;


@Service
public class ServiceavailibilityService {
	@Autowired
	private ServiceavailibilityDao serviceavailibilityDao;
	@Autowired
	private ProductDao productDao;
	public List<Serviceavailibility>  getProductByService(Long pincode)
	{
//		List <Product> product= productDao.findByProductId(productId);
		List<Serviceavailibility> product= this.serviceavailibilityDao.findByPincode(pincode);
//		if (product!=null){
//			Object ser=((Product) product).getService().stream().filter(x ->(x.getPincode()==pincode)).findAny();
//		}
		

		return product;
		
	}
}
