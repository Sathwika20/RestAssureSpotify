package com.bridgelazRestAssureSpotify;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;

public class RestAssureSpotify {
        public String token = "";
        public String user_id = "";

        @BeforeMethod
        public void setUp(){

        token = "Bearer BQCumY0U_C-_RLJufiYQVCClfihnctGqwlHWmBswjp7qq2JDPj-OzFieHUCxdp59Xznx-h4h1v4xYANVTIeSRLIaRQUczwz6xoNXg-jxfoQPnXMZ5sn6cfjt7o5Ch3LX_cVM_dbkpm89JwHRhCq21t3MexKR3_-QgBsPQiBjoipMKzmAK9PkC5DaC9lWcNCozsk36C08npB2o_9lwKEzomn2kOpol5dnRzhL_fPHZBGfKJ1bMnAfxfBmRBiszIISJF_QGT5vZp2WJz_rctqQqwHsOPSIzyrjfphrKcs0J88o";
    }
    @Test(priority = 1)
    public void getCurrent_User_Profile(){
            Response response = given()
                    .contentType(ContentType.JSON).accept(ContentType.JSON)
                    .header("Authorization",token)
                    .when()
                    .get("https://api.spotify.com/v1/me");
            response.prettyPrint();
            int statusCode = response.getStatusCode();
            user_id = response.path("id");
        Assert.assertEquals(200,statusCode);
        Assert.assertEquals("312oj3o3gcidmzwbk4gzurfkffk4", user_id);
        System.out.println("get user profile "+user_id);
    }
    @Test(priority = 2)
    public void get_UserProfile(){
        System.out.println("get user profile1 "+user_id);
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization",token)
                    .when()
                    .get("https://api.spotify.com/v1/users/" + user_id+ "/");
            response.prettyPrint();
            int statusCode = response.getStatusCode();

        Assert.assertEquals(200,statusCode);
       // Assert.assertEquals("312oj3o3gcidmzwbk4gzurfkffk4", user_id);

    }
    @Test(priority = 3)
    public void get_PlayLists(){
            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .header("Authorization",token)
                    .when()
                    .get("https://api.spotify.com/v1/me/playlists");
            response.prettyPrint();
        int statusCode = response.getStatusCode();
           //user_id = response.path("id");
        Assert.assertEquals(200,statusCode);
        }
    @Test(priority = 4)
    public void post_Playlist(){
        //JSONObject request = new JSONObject();
        //request.put("name", "FastTrackSongs");
        //request.put("description", "Play Fast Track Songs");
        //request.put("public", "false");

      Response response = given()
              .contentType(ContentType.JSON)
              .accept(ContentType.JSON)
              .header("Authorization",token)
              .body("{\"name\":\"FastTrackSongs\",\"description\":\"OLD MOVIE SONGS\",\"public\":\"false\"}")
              .when()
              .post("https://api.spotify.com/v1/users/"+user_id+"/playlists");
      response.prettyPrint();
        int statusCode = response.getStatusCode();
          //  user_id = response.path("id");
        response.then().assertThat().statusCode(201);
        //Assert.assertEquals("312oj3o3gcidmzwbk4gzurfkffk4", user_id);
        System.out.println("get user profile "+user_id);

        }
}
