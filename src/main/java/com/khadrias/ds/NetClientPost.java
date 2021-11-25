package com.khadrias.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class NetClientPost {

	public static void main(String[] args) {

		try {
			String token = "";
			HashMap<String, String> params = new HashMap<>();
			params.put("client_id", "");
			params.put("client_secret", "");
			params.put("scope", "");
			params.put("grant_type", "client_credentials");

			String urlParameters = getDataString(params);
			URL url = new URL(
					"https://login.microsoftonline.com/oauth2/v2.0/token");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
			conn.setUseCaches(false);

			OutputStream os = conn.getOutputStream();
			os.write(urlParameters.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				JSONObject obj = new JSONObject(output);
				String tokenType = obj.getString("token_type");
				String accessToken = obj.getString("access_token");
				int expiresIn = obj.getInt("expires_in");
				int extExpiresIn = obj.getInt("ext_expires_in");
				token = tokenType + " " + accessToken;
				System.out.println("token = " + token);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	private static String getDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (first)
				first = false;
			else
				result.append("&");
			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}
		return result.toString();
	}
}