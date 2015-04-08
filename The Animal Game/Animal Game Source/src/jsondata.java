import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class jsondata {
	 ArrayList<points> list=new ArrayList<points>();
	public  ArrayList<points> fromjson() {
		try {
			FileReader reader=new FileReader("data.json");
			
			JSONParser jsonparser=new JSONParser();
			JSONObject jsnobj=(JSONObject)jsonparser.parse(reader);
			
			
			JSONArray points=(JSONArray)jsnobj.get("questions");
			
			Iterator it=points.iterator();
			while(it.hasNext()){
				JSONObject innerobj=(JSONObject)it.next();
				list.add(new points((String)innerobj.get("question"), Integer.parseInt((String)innerobj.get("yes")), Integer.parseInt((String)innerobj.get("no"))));
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
