package com.remo.gsmarena;


import com.jayway.restassured.response.Response;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.remo.gsmarena.api.users.DeleteUserMethod;
import com.remo.gsmarena.api.users.GetUsersMethod;
import com.remo.gsmarena.api.users.PostUserMethod;
import com.remo.gsmarena.api.users.PutUserMethod;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITest extends AbstractTest {
    @Test
    public void getUsers(){
        GetUsersMethod api = new GetUsersMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstJSONSchema("api/users/get/rs.schema");
    }

    @Test
    public void postUser(){
        PostUserMethod api = new PostUserMethod();
        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void deleteUser(){
        PostUserMethod newUser = new PostUserMethod();
        Response rp = newUser.callAPI();
        newUser.validateResponse();
        int id = rp.jsonPath().getInt("result.id");
        DeleteUserMethod api = new DeleteUserMethod(id);
        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void putUser(){
        PostUserMethod newUser = new PostUserMethod();
        Response rp = newUser.callAPI();
        newUser.validateResponse();
        int id = rp.jsonPath().getInt("result.id");
        PutUserMethod api = new PutUserMethod(id);
        api.callAPI();
        api.validateResponse();
    }
}
