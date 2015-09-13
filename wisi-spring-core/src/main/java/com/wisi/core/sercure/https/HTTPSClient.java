package com.wisi.core.sercure.https;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTTPSClient {
	
	private static SSLContext sslContext;
	private static SSLSocketFactory ssf;
	private static Logger logger = LoggerFactory.getLogger(HTTPSClient.class);
	
	static{
		try {
			sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			TrustManager[] tm = {new BaseTrustManager()};
			sslContext.init(null, tm, new java.security.SecureRandom());
			ssf = sslContext.getSocketFactory();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object ConnectToServer(URL url, String jsoninput, boolean hasinput, boolean hasoutput, String requestMethod){
		try {
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setSSLSocketFactory(ssf);
			con.setDoInput(true);
			con.setRequestMethod(requestMethod);
			OutputStream os = null;
			StringBuffer sb = null;
			StringBuffer log = new StringBuffer();
			log.append(requestMethod).append(":");
			log.append("url=").append(url).append(".");
			
			if(hasinput){
				log.append("jsoninput=").append(jsoninput).append(".");
				if(jsoninput == null){
					log.append("parameter error.");
					logger.error(log.toString());
				}
				con.setDoOutput(true);
				os = con.getOutputStream();
				os.write(jsoninput.getBytes());
				os.close();
			}
			
			if(hasoutput){
				InputStream is = con.getInputStream();
				InputStreamReader inputstreamReader = new InputStreamReader(is);
				BufferedReader bufferedreader = new BufferedReader(inputstreamReader);
				String str = null;
				sb = new StringBuffer();
				while((str = bufferedreader.readLine()) != null){
					sb.append(str);
				}
				bufferedreader.close();
				inputstreamReader.close();
				is.close();
			}

			con.disconnect();
			return sb.toString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object doPost(URL url, String input){
		return ConnectToServer(url, input, true, true, "POST");
	}
	
	public static Object doGet(URL url){
		return ConnectToServer(url, null, false, true, "GET");
	}
}
