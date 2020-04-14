package com.project.rest.webservice.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorldController {
	
@RequestMapping(method=RequestMethod.GET,path="/helloworld")
public  String HelloWorld() {
	
	return "Hello World";
}

@RequestMapping(method=RequestMethod.GET,path="/hello-world-bean")
public HelloWorldBean GetHelloWorld() {
	return new HelloWorldBean ("helloworldbean");
}

@GetMapping(path="/helloworld/path-variable/{name}")
public HelloWorldBean Helloworld(@PathVariable String name) {
	return new HelloWorldBean(String.format("hellowordbean %s",name));
}

}
