package springmvcDemo.demo1_controller.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetail implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4330355632026043749L;
	
	private String id;
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	private Boolean isAccountNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentialsNonExpired;
	private Boolean isEnabled;
	
	public MyUserDetail(String id, String username, String password, List<GrantedAuthority> authorities,
			Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired,
			Boolean isEnabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
	}
	
	public MyUserDetail(String id, String username, String password, List<GrantedAuthority> authorities,
			boolean isEnabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.isAccountNonExpired = true;
		this.isAccountNonLocked = true;
		this.isCredentialsNonExpired = true;
		this.isEnabled = isEnabled;
	}
	
	public MyUserDetail() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		if(null != isAccountNonExpired) {
			return isAccountNonExpired;
		}
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		if(null != isAccountNonLocked) {
			return isAccountNonLocked;
		}
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if(null != isCredentialsNonExpired) {
			return isCredentialsNonExpired;
		}
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

	@Override
	public String toString() {
		return "MyUserDetail [id=" + id + ", username=" + username + ", password=" + password + ", authorities="
				+ authorities + ", isAccountNonExpired=" + isAccountNonExpired + ", isAccountNonLocked="
				+ isAccountNonLocked + ", isCredentialsNonExpired=" + isCredentialsNonExpired + ", isEnabled="
				+ isEnabled + "]";
	}

}
