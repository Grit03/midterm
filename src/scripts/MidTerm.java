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
import org.snu.ids.kkma.index.Keyword;
import org.snu.ids.kkma.index.KeywordExtractor;
import org.snu.ids.kkma.index.KeywordList;


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
		
		String[] queryKeyword;
		
		
		// query 분석
		KeywordExtractor ke = new KeywordExtractor();
		KeywordList kl = ke.extractKeyword(query_text, true);
		queryKeyword = new String[kl.size()];
		for(int i=0; i<kl.size(); i++) {
			Keyword kwrd = kl.get(i);
			queryKeyword[i] = kwrd.getString();
		}
		
		
		// body 내용 하나씩 읽어와서 형태소 분석하고 body 안의 내용 바꾼다.
		Elements docDataList = indexXmlDoc.select("doc");
		String[] title = new String[docDataList.size()];

		for (int i = 0; i < docDataList.size(); i++) {
			Element doc = docDataList.get(i);
			title[i] = doc.getElementsByTag("title").text();
		}
		
		Elements bodyDataList = indexXmlDoc.select("body");
		for (int i = 0; i < bodyDataList.size(); i++) {
			String bodyElementText = bodyDataList.get(i).text();
			int count = (int)bodyDataList.size()/30;
			
			
			for(int j= 0; j< count ;j = j++) {
				String trim = bodyElementText.substring(0,2);
				System.out.println(trim);
			}
			
		}
		
		String[] str = new String[docDataList.size()];
		// https://github.com/everglow03/midterm
		
	}
}
