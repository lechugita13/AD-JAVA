package probaurlconection;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ProvaURLConnection {

	// funció per mostrar el contingut d'un fitxer de text en una URL
	// a través d'URLConnection
	private void printContent(URL url) {
		// Flux d'entrada
		InputStream in;
		// Buffer per anar llegint el contingut del fitxer
		char[] cbuf = new char[512];
		// per comprovar si ja hem aribat al final
		int caractersLlegits;
		try {
			// obrim l'stream associat a la url
			in = url.openStream();
			// creem un flux de lectura a partir de l'stream que apunta a la url
			InputStreamReader inr = new InputStreamReader(in);
			// mentre no s'acabe el fitxer
			while ((caractersLlegits = inr.read(cbuf)) != -1) {
				// obtenim els caràcters rebuts
				String str = String.copyValueOf(cbuf, 0, caractersLlegits);
				// ho mostrem per pantalla
				System.out.print(str);
			}
			System.out.println();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// funció per guardar el contingut d'un fitxer de text en una URL
	// a través d'URLConnection
	private void saveTextContent(URL url, String fitxer) {
		// Flux d'entrada
		InputStream in;
		// Buffer per anar llegint el contingut del fitxer
		char[] cbuf = new char[512];
		// per comprovar si ja hem aribat al final
		int caractersLlegits;
		try {
			// obrim l'stream associat a la url
			in = url.openStream();
			// creem un flux de lectura a partir de l'stream que apunta a la url
			InputStreamReader inr = new InputStreamReader(in);
			// PEr escriure en un fitxer, esborrant-lo cada vegada
			FileWriter writer = new FileWriter(fitxer, false);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			// mentre no s'acabe el fitxer
			while ((caractersLlegits = inr.read(cbuf)) != -1) {
				// obtenim els caràcters rebuts
				String str = String.copyValueOf(cbuf, 0, caractersLlegits);
				// ho escrivim en el fitxer
				bufferedWriter.write(str);
			}
			// TAnquem l'escriptor i el fitxer
			bufferedWriter.close();
			writer.close();
			// executem el firefox perquè mostre el fitxer resultat
			Process p = Runtime.getRuntime().exec("firefox " + fitxer);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	// funció per guardar el contingut d'un fitxer de text en una URL
		// a través d'URLConnection
		private void saveDataContent(URL url, String fitxer) {
			// Flux d'entrada
			InputStream in;
			// Buffer per anar llegint el contingut del fitxer en bytes
			byte[] cbuf = new byte[512];
			try {
				// obrim la connexió associada a la url
				URLConnection urlcon= url.openConnection();
				// creem un flux d'entrada a partir de l'stream que apunta a la url
				InputStream inr = urlcon.getInputStream();
				// PEr escriure en un fitxer, esborrant-lo cada vegada
				FileOutputStream outputStream = new FileOutputStream(fitxer);

				// mentre no s'acabe el fitxer
				int bytesLlegits;
				while ((bytesLlegits = inr.read(cbuf)) != -1) {
					// ho escrivim en el fitxer
					outputStream.write(cbuf, 0, bytesLlegits);
				}
				// TAnquem els fluxos
				outputStream.close();
				inr.close();
				// executem el firefox perquè mostre el fitxer resultat
				Process p = Runtime.getRuntime().exec("firefox " + fitxer);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	public static void main(String[] args) {
		try {
			// Establim la connexió
			ProvaURLConnection provaURL = new ProvaURLConnection();
			
			// creem una url completa cap a un recurs: fitxer de text
			//URL url = new URL("http://192.168.8.37/dam/text.txt");
			
			// creem una url completa cap a un recurs: fitxer d'imatge
			URL url = new URL("http://192.168.8.37/dam/cat.jpg");
			
			// Text: Li ho passem a la funció printContent per mostar-ne el contingut
			//provaURL.printContent(url);
			
			// Text: Li ho passem a la funció saveTextContent per guardar-ne el contingut
			//provaURL.saveTextContent(url, "fitxertextcopiat.txt");
			
			// Li ho passem a la funció saveContent per guardar-ho en un fitxer
			provaURL.saveDataContent(url, "fitxerimatgecopiat.jpg");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
