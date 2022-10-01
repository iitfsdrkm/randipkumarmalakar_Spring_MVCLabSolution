package in.randip.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.randip.student.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Student> theQuery = currentSession.createQuery("from Student order by name", Student.class);

		// execute query and get result list
		List<Student> students = theQuery.getResultList();

		// return the results
		return students;
	}

	@Override
	public void saveStudent(Student theStudent) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update the student
		currentSession.saveOrUpdate(theStudent);
		;

	}

	@Override
	public Student getStudent(int theId) {
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Retrieve from database using the ID key
		Student theStudent = currentSession.get(Student.class, theId);

		return theStudent;
	}

	@Override
	public void deleteStudent(int theId) {
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the object with primary key
		Query theQuery = currentSession.createQuery("delete from Student where id=:studentId");
		theQuery.setParameter("studentId", theId);

		theQuery.executeUpdate();
	}

}
