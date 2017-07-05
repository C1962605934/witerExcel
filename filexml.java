package cn.sunline.ltts.busi.lntran.batchtran.vat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


import cn.sunline.ltts.base.util.FileDataExecutor;
import cn.sunline.ltts.base.util.XmlUtil;
import cn.sunline.ltts.busi.aplt.tools.FileTools;
import cn.sunline.ltts.busi.sys.errors.LnError;



public  class FileXml {	
	
	static StringBuffer xmlSb= new StringBuffer();
   /*
    *XML文件解析
    *@para String filename(路径+文件名)
    *@return Map<String, Object>
    **/
   public static Map<String, Object> paseXML(String filename,String charset) {
	   List<String> listfile = null;
	   String message = null;
	   Map<String, Object> XMLMap = null;	 
	   Path path = null;
			try {
				path = Paths.get(filename, new String[0]);
				listfile = Files.readAllLines(path, Charset.forName(charset));
				for(int i=0,j=listfile.size();i<j;i++){
					xmlSb.append(listfile.get(i).trim());
				}
				message=xmlSb.toString();
				System.out.println(message);
				XMLMap =  XmlUtil.parse(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	 /*
	   FileTools.readFile(filename,  new FileDataExecutor() {
				@Override
				public void process(int index, String line) {
					try {				
						xmlSb.append(line);
					} catch (Exception e) {
						throw LnError.geno.E0001("文件第[" + index + "]行数据处理失败。",
								e);
					}
				}
			});
	   message = xmlSb.toString(); 
	   System.out.println("message:"+message);
	   XMLMap =  XmlUtil.parse(message);*/
	   return XMLMap;
   }
   //todo
   public void createXML(String filename){
	  
   }
   public static void main(String[] args) {
	String filename = "test.xml";
	String path = "I:/home/ltts/file/upload/vat/";
	System.out.println(path+filename);
	Map<String, Object> XMLMap = paseXML(path+filename, "UTF-8");
	System.out.println(XMLMap.get("filename"));
   }
}
