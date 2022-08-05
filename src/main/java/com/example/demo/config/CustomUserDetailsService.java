package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.dto.Credential;
import com.example.demo.repository.CredentialRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private CredentialRepository credentialRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credential credential = credentialRepository.getCredentialsByUsername(username);
		if (credential != null) {
			return new CustomUserDetail(credential);
		} else {
			throw new UsernameNotFoundException("User not found!");
		}
	}
}
