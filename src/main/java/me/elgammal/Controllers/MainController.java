package me.elgammal.Controllers;

import  me.elgammal.models.User;
import me.elgammal.repositorties.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired

    private UsersRepository usersRepository;


    @GetMapping(path = "users")
    public @ResponseBody Iterable<User> getAllUsers()
    {
        return usersRepository.findAll();
    }

    @PostMapping(path = "users")
    public ResponseEntity <User> addNewUser(@RequestBody User data)
    {
        User user = new User();
        if (data.getId() > 0)
            user.setId(data.getId());

        user.setName(data.getName());
        user.setEmail(data.getEmail());
        usersRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @PatchMapping(path = "users")
    public ResponseEntity <?> updateUser(@RequestBody User data)
    {
        Optional <User> user =  usersRepository.findById(data.getId());
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        usersRepository.save(data);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "users")
    public @ResponseBody  String deleteUser(@RequestParam Integer id)
    {
        Optional<User> user =  usersRepository.findById(id);
        return "find";
    }
}
