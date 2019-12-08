package dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import department.DepartmentPO;

import student.StudentPO;

import admin.AdminPO;



public class UserDao {
	Session session=HibernateUtil.openSession();
	Transaction tx=null;
	//按条件查找
	public List<Object> check(String hql){
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			List<Object> list=query.list();
			tx.commit();
			return list;
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	//添加用户
	public void save(Object ob){
		try{
			tx=session.beginTransaction();
			session.save(ob);
			tx.commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	public void delete(Class c,String number){
		try{
			tx=session.beginTransaction();
			Object ob=session.get(c, number);
			session.delete(ob);
			tx.commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	public void update_admin(Class c,String number,AdminPO admin1){
		try{
			tx=session.beginTransaction();
			AdminPO admin=(AdminPO) session.get(c,number);
			if(admin1.getName()!=null){
				admin.setName(admin1.getName());
			}
			if(admin1.getPassword()!=null){
				admin.setPassword(admin1.getPassword());
			}
			session.update(admin);
			tx.commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	public void update_department(Class c,String id,DepartmentPO department1){
		try{
			tx=session.beginTransaction();
			DepartmentPO department=(DepartmentPO)session.get(c, id);
			if(department1.getName()!=null){
				department.setName(department1.getName());
			}
			if(department1.getType()!=null){
				department.setType(department1.getType());
			}
			session.update(department);
			tx.commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	public void update_student(Class c,String number,StudentPO student1){
		try{
			tx=session.beginTransaction();
			StudentPO student=(StudentPO) session.get(c, number);
			if(student1.getAge()!=student.getAge()){
				student.setAge(student1.getAge());
			}
			if(!student1.getName().equals(student.getName())){
				student.setName(student1.getName());
			}
			if(!student1.getSex().equals(student.getSex())){
				student.setSex(student1.getSex());
			}
			if(!student1.getPassword().equals(student.getPassword())){
				student.setPassword(student1.getPassword());
			}
			if(!student1.getPhone().equals(student.getPhone())){
				student.setPhone(student1.getPhone());
			}
			if(!student1.getDepartment().equals(student.getDepartment())){
				student.setDepartment(student1.getDepartment());
			}
			session.update(student);
			tx.commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	public void update_student1(Class c,String number,StudentPO student1){
		try{
			tx=session.beginTransaction();
			StudentPO student=(StudentPO) session.get(c, number);
			if(!student1.getPassword().equals(student.getPassword())){
				student.setPassword(student1.getPassword());
			}
			if(!student1.getPhone().equals(student.getPhone())){
				student.setPhone(student1.getPhone());
			}
			session.update(student);
			tx.commit();
		}catch(RuntimeException e){
			session.getTransaction().rollback();
			throw e;
		}finally{
			session.close();
		}
	}
}
