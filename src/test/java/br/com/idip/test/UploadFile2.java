package br.com.idip.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idip.alfresco52.BaseRest;
import com.idip.alfresco52.Entry;

public class UploadFile2 {

	public static void main(String[] args) {
		// criarVazio();
//		atualizarVazio();
//		testeDesacreditado();
		testefinal2();
	}

	public static void criarVazio() {
		try {
			String usuario = "admin";
			String senha = "1234";
			String jsonString = "{\"name\":\"30K CL8.jpg\",\"nodeType\":\"cm:content\", \"relativePath\":\"My Folder1/Brasil\"}";
			ObjectMapper mapper = new ObjectMapper();
			JsonNode actualObj;

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
			if (conn.getResponseCode() != 201) {
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

	public static void atualizarVazio() {
		String usuario = "admin";
		String senha = "1234";
		try {
			String postUrl = "http://localhost:8085/alfresco/api/-default-/public/alfresco/versions/1/nodes/-my-/children";
			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "multipart/form-data");
			conn.getContentType();
			conn.addRequestProperty("name", "30K.jpg");
			conn.addRequestProperty("nodetype", "file");
			conn.addRequestProperty("relativePath", "My Folder1/Brasil");
			byte[] fileB = IOUtils.toByteArray(new FileInputStream("C:\\Users\\jonat\\Pictures\\30K CL.jpg"));

			String userCredentials = usuario + ":" + senha;
			String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			conn.setRequestProperty("Authorization", basicAuth);

			DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
			outputStream.write(fileB);
			outputStream.flush();
			outputStream.close();

			if (conn.getResponseCode() != 201) {
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

	public static void testeDesacreditado() {
		String usuario = "admin";
		String senha = "1234";
		String userCredentials = usuario + ":" + senha;
		String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

		try {
			byte[] fileB = IOUtils.toByteArray(new FileInputStream("C:\\Users\\jonat\\Pictures\\30K CL.jpg"));

			ProcessBuilder pb = new ProcessBuilder("curl", "-X PUT", "-H 'Content-Type: application/octet-stream'",
					"-H 'Authorization: " + basicAuth + "'", "-F filedata=@C:/Users/jonat/Pictures/30K CL.jpg",
					"http://localhost:8085/alfresco/api/-default-/public/alfresco/versions/1/nodes/00b25bc1-4c40-44cb-a649-5919220b9b53/content?majorVersion=false");
			Process p;
			pb.redirectErrorStream(true);
			p = pb.start();
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String output;
			String str = "";
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				str += output;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testefinal() {
		String usuario = "admin";
		String senha = "1234";
		String userCredentials = usuario + ":" + senha;
		String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
		File file = new File("C:/Users/jonat/Pictures/1.jpg");

		HttpPost uploadFile = new HttpPost(
				"http://localhost:8085/alfresco/api/-default-/public/alfresco/versions/1/nodes/-my-/children");
		uploadFile.addHeader("Authorization", basicAuth);
		CloseableHttpClient client = HttpClientBuilder.create().build();
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		FileBody fileBody = new FileBody(file);
		builder.addTextBody("relativePath", "My Folder1/Brasi8/Bra89a/l992/");
		builder.addPart("filedata", fileBody);

		HttpEntity multipart = builder.build();
		uploadFile.setEntity(multipart);
		uploadFile.setHeader("Accept", "application/json");
		try {
			HttpResponse response = client.execute(uploadFile);
			System.out.println(response.toString());
			System.out.println(response.getStatusLine().getStatusCode());
			String body = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8.toString());
			System.out.println(body);
			Entry baseRest;
			ObjectMapper mapper = new ObjectMapper();
			baseRest = mapper.readValue(body, Entry.class);
			System.out.println(baseRest.getEntry().getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testefinal2() {
		File file = new File("C:/Users/jonat/Pictures/1.jpg");
		HttpPost uploadFile = new HttpPost("http://localhost:8081/AlfrescoWS-war/public5/uploadRestFileFromByte");
		CloseableHttpClient client = HttpClientBuilder.create().build();
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		// FileBody fileBody = new FileBody(file);
		ByteArrayBody fileBody;
		try {
			fileBody = new ByteArrayBody(Files.readAllBytes(file.toPath()), "picture.jpg");

			builder.addTextBody("token", "_");
			builder.addTextBody("folderSequenceTree", "Cynthia");
			builder.addTextBody("docName", "picture1.jpg");
			builder.addTextBody("user", "admin");
			builder.addTextBody("password", "1234");
			builder.addPart("filedata", fileBody);

			HttpEntity multipart = builder.build();
			uploadFile.setEntity(multipart);
			uploadFile.setHeader("Accept", "application/json");
			HttpResponse response = client.execute(uploadFile);
			System.out.println(response.toString());
			System.out.println(response.getStatusLine().getStatusCode());
			String body = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8.toString());
			System.out.println(body);
			Entry baseRest;
			ObjectMapper mapper = new ObjectMapper();
			baseRest = mapper.readValue(body, Entry.class);
			System.out.println(baseRest.getEntry().getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
