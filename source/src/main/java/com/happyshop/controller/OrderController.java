package com.happyshop.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import com.happyshop.bean.MailInfo;
import com.happyshop.dao.UserDAO;
import com.happyshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.happyshop.dao.OrderDAO;
import com.happyshop.dao.OrderDetailDAO;
import com.happyshop.dao.ProductDAO;
import com.happyshop.entity.Order;
import com.happyshop.entity.OrderDetail;
import com.happyshop.entity.Product;
import com.happyshop.entity.User;
import com.happyshop.service.CartService;



@Controller
public class OrderController {
	@Autowired
	ProductDAO pdao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CartService cart;

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO dao;
	
	@Autowired
	OrderDetailDAO ddao;

	@Autowired
	MailService mailer;

	@GetMapping("/order/checkout")
	public String showForm(@ModelAttribute("order") Order order) {
		User user = (User) session.getAttribute("user");

		order.setOrderDate(new Date());
		order.setUser(user);
		order.setAmount(cart.getAmount());
		order.setStatus(1);
		return "order/checkout";

	}
	
	@PostMapping("/order/checkout")
	public String purchase(Model model, 
			@ModelAttribute("order") Order order) throws MessagingException {
		Collection<Product> list = cart.getItems();
		List<OrderDetail> details = new  ArrayList<>();
		for(Product product:list) {
			OrderDetail detail =new OrderDetail();
			detail.setOrder(order);
			detail.setProduct(product);
			detail.setUnitPrice(product.getUnitPrice());
			detail.setQuantity(product.getQuantity());
			detail.setDiscount(product.getDiscount());
			details.add(detail);

		}
		dao.create(order, details);
		cart.clear();

		String from = "truongthimyvvan01012000@gmail.com";
		User user = userDAO.findById(order.getUser().getId());
		String to = user.getEmail();
		String subject = "Đặt hàng thành công!";
		BigDecimal bigDecimal = new BigDecimal(Double.toString(order.getAmount()));
		String body = "Happy shop xin chào! Bạn vừa đặt đơn hàng tổng giá trị " + bigDecimal.toPlainString() + " VNĐ";
		MailInfo mail = new MailInfo(from, to, subject, body);
		mailer.send(mail);
		 
		model.addAttribute("message", "Đặt hàng thành công!");


		return "redirect:/order/list";

	}
	
	
	@GetMapping("/order/list")
	public String list(Model model) {
		User user = (User) session.getAttribute("user");
		List<Order> orders = dao.findByUser(user);
		model.addAttribute("orders", orders);
		return "order/list";
	}
	
	@GetMapping("/order/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Order order = dao.findById(id);
		List<OrderDetail> details = ddao.findByOrder(order);
		model.addAttribute("order", order);
		model.addAttribute("details", details);
		return "order/detail";
	}
	
	@GetMapping("/order/items")
	public String items(Model model) {
		User user = (User) session.getAttribute("user");
		List<Product> list = dao.findItemsByUser(user);
		model.addAttribute("list", list);
		return "product/list_order_item";
	}
}




