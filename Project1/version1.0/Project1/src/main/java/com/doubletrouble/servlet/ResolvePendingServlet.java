package com.doubletrouble.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doubletrouble.dao.CHERSDao;
import com.doubletrouble.dao.CHERSDaoImpl;
import com.doubletrouble.domain.Reimbursements;
import com.google.gson.Gson;

public class ResolvePendingServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int resolver= (int) session.getAttribute("username");
		
		CHERSDao dao = new CHERSDaoImpl();
		Reimbursements u = new Reimbursements();
		try{
			dao.resolveRequest(id, State, resolver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			RequestDispatcher rs = req.getRequestDispatcher("pendingRequests.html");
			rs.include(req, resp);
		 
	}
}
