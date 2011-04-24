package update;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class VersionUpdate {

	public static boolean isNewVersion(Version compare, URL version){
		File versionFile = Downloader.Download(version);
		try {
			FileReader fis = new FileReader(versionFile);
			BufferedReader bis = new BufferedReader(fis);
			try {
				URL updateUrl = new URL(bis.readLine());
				Version newVersion = new Version(bis.readLine());
				if(newVersion.compare(compare)){
					if(offerUpdate()){
						doUpdate(updateUrl);
					}

				}else{
					return false;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}

	public static boolean offerUpdate(){
		Scanner myScan = new Scanner(System.in);
		System.out.println("There is an update available. Would you like to apply it?");
		System.out.print("(Y/n): ");
		String response = myScan.nextLine().toLowerCase().replace(" ", "");
		if(response.equals("yes") || response.equals("y")){
			return true;
		}else{
			return false;
		}
	}

	public static void doUpdate(URL loc){
		File tempUpdate = Downloader.Download(loc);
		File replace = new File("./SimpleServer.jar");
		File backup = new File("./SimpleServerBackup.jar");
		try{
		Downloader.FileCopy(replace, backup);
		replace.delete();
		Downloader.FileCopy(tempUpdate, replace);
		}catch(Exception e){
			e.printStackTrace();
		}
	}



}
