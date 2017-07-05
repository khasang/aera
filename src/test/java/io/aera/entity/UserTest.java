package io.aera.entity;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class UserTest {
    private static final Object[] getUser() {
      return new Object[] {
              new Object[] {1L,"pet","Petr","Smirnov","smirnov","petr@yandex.ru",1},
              new Object[] {2L,"krak","Ivan","Petrov","petrov","ivan@yandex.ru",1},
              new Object[] {3L,"fact","Fedor","Kolokov","kolokov","fedor@yandex.ru",1}
      };
    }

    @Test
    @Parameters(method = "getUser")
    public void createNewUserSuccessfully(long id, String login, String firstname,
                                          String lastname, String password, String email, int role){
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPassword(password);
        user.setEmail(email);
        user.setRoleId(role);

        assertEquals(id, user.getId());
        assertEquals(login, user.getLogin());
        assertEquals(firstname, user.getFirstname());
        assertEquals(lastname, user.getLastname());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(role, user.getRoleId());
    }
}
