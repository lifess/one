package example.ss.com.commit1;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String mUrl="http://v.juhe.cn/";
    @GET("toutiao/index?type=shishang&key=d2c810afda836f6f04774dd84aa8c7b5")
    Observable<FashionBean> getFashion();
}
