package com.freya.nc.common.ncutil;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class HttpClientUtils {

    static HttpClient getClient() {
        RequestConfig config = RequestConfig.custom().setSocketTimeout(50000).setConnectTimeout(50000)
                .setConnectionRequestTimeout(50000).build();

        CloseableHttpClient client = HttpClients.custom()
                // 设置请求配置
                .setDefaultRequestConfig(config)
                // 设置重试次数
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();
        return client;
    }

    static HttpClient getSSLClient() {
        RequestConfig config = RequestConfig.custom().setSocketTimeout(50000).setConnectTimeout(50000)
                .setConnectionRequestTimeout(50000).build();

        X509TrustManager trustManager = new X509TrustManager() {
            //检查客户端证书
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
            }

            //检查服务器证书
            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
            }

            //返回受信任的X509证书数组
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        /**
         * 用于解决javax.net.ssl.SSLException: hostname in certificate didn't
         * match: <202.69.27.140> != <*.tongji.baidu.com>
         */
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        };
        CloseableHttpClient client = null;
        try {
            SSLContext ctx = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            ctx.init(null, new TrustManager[]{trustManager}, null);
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx, hostnameVerifier);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("https", socketFactory).build();
            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);

            client = HttpClients.custom()
                    .setConnectionManager(connectionManager)
                    // 设置请求配置
                    .setDefaultRequestConfig(config)
                    // 设置重试次数
                    .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return client;
    }


    public static String doGet(String url) throws Exception {
        HttpClient client = getClient();
        HttpGet get = new HttpGet(url);
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            return EntityUtils.toString(entity, "UTF-8");
        } else {
            return null;
        }
    }

    public static String doPostSSL(String url, String data) throws Exception {
        HttpClient client = getSSLClient();
        StringEntity stringEntity = new StringEntity(data, ContentType.create("application/json", "UTF-8"));
        HttpPost post = new HttpPost(url);
        post.setEntity(stringEntity);
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            return EntityUtils.toString(entity, "UTF-8");
        } else {
            return null;
        }
    }


}
