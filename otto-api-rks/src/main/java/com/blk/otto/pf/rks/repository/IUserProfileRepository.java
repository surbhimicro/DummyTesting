package com.blk.otto.pf.rks.repository;

import java.util.List;
import java.util.Optional;

import com.blk.otto.pf.rks.entity.UserProfile;

public interface IUserProfileRepository {

	public UserProfile save(UserProfile entity);

	public Optional<UserProfile> findById(String id);

	public boolean existsById(String id);

	public long count();

	public void deleteById(String id);

	public void delete(UserProfile entity);

	public void deleteAll();

	public List<UserProfile> findAll();
	
}
