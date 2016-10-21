package br.com.saude.coletiva.utils;

public final class Paths {

	public static final String ALL = "/**";
	
	public static final String ROOT_PATH = "/api";
	
	public static final String PUBLIC_ROOT_PATH = ROOT_PATH + "/public";
	
	public static final String PRIVATE_ROOT_PATH = ROOT_PATH + "/private";
	
	public static final String USER_PATH = PRIVATE_ROOT_PATH + "/user";
	
	public static final String PERMISSION_PATH = ROOT_PATH + "/permission";
	
	public static final String ADMIN_PATH = PRIVATE_ROOT_PATH + USER_PATH + "/admin";
	
	//---------------------------------------------------------------------------------
	
	public static final String URGENCIA_EMERGENCIA_PATH = PUBLIC_ROOT_PATH + "/uue";
	
}
