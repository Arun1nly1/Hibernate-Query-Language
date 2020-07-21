package com.arun.hql;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
   		SessionFactory sf = config.buildSessionFactory();
   		Session session = sf.openSession();
   		
   		session.beginTransaction();
   		
   		//HQL Query
   		//Inserting 50 elements
   		//Random number generated for marks
//   		Random r = new Random();
//   		for (int i = 1; i<=50; i++) {
//   			Student s = new Student();
//   			s.setRollno(i);
//   			s.setName("Name"+ i );
//   			s.setMarks(r.nextInt(100));
//   			session.save(s);
//   		}
   		
   		//For all data fetching
//   		Query q = session.createQuery("from Student where marks>50");
//   		List <Student> students = q.list();
   		
//   		for(Student s: students) {
//   			System.out.println(s);
//   		}
   		
   		
   		//For single data fetching
//   			Query q = session.createQuery("from Student where rollno=50");
//   			Student s = (Student) q.uniqueResult();
//   			System.out.println(s);
   		
   		
   		//To find sum of marks
//   			Query q = session.createQuery("select sum(marks) from Student s where s.marks>50");
//   			Long marks = (Long) q.uniqueResult();
//   			System.out.println(marks);
   		
	//Lets fire SQL Query instead of HQL Query
   		//Entire student fetching
//   			NativeQuery query = session.createNativeQuery("select * from student where marks>60");
//   			query.addEntity(Student.class);
//   			List<Student> students = query.list();
//   			
//   			for(Student s : students) {
//   				System.out.println(s);
//   			}
   		
   		//Fetching columns name and marks only
//   		NativeQuery query = session.createNativeQuery("select name,marks from student where marks>60");
//   		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//		List students = query.list();
//			
//			for(Object o : students) {
//				Map m = (Map)o;
//				System.out.println(m.get("name")+" "+m.get("marks"));
//			}
//			
			
//			Get vs Load
			Student s = session.load(Student.class, 6);
			System.out.println(s);
   			
   		session.getTransaction().commit();
    }
}
