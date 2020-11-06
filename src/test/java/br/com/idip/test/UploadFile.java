package br.com.idip.test;

import java.io.File;
import java.net.URLEncoder;
import java.util.Base64;

import org.apache.commons.httpclient.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
  

public class UploadFile {

	/*public static void main(String[] args) {
		String usuario = "admin";
		String senha = "1234";
		String s = Normalizer.normalize("Legilação Tributária", Normalizer.Form.NFD);
		s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		String jsonString =  "{\"name\":\"Legilação Tributária\",\"nodeType\":\"cm:folder\", \"relativePath\":\"My Folder1/Brasil\"}";
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
	}*/
	public static void main(String args[]) throws Exception
    {
		UploadFile fileUpload = new UploadFile () ;
        File file = new File("C:\\Users\\jonat\\Pictures\\30K CL.jpg") ;
        
        String a = URLEncoder.encode("My Folder1/Brasil/Legilação Tributária", "UTF-8");

		String postUrl = "http://localhost:8085/alfresco/api/-default-/public/alfresco/versions/1/nodes/-my-/children";
        //Upload the file
        fileUpload.executeMultiPartRequest(postUrl,
                file, file.getName()) ;
    } 
     
    public void executeMultiPartRequest(String urlString, File file, String name) throws Exception
    {
    	String usuario = "admin";
		String senha = "1234";
        HttpClient client = new DefaultHttpClient() ;
        HttpPost postRequest = new HttpPost (urlString) ;
        
        try
        {	String userCredentials = usuario + ":" + senha;
			String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
			
            //Set various attributes
            MultipartEntity multiPartEntity = new MultipartEntity () ;
            //multiPartEntity.addPart("fileDescription", new StringBody(fileDescription != null ? fileDescription : "")) ;
            multiPartEntity.addPart("name", new StringBody(name != null ? name : file.getName())) ;
            
            FileBody fileBody = new FileBody(file, "application/octect-stream") ;
            //Prepare payload
            multiPartEntity.addPart("nodeBodyCreate", fileBody) ;
  
            //Set to request body
            postRequest.setEntity(multiPartEntity) ;
             
            //client.
            //Send request
            HttpResponse response = client.execute(postRequest) ;
             
            //Verify response if any
            if (response != null)
            {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace() ;
        }
    }
	
}
