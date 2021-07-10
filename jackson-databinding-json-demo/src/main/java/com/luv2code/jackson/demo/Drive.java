package com.luv2code.jackson.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Drive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			// for sample-lite data 
			
//			Student theStu  = 
//					 mapper.readValue(new File("data/sample-lite.json"),Student.class);
			
			
			// for sample full data 
			
			Student theStu = mapper
					.readValue(new File("data/sample-full.json"),Student.class);
			
			System.out.println("FirstName - " + theStu.getFirstName());
			
			System.out.println("LastName - " + theStu.getLastName());
			
			// print out address : street and city
			
			Address tempadd = theStu.getAddress();
			
			System.out.println("Street - " + tempadd.getStreet());
			System.out.println("City - " + tempadd.getCity());
			
			
			// languages 
			System.out.println("\nLanguages -- \n");
			for(String temp : theStu.getLanguages()) {
				System.out.println(temp);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
