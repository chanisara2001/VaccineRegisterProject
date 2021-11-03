package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	private Register register;
	
	@Autowired
	private User user;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private VaccineRepository vaccineRepository;
	
	@RequestMapping("/")
	public String viewHome() {
		return "home";
	}

	@RequestMapping("/detailRegister")
	public String viewDetail() {
		return "detailRegister";
	}

	@RequestMapping("/detailCondition")
	public String viewCondition() {
		return "detailCondition";
	}
	
	@GetMapping("/userRegister")
	public String viewRegistrationForm(Model model) {
	    model.addAttribute("user", user);
	    return "userRegister";
	}
	
	@PostMapping("/userRegister")
	public String regisUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "detailRegister";
	}
	
	@GetMapping("/userLogin")
	public String viewloginForm(Model model) {
		model.addAttribute("user", user);
	    return "userLogin";
	}
		
	@GetMapping("/vaccineRegister")
	public String viewVaccineRegis(Model model) {
		Iterable<Province> provinces = provinceRepository.findAll();
		Iterable<Vaccine> vaccines = vaccineRepository.findAll();
		model.addAttribute("register", register);
		model.addAttribute("vaccines", vaccines);
		model.addAttribute("provinces", provinces);
		return "vaccineRegister";
	}
	
	@GetMapping("/resultRegister")
		public String viewResult(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String pid = auth.getName();
		User user = userRepository.findById(pid).orElse(null);
		List<Register> registers = registerRepository.findByUser(user);
		model.addAttribute("registers", registers);
		return "resultRegister";
	}
	
	@PostMapping("/vaccineRegister")
	public String regisVaccine(@ModelAttribute Register register) {
		Province province = provinceRepository.findById(register.getProvince().getProvince_id()).orElse(null);
		Vaccine vaccine = vaccineRepository.findById(register.getVaccine().getVaccine_id()).orElse(null);
		register.setProvince(province);
		register.setVaccine(vaccine);
		register.setStatus("Complete");
		register.setDate(new Date().toString());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String pid = auth.getName();
		User user = userRepository.findById(pid).orElse(null);
		register.setUser(user);
		registerRepository.save(register);
		return "redirect:/resultRegister";
	}
	

				
}
