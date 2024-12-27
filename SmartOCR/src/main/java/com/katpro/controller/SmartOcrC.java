package com.katpro.controller;
import com.katpro.model.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import net.sourceforge.tess4j.Tesseract;

/**
 * Servlet implementation class ExtractData
 */
@WebServlet("/files")
public class SmartOcrC extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        Tesseract tesseract = new Tesseract();
	        tesseract.setDatapath("C:\\Users\\nagar\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
	        response.getWriter().println("Hey I am in servlet");
	        String folderPath = request.getParameter("file");
	        List<String> filePaths = getFileList(folderPath);
	        List<CustomerData> cd=new ArrayList<>();
	        //Database Connection
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Demo","root","root");
	        PreparedStatement ps=con.prepareStatement("insert into customer(receiptNo,Name,date,location,tax,total) values(?,?,?,?,?,?)");
	        
	        
	        for (String path : filePaths) {
	        	 String text = tesseract.doOCR(new File(path));
	             System.out.println(text);
	             String receiptNumber = extractReceiptNumber(text);
	             String customerName = extractCustomerName(text);
	             String date=extractDate(text);
	             String location=extractLocation(text);
	             String tax=extractTax(text);
	             String totalAmount = extractTotalAmount(text);
	             
	             System.out.println("LOCATION "+location+"  "+tax+" "+date);
	             ps.setString(1,receiptNumber);
	             ps.setString(2,customerName);
	             ps.setString(3,date);
	             ps.setString(4, location);
	             ps.setString(5, tax);
	             ps.setString(6, totalAmount);
	             cd.add(new CustomerData(receiptNumber,customerName,date,location,tax,totalAmount));
	             ps.executeUpdate();
	        }
	        request.setAttribute("customerList", cd);
	        RequestDispatcher rd=request.getRequestDispatcher("table.jsp");
	        rd.forward(request, response);
	        
	        
	         } catch (Exception e) {
	             System.out.println("Error processing "+e);
	         }
		     System.out.println("Heyy");
	        }
	public static List<String> getFileList(String folderPath) {
	    final List<String> filePaths = new ArrayList<>(); // Declare filePaths as final
	    try {
	        Files.walkFileTree(Paths.get(folderPath), new SimpleFileVisitor<Path>() {
	            @Override
	            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
	                filePaths.add(file.toString());
	                return FileVisitResult.CONTINUE;
	            }

	            @Override
	            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
	                System.err.println(exc);
	                return FileVisitResult.CONTINUE;
	            }
	        });
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return filePaths;
	}


	    

	    public static String extractReceiptNumber(String receiptText) {
	    	String lines[]=receiptText.split("\n");
	    	int flag=0;
	    	String t="";
	    		String words[]=lines[4].split("\\s");
	    		for(int j=0;j<words.length;j++) {
	    			if(flag==1) {
	    				t+=words[j]+" ";
	    			}
	    			if(words[j].contains("#")) {
	    				flag=1;
	    		    }
	    			
	    	}
	    		return t;
	    }

	    public static String extractCustomerName(String receiptText) {
	    	String lines[]=receiptText.split("\n");
	    	String t="";
	    	
	    		String words[]=lines[5].split("\\s");
	    		for(int j=0;j<words.length;j++) {
	    			if(words[j].contains("Receipt")) {
	    				break;
	    		}
	    			t+=words[j]+" ";
	    	}
	    		return t;
	    }

	    public static String extractTotalAmount(String receiptText) {
	    	String temp="";
	    	if(receiptText.contains("Bill To Receipt")) {
		    	  int n=receiptText.indexOf("$");
		    	  int f=0;
		    	  for(int i=n;i<receiptText.length();i++) {
		    		  if(receiptText.charAt(i) !='\n') {
		    			  f=i;
		    		  }
		    	  }

		    	  temp=receiptText.substring(n,f);
		      }
		      return  temp;
	    }
	    public String extractLocation(String text) {
	    String lines[]=text.split("\n");
	    return lines[6];
	    }
	    
	    public static String extractTax(String text) {
	       String lines[]=text.split("\n");
	       String temp="";
	       for(String line:lines) {
	    	   if(line.contains("state sales tax rate")) {
	    		   temp=line;
	    	   }
	       }
	       String words[]=temp.split("\\s");
	       return words[words.length-1];
	    }
	    
	    public static String extractDate(String text) {
		       String lines[]=text.split("\n");
		       String temp="";
		       for(String line:lines) {
		    	   if(line.contains("Receipt Date ")) {
		    		   temp=line;
		    	   }
		       }
		       String words[]=temp.split("\\s");
		       return words[words.length-1];
		    }
	    
	    
	    
	}


