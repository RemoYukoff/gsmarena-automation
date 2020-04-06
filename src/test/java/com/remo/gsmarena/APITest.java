package com.remo.gsmarena;


import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.remo.gsmarena.api.users.GetUsersMethod;
import org.testng.annotations.Test;

public class APITest extends AbstractTest {
    @Test
    public void testGetUsers(){
        GetUsersMethod api = new GetUsersMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstJSONSchema("api/users/get/rs.schema");
    }
}
