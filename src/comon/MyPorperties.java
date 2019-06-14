package comon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class MyPorperties {

	// 准备了一个映射表,存放属性名和属性值
	private Map<String, String> props = new Hashtable<>();
	
	// 从指定的配置文件中加载配置项
	public MyPorperties(String path) throws IOException {
		FileReader reader = new FileReader(path);
		BufferedReader buffer = new BufferedReader(reader);
		String s = null;		
		while( (s = buffer.readLine())!= null) {
			int pos = s.indexOf("=");
			String propName = s.substring(0, pos);
			String propValue = s.substring(pos+1);
			props.put(propName, propValue);
		}
		buffer.close();
		reader.close();
	}
	
	//在Hashtable中通过键的名称访问对应的值
	public String getProp(String propName) {
		return props.get(propName);
	}
}
