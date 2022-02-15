package com.mcanics.user_app.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcanics.user_app.data.models.User;
import com.mcanics.user_app.data.payloads.request.UserRequest;
import com.mcanics.user_app.data.payloads.response.MessageResponse;
import com.mcanics.user_app.data.repository.MechanicRepository;
import com.mcanics.user_app.data.repository.UserRepository;
import com.mcanics.user_app.service.UserService;

import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
//Line 19 to 24 is the newly added code for swagger documentation
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
public class UserController {
	@Autowired
    UserService userService;
    @Autowired
	private MechanicRepository mechRepo;
    @Autowired
	private UserRepository userRepo;
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> footballers = userService.getAllUser();
        return new ResponseEntity<>(footballers, HttpStatus.OK);
    }
    @GetMapping("/find/{userId}")
    public ResponseEntity<User> getUserById (@PathVariable("userId") Integer userId) {
        User user = userService.getASingleUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addUser(@Valid @RequestBody UserRequest user) {
        MessageResponse newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    

    @PutMapping("/update/{userId}")
    public Optional<User> updateUser(@PathVariable Integer userId, @RequestBody UserRequest user) {
        return userService.updateUser(userId,user);

    }

    @DeleteMapping("/delete/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users")
	public List<User> getAll (@RequestParam Integer page, @RequestParam Integer size) {
		Pageable pages = PageRequest.of(page, size);
		return userService.getAll(pages).toList();
    }
}
