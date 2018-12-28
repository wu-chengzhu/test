package com.example.gp62.test;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class HttpUtil {

    //创建HttpClient对象
    public static HttpClient httpClient=new DefaultHttpClient();
    public static final String BASE_URL="http://192.168.32.1:88/Login"; //访问的服务器地址

    /**
     *
     * @param url 发送请求的url
     * @param rawParams 请求的参数 map类的键值对
     * @return   服务器响应字符串
     * @throws Exception
     */
   public static String postRequest(final String url,final Map<String,String> rawParams)throws Exception
   {
       FutureTask<String> task=new FutureTask<String>(new Callable<String>() {
           @Override
           public String call() throws Exception {
               HttpPost post=new HttpPost(url);//创建HttpPost对象
               List<NameValuePair> params=new ArrayList<NameValuePair>();
               for(String key:rawParams.keySet())
               {
                   params.add(new BasicNameValuePair(key,rawParams.get(key))); //封装请求参数
               }
               post.setEntity(new UrlEncodedFormEntity(params,"utf-8"));//设置请求参数
               HttpResponse httpResponse=httpClient.execute(post);//发送post请求
               Log.v("service","发送成功了吗？");
               if(httpResponse.getStatusLine().getStatusCode()==200)// 如果200ms内有返回响应
               {
                   String result=EntityUtils.toString(httpResponse.getEntity());//获得服务器响应的字符串

                   return result;//返回响应字符串
               }

               return null;
           }
       });
       new Thread(task).start(); //开启一个线程执行这个任务
       return task.get(); //


   }
}
