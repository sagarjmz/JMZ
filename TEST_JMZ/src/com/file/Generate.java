package com.file;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Param;

/**
 * Servlet implementation class Generate
 */

public class Generate extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().println("");
		
		 try{
	            String host = "smtp.gmail.com";
	            String from = "abhik.patra.10@gmail.com";
	            String pass = "abhik9002876278";
	            Properties props = System.getProperties();
	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.user", from);
	            props.put("mail.smtp.password", pass);
	            props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.auth", "true");
	            String email = request.getParameter("email");
	            String[] to = {email};

	            Session session = Session.getDefaultInstance(props, null);
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i=0; i < to.length; i++ ) { // changed from a while loop
	                toAddress[i] = new InternetAddress(to[i]);
	            }
	            System.out.println(Message.RecipientType.TO);

	            for( int i=0; i < toAddress.length; i++) { // changed from a while loop
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }
	            String sub = request.getParameter("sub");
	            String qtype = request.getParameter("typ");
	          //  String sub = request.getParameter("");
	            message.setSubject(" EXAM SHEDULED ");
	          
	            message.setText(" :- DON'T STRESS! DO YOUR BEST, FORGET THE REST! -: www.google.com");
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	            request.getRequestDispatcher("./dashboard/dashboard.html").forward(request, response);
	        //    response.sendRedirect("./dashboard/dashboard.html");	       
	            }	catch(Exception e){
	            e.getMessage();
	        }
	}

}
