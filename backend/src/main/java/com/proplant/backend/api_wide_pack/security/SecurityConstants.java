package com.proplant.backend.api_wide_pack.security;

public class SecurityConstants{	

	public static final String SECRET ="joeltchoufa@test.com";
	public static final long EXPIRATION_TIME = 864_000_000; //10 days
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING ="Authorization";
	public static final String REFRESH_TOKEN="refresh-token";
	public static final String ACCESS_TOKEN="access-token";
	public static final String REFRESH_TOKEN_HTTP="/refreshToken";
	

}
