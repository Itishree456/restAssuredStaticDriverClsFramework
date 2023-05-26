package requestRepositoryPack;

public class Post_req_repository {

	public static String Base_URI() {

		String BaseURI = "https://reqres.in/";

		return BaseURI;

	}

	public static String Post_Resource() {

		String Resource = "/api/users";

		return Resource;

	}

	public static String Post_TC1() {

		String RequestBody = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}\r\n" + "";

		return RequestBody;

	}
}