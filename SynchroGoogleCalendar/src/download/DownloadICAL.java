package download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadICAL {

	public static void copyURLToFile(URL url, File file) {
		
		try {
			
			InputStream input = url.openStream();
			if (file.exists()) {
				if (file.isDirectory())
					throw new IOException("File '" + file + "' is a directory");
				
				if (!file.canWrite())
					throw new IOException("File '" + file + "' cannot be written");
			}
			else {
				File parent = file.getParentFile();
				if ((parent != null) && (!parent.exists()) && (!parent.mkdirs())) {
					throw new IOException("File '" + file + "' could not be created");
				}
			}

			FileOutputStream output = new FileOutputStream(file);

			byte[] buffer = new byte[4096];
			int n = 0;
			while (-1 != (n = input.read(buffer))) {
				output.write(buffer, 0, n);
			}

			input.close();
			output.close();
			
			System.out.println("File '" + file + "' downloaded successfully!");
		}
		
		catch(IOException ioEx) {
			ioEx.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		
		//URL pointing to the file
		//String sUrl = "https://planification.univ-lorraine.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=5424&projectId=5&calType=ical&firstDate=2018-01-29&lastDate=2018-02-04";
		String sUrl = "https://adeical.univ-lorraine.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=5424&projectId=5&calType=ical&firstDate=2018-01-29&lastDate=2018-02-04&sqlMode=true";
		URL url = new URL(sUrl);
		
		//File where to be downloaded
		File file = new File("C:/Users/Halit Cetin/Desktop/Replication/Replication/ade.ics");
		
		DownloadICAL.copyURLToFile(url, file);
	}

}