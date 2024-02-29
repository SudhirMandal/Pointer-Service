package com.sudhir.services;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sudhir.entities.UserDetails;
import com.sudhir.repositories.UserDetailsRepository;


@Service
public class PointCalculatorService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	List<UserDetails> listOfUsers;

	public long getRewardPoints(Long id) {
		UserDetails userDetails = userDetailsRepository.findById(id).orElse(null);
		if (userDetails == null) {
			throw new ServiceException("User Not found");
		}
		return userDetails.getRewardPoints();
	}

	public void geAllUsers(Long id) {
		listOfUsers = userDetailsRepository.findAll();
	}

	@Scheduled(cron = "0 0 0 L * ?")
	public void monthlyRewardPointUpdate() {
		listOfUsers.stream().forEach(user -> {
			Long temp = user.getCurrentMonthPurchaseAmount();// let 120
			// 120 purchase = 2x$20 + 1x$50 = 90 points
			long rewardpoints = 0L;
			if (temp > 100) {
				rewardpoints = (temp - 100) * 20;
			}
			if (temp > 50) {
				rewardpoints = rewardpoints + (temp - 50);
			}
			user.setRewardPoints(rewardpoints);
		});
		userDetailsRepository.saveAllAndFlush(listOfUsers);
	}

}
