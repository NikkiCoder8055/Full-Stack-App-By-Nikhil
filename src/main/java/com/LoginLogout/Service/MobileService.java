package com.LoginLogout.Service;

import java.util.List;
import java.util.Map;

import com.LoginLogout.Model.Mobile;

public interface MobileService {
	
	Mobile addMobile(Mobile mobile);
	
	List<Mobile> getMobiles();
	
	Mobile findById(Long id);
	
	void deleteMobile(Long id);
	
	Mobile UpdateMobile(Long id);

	Mobile updatePatch(long id, Map<String, Object> fields);
	
	

}
