package com.wyman.wymanframework.net;

import com.wyman.wymanframework.entity.Article;
import com.wyman.wymanframework.entity.Banner;
import com.wyman.wymanframework.entity.DataResponse;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lw on 2018/1/23.
 */

public interface ApiService {
    /**
     * 首页数据
     * http://www.wanandroid.com/article/list/0/json
     *
     * @param page page
     */
    @GET("/article/list/{page}/json")
    Observable<DataResponse<Article>> getHomeArticles(@Path("page") int page);

    /**
     * 首页Banner
     *
     * @return BannerResponse
     */
    @GET("/banner/json")
    Observable<DataResponse<List<Banner>>> getHomeBanners();

}
