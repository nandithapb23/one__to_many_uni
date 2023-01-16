package com.ty.onetomany_uni1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany_uni.dto.School;
import com.ty.onetomany_uni.dto.Students;
import com.ty.onetomany_uni1.dao.Schooldao;
import com.ty.onetomany_uni1.dao.Studentsdao;

public class SchoolMain {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	Scanner scanner=new Scanner(System.in);
	boolean repeat=true;
	Students students=new Students();
	School school=new School();
	Studentsdao dao1=new Studentsdao();
	Schooldao dao=new Schooldao();

	do{
		System.out.println("1:School \n 2:Student");
		System.out.println("enter your choice");
		int choice=scanner.nextInt();
		switch(choice){
		case 1:{
			System.out.println("1:save school \n 2:update school \n 3:delete school \n 4:getSchool by Id \n 5:get School");
			System.out.println("enter your choice");
			int choice1=scanner.nextInt();
			switch(choice1){
			case 1:{
				System.out.println("enter the schoolid");
				int id=scanner.nextInt();
				System.out.println("enter the schoolname");
				String name=scanner.next();
				System.out.println("enter the address");
				String address=scanner.next();
				school.setId(id);
				school.setName(name);
				school.setAddress(address);
				List<Students>list=new ArrayList<Students>();
				System.out.println("enter the id");
				int sid=scanner.nextInt();
				System.out.println("enter the name");
				String sname=scanner.next();
				System.out.println("enter the father name");
				String fatherName=scanner.next();
				System.out.println("enter the mother name");
				String motherName=scanner.next();
				students.setId(sid);
				students.setName(sname);
				students.setFatherName(fatherName);
				students.setMotherName(motherName);
				list.add(students);
				school.setList(list);
				
				dao.saveSchool(school);
			}
			break;
			case 2:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the name");
				String name=scanner.next();
				System.out.println("enter the address");
				String address=scanner.next();
				EntityManager entityManager =dao.getEntityManager();
				school.setId(id);
				school.setName(name);
				school.setAddress(address);
				dao.updateSchool(id, school);	
			}
			break;
			case 3:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				school.setId(id);
				dao.deleteSchool(id);
			}
			break;
			case 4:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				school.setId(id);
				School school1=dao.getSchoolById(id);
				System.out.println(school1);
			}
			break;
			case 5:{
				List<Students>list1=dao.getSchool();
				System.out.println(list1);
			}
			break;
			default:{
				System.out.println("thank you");
			}
			}
		}
		case 2:{
			System.out.println("1:save student \n 2:update student \n 3:delete student \n 4:getStudent by id \n 5:getStudent");
			System.out.println("enter your choice");
			int choice1=scanner.nextInt();
			switch(choice1){
			case 1:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the schoolid");
				int schoolId=scanner.nextInt();
				System.out.println("enter the name");
				String name=scanner.next();
				System.out.println("enter the father name");
				String fatherName=scanner.next();
				System.out.println("enter the mother name");
				String motherName=scanner.next();
				school.setId(schoolId);
				students.setId(id);
				students.setName(name);
				students.setFatherName(fatherName);
				students.setMotherName(motherName);
				dao1.saveStudents(id, students);
			}
			break;
			case 2:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the name");
				String name=scanner.next();
				System.out.println("enter the father name");
				String fatherName=scanner.next();
				System.out.println("enter the mother name");
				String motherName=scanner.next();
				EntityManager entityManager =dao.getEntityManager();
				students.setId(id);
				students.setName(name);
				students.setFatherName(fatherName);
				students.setMotherName(motherName);
//				list.add(students);
//				school.setList(list);
				dao1.updateStudents(id, students);
			}
			break;
			case 3:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				EntityManager entityManager =dao.getEntityManager();
				students.setId(id);
				dao1.deleteStudents(id);
			}
			break;
			case 4:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				EntityManager entityManager=dao.getEntityManager();
				students.setId(id);
				Students students1=dao1.getStudentsById(id);
				System.out.println(students1);
			}
			break;
			case 5:{
				EntityManager entityManager=dao.getEntityManager();
				List<Students>list1=dao.getSchool();
				System.out.println(list1);
			}
			break;
			default:{
				System.out.println("thank you");
			}
			}
		}
		}
		
	}while(repeat);
}
}


//do{
//	System.out.println(" 1 :save Student \n 2 :update student \n 3 :delete student \n 4 :get student by id \n 5 :get all students");
//	System.out.println(" 6 :save school \n 7 :update school \n 8 :delete school \n 9 :get school by id \n 10:get school");
//	System.out.println("****************************************");
//	System.out.println("enter your choice");
//	int choice=scanner.nextInt();
//	switch(choice){
//	case 1:{
//		System.out.println("enter the id");
//		int id=scanner.nextInt();
//		System.out.println("enter the name ");
//		String name=scanner.next();
//		System.out.println("enter the fathername");
//		String fatherName=scanner.next();
//		System.out.println("enter the mothername");
//		String motherName=scanner.next();
//		
//		students.setId(id);
//		students.setName(name);
//		students.setFatherName(fatherName);
//		students.setMotherName(motherName);
//		list.add(students);
//		
//		System.out.println("enter the schoolid");
//		int schoolId=scanner.nextInt();
//		System.out.println("enter the schoolname");
//		String schoolName=scanner.next();
//		System.out.println("enter the address");
//		String address=scanner.next();
//		
//		
//		school.setList(list);
//		school.setId(schoolId);
//		school.setName(schoolName);
//		school.setAddress(address);
//		
//		dao.saveStudents(students, school);
//		System.out.println("saved successfully");
//	}
//	break;
//	case 2:{
//		System.out.println("enter the id");
//		int id=scanner.nextInt();
//		System.out.println("enter the name");
//		String name=scanner.next();
//		System.out.println("enter the father name");
//		String fatherName=scanner.next();
//		System.out.println("enter the mother name");
//		String motherName=scanner.next();
//		students.setName(name);
//		students.setMotherName(motherName);
//		students.setFatherName(fatherName);
//		EntityManager entityManager =dao.getEntityManager();
//		dao.updateStudents(id, students);
//		System.out.println("Updated successfully");
//	}
//	break;
//	case 3:{
//		System.out.println("enter the id");
//		int id=scanner.nextInt();
//		EntityManager entityManager=dao.getEntityManager();
//		students.setId(id);
//		dao.deleteStudents(id);
//		System.out.println("deleted");
//	}
//	break;
//	case 4:{
//		System.out.println("enter the id");
//		int id=scanner.nextInt();
//		EntityManager entityManager=dao.getEntityManager();
//		students.setId(id);
//		Students students1=dao.getStudentsById(id);
//		System.out.println(students1);
//	}
//	break;
//	case 5:{
//		EntityManager entityManager=dao.getEntityManager();
//		List<Students>list1=dao.getStudents();
//		System.out.println(list1);
//	}
//	break;
//	case 6:{
//		System.out.println("enter the schoolid");
//		int schoolId=scanner.nextInt();
//		System.out.println("enter the name");
//		String name=scanner.next();
//		System.out.println("enter the address");
//		String address=scanner.next();
//		
//		
//		school.setList(list);
//		school.setName(name);
//		school.setAddress(address);
//		dao1.saveSchool(school);
//		System.out.println("saved successfully");
//	}
//	break;
//	case 7:{
//		System.out.println("enter the schoolid to be updated");
//		int schoolId=scanner.nextInt();
//		System.out.println("enter the name");
//		String name=scanner.next();
//		System.out.println("enter the address to be update");
//		String address=scanner.next();
//		school.setName(name);
//		school.setAddress(address);
//		EntityManager entityManager =dao1.getEntityManager();
//		dao1.updateSchool(schoolId, school);
//		System.out.println("Updated");
//	}
//	break;
//	case 8:{
//		System.out.println("enter the schoolid to be deleted");
//		int schoolId=scanner.nextInt();
//		EntityManager entityManager=dao1.getEntityManager();
//		school.setId(schoolId);
//		dao1.deleteSchool(schoolId);
//		System.out.println("deleted");
//	}
//	break;
//	case 9:{
//		System.out.println("enter the schoolid");
//		int schoolId=scanner.nextInt();
//		school.setId(schoolId);
//		School school1=dao1.getSchoolById(schoolId);
//		System.out.println(school1);
//	}
//	break;
//	case 10:{
//		EntityManager entityManager=dao1.getEntityManager();
//		List<Students>list1=dao1.getSchool();
//		System.out.println(list1);
//	}
//	break;
//	default:{
//		System.out.println("thank you");
//	}
//	}
//}while(repeat);
//}
//}

