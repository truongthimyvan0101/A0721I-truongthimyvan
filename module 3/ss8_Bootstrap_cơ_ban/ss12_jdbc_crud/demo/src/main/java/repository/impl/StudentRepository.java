package repository.impl;

import model.Student;
import repository.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private BaseRepository baseRepository = new BaseRepository();


    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            //Statement
//            Statement statement = this.baseRepository.getConnection().createStatement();
////            statement.executeQuery("select * from student where name ="+name);

            //PreparedStatement
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("select * from student");
            //executeQuery : select
            //executeUpdate: insert, update, delete.
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGrade(resultSet.getDouble("grade"));
                student.setGender(resultSet.getInt("gender"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findById(String id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("select * from student where id = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGrade(resultSet.getDouble("grade"));
                student.setGender(resultSet.getInt("gender"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                break;
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(String id, String name, String grade) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("update student set name = ?, grade = ? where id = ?");
            preparedStatement.setString(3, id);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, grade);
            int num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createStudent(Student student) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("insert into student(name,date_of_birth,grade,gender) value (?,?,?,?)");
            preparedStatement.setDouble(3, student.getGrade());
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDateOfBirth());
            preparedStatement.setInt(4,student.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}