package com.github.cmput301w13t04.food;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ParseException;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

/* 
 * NOTE: A lot of this code is taken from:
 *  http://stackoverflow.com/questions/7124484/android-uploading-a-photo-to-host-on-imgur-programatically
 */
/* To implement, do something like this:
 * 
 * Log.d("REALP",path);
		imgurController ic = new imgurController(path);
		try
		{
			String result = 
					ic.post();
			Log.d("YATTA", result);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 * Where "path" is the string path of the photo.
 */
public class imgurController
{
	/*
	 * NOTE: This method implements the 2nd version of the imgur API, which unfortunately
	 * is no longer supported, so this API Key is actually from a demo app I found online
	 * but there doesn't seem to be a way to register a new key for the 2nd version.
	 */
	private String DEV_KEY = "5a5141ca9354bf7929b98a1d7a4c26ae";
	//private String DEV_KEY = "3c45563c813ad29";
	private String path;

	/*
	 * Constructor
	 */
	public imgurController(String path){
		this.path = path;

	}
	private class PublishImageTask extends AsyncTask<Bitmap, Void, String> {
	     protected String doInBackground(Bitmap... bitmap) {
	        //Your download code here; work with the url parameter and then return the result
	        //which if I remember correctly from your code, is a string.
	        //This gets called and runs ON ANOTHER thread
	 		
	 		// Creates Byte Array from picture
	    	 
	 		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	 		bitmap[0].compress(Bitmap.CompressFormat.JPEG, 100, baos);
	 		
	 		 String data = null;
	         data = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
	         
	         HttpPost hpost = new HttpPost("http://api.imgur.com/2/upload");
	 		//HttpPost hpost = new HttpPost("http://api.imgur.com/2/account/images");

	 		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	 		nameValuePairs.add(new BasicNameValuePair("image", data));
	 		nameValuePairs.add(new BasicNameValuePair("type", "base64"));
	 		nameValuePairs.add(new BasicNameValuePair("key", DEV_KEY));	 		

	 		try 
	 		{
	 			hpost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	 		} catch (UnsupportedEncodingException e) 
	 		{
	 			e.toString();
	 		}

	 		
	 		DefaultHttpClient client = new DefaultHttpClient();
	 		HttpResponse resp = null;
	 		try 
	 		{
	 			resp = client.execute(hpost);
	 		} catch (ClientProtocolException e) 
	 		{
	 		e.toString();
	 		} catch (IOException e) 
	 		{
	 			e.toString();
	 		}

	 		String result = null;
	 		try {
	 			result = EntityUtils.toString(resp.getEntity());
	 			Log.d("YOYO", result);
	 		} catch (ParseException e) 
	 		{
	 		e.toString();
	 		} catch (IOException e) 
	 		{
	 			e.toString();
	 		}
	 		String dest = null;
	 		if (result.indexOf("original") >= 0)
	            dest = result.substring(result.indexOf("original") + "original".length() + 1, 
	                    result.lastIndexOf("original") - 2);
	 		Log.d("Destination",dest);

	 		return dest;
	    	
	     }
	}
	/* Post method, returns the string result */
	public String post() throws IOException{

		Bitmap bitmap = BitmapFactory.decodeFile(Uri.parse(path).getPath());
		PublishImageTask runner = new PublishImageTask();
		String result = null;
		try {
			result = runner.execute(bitmap).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return result;
	}
	
}