package update;

public class Version {

	int primary;
	int minor;
	int tertiary;
	String descriptor;

	public Version(String ver){
		String numericalVersion = new String();
		try{
		if(ver.contains("-")){
		numericalVersion = ver.substring(0, ver.indexOf('-')-1);
		this.descriptor = ver.substring(ver.indexOf('-')+1, ver.length());
		}else{
		numericalVersion = ver;
		}
		if(numericalVersion.contains(".")){
			primary = Integer.parseInt(numericalVersion.substring(0, numericalVersion.indexOf('.')-1));
			numericalVersion = numericalVersion.substring(numericalVersion.indexOf('.')+1, numericalVersion.length());
		}else{
			primary = Integer.parseInt(numericalVersion);
		}
		if(numericalVersion.contains(".")){
			minor = Integer.parseInt(numericalVersion.substring(0, numericalVersion.indexOf('.')-1));
			numericalVersion = numericalVersion.substring(numericalVersion.indexOf('.')+1, numericalVersion.length());
		}
		if(numericalVersion.contains(".")){
			tertiary = Integer.parseInt(numericalVersion.substring(0, numericalVersion.indexOf('.')-1));
			numericalVersion = numericalVersion.substring(numericalVersion.indexOf('.')+1, numericalVersion.length());
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
