package com.happyshop.controller;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.happyshop.bean.MailInfo;
import com.happyshop.dao.UserDAO;
import com.happyshop.entity.Order;
import com.happyshop.entity.User;
import com.happyshop.service.CookieService;
import com.happyshop.service.MailService;

@Controller
public class AccountController {

	@Autowired
	UserDAO dao;

	@Autowired
	HttpSession session;

	@Autowired
	CookieService cookie;

	@Autowired
	ServletContext app;

	@Autowired
	MailService mailer;

	@Autowired
	HttpServletRequest request;

	@GetMapping("/account/login")
	public String login(Model model) {
		Cookie ckid = cookie.read("userid");
		Cookie ckpw = cookie.read("pass");
		if (ckid != null) { 
			String uid = ckid.getValue();
			String pwd = ckpw.getValue();

			model.addAttribute("uid", uid);
			model.addAttribute("pwd", pwd);
		}
		return "account/login";
	}

	@PostMapping("/account/login")
	public String login(Model model, 
			@RequestParam("id") String id, 
			@RequestParam("pw") String pw, @RequestParam(value = "rm", defaultValue = "false") boolean rm) { 
		
		User user = dao.findById(id); 
		if (user == null) { 
			model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
		} else if (!pw.equals(user.getPassword())) { 
			model.addAttribute("message", "Sai mật khẩu!"); 

			
		} else if (!user.getActivated()) {
			model.addAttribute("message", "Tài khoản chưa được kích hoạt!");
		}else if (user.getAdmin()) {
			model.addAttribute("message", "Bạn không có quyền!");
		} else {
			model.addAttribute("message", "Đăng nhập thành công!");
			session.setAttribute("user", user); 
			
			if (rm == true) { 
				cookie.create("pass", user.getPassword(), 30); 
			} else { 
				cookie.delete("userid");
				cookie.delete("pass");
			}
			
			String backUrl = (String) session.getAttribute("back-url");
			if (backUrl != null) {
				return "redirect:" + backUrl;
			}
			return "redirect:/home";
		}
		return "account/login";
	}

	@RequestMapping("/account/logout") 
	public String logout(Model model) { 
		session.removeAttribute("user");
		return "redirect:/home";
	}

	@GetMapping("/account/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("form", user);

		return "account/register";
	}

	@PostMapping("/account/register")
	public String register(Model model, @Validated @ModelAttribute("form") User user, BindingResult errors, //đọc dữ liệu từ form gửi lên

			@RequestParam("photo_file") MultipartFile file)
			throws IllegalStateException, IOException, MessagingException {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Error");
			return "account/register";
		} else {
			User user2 = dao.findById(user.getId());
			if (user2 != null) {
				model.addAttribute("message", "Tên đăng nhập đã được sử dụng!");
				return "account/register";
			}
		}

		if (file.isEmpty()) {
			user.setPhoto("user.png");
		} else {
			String dir = app.getRealPath("static/images/customers");
			File f = new File(dir, file.getOriginalFilename());
			file.transferTo(f);
			user.setPhoto(f.getName());
		}
		user.setActivated(false);
		user.setAdmin(false);
		dao.create(user); 
		model.addAttribute("message", "Đăng ký thành công. Vui lòng kiểm tra mail để kích hoạt tài khoản!");


		String from = "truongthimyvvan01012000@gmail.com";
		String to = user.getEmail();
		String subject = "Welcome!";
		String url = request.getRequestURL().toString().replace("register", "activate/" + user.getId());
		String body = "Happy shop xin chào! Vui lòng nhấn vào <a href='" + url + "'>Activate</a> để kích hoạt tài khoản.";
		MailInfo mail = new MailInfo(from, to, subject, body);
		mailer.send(mail);

		return "account/register";
	}

	@GetMapping("/account/activate/{id}")
	public String activate(Model model, @PathVariable("id") String id) {
		User user = dao.findById(id);
		user.setActivated(true);
		dao.update(user);

		return "redirect:/account/login";
	}

	@GetMapping("/account/forgot")
	public String forgot(Model model) {
		return "account/forgot";
	}

	@PostMapping("/account/forgot")
	public String forgot(Model model, 
			@RequestParam("id") String id, 
			@RequestParam("email") String email)
			throws MessagingException {
		User user = dao.findById(id);
		if (user == null) {
			model.addAttribute("message", "Tên tài khoản không đúng!");
		} else if (!email.equals(user.getEmail())) {
			model.addAttribute("message", "Email không đúng!");
		} else {
			String from = "happyshopsuport2020@gmail.com";
			String to = user.getEmail();
			String subject = "Quên mật khẩu!";
			String body = "Happy Shop xin chào! Mật khẩu của bạn là: " + user.getPassword();
			MailInfo mail = new MailInfo(from, to, subject, body);
			mailer.send(mail);
			model.addAttribute("message", "Mật khẩu đã được gửi đến mail của bạn!");

			
		}
		return "account/forgot";
	}

	@GetMapping("/account/change")
	public String change(Model model) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("form", user);

		return "account/change";
	}

	@PostMapping("/account/change")
	public String change(Model model, 
			@ModelAttribute("form") User users,
			@RequestParam("id") String id, 
			@RequestParam("pw") String pw,
			@RequestParam("pw1") String pw1, 
			@RequestParam("pw2") String pw2) {
		if (!pw1.equals(pw2)) {
			model.addAttribute("message", "Xác nhận mật khẩu không trùng khớp!");
		} else {
			User user = dao.findById(id);
			if (user == null) {
				model.addAttribute("message", "Sai tài khoản!");
			} else if (!pw.equals(user.getPassword())) {
				model.addAttribute("message", "Mật khẩu hiện tại không đúng!");
			} else {
				user.setPassword(pw1);
				dao.update(user);

				model.addAttribute("message", "Thay đổi mật khẩu thành công!");
			}
		}
		return "account/change";
	}

	@GetMapping("/account/edit")
	public String edit(Model model) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("form", user);

		return "account/edit";
	}

	@PostMapping("/account/edit")
	public String edit(Model model, @ModelAttribute("form") User user,BindingResult errors,
			@RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException, MessagingException {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây!");
			return "account/edit";
		} 
		if(!file.isEmpty()) {
			String dir = app.getRealPath("static/images/customers");
			File f = new File(dir, file.getOriginalFilename());
			file.transferTo(f);
			user.setPhoto(f.getName());
		}
		dao.update(user);
		session.setAttribute("user", user);
		model.addAttribute("message", "Cập nhật tài khoản thành công!");


		return "account/edit";
	}

}
