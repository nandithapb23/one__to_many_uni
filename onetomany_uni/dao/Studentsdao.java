package com.ty.onetomany_uni1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.onetomany_uni.dto.School;
import com.ty.onetomany_uni.dto.Students;

public class Studentsdao {
public EntityManager getEntityManager(){
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	return entityManager;
}
public void saveStudents(int id,Students students){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	School school=entityManager.find(School.class, id);
	
	entityTransaction.begin();
	entityManager.persist(students);
	
	entityTransaction.commit();
}
public void updateStudents(int id,Students students){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Students students1=entityManager.find(Students.class, id);
	if(students1!=null){
		students1.setId(id);
	students1.setName(students.getName());
	students1.setFatherName(students.getFatherName());
	students1.setMotherName(students.getMotherName());
	entityTransaction.begin();
	entityManager.merge(students1);
	entityTransaction.commit();
}else{
	System.out.println("this students doesnot exist");
}
}
public Students deleteStudents(int id){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Students students=entityManager.find(Students.class, id);
	if(students!=null){
		entityTransaction.begin();
		entityManager.remove(students);
		entityTransaction.commit();
	}
	return students;
}
public Students getStudentsById(int id){
	EntityManager entityManager=getEntityManager();
	Students students=entityManager.find(Students.class, id);
	return students;
}
public List<Students> getStudents(){
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select s from Students s");
	List<Students>list=query.getResultList();
	return list;
	
}
}
