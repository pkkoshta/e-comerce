package com.controller;

import com.entity.Category;
import com.entity.Product;
import com.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.Userservice;
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
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("/flipkart.com")
public class FlipKartController {

    @Autowired private Userservice userservice;
    @Autowired private ProductService productService;
    @Autowired private CategoryService categoryService;

    private byte[] bytes;

    private ObjectMapper objectMapper = new ObjectMapper();

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

    @GetMapping
    public String heelo(){
        return "His ";
    }

    @PostMapping("/category")
    public String addCategory(@RequestBody Category category){
        Category category1 = null;
        category1 = categoryService.addCategory(category);
        return "Category Added";

    }
    @PostMapping("/upload")
    public void getFileName(@RequestParam("imageFile") MultipartFile file) throws IOException {
      this.bytes = file.getBytes();


    }

    @PostMapping(value = "/creProduct")
    @CrossOrigin(value = "http://localhost:4200")
    public ResponseEntity<?> createProduct(@RequestBody Product product) throws JsonProcessingException {
        Product product1 = null;
      product.setpPhoto(this.bytes);
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
