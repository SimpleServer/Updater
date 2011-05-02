package main;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import update.Version;
import update.VersionUpdate;

public class main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Deal with each element in args, unless it's a "null" (not null, but "null")
		 * If we have a switch that needs extra args, convert those to "null"
		 * so they'll automatically be skipped
		 */
		for(int x = 0; x<args.length;x++){
			if(args[x]!="null"){
				if(args[x].equals("-update")){
					args[x]="null";
					try {
						//TODO convert this into an array with load balancing for multiple update sites
						URL mainUpdateMirror = new URL("http://minecraft.dreamsofmercury.com/update/version.php");
						Process ret = Runtime.getRuntime().exec("java -jar SimpleServer.jar --version");
						Scanner sis = new Scanner(ret.getInputStream());
						VersionUpdate.isNewVersion(new Version(sis.nextLine()), mainUpdateMirror);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(args[x].equals("-download")){
					args[x]="null";
					try {
						//TODO convert this into an array with load balancing for multiple update sites
						URL mainUpdateMirror = new URL("http://minecraft.dreamsofmercury.com/update/version.php");
						VersionUpdate.isNewVersion(new Version("0.0.0"), mainUpdateMirror);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

}
