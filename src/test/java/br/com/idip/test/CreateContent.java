package br.com.idip.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Normalizer;
import java.util.Base64;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateContent {

	public static void main(String[] args) {
		String usuario = "admin";
		String senha = "1234";
		String s = Normalizer.normalize("Legilação Tributária", Normalizer.Form.NFD);
		s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		String jsonString =  "{\"name\":\"Vamuuuuuuuu Brasil\",\"nodeType\":\"cm:folder\", \"relativePath\":\"My Folder1/Brasil/\"}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj;
		try {
			actualObj = mapper.readTree(jsonString);

			String postUrl = "http://localhost:8085/alfresco/api/-default-/public/alfresco/versions/1/nodes/-my-/children";
			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			
			String userCredentials = usuario + ":" + senha;
			String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			conn.setRequestProperty("Authorization", basicAuth);
			DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			System.out.println(actualObj.toString());
			writer.write(actualObj.toString());
			writer.flush();
			writer.close();
			/*if (conn.getResponseCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}*/
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
	
	public static String stripAccents(String s) {
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
		s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return s;
	}
	
	
}
