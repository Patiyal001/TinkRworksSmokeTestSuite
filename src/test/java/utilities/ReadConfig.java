package utilities;

//Listener Class user to generate extent reports
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
	
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicaitonURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getOrganization()
	{
		String orgName = pro.getProperty("org");
		return orgName;
	}
	
	public String getAccType()
	{
		String accType = pro.getProperty("acc");
		return accType;
	}
	
	public String getPassword()
	{
		String  pwd= pro.getProperty("password");
		return pwd;
	}
}
