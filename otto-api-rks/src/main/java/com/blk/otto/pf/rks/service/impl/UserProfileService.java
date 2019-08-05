package com.blk.otto.pf.rks.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blk.otto.pf.rks.entity.UserProfile;
import com.blk.otto.pf.rks.repository.IUserProfileRepository;
import com.blk.otto.pf.rks.service.IUserProfileService;

@Service
public class UserProfileService implements IUserProfileService {

	private IUserProfileRepository userProfileRepository;
	
	/**
	 * @param planRepository: constructor injection
	 */
	@Autowired
	public UserProfileService(IUserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}
	
	@Override
	public UserProfile save(UserProfile entity) {
		return userProfileRepository.save(entity);
	}

	@Override
	public Optional<UserProfile> findById(String id) {
		return userProfileRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return userProfileRepository.existsById(id);
	}

	@Override
	public long count() {
		return userProfileRepository.count();
	}

	@Override
	public void deleteById(String id) {
		userProfileRepository.deleteById(id);
	}

	@Override
	public void delete(UserProfile entity) {
		userProfileRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		userProfileRepository.deleteAll();
	}

	@Override
	public List<UserProfile> findAll() {
		return userProfileRepository.findAll();
	}

}
