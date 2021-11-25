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

public class NetClientGet {

	public static void main(String[] args) {

		try {
			String token = "";
			HashMap<String, String> params = new HashMap<>();
			params.put("client_id", "");
			params.put("client_secret", "");
			params.put("scope", "");
			params.put("grant_type", "client_credentials");

			String urlParameters = getDataString(params);
			URL url = new URL("https://login.microsoftonline.com/oauth2/v2.0/token");
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

				// Map jsonStringToMap = objectMapper.readValue(countryStr,
				// new TypeReference<Map>() {
				// });
				// System.out.println("Country as a Map : " + jsonStringToMap);
			}

			conn.disconnect();
			callGetAPI(token);
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void callGetAPI(String token) {
		final String USER_AGENT = "Mozilla/5.0";
		try {
			HashMap<String, String> params = new HashMap<>();
			params.put("requestDate", "2017-10-16");
			params.put("agentCode", "100165");
//			params.put("agencyCode", "511212");
			params.put("licenseCode", "VA");

			StringBuilder stringBuilder = new StringBuilder("https://internal.dev.apps.com/api/agents/v1/search");
			stringBuilder.append("?");
			stringBuilder.append(getDataString(params));
			System.out.println(stringBuilder.toString());
			URL url = new URL(stringBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", token);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("GET");
//			conn.setRequestProperty("User-Agent", USER_AGENT);
//			conn.setRequestProperty("Accept", "*");
//			conn.setDoOutput(true);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
//
//			responseMessage = conn.getResponseMessage();
//			System.out.println(responseMessage);
//			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
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