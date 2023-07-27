package com.LoginLogout.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.LoginLogout.Exception.ResourceNotFoundException;
import com.LoginLogout.Model.Mobile;
import com.LoginLogout.Repository.MobileRepo;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	private MobileRepo mobileRepo;

	@Override
	public Mobile addMobile(Mobile mobile) {
		Mobile mobilePhone = this.mobileRepo.save(mobile);
		return mobilePhone;
	}

	@Override
	public List<Mobile> getMobiles() {
		List<Mobile> findAll = this.mobileRepo.findAll();
		return findAll;
	}

	@Override
	public Mobile findById(Long id) {
		Mobile mobiles = this.mobileRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Id","Id", id));
		return mobiles;
	}

	@Override
	public void deleteMobile(Long id) {
		Mobile delete = this.mobileRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Id","Id",id));
		this.mobileRepo.delete(delete);
	}

	@Override
	public Mobile UpdateMobile(Long id) {
		Mobile update = this.mobileRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Id","Id", id));
		return update;
		
		
	}

	@Override
	public Mobile updatePatch(long id, Map<String, Object> fields) {
		Mobile existing = this.findById(id);
		fields.forEach((key,value)->{
			Field filed = ReflectionUtils.findRequiredField(Mobile.class, key);
			filed.setAccessible(true);
			ReflectionUtils.setField(filed, existing, value);
		});
		return this.mobileRepo.save(existing);
	}

}
