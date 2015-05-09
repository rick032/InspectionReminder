package com.oil.ir.log;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;
import org.springframework.util.StringUtils;

/**
 * 
 * @author Rick
 *
 */
public class Log4jFilter implements Filter {

	private final static String DEFAULT_EMPNO = "-----";
	private final static String DEFAULT_USERNAME = "-----";
	private final static String EMPNO = "empNo";
	private final static String USERNAME = "loginId";
	private final static String IP = "IP";
	private final static String URL = "URL";

	@Override
	public void destroy() {
		MDC.getContext().clear();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		if (session.isNew()) {
			MDC.put(EMPNO, DEFAULT_EMPNO);
			MDC.put(USERNAME, DEFAULT_USERNAME);

		} else {
			String userName = (String) session.getAttribute(EMPNO);
			userName = StringUtils.isEmpty(userName) ? (String) request
					.getParameter("j_userName") : userName;
			if (StringUtils.isEmpty(userName)) {
				MDC.put(EMPNO, DEFAULT_EMPNO);
				MDC.put(USERNAME, DEFAULT_USERNAME);
			} else {
				Object ID = session.getAttribute(EMPNO);
				MDC.put(EMPNO, ID);
				MDC.put(USERNAME, userName);
			}
		}
		MDC.put(IP, request.getRemoteAddr());
		MDC.put(URL, getURL(req));

		chain.doFilter(request, response);
		MDC.getContext().clear();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public String getURL(HttpServletRequest req) {
		String pathInfo = req.getPathInfo();
		return req.getServletPath() + (pathInfo != null ? "//" + pathInfo : "");
	}

}
