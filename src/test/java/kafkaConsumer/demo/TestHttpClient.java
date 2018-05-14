package kafkaConsumer.demo;

import org.junit.Test;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.AsyncHttpClientConfig.Builder;
import com.ning.http.client.Response;
import com.ning.http.client.providers.netty.NettyAsyncHttpProvider;
import com.ning.http.client.providers.netty.NettyResponse;

public class TestHttpClient {
	

		 
		public static int runCount = 10;
	 
		@Test
		public void main() {
			// --------------AsyncHttpClient-------------------------
			long start1 = System.currentTimeMillis();
			this.AsyncHttpClientTest1();
			long end1 = System.currentTimeMillis();
			System.out.println("使用AsyncHttpClient 共用时间　" + (end1 - start1) + "ms");
			
			// --------------NettyAsyncHttpProvider-------------------------
			long start2 = System.currentTimeMillis();
			this.AsyncHttpClientTest2();
			long end2 = System.currentTimeMillis();
			System.out.println("使用AsyncHttpClient中的NettyAsyncHttpProvider 共用时间　" + (end2 - start2) + "ms");
			
			// --------------httpClient-------------------------
			long start11 = System.currentTimeMillis();
			this.HttpCientTest();
			long end11 = System.currentTimeMillis();
			System.out.println("使用AsyncHttpClient中的HttpCientTest 共用时间　" + (end11 - start11) + "ms");
		}
	 
		@Test
		public void AsyncHttpClientTest1() {
			try {
				System.out.println("AsyncHttpClientTest1 1");
				AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
				System.out.println("AsyncHttpClientTest1 2");
				builder.setMaximumConnectionsTotal(10000);
				System.out.println("AsyncHttpClientTest1 3");
				AsyncHttpClient asyncHttpClient = new AsyncHttpClient(builder.build());
				System.out.println("AsyncHttpClientTest1 4");
				for (int i = 0; i < runCount; i++) {
					System.out.println("AsyncHttpClientTest1 i-1"+i);
					Future future = asyncHttpClient.prepareGet("http://10.69.7.14/api/version").execute();
					System.out.println("AsyncHttpClientTest1 i-2"+i);
					NettyResponse nettyResponse = (NettyResponse) future.get();
					System.out.println("AsyncHttpClientTest1 i-3"+i);
					//System.out.println("*********"+nettyResponse.getResponseBody());
					System.out.println("AsyncHttpClientTest1 i-4"+i);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	 
		@Test
		public void AsyncHttpClientTest2() {
			try {
				Builder config = new AsyncHttpClientConfig.Builder();
				NettyAsyncHttpProvider nettyAsyncHttpProvider = new NettyAsyncHttpProvider(config.build());
				AsyncHttpClient asyncHttpClient = new AsyncHttpClient(nettyAsyncHttpProvider);
				for (int i = 0; i < runCount; i++) {
					Future future = asyncHttpClient.prepareGet("http://10.69.7.14/api/version").execute();
					NettyResponse nettyResponse = (NettyResponse) future.get();
					// System.out.println(nettyResponse.getResponseBody());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	 
		@Test
		public void HttpCientTest() {
			try {
				for (int i = 0; i < runCount; i++) {
					HttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet("http://10.69.7.14/api/version");
					HttpResponse httpResponse = httpClient.execute(httpGet);
					HttpEntity entity = httpResponse.getEntity();
					// System.out.println(entity.getContent());
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


}
