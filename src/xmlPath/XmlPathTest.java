package xmlPath;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlPathTest {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("C:/Users/liuzh/Desktop/5887.xml"));
		List<Element> list = doc.selectNodes("/RECORDS/RECORD[ends-with(name,'市')]");
		String fid = "";
		String name = "";
		for(Element e:list){
			fid = e.element("Fid").getText();
			name = e.element("name").getText();
			name = name.substring(0,name.length()-1);
			System.out.println(fid+"-"+name);
			
			
		}
		
		
		
		
	}
}
