package update;

public class Version {

	int primary;
	int minor;
	int tertiary;
	String descriptor;

	public Version(String ver){
		System.out.println("Parsing Version: " + ver);
		String numericalVersion = new String();
		try{
		if(ver.contains("-")){
		System.out.println("Found descriptor!");
		numericalVersion = ver.substring(0, ver.indexOf('-'));
		this.descriptor = ver.substring(ver.indexOf('-')+1, ver.length());
		}else{
		numericalVersion = ver;
		}
		if(numericalVersion.contains(".")){
			System.out.println("Found primary! " + numericalVersion);
			primary = Integer.parseInt(numericalVersion.substring(0, numericalVersion.indexOf('.')));
			numericalVersion = numericalVersion.substring(numericalVersion.indexOf('.')+1, numericalVersion.length());
			if(numericalVersion.contains(".")){
				System.out.println("Found secondary!");
				minor = Integer.parseInt(numericalVersion.substring(0, numericalVersion.indexOf('.')));
				numericalVersion = numericalVersion.substring(numericalVersion.indexOf('.')+1, numericalVersion.length());
				try{
				tertiary = Integer.parseInt(numericalVersion);
				}catch(Exception e){
					//no tertiary
				}
			}else{
				minor = Integer.parseInt(numericalVersion);
				System.out.println("Minor: " + minor);
			}
		}else{
			primary = Integer.parseInt(numericalVersion);
		}
		}catch(Exception e){
			System.out.println("Issue parsing Version!");
			e.printStackTrace();
		}
	}
	public boolean compare(Version comp){
		if(comp.primary > this.primary){
			return true;
		}else{
			if(comp.minor > this.minor){
				return true;
			}else{
				if(comp.tertiary > this.tertiary){
					return true;
				}
			}
			return false;
		}
	}
}
