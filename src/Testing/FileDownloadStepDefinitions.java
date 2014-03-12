package Testing;
//Test by MDS
import cucumber.api.java.en.*;
import static org.junit.Assert.*;

import org.mockito.*;

import Main.FileClient;
import Main.UserToken;
import Main.Token;

public class FileDownloadStepDefinitions{
	
	Boolean confirm = false;
	String file_source = "";
	String file_dest = "";
	String group = "";
	
	@Mock
	FileClient m_fc; 
	
	@Given("I am going to download a file from my group")
	public void start_download_process(){
		m_fc = Mockito.mock(FileClient.class);
	}
	
	@When("The file I want to download is (.+)$")
	public void choose_file_source(){
		file_source = "testersfile/thisfile";
	}
	
	@And("I want to download the file to (.+)$")
	public void choose_file_dest(){
		file_dest = "testersfile/thisfile";
	}
	
	@Then("I shall be able to confirm the file (.+) is downloaded to my computer")
	public void confirm_download(){
		UserToken token = new Token();
		Mockito.when(m_fc.download(file_source, file_dest, token)).thenReturn(true);
		confirm = m_fc.download(file_source, file_dest, token);
		assertTrue(confirm.equals(true));
	}
	
}