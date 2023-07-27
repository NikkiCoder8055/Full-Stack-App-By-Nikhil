package com.LoginLogout.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LoginLogout.Model.Mobile;
import com.LoginLogout.Service.MobileService;
import com.LoginLogout.Util.ApiResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MobileController {
	
	@Autowired
	private MobileService mobileService;
	
	@PostMapping("/add")
	public ResponseEntity<Mobile> addMobilePhone(@RequestBody Mobile mobile){
		Mobile addMobile = this.mobileService.addMobile(mobile);
		return new ResponseEntity<Mobile>(addMobile,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Mobile>> getMobiles(){
		List<Mobile> mobiles = this.mobileService.getMobiles();
		return new ResponseEntity<List<Mobile>>(mobiles,HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mobile> findById(@PathVariable Long id){
		Mobile findById = this.mobileService.findById(id);
		return new ResponseEntity<Mobile>(findById,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Mobile>updateMobile(@RequestBody Mobile mobile,@PathVariable Long id){
		Mobile updateMobileId = this.mobileService.UpdateMobile(id);
		if(updateMobileId==null) {
			return new ResponseEntity<Mobile>(updateMobileId,HttpStatus.NOT_FOUND);
		}else {
			mobile.setProductId(id);
			Mobile addMobile = this.mobileService.addMobile(mobile);
			return new ResponseEntity<Mobile>(addMobile,HttpStatus.OK);
		}
	}
	@PatchMapping("/{id}")
	public ResponseEntity<Mobile> updatePatch(@PathVariable long id,@RequestBody Map<String, Object> fields){
		Mobile updatePatch = this.mobileService.updatePatch(id,fields);
		return new ResponseEntity<Mobile>(updatePatch,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteMobile(@PathVariable Long id){
		this.mobileService.deleteMobile(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("deleted Successfully..!", true),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
