package com;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo1
 */
public class Demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Only once it will get Execute "
				+ "kind of db con open ");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Every time serveice will get Execute ");
	}
	public void destroy() {
		
		System.out.println("At the END  it will get Execute "
				+ "close the connection");
	}

}
