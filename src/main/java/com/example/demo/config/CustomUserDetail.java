package com.example.demo.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.dto.Credential;
import com.example.demo.dto.Profile;

public class CustomUserDetail implements UserDetails{
	
	private Credential credentials;
	
	public CustomUserDetail(Credential credential) {
		this.credentials=credential;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(credentials.getProfile().getRole());
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		list.add(authority);
		return list;
	}

	@Override
	public String getPassword() {
		return credentials.getPassword();
	}

	@Override
	public String getUsername() {
		return credentials.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
