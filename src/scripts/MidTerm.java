package scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;


public class MidTerm {
	private String input_path;
	private String query_text;

	public MidTerm(String path, String query) {
		this.input_path = path;
		this.query_text = query;
	}
	
	public void showSnippet() throws IOException {
		File file = new File(input_path);
		org.jsoup.nodes.Document indexXmlDoc = Jsoup.parse(file, "UTF-8", "", Parser.xmlParser());
		
		
		
		
		// body 내용 하나씩 읽어와서 형태소 분석하고 body 안의 내용 바꾼다.
		Elements docDataList = indexXmlDoc.select("doc");
		for (int i = 0; i < docDataList.size(); i++) {
			Element doc = docDataList.get(i);
			System.out.println(doc.getElementsByTag("title").text());
		}
		
		String[] str = new String[docDataList.size()];
		
		
	}
}
