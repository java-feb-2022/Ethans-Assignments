package com.empty.studentroster.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.empty.studentroster.models.dorm;
import com.empty.studentroster.models.student;
import com.empty.studentroster.services.dormservice;
import com.empty.studentroster.services.studentservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class maincontroller {
	private studentservice studentserv;
	private dormservice dormserv;
	public maincontroller(dormservice e, studentservice f) {
		this.dormserv = e;
		this.studentserv = f;
	}
	
	@GetMapping("/dorms/create")
	public String newDorm(@RequestParam(value = "name")String name) {
		dorm dorm = new dorm();
		dorm.setName(name);
		dormserv.save(dorm);
		return "new dorm " + name + " has been created";
	}
	@GetMapping("dorms/{id}/add")
	public String addStudent(@RequestParam(value = "student") long studentid, @PathVariable Long id) {
		if(studentserv.findStudent((Long)studentid) == null) {
			studentserv.save(new student());
		}
		student student = studentserv.findStudent((Long)studentid);
		dorm dorm = dormserv.findDorm(id);
		student.setDorm(dorm);
		studentserv.save(student);
		dormserv.save(dorm);
		return "New student added";
	}
	@GetMapping("/dorms/{id}")
	public void display(@PathVariable Long id) {
		dorm dorm = dormserv.findDorm(id);
		if (dorm == null) {
			System.out.println("dorm is Null");
		}
		else {
			for (student i : dorm.getStudents()) {
				System.out.println(i.getId());
			}
		}
		
	}
	@GetMapping("dorms/{id}/remove")
	public String remove(@RequestParam(value = "student")long studentid, @PathVariable Long id) {
		student s = studentserv.findStudent((Long)studentid);
		s.setDorm(null);
		dorm d = dormserv.findDorm(id);
		return " " + d.getStudents();
	}
}
