package com.hackfse.giveaway.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hackfse.giveaway.dao.InventoryManagementDao;
import com.hackfse.giveaway.dao.UserDao;
import com.hackfse.giveaway.dto.UsersBean;
import com.hackfse.giveaway.util.CommonUtil;

@Service
public class ReportingService {

	@Autowired
	InventoryManagementDao inventoryManagementDao;
	
	@Autowired
	UserDao userDao;
	
	@Value("${application.storage.location}")
	private String fileStorageLocation;
	
	CommonUtil commonUtil = new CommonUtil();
	
	
	public List<Object[]> getReportForInventry(String itemCategory, String itemStatus, Long qutrValue, Long yrValue,
			String mntname, String userId) throws SQLException {
		List<Object[]> lstReportData = new ArrayList<Object[]>();
		System.out.println("DATA OUTPUT : "+itemCategory+" :::: "+itemStatus+" :::: "+qutrValue+" :::: "+yrValue+" :::: "+mntname+" :::: "+userId);
		lstReportData = inventoryManagementDao.getInventoryReport(itemCategory.trim().equalsIgnoreCase("") ? null : itemCategory.trim().equalsIgnoreCase("null") ? null : itemCategory.trim(),
						itemStatus.trim().equalsIgnoreCase("") ? null : itemStatus.trim().equalsIgnoreCase("null") ? null : itemStatus.trim(), 
						qutrValue.toString().trim().equalsIgnoreCase("") ? null : qutrValue.toString().trim().equalsIgnoreCase("0") ? null : qutrValue, 
						yrValue.toString().trim().equalsIgnoreCase("") ? null : yrValue.toString().trim().equalsIgnoreCase("0") ? null : yrValue, 
						mntname.trim().equalsIgnoreCase("") ? null : mntname.trim().equalsIgnoreCase("null") ? null : mntname.trim(),
						userId.trim().equalsIgnoreCase("") ? null : userId.trim().equalsIgnoreCase("null") ? null : userId.trim());
		return lstReportData;
		
	}
	
	public String generateReportExcel(String[] columns, List<Object[]> lstReportData, String strFileName) throws IOException {
		 Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		 	final Path fileStoragePath = Paths.get(fileStorageLocation);
		 	String filePath = fileStorageLocation+"\\"+UUID.randomUUID()+strFileName+".xlsx";
	        CreationHelper createHelper = workbook.getCreationHelper();

	        // Create a Sheet
	        Sheet sheet = workbook.createSheet(strFileName);

	        // Create a Font for styling header cells
	        Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14);
	        headerFont.setColor(IndexedColors.RED.getIndex());

	        // Create a CellStyle with the font
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);

	        // Create a Row
	        Row headerRow = sheet.createRow(0);

	        // Create cells
	        for(int i = 0; i < columns.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);
	        }

	        // Create Cell Style for formatting Date
	        CellStyle dateCellStyle = workbook.createCellStyle();
	        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

	        // Create Other rows and cells with employees data
	        int rowNum = 1;
	        for(Object[] rowData: lstReportData) {
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0).setCellValue(rowData[0].toString());

	            row.createCell(1).setCellValue(rowData[1].toString());
	            
	            row.createCell(2).setCellValue(rowData[2].toString());
	            
	            row.createCell(3).setCellValue(rowData[3].toString());

	            row.createCell(4).setCellValue(rowData[4].toString());
	           /* Cell dateOfBirthCell = row.createCell(4);
	            dateOfBirthCell.setCellValue(rowData[4].toString());
	            dateOfBirthCell.setCellStyle(dateCellStyle);*/

	            row.createCell(5).setCellValue(rowData[5].toString());
	            row.createCell(6).setCellValue(rowData[6].toString());
	            row.createCell(7).setCellValue(rowData[7].toString());
	            row.createCell(8).setCellValue(rowData[8].toString());
	            row.createCell(9).setCellValue(rowData[9].toString());
	        }

			// Resize all columns to fit the content size
	        for(int i = 0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // Write the output to a file
	        File file = new File(filePath);
	        file.createNewFile();
	        FileOutputStream fileOut = new FileOutputStream(file, false);
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	       
	        
	        byte[] bytes = new byte[(int) file.length()];
	        FileInputStream fis = new FileInputStream(file);
	        fis.read(bytes);
	        String base64 = new sun.misc.BASE64Encoder().encode(bytes);
	        base64 = base64.replace("\n", "").replace("\r", "");
	        return base64;
	}
	
	public String getUserList() throws IOException {
		List<UsersBean> listUsers = userDao.findAll();
		List<Object[]> lstReportData = new ArrayList<Object[]>();
		for(UsersBean userBean : listUsers) {
			Object[] userRow = new Object[2];
			userRow[0] = userBean.getUserName();
			userRow[1] = userBean.getUserFirstName()+" "+userBean.getUserLastName();
			lstReportData.add(userRow);
		}
		String strReportData = commonUtil.writeListToJsonArray(lstReportData);
		
		return strReportData;
	}
}
