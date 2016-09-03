package net.fs.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LangList {
	
	public static HashMap<Integer,String> langMap=new HashMap<>();
	
	public LangList() {
		
	}
	
	public boolean InitLangList(String url) {
		File f=new File(url);
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String t="";
			int i=0;
			while ((t=br.readLine())!=null) {
				langMap.put(i, t);
				i++;
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public String g(int key) {
		return langMap.get(key);
	}
}
