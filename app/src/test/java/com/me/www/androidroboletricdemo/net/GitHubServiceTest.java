package com.me.www.androidroboletricdemo.net;

import com.google.gson.Gson;
import com.me.www.androidroboletricdemo.GithubService;
import com.me.www.androidroboletricdemo.Repository;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.shadows.ShadowLog;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-9-28
 */

public class GitHubServiceTest {

    private static final String TAG = "GithubServiceTest";

    private GithubService githubService;

    @Before
    public void setUp() throws URISyntaxException {
        //输出日志
        ShadowLog.stream = System.out;
        githubService = GithubService.Factory.create();
    }


    @Test
    public void publicRepositories() throws IOException {

        Call<List<Repository>> call = githubService.publicRepositories("bigbigpeng3");
        Response<List<Repository>> execute = call.execute();

        List<Repository> list = execute.body();
        //可输出完整的响应结果，帮助我们调试代码
        System.out.println(TAG + " = " + new Gson().toJson(list));
//        Log.i(TAG,new Gson().toJson(list));
        assertTrue(list.size() > 0);
        assertNotNull(list.get(0).name);
    }

}
