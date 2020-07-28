package com.example.akaoshi.net;



import com.example.akaoshi.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String Base_url="http://cdwan.cn:7000/";
//    http://cdwan.cn:7000/exam/data.json
    @GET("exam/data.json")
    Observable<Bean>getData();
//

}
