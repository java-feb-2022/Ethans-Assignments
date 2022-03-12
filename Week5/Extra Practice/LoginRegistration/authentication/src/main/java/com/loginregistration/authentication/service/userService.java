package com.loginregistration.authentication.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.loginregistration.authentication.models.LoginUser;
import com.loginregistration.authentication.models.User;
import com.loginregistration.authentication.repo.userRepo;
    

    
@Service
public class userService {
    @Autowired
    private userRepo UserRepo;
    public void validate(User newUser, Errors errors) {
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			errors.rejectValue("password", "Mismatch", "Password does not match!!!");
		}
		if(UserRepo.findByEmail(newUser.getEmail())!=null) {
			errors.rejectValue("email", "unique", "Email is already taken!!!");
		}
    }
	public User registerUser(User newUser) {
			
			String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPW);
			return UserRepo.save(newUser);
			
	}
	public boolean authenticateUser(LoginUser newLogin, Errors errors) {
		
		User user = UserRepo.findByEmail(newLogin.getEmail());
		if(user == null) {
			errors.rejectValue("password", "Matches", "");
			return false;
		} else {
			if(BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				errors.rejectValue("password", "Matches", "Invalid Password!!!");
				return false;
			}
		}
		return true;
	}
    public User findByEmail(String email) {
		
		return UserRepo.findByEmail(email);
	} 
    public User findById(Long id) {
		
		return UserRepo.findById(id).orElse(null);
	}
}