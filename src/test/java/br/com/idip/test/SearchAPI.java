package br.com.idip.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SearchAPI {

	public static void main(String[] args) {
		String usuario = "legislacao";
		String senha = "1234";
		String jsonString = "{\"query\": {\"language\": \"afts\",\"query\": \" "
				+ "TEXT:Contrato AND TEXT:Cynthia\"}}";
	/*	String jsonString = "{\"query\": {\"language\": \"afts\",\"query\": \""
				+ " TEXT:Durante AND TEXT:sua\",\"usr\":\"admin\"}}";*/
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj;
		try {
			actualObj = mapper.readTree(jsonString);

			String postUrl = "http://localhost:8085/alfresco/api/-default-/public/search/versions/1/search";
			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");

			String userCredentials = usuario + ":" + senha;
			String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			conn.setRequestProperty("Authorization", basicAuth);
			DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
			System.out.println(actualObj.toString());
			outputStream.writeBytes(actualObj.toString());
			outputStream.flush();
			outputStream.close();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));
			String output;
			String str = "";
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				str += output;
			}
			conn.disconnect();
			// System.out.println(response.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
