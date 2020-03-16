package com.freya.mybatis.dynamic.datasource.servlet;


import com.alibaba.druid.support.http.StatViewServlet;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/16 13:59
 */
public class DruidStatViewServlet extends StatViewServlet {

	private static final long serialVersionUID = -1773916779016227352L;

	private String username;

	private String password;


	@Override
	public String getInitParameter(String name) {
		if ("loginUsername".equals(name)) {
			return username;
		}

		if ("loginPassword".equals(name)) {
			return password;
		}
		return super.getInitParameter(name);
	}

	public DruidStatViewServlet(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}


}
