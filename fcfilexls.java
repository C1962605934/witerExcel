package cn.sunline.ltts.busi.fc.acct;

import java.io.File;
import java.io.IOException;

import cn.sunline.ltts.busi.aplt.tools.LogManager;
import cn.sunline.ltts.core.api.logging.BizLog;
import jxl.Workbook;
import jxl.write.WritableWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class FcFilexls {

	private static final BizLog bizlog = LogManager
			.getBizLog(FcFilexls.class);
	public static final String fileSuffix = ".xls";
	public static File getFile(String fileName, String filePath) {
		File file = new File(filePath);
		if (!file.exists()) file.mkdirs();
		if (!fileName.endsWith(fileSuffix)) fileName = fileName + fileSuffix;
		return new File(file, fileName);
	}
	
	public static WritableWorkbook getWritableWorkbook(File file) {
		try {
			return Workbook.createWorkbook(file);
		} catch (IOException e) {
			bizlog.error("生成工作薄[" + file.getAbsolutePath() + "]错误", e);
			return null;
		}
		
	}
	
 public static List<String[]> readExcel(String excelFileName) throws BiffException, IOException{	    
	 		//创建一个list 用来存储读取的内容
		    List<String[]> list = new ArrayList<String[]>();
		    Workbook rwb = null;
		    Cell cell = null;    
		    //创建输入流
		    InputStream stream = new FileInputStream(excelFileName);    
		    //获取Excel文件对象
		    rwb = Workbook.getWorkbook(stream);    
		    //获取文件的指定工作表 默认的第一个
		    Sheet sheet = rwb.getSheet(0);  
		    //行数(表头的目录不需要，从1开始)
		    for(int i=2; i<sheet.getRows(); i++){	     
		     //创建一个数组 用来存储每一列的值
		     String[] str = new String[sheet.getColumns()];		     
		     //列数
		     for(int j=0; j<sheet.getColumns(); j++){	     
		      //获取第i行，第j列的值
		      cell = sheet.getCell(j,i);    
		      str[j] = cell.getContents();		      
		     }
		     //把刚获取的列存入list
		     list.add(str);
		    }		    
		    //返回值集合
		    return list;
		   }

 public static List<String[]> readExcelone(String excelFileName) throws BiffException, IOException{	    
		//创建一个list 用来存储读取的内容
	    List<String[]> list = new ArrayList<String[]>();
	    Workbook rwb = null;
	    Cell cell = null;    
	    //创建输入流
	    InputStream stream = new FileInputStream(excelFileName);    
	    //获取Excel文件对象
	    rwb = Workbook.getWorkbook(stream);    
	    //获取文件的指定工作表 默认的第一个
	    Sheet sheet = rwb.getSheet(0);  
	    //行数(表头的目录不需要，从1开始)
	     
	     //创建一个数组 用来存储每一列的值
	     String[] str = new String[sheet.getColumns()];		     
	     //列数
	     for(int j=0; j<sheet.getColumns(); j++){	     
	      //获取第i行，第j列的值
	      cell = sheet.getCell(j,0);    
	      str[j] = cell.getContents();		      
	     }
	     //把刚获取的列存入list
	     list.add(str);
	    	    
	    //返回值集合
	    return list;
	   }


}
