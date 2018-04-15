package utils;

import entity.Role;
import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class SetupTestUsers {
  
  public static void main(String[] args) {
    
    EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();
    
     em.getTransaction().begin();
          Role userRole = new Role("user");
          Role adminRole = new Role("admin");
          
          User user = new User("user", "test");
          user.addRole(userRole);
          
          User admin = new User("admin", "test");
          admin.addRole(adminRole);
          
          User both = new User("user_admin", "test");
          both.addRole(userRole);
          both.addRole(adminRole);
          
          User anders = new User("anders","test");
          anders.addRole(userRole);
          
          
          em.persist(userRole);
          em.persist(adminRole);
          em.persist(user);
          em.persist(admin);
          em.persist(both);
          em.persist(anders);
          em.getTransaction().commit();
          System.out.println("PW: "+user.getUserPass());
          System.out.println("Testing user with OK password: "+user.verifyPassword("test"));
          System.out.println("Testing user with wrong password: "+user.verifyPassword("test1"));
          System.out.println("Created TEST Users");
    
  }
        
}