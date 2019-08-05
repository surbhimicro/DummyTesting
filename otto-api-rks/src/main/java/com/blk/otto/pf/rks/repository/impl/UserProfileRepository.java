package com.blk.otto.pf.rks.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.blk.otto.pf.rks.entity.UserProfile;
import com.blk.otto.pf.rks.repository.IUserProfileRepository;

@Repository
public class UserProfileRepository implements IUserProfileRepository {

	private List<UserProfile> userList;

	public UserProfileRepository() {
		userList = new ArrayList<>();
	}

	@Override
	public UserProfile save(UserProfile entity) {
		entity.setParticipantId(String.valueOf((Math.random() * 1000 + 1)));
		userList.add(entity);
		return entity;
	}

	@Override
	public Optional<UserProfile> findById(String id) {
		return userList.stream().filter(u -> u.getParticipantId().equals(id)).findFirst();
	}

	@Override
	public boolean existsById(String id) {
		return userList.stream().filter(u -> u.getParticipantId().equals(id)).count() == 1;
	}

	@Override
	public long count() {
		return userList.size();
	}

	@Override
	public void deleteById(String id) {
		userList.remove(this.findById(id).orElse(null));
	}

	@Override
	public void delete(UserProfile entity) {
		userList.remove(entity);

	}

	@Override
	public void deleteAll() {
		userList.clear();

	}

	@Override
	public List<UserProfile> findAll() {
		return userList;
	}

}
