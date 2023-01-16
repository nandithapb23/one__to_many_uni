package com.ty.onetomany_uni1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



import com.ty.onetomany_uni.dto.School;
import com.ty.onetomany_uni.dto.Students;

public class Schooldao {
public EntityManager getEntityManager(){
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	return entityManager;
}
public void saveSchool(School school){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	List<Students>students=school.getList();
	entityTransaction.begin();
	for(Students students1:students){
		entityManager.persist(students1);
		}
	entityManager.persist(school);
	entityTransaction.commit();
}
public void updateSchool(int id,School school){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	School school1=entityManager.find(School.class, id);
	if(school1!=null){
//		school1.setId(id);
		List<Students>students=school1.getList();
		entityTransaction.begin();
		entityManager.merge(school1);
		entityTransaction.commit();
	}else{
		System.out.println("this school does not exist");
	}
}
public void deleteSchool(int id){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	School school=entityManager.find(School.class, id);
	if(school!=null){
		entityTransaction.begin();
		entityManager.remove(school);
		entityTransaction.commit();
	}
}
public School getSchoolById(int id){
	EntityManager entityManager=getEntityManager();
	School school=entityManager.find(School.class, id);
	return school;
}
public List<Students> getSchool(){
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select s from School s");
	List<Students>list=query.getResultList();
	return list;
	
}
}
