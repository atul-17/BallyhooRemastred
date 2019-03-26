package example.atul.ballyhoohomescreenappchanges;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by atul on 2/11/19.
 */
public interface ApiService {
    @GET("api/v1/test")
    Call<ModelHomeScreen>homeScreenApi ();

}
