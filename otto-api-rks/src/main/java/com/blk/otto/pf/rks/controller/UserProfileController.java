package com.blk.otto.pf.rks.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blk.otto.pf.rks.apicontract.UserProfileContract;
import com.blk.otto.pf.rks.entity.UserProfile;
import com.blk.otto.pf.rks.service.IUserProfileService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("user")
public class UserProfileController {

	private IUserProfileService userProfileService;
	
	private ModelMapper modelMapper;

	/**
	 * constructor using fields
	 * @param userProfileRepository
	 * @param modelMapper
	 */
	@Autowired
	public UserProfileController(IUserProfileService userProfileService, ModelMapper modelMapper) {
		this.userProfileService = userProfileService;
		this.modelMapper = modelMapper;
	}

	/**
	 * @return: get all UserProfile available
	 */
	@ApiOperation("Get all user profiles")
	@GetMapping
	public List<UserProfile> getUserProfiles() {
		return userProfileService.findAll();
	}

	/**
	 * @param id
	 * @return: get user profile for the requested id
	 */
	@ApiOperation("Get user profiles from id")
	@GetMapping("{participantId}")
	public UserProfile getUserProfile(@PathVariable("participantId") String participantId) {
		return userProfileService.findById(participantId).orElse(new UserProfile());
	}

	/**
	 * UserProfile entity in request body to add UserProfile
	 * Use the following json to add
	 * @param UserProfile
	 */
	@ApiOperation("Add a new user profile")
	@PostMapping
	public void addUserProfile(@RequestBody UserProfileContract userProfileContract) {
		userProfileService.save(modelMapper.map(userProfileContract, UserProfile.class));
	}

	/**
	 * Id to delete UserProfile
	 * @param id
	 */
	@ApiOperation("Delete a user profile from id")
	@DeleteMapping("{participantId}")
	public void deleteUserProfile(@PathVariable("participantId") String participantId) {
		userProfileService.deleteById(participantId);
	}
	
}
