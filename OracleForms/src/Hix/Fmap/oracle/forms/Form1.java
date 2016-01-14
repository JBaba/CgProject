package Hix.Fmap.oracle.forms;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.adobe.idp.Document;
import com.adobe.idp.dsc.DSCException;
import com.adobe.idp.dsc.InvocationRequest;
import com.adobe.idp.dsc.InvocationResponse;
import com.adobe.idp.dsc.clientsdk.ServiceClient;
import com.adobe.idp.dsc.clientsdk.ServiceClientFactory;
import com.adobe.idp.dsc.clientsdk.ServiceClientFactoryProperties;

public class Form1 {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		prop.setProperty(
				ServiceClientFactoryProperties.DSC_DEFAULT_SOAP_ENDPOINT,
				"http://10.118.19.108:9080");
		prop.setProperty(ServiceClientFactoryProperties.DSC_TRANSPORT_PROTOCOL,
				ServiceClientFactoryProperties.DSC_SOAP_PROTOCOL); // SOAP
																	// protocol
		prop.setProperty(ServiceClientFactoryProperties.DSC_SERVER_TYPE,"JBoss");
		prop.setProperty(ServiceClientFactoryProperties.DSC_CREDENTIAL_USERNAME,"kanber");
		prop.setProperty(ServiceClientFactoryProperties.DSC_CREDENTIAL_PASSWORD,"kanber123");

		// Create a ServiceClientFactory object
		ServiceClientFactory myFactory = ServiceClientFactory
				.createInstance(prop);
		// Create a ServiceClient object
		ServiceClient myServiceClient = myFactory.getServiceClient();
		// Create a Map object to store the parameter value
		Map params = new HashMap();

		// finalized boolean set to true
		String input = null;
		try {
			/*input = "<uaTestReport>"
					+"<name>Input1</name>"
					+"<project>Input2</project>"
					+ "</uaTestReport>";*/
			input = "<uaReport></uaReport>";
		} catch (Exception e) {
			input = "<uaReport></uaReport>";
		}

		// Clear any 0x0, if there is any
		input = input.replaceAll("[\\000]*", "");

		// Replace <b>, </b>
		//input = input.replaceAll("&lt;b&gt;([^<]*)&lt;/b&gt;", "$1");

		// Decode ampersand
		input = input.replace("&amp;", "&");

		// Decodes special characters
		//input = FwSecurityUtil.decodeSpecialCharacters(input);

		// Encode ampersand for XML
		input = input.replace("&", "&amp;");

		// Document doc = new Document(input.getBytes());
		params.put("inputXml", input);

		// Create an InvocationRequest object
		InvocationRequest esRequest = myFactory.createInvocationRequest(
				"TestApplication/process/uaTestRport",// process name
				"invoke", // operation name
				params, // input values
				true); // synchronous request
		// Send the invocation request to the process and get a response
		// object
		InvocationResponse esResponse = null;


		try {
			esResponse = myServiceClient.invoke(esRequest);
		} catch (DSCException e) {

			System.out.println("****Exception thrown on ServiceClient invocation, DSCExcpetion ****"
					+ e);
		}

		Document resultDoc = null;

		if (esResponse != null) {
			resultDoc = (Document) esResponse.getOutputParameter("outputPdf");
		}
		
		
	}
	
}
