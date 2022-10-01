package in.randip.student.dao;

import java.util.List;

import in.randip.student.entity.Student;

public interface StudentDAO {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);

}
