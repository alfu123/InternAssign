package productcrud.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrud.dao.LoginDao;
import productcrud.dao.ProductDao;
import productcrud.model.Product;


@Controller
public class MainController {
	@Autowired
	public ProductDao productDao;
	
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	// this is first login index.jsp page.
		@RequestMapping("/login")
		public String loginPage() 
		{
			System.out.println("this is loginpage handler!!..");
			return "home";
		}
	@RequestMapping("/welcome-product")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping("/index-product")
	public String index(Model m) {
		List<Product> products=productDao.getProducts();
		m.addAttribute("products",products);
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m,HttpServletRequest request ) {
		m.addAttribute("title","add product");
		return "add_product_form";
	}
	@RequestMapping(value="/handle-product", method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request ) {
		System.out.print(product);
		productDao.createproduct(product);
		
		 RedirectView  redirectView =new  RedirectView ();
		 redirectView.setUrl(request.getContextPath()+"/index-product");
		 return redirectView ;
		
	}
	
	
//	
//	@RequestMapping(value="/handle-product", method=RequestMethod.POST)
//	public String handleProduct(@ModelAttribute Product product,HttpServletRequest request ) {
//		System.out.print(product);
//		productDao.createproduct(product);
//		
//		 RedirectView  redirectView =new  RedirectView ();
//		 redirectView.setUrl(request.getContextPath()+"/");
//		 return "index" ;
//		
//	}
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId ,HttpServletRequest request ) {
		this.productDao.deleteProduct(productId);
		RedirectView  redirectView =new  RedirectView ();
		 redirectView.setUrl(request.getContextPath()+"/index-product");
		 return redirectView ;
	}
	
	@RequestMapping("/update/{productId}")



	public String updateForm (@PathVariable("productId") int pid, Model m) {


	Product product= this.productDao.getProduct (pid); 
	 m.addAttribute("product", product);


	return "update_form";
	
	}
	
	
	@RequestMapping(path = "/checkuser")//, method = RequestMethod.POST)
	public String checkUser(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {

		String uname = request.getParameter("name");
		String upass = request.getParameter("password");
		if(uname.length()>=5 && uname.length()<=50 && upass.length()>=5 && upass.length()<=50) {
			LoginDao d=new LoginDao();
			if(d.check(uname, upass)) {
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("current-user",uname);
				return "welcome";
			}
				else {
					return "redirect:/login";
				}
			
		}

//
//		if (uname.equals("test") && upass.equals("test@123"))
//		{
//			
//			HttpSession httpSession=request.getSession();
//			httpSession.setAttribute("current-user",uname);
//			return "welcome";
//		}
		
		return "redirect:/login";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		HttpSession httpSession=request.getSession();
		httpSession.removeAttribute("current-user");
		System.out.println("Logout page handler");
		return "redirect:/login";
		
	}
	

}
