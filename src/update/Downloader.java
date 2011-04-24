package update;

import java.net.URL;
import java.util.Calendar;
import java.io.*;
public class Downloader {

	
public static File DownloadToFile(URL source, String dest){
	try {
		BufferedInputStream bis = new BufferedInputStream(source.openStream(), 1024);
		File outfile = new File(dest + source.getFile());
		if(outfile.canWrite()){
			outfile.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(outfile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] data = new byte[1024];
		int x=0;
		while((x=bis.read(data,0,1024))>=0)
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
		return DownloadToFile(source, File.createTempFile("jDownload_", cal.getTime().toString()).getAbsolutePath());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}

public static void FileCopy(File inputFile, File outputFile) throws IOException {
    FileReader in = new FileReader(inputFile);
    FileWriter out = new FileWriter(outputFile);
    int c;

    while ((c = in.read()) != -1)
      out.write(c);

    in.close();
    out.close();
  }
}
