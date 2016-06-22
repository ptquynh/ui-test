package com.tekexperts.pipeline.common.readData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class ExcelUtils {
	private static Sheet ExcelWSheet;
	private static Workbook ExcelWBook;
	private static Cell Cell;
	private static Font font;
	private static FileInputStream ExcelFile;
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		try {
			// Open the Excel file
			ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = WorkbookFactory.create(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheetAt(0);
			font = ExcelWBook.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setCharSet(HSSFFont.ANSI_CHARSET);
		} catch (Exception e){
			throw (e);
		}
	}
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		}catch (Exception e){
			return"";
		}
	}

	public static String[][] getData(){
		int xRows = ExcelWSheet.getLastRowNum()+1;
		int xCols = ExcelWSheet.getRow(0).getLastCellNum();
		//int nRow = 1;
		Iterator<Row> iterator=ExcelWSheet.iterator();
		info("xRows:"+xRows);
		info("xCols:"+xCols);
		String[][] xData = new String[xRows][xCols];
		
		while(iterator.hasNext()){
			Row nextRow=iterator.next();
			Iterator<Cell> cellIterator=nextRow.cellIterator();
			int i=nextRow.getRowNum();
			int j=0;
			info("i:"+i);
			while(cellIterator.hasNext()){
				Cell cell = cellIterator.next();
				if(i>0){
					j=cell.getColumnIndex();
					if (cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC){
						String value = NumberToTextConverter.toText(cell.getNumericCellValue()); 
						if(value!=null)
						xData[i][j] = value;
					}
					else{
						cell.setCellType(1);
						String value =  cell.getStringCellValue();
						if(value!=null)
						xData[i][j] = value;
					}
					//info("xData["+i+"]["+j+"]:"+xData[i][j]);
				}
				
			}
		}
		return xData;
	}
	/**
	 * Update data in existing file for many contracts
	 * @param Path
	 * @param rowList
	 * @param cellNum
	 * @param updateValue
	 */
	public static void writeData(String Path,ArrayList<Integer> rowList, ArrayList<Integer> cellNum,ArrayList<String> updateValue ) {
		try {
			Cell cell = null; 
			for(int j=0;j<rowList.size();j++){
				info("j:"+j);
				info("rowList.size():"+rowList.size());
				// declare a Cell object 
				for(int i=0;i<cellNum.size();i++){
					info("i:"+i);
					info("cellNum.size():"+cellNum.size());
					info("rowList.get(j):"+rowList.get(j));
					info("cellNum.get(i):"+cellNum.get(i));
					info("updateValue.get(i):"+updateValue.get(i));
					//Cell cell = null; 
		            cell = ExcelWSheet.getRow(rowList.get(j)).getCell(cellNum.get(i));
		            if(cell==null)
						cell=ExcelWSheet.getRow(rowList.get(j)).createCell(cellNum.get(i));
		            cell.setCellValue(updateValue.get(i)); 
				}
			}
            //Close the InputStream
            ExcelFile.close(); 
            //Open FileOutputStream to write updates
            FileOutputStream output_file =new FileOutputStream(new File(Path));  
            //write changes
            ExcelWBook.write(output_file); 
            //close the stream    
            output_file.close();  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Update data in existing file for one contract
	 * @param Path
	 * @param row
	 * @param cellNum
	 * @param updateValue
	 */
	public static void writeData(String Path,int row,int cellNum,String updateValue ) {
		try {
            Cell cell = null; 
            cell = ExcelWSheet.getRow(row).getCell(cellNum);
            if(cell==null)
            	cell=ExcelWSheet.getRow(row).createCell(cellNum);
           // Get current cell value value and overwrite the value
            cell.setCellValue(updateValue); 
            //Close the InputStream
            ExcelFile.close(); 
            //Open FileOutputStream to write updates
            FileOutputStream output_file =new FileOutputStream(new File(Path));  
            //write changes
            ExcelWBook.write(output_file); 
            //close the stream    
            output_file.close();  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}