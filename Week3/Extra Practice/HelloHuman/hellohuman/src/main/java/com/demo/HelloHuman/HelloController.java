package com.demo.HelloHuman;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
	@RequestMapping("/")
	public String URL(@RequestParam(required=false)String name, @RequestParam(required=false)String lastName, @RequestParam(required=false) Integer times) {
		if (times == null ) {
			return "Hello " + name + " " + lastName;
		}
		else if (lastName == null) {
			return "Hello " + name;
		}
		else if (name == null) {
			return "Hello!";
		}
		else {
			String message = "";
			for (int i = 0; i < times; i++) {
				message += " Hello " + name + " " + lastName;
			}
			return message;
		}
		
	}
}
