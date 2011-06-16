package update;

import java.net.URL;
import org.apache.commons.io.*;

import java.util.Calendar;
import java.io.*;
public class Downloader {

	
public static File DownloadToFile(URL source, String dest){
	try {
		BufferedInputStream bis = new BufferedInputStream(source.openStream(), 1);
		File outfile = new File(dest);
		if(outfile.canWrite()){
			outfile.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(outfile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] data = new byte[1];
		int x=0;
		while((x=bis.read(data,0,1))>=0)
		{
		bos.write(data,0,x);
		}
		bos.close();
		bis.close();
		return outfile;
	} catch (IOException e){
		e.printStackTrace();
		return null;
	}

}

public static File Download(URL source){
	Calendar cal = Calendar.getInstance();
	
	try {
		return DownloadToFile(source, File.createTempFile("jDownload_", "_dl").getAbsolutePath());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}

public static void FileCopy(File inputFile, File outputFile) throws IOException {
    FileUtils.copyFile(inputFile, outputFile);
  }
}
