package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Branch;
import com.masai.service.BranchService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	@PostMapping("/branch")
	public ResponseEntity<Branch> addBranchHandler(@RequestBody Branch branch){
		return new ResponseEntity<Branch>(branchService.addBranch(branch), HttpStatus.CREATED);
	}

}
