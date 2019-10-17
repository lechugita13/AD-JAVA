package IMDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		URL web;
		try {
			web = new URL("https://www.imdb.com/title/tt0034583/");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader entradaWeb;
		try {
			entradaWeb = new BufferedReader(new InputStreamReader(web.openStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String linia="";
		while ((linia = entradaWeb.readLine()) != null) {
			System.out.println("linia");
		}
		entradaWeb.close();
		
	}

}
