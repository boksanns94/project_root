package com.milosboksan.backendroot.security;

/*
 * 
 * Views - For separating levels of access and gaining increased security.
 * Author: Milos Boksan
 * Created on: 22:51 24.07.2017.
 */

public class Views
{
	public static class Public{}
	
	public static class Private extends Public{}
	
	public static class Administrator extends Private{}
}
