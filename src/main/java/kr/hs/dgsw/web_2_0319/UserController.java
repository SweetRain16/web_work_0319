package kr.hs.dgsw.web_2_0319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody           //안 넣어도 되지만 넣으면 프로그램이 덜 힘들어한다.
    public List<User> list(){
        return this.userService.list();
    }

    @GetMapping("/user/{name}")
    @ResponseBody
    public User view(@PathVariable String name){
        return this.userService.view(name);
    }

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user){
        return this.userService.add(user);
    }

    @PutMapping("/user/")
    @ResponseBody
    public User update(@RequestBody User user){
        return this.userService.update(user);
    }

    @PutMapping("/user/{name}")
    @ResponseBody
    public boolean delete(@PathVariable String name){
        return this.userService.delete(name);
    }
}
// CRUD Create Read Update Delete
// SQL inser select update delete
//HTTP POST  GET    PUT    DELETE