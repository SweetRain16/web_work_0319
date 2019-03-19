package kr.hs.dgsw.web_2_0319;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> userList;

    public UserServiceImpl(){
        this.userList = new ArrayList<>();
        this.userList.add(new User("user1", "user111@dgsw"));
        this.userList.add(new User("user2", "user222@dgsw"));
        this.userList.add(new User("user3", "user333@dgsw"));
    }

    @Override
    public List<User> list() {
        return this.userList;
    }

    @Override
    public User view(String name){
//        for (int i = 0 ; i < this.userList.size() ; i++){
//            User found = this.userList.get(i);
//            if (found.getName().equals(name)){
//                return found;
//            }
//        }
//        return null;

        User found = this.userList.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
        return found;
    }

    @Override
    public boolean add(User user){
        return this.userList.add(user);
    }

    @Override
    public User update(User user){
        User found = this.view(user.getName());
        if (found != null){
            found.setEmail(user.getEmail());
        }
        return found;
    }

    @Override
    public boolean delete(String name){
        User found = this.view(name);
        return this.userList.remove(found);
    }

    public User find1(String name){
        Iterator<User> iterable = this.userList.iterator();
        while (iterable.hasNext()){
            User found = iterable.next();
            if (found.getName().equals(name)){
                return found;
            }
        }
        return null;
    }

    public User find2(String name){
        for (User found: this.userList){
            if (found.getName().equals(name)) {
                return found;
            }
        }
        return null;
    }

    public User find3(String name){
        //리스트는 stream으로 만들 수 있다. stream으로 만든 것을 필터링할 수 있다. 필터링의 결과는 findAny로 끄집어 낼 수 있다.
        User found = this.userList.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
        return found;
    }

}
