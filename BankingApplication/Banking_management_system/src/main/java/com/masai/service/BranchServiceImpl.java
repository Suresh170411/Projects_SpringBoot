package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Branch;
import com.masai.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository;
	
	@Override
	public Branch addBranch(Branch branch) {
		return branchRepository.save(branch);
	}

}
