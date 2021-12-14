package com.file;

import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

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
import javax.servlet.http.HttpSession;

public class DemoExamSchedule extends HttpServlet {
	static List list = new LinkedList();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		FileOperation.listFinal.clear();
//		FileOperation.list.clear();
	
		System.out.println("test points "+request.getParameter("points"));
		list.clear();
		System.out.println(list.size()+" list size()");
		Random random = new Random();
		int examId = random.nextInt(1121212);

		String subject = request.getParameter("sub");
		String examType = request.getParameter("typ");
		String noOfQuestions = request.getParameter("qus");
		String studentEmail = request.getParameter("email");
		request.setAttribute("id", examId);
		FileOperation.range = Integer.parseInt(noOfQuestions);
		FileOperation.fileName = subject;

		FileOperation.mainEntry(examId);

		System.out.println(subject + " " + " " + examType + " " + noOfQuestions + " " + studentEmail + " " + examId);
		RequestDispatcher rd = request.getRequestDispatcher("DemoExamScheduleToDB");
		rd.include(request, response);
		
		System.out.println("map Size "+FileOperation.map.size());
		
		 try{
	            String host = "smtp.gmail.com";
	            String from = "abhik.patra2021@gmail.com";
	            String pass = "abhik1234567890";
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
	          
	            message.setText(" Please Click Below Link For Exam "+" http://localhost:8080/OnlineEntranceExam/ConfirmTestTaker?id="+examId+"&email="+studentEmail);
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();	       
	            }	catch(Exception e){
	            e.getMessage();
	        }
		 
		response.sendRedirect("dashboard/viewExam.jsp");
	}

}
