import service.User;
import service.UserService;
import service.UserServiceImplService;

public class webServiceClient {

    public static void main(String args[]) {

        UserServiceImplService serviceImpl = new UserServiceImplService();

        UserService service = serviceImpl.getUserServiceImplPort();

        User u1 = new User();
        u1.setName("User1");
        u1.setId(1);

        User u2 = new User();
        u2.setName("User2");
        u2.setId(2);

        System.out.println("Add User Status="+service.addUser(u1));
        System.out.println("Add User Status="+service.addUser(u2));

        //get user
        User user1 = service.getUser(1);
        System.out.println("Get User");
        System.out.println("User: Id:" +user1.getId()+ " :: "+user1.getName());

        //get all users
        System.out.println("Get All Users");
        service.getAllUsers().getItem().forEach(user -> {
            System.out.println("User: Id:" +user.getId()+ " :: "+user.getName());
        });
    }
}
