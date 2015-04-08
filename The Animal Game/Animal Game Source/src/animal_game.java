
	import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

	import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

	import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

	class points{
		String question;
		int yes;
		int no;
		public points(String a,int b,int c) {
			question=a;
			yes=b;
			no=c;
		}
	}
	
public class animal_game {
		static ArrayList<points> list=new ArrayList<points>();
		public static void main(String[] args) {
			System.out.println("Welcome to Animal game!");
			System.out.println("");
			System.out.println("Select your File format");
			Scanner input=new Scanner(System.in);
			do{			
				System.out.println("1.for XML file");
				System.out.println("2.for JSON file");
				int i=input.nextInt();
				
				if (i==1) {
					list=new xmldata().fromxml();
					new animal_game().Comense();
					break;
				}else if(i==2){
					list=new jsondata().fromjson();
					new animal_game().Comense();
					break;
				}else{
					System.out.println("Please check your selection");
					continue;
				}
					
				
			}while(true);

		}
		
		
		public void Comense() {
			Scanner input=new Scanner(System.in);
			int index=0;
			
			do{
				points temp=list.get(index);
				if (temp.yes==0||temp.no==0) {
					System.out.println("your animal is ::"+temp.question+" !!!");
					System.out.println("i hope i am right");
					break;
				}
				
				System.out.println(temp.question);
				
				do{
					System.out.println("Press 1 for YES and Press 2 for NO");
					int i=input.nextInt();
					if (i==1) {
						index=temp.yes-1;
						break;
					}
					else if(i==2){
						index=temp.no-1;
						break;
					}else{
						System.out.println("Plaese check your selection");
						continue;
					}
				}while(true);
				
			}
			while(true);
			
			input.close();
			
		}
		private static String getValue(String tag, Element element) {
			NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
			Node node = (Node) nodes.item(0);
				return node.getNodeValue();
			}
}
