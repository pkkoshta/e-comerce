package com.controller;

import com.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("/flipkart.com")
public class FlipKartController {
    public static String FileDir = System.getProperty("user.dir")+"/uploads";
    @Autowired
    private Userservice userservice;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CartService cartService;



   private String actualFile = null;
    private String originalFIlename=null;

    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private CheckOutService checkOutService;

    @PostMapping("/checkout")
    public void saveBillingAdd(@RequestBody CheckOut checkOut){
        System.out.println(checkOut.toString());
        checkOutService.saveCheckoutetails(checkOut);
    }


    // get all cart items
    @GetMapping("/getCartItem")
    public List<CartItem> getCartItem(){
        List<CartItem> cartItems = cartService.getItems();
        System.out.println(cartItems.size());
        return cartService.getItems();
    }

//    add to cart
    @PostMapping("/addCart")
    public String addCart(@RequestBody CartItem cartItem){
        String msg = null;
        CartItem cartItem1 =  cartService.addCart(cartItem);
        if(cartItem1 != null){
            return new String("You cart is added "+ cartItem1.getCartId());
        }else {
            return new String ("Something went wroung ");
        }
    }

    // get All total product
    @GetMapping("totoalPro")
    public int getNumberOfProduct(){
        List<Product> listPro = productService.getTotalproduct();
        return listPro.size();
    }

    @GetMapping("/totalCat")
    public int getTotalCategory(){
        List<Category> cat = categoryService.totalCategories();
        return cat.size();

    }

    @GetMapping("/category")
    public List <Category> getAllCategory(){
        return categoryService.getAllProduct();
    }


    @GetMapping("/getProduct")
    public List<Product> getAllProduct(){
      return productService.getProduct();
    }

    @PostMapping("/category")
    public String addCategory(@RequestBody Category category){
        Category category1 = null;
        category1 = categoryService.addCategory(category);
        return "Category Added";

    }
    @PostMapping("/upload")
    public void getFileName(@RequestParam("imageFile") MultipartFile file) throws IOException {
      StringBuilder originalFile = new StringBuilder();

      Path fileNameAndPAth = Paths.get(FileDir, file.getOriginalFilename());
      originalFile.append(file.getOriginalFilename());
        Files.write(fileNameAndPAth, file.getBytes());
      actualFile = file.getOriginalFilename();
    }

    @PostMapping(value = "/creProduct")
    @CrossOrigin(value = "http://localhost:4200")
    public ResponseEntity<?> createProduct(@RequestBody Product product) throws JsonProcessingException {
        Product product1 = null;
       product.setpPhoto(actualFile);
        product1 = productService.saveProduct(product);
        if (product1 !=null){
            return new ResponseEntity <>("Product is saved", HttpStatus.OK);
        }
        return new ResponseEntity <>("Product is not saved", HttpStatus.OK);

    }

    @PostMapping("/userlogin")
    public ResponseEntity<?> getByEmailPass(@RequestBody User user){
        User user1 = null;
        System.out.println("Controller "+user.getEmail() +" "+user.getPassword());
       user1 = userservice.getUserByEmail(user.getEmail(), user.getPassword());
        //System.out.println(user1.toString());
       if (user1 != null){
           return new ResponseEntity ("User is authenticated" , HttpStatus.OK);
       }else{
           return new ResponseEntity ("User is not authenticated" , HttpStatus.OK); }

    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody User user){
        User user1 = null;
       user1 = userservice.saveUser(user);
        if (user1 != null){
            return new ResponseEntity ("User is created" , HttpStatus.OK);
        }else{
            return new ResponseEntity ("User is not created" , HttpStatus.OK); }

    }

//    adminlogin
    @PostMapping("/login")
    public User adminLogin(@RequestBody User user){
        User user1 = null;
        user1 = userservice.adminLog(user.getEmail(), user.getPassword());
        System.out.println("admin log"+user1.toString());
        return user1;
    }
}
