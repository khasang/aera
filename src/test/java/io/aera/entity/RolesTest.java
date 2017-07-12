package io.aera.entity;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnitParamsRunner.class)
public class RolesTest {
    private static final Object[] getRoles() {
        return new Object[] {
                new Object[] {1, "ROLE_ADMIN"},
                new Object[] {2, "ROLE_USER"}
        };
    }

    @Test
    @Parameters(method = "getRoles")
    public void createNewRolessuccessfully(int id, String role){
        Roles roles = new Roles();
        roles.setId(id);
        roles.setRole(role);

        assertNotNull(roles);
        assertEquals(id, roles.getId());
        assertEquals(role, roles.getRole());
    }
}
