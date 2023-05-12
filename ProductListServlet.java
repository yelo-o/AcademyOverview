package com.my.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProductListServlet이 요청됨");
		com.my.vo.Product[] all = com.my.repository.ProductRepository.selectAll();
		
		// 응답
		// response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		// 응답내용 출력하기
		java.io.PrintWriter out = response.getWriter();
//		out.println("WELCOME");
//		out.println("반갑습니다. 263기 여러분");
//		out.println("상품목록입니다");
//		for(com.my.vo.Product p: all) {
//			out.println(p.prodNo);
//		}
		out.print("[");
		for(int i=0; i<all.length; i++) {
			if(i>0) {
				out.print(",");
			}
			com.my.vo.Product p = all[i];
			out.print("\"");
			out.print(p.prodNo);
			out.print("\"");
		}
		out.print("]");
	}
}
