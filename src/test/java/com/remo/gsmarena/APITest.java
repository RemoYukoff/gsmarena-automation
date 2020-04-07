package com.remo.gsmarena;


import com.jayway.restassured.response.Response;
import com.qaprosoft.apitools.validation.JsonKeywordsComparator;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.remo.gsmarena.api.users.*;
import org.json.JSONException;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.RegularExpressionValueMatcher;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class APITest extends AbstractTest {
    @Test
    public void getAllUsers(){
        GetUsersMethod api = new GetUsersMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstJSONSchema("api/users/get/rs.schema");
    }

    @Test
    public void getUserById(){
        PostUserMethod newUser = new PostUserMethod();
        Response rp = newUser.callAPI();
        newUser.validateResponse();
        int id = rp.jsonPath().getInt("result.id");
        GetUserMethod api = new GetUserMethod(id);
        //set GET properties equal to the POST properties
        for(Entry<Object,Object> entry : newUser.getProperties().entrySet()){
            api.getProperties().setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void getUsersByFilter() throws JSONException {
        Map<String,String> params = new HashMap<>();
        params.put("first_name","Daniel");
        params.put("status","inactive");
        FilterUsersMethod api = new FilterUsersMethod(params);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        Response rp = api.callAPI();
        for(Entry<String,String> entry: params.entrySet()){
            List<String> results = rp.jsonPath().getList("result."+entry.getKey());
            boolean allContains = results.stream()
                    .allMatch(value -> value.contains(entry.getValue()));
            Assert.assertTrue(allContains);
        }
        api.validateResponseAgainstJSONSchema("api/users/get/rs.schema");
    }

    @Test
    public void postNewUser(){
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
    public void updateUser(){
        PostUserMethod newUser = new PostUserMethod();
        Response rp = newUser.callAPI();
        newUser.validateResponse();
        int id = rp.jsonPath().getInt("result.id");
        PutUserMethod api = new PutUserMethod(id);
        api.callAPI();
        api.validateResponse();
    }
}
