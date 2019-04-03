package com.packers.bo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class RolesBO implements GrantedAuthority {
	private String id;
	@Column
	private String name;
	@ManyToMany(mappedBy = "role")
	private Set<UserDetailsBO> user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserDetailsBO> getUser() {
		return user;
	}

	public void setUser(Set<UserDetailsBO> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RolesBO [id=" + id + ", name=" + name + ", user=" + user + "]";
	}

	@Override
	public String getAuthority() {
		return name;
	}
}
