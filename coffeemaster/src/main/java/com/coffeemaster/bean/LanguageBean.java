package com.coffeemaster.bean;

import javax.annotation.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @author adil
 *
 */
@ManagedBean
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LanguageBean {
	
	private String lang = "tr";
	
	public String changeLang(String lang)
	{
		this.lang = lang;
		return "";
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	

}
