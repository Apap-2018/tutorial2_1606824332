package com.example.demo.controller;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value="name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value = {"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model){
		if (name.isPresent()) {
			model.addAttribute("name",name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping(value = "/generator")
	public String generator(@RequestParam(required=false, defaultValue="0") Integer a, @RequestParam(required=false, defaultValue="0") int b, Model model) {
		String viral = "";
		int a_new = a;
		int b_new = b;
		if (a==0) {
			a_new = 1;
		}else if (b==0) {
			b_new = 1;
		}
		String m = new String(new char[a_new]).replace("\0", "m");
		viral = new String(new char[b_new]).replace("\0", "h"+m+" ");
		String[] books = {"buku1", "buku2"};
		
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute("books", books);
		model.addAttribute("viral", viral);
		model.addAttribute("title", "apaaja");
		return "generator";
	}
}

