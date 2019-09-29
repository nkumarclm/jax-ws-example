package service;

import domain.User;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebService(endpointInterface = "service.UserService")
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> users = new HashMap<Integer, User>();

    @Override
    public boolean addUser(User p) {
        if(users.get(p.getId()) != null) return false;
        users.put(p.getId(), p);
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        if(users.get(id) == null) return false;
        users.remove(id);
        return true;
    }

    @Override
    public User getUser(int id) {
        return users.get(id);
    }

    @Override
    public User[] getAllUsers() {
        Set<Integer> ids = users.keySet();
        User[] p = new User[ids.size()];
        int i=0;
        for(Integer id : ids){
            p[i] = users.get(id);
            i++;
        }
        return p;
    }
}
