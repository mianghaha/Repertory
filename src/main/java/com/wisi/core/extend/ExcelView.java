package com.wisi.core.extend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.wisi.core.util.DateUtil;

public class ExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String filename = "----";
		if(model.get("filename")!=null && !"".equals(model.get("filename"))){
			filename = (String) model.get("filename");
		}
		int depth = (Integer) model.get("depth");
		String headerStr =  (String) model.get("headerStr");
		String[] styleArray =  (String[]) model.get("styleArray");
		List<String[]> rowsList =  (List<String[]>) model.get("rowsList");
		
		
		
		int len = styleArray.length;
		
		
		HSSFSheet sheet = workbook.createSheet(filename);
		short s = workbook.createDataFormat().getFormat("@");
		
		response.setHeader("Content-Disposition",
				"inline;filename="+new String((filename+"-"+DateUtil.getCalendarStr()+".xls").getBytes(),"iso8859-1"));
		HSSFCellStyle style = workbook.createCellStyle(); // 样式对象   
		style.setDataFormat(s);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直   
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平   
//        for (int i = 0; i < len; i++) {
//        	sheet.setDefaultColumnStyle((short) i, style);
//        }
//        
//        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        
        HSSFCellStyle styleLeft = workbook.createCellStyle();
		style.setDataFormat(s);
        styleLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        styleLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直   
//        styleLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        styleLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        styleLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        styleLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
        
        HSSFCellStyle styleCenter = workbook.createCellStyle();
		style.setDataFormat(s);
        styleCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        styleCenter.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直   
//        styleCenter.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        styleCenter.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        styleCenter.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        styleCenter.setBorderTop(HSSFCellStyle.BORDER_THIN);
        
        HSSFCellStyle styleRight = workbook.createCellStyle();
		style.setDataFormat(s);
        styleRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        styleRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直   
//        styleRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        styleRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        styleRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        styleRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
        
        
        int rowNum = 0;
        
        
        sheet.addMergedRegion(new Region(0,(short)0,1,(short)(len-1)));// 四个参数分别是：起始行，起始列，结束行，结束列   
		HSSFCell titleCell = sheet.createRow(rowNum).createCell((short) 0);
		titleCell.setCellStyle(styleCenter);
		titleCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		titleCell.setCellValue(filename);
		
		
		
		String[] rows = headerStr.split("\\&\\$\\&");
		rowNum = 1;
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < depth; i++) {
			map.put("row"+i, rowNum+1);
			map.put("col"+i, 0);
		}
		
		for (int i = 0,l = rows.length;i<l;i++) {
			String row = rows[i];
			rowNum ++;
			  //header = sheet.createRow(rowNum);
			String[] rs = row.split("\\!\\*\\!");
			for (String strs : rs) {
				String[] o = strs.split("\\<\\*\\>");//o:[o.text, o.align,o.hidden,o.child_len]
				if(!"true".equals(o[2])){
					int child_len = Integer.parseInt(o[3]);
					if(child_len>0){
						sheet.addMergedRegion(new Region(rowNum,(short)(int)map.get("col"+i),rowNum,(short)(int)(map.get("col"+i)+(child_len-1))));// 四个参数分别是：起始行，起始列，结束行，结束列   
						//this.makeCell(header, (int) map.get("col"+i), o[1], o[0], styleLeft, styleCenter, styleRight);
						map.put("col"+i, map.get("col"+i)+child_len);
					}else{
						if(i<depth){
							int a = depth-i;
							sheet.addMergedRegion(new Region(rowNum,(short)(int)map.get("col"+i),rowNum+(a-1),(short)(int)map.get("col"+i)));// 四个参数分别是：起始行，起始列，结束行，结束列   
							//this.makeCell(header, (int) map.get("col"+i), o[1], o[0], styleLeft, styleCenter, styleRight);
							for (int j = 0; j < a; j++) {
								map.put("col"+(i+j), map.get("col"+(i+j))+1);
							}
						}
					}
				}
			}
		}
		
		
		
//		for (int i = 0; i < len; i++) {
//			HSSFCell cell = header.createCell((short) i);
//			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//			cell.setCellStyle(retrunStyle(styleArray[i], styleLeft, styleCenter, styleRight));
//			cell.setCellValue(headerArray[i]);
//		}
//		
//		int rowNum = 3;
		
		rowNum++;
		for(String[] rowArr : rowsList){
			HSSFRow row = sheet.createRow(rowNum++);
			for (int i = 0; i < rowArr.length; i++) {
				this.makeCell(row, i, styleArray[i], rowArr[i].replaceAll("<IMG>", ""), styleLeft, styleCenter, styleRight);
			}
		}
		
	}

	
	private HSSFCellStyle retrunStyle(String alignStr,HSSFCellStyle styleLeft,HSSFCellStyle styleCenter,HSSFCellStyle styleRight){
		if("center".equalsIgnoreCase(alignStr)){
			return styleCenter;
		}else if("right".equalsIgnoreCase(alignStr)){
			return styleRight;
		}else{
			return styleLeft;
		}
	}
	
	
	private void makeCell(HSSFRow row, int column ,String alignStr, String value,HSSFCellStyle styleLeft,HSSFCellStyle styleCenter,HSSFCellStyle styleRight){
		HSSFCell cell = row.createCell((short) column);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(retrunStyle(alignStr, styleLeft, styleCenter, styleRight));
		cell.setCellValue(value);
	}
}
