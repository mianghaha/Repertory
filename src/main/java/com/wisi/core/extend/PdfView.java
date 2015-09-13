package com.wisi.core.extend;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.wisi.core.util.DateUtil;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String filename = (String) model.get("filename");
		String[] headerArray =  (String[]) model.get("headerArray");
		String[] styleArray =  (String[]) model.get("styleArray");
		
		
		List<String[]> rowsList = (List<String[]>) model.get("rowsList");
		
		int len = headerArray.length;
		
		response.setHeader("Content-Disposition",
				"inline;filename="+new String((filename+"-"+DateUtil.getCalendarStr()+".pdf").getBytes(),"iso8859-1"));
		
		Table table = new Table(len);
		table.setWidth(105);
		
		table.setBorderWidth(1);//将边框宽度设为1
		table.setAutoFillEmptyCells(true);
		//table.getDefaultCell().setVerticalAlignment(Cell.ALIGN_MIDDLE);
		table.setPadding(1);
		
//		int[] colWiths = new int[len];
//		table.setWidths(colWiths)
		
		BaseFont cnBaseFont = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H",false);
		
//		Cell titleCell = buildFontCell(filename, "center", new Font(cnBaseFont,11,Font.BOLD,Color.black));
//		titleCell.setColspan(len);
//		titleCell.setLeading(20);
//		titleCell.setBorder(0);
//		table.addCell(titleCell);
		
		
		Font cnFont = new Font(cnBaseFont,8,Font.NORMAL,Color.black);
		
		for (int i = 0; i < headerArray.length; i++) {
			Cell cell = buildFontCell(headerArray[i], styleArray[i], cnFont);
			cell.setHeader(true);//将该单元格作为表头信息显示
			table.addCell(cell);
		}
		table.endHeaders();/*要注意的是一旦表头信息添加完了之后，必须调用endHeaders()方法，否则当表格跨页后，表头信息不会再显示*/
		for(String[] rowArr : rowsList){
			for (int i = 0; i < rowArr.length; i++) {
				table.addCell(buildFontCell(rowArr[i], styleArray[i], cnFont));
			}
		}
		
		Phrase phrase  = new Phrase(filename, new Font(cnBaseFont,15,Font.BOLD,Color.black));
		Paragraph paragraph = new Paragraph(phrase);
		
		document.add(paragraph);
		document.add(table);
		
	}

//	private Cell buildFontCell(String content, Font font) throws RuntimeException{
//		try {
//			Phrase phrase = new Phrase(content,font);
//			return new Cell(phrase);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	private Cell buildFontCell(String content,String alignStr, Font font) throws RuntimeException{
		try {
			Phrase phrase = new Phrase(content,font);
			Cell cell = new Cell(phrase);
			if("center".equalsIgnoreCase(alignStr)){
				cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			}else if("right".equalsIgnoreCase(alignStr)){
				cell.setHorizontalAlignment(Cell.ALIGN_RIGHT);
			}else{
				cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			}
			return cell;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
