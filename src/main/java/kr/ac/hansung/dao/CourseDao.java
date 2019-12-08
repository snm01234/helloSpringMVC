package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// query and return a single object
	public Course getCourse(String ccode) {
		
		String sqlStatement = "select * from courses where ccode=?"; //placeholder
		
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {ccode}, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				
				course.setCyear(rs.getInt("cyear"));
				course.setSemester(rs.getInt("semester"));
				course.setCcode(rs.getString("ccode"));
				course.setCtitle(rs.getString("ctitle"));
				course.setDivision(rs.getString("division"));
				course.setGrade(rs.getInt("grade"));
				
				return course;
			}	
		
		});
	}
		
		// query and return a multiple object
	public List<Course> getCourses() {

		String sqlStatement = "select * from courses"; // placeholder

		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();

				course.setCyear(rs.getInt("cyear"));
				course.setSemester(rs.getInt("semester"));
				course.setCcode(rs.getString("ccode"));
				course.setCtitle(rs.getString("ctitle"));
				course.setDivision(rs.getString("division"));
				course.setGrade(rs.getInt("grade"));
				
				return course;
			}

		});
	}

	public boolean insert(Course course) {
		
		int cyear = course.getCyear();
		int semester = course.getSemester();
		String ccode = course.getCcode();
		String ctitle = course.getCtitle();
		String division = course.getDivision();
		int grade = course.getGrade();
		
		//id는 autoincrement라 넣을 필요 없었음
		String sqlStatement = "Insert into courses (cyear, semester, ccode, ctitle, division, grade) values (?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { cyear, semester, ccode, ctitle, division, grade }) == 1);

	}
	public boolean update(Course course) {
		
		int cyear = course.getCyear();
		int semester = course.getSemester();
		String ccode = course.getCcode();
		String ctitle = course.getCtitle();
		String division = course.getDivision();
		int grade = course.getGrade();

		String sqlStatement = "update offers set cyear=?, semester=?, ctitle=? division=? grade=? where ccode=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] { cyear, semester, ctitle, division, grade, ccode }) == 1);

	}
	
	public boolean delete(int ccode) {
		
		String sqlStatement = "delete from courses where ccode=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] { ccode }) == 1);
	}
	
}
