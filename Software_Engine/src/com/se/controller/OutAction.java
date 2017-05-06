package com.se.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.se.dao.StudentDaoJDBCImpl;
import com.se.domain.Student;

public class OutAction extends ActionSupport implements ServletResponseAware {
	private static final long serialVersionUID = 1L;     
	private Student student;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	private StudentDaoJDBCImpl studentDao=new StudentDaoJDBCImpl();
    private String format = "xls";   
    private HttpServletResponse response;   
    private String fileName;  
    
    public String execute(){      
        @SuppressWarnings("all")   
        List la = studentDao.findAll();       
        setResponseHeader();   
        try {   
            exportExcel(response.getOutputStream());   
            response.getOutputStream().flush();   
            response.getOutputStream().close();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
        return null;   
    }     
    /** ������Ӧͷ*/   
    public void setResponseHeader(){   
        try{   
//          response.setContentType("application/msexcel;charset=UTF-8");  //���ַ���������   
            response.setContentType("application/octet-stream;charset=iso-8859-1");   
            response.setHeader("Content-Disposition", "attachment;filename="   
                    +java.net.URLEncoder.encode(this.fileName, "UTF-8"));   
            //�ͻ��˲�����   
            response.addHeader("Pargam", "no-cache");   
            response.addHeader("Cache-Control", "no-cache");   
        }catch(Exception ex){   
            ex.printStackTrace();   
        }   
    }     
    /**��������*/   
    private void exportExcel(OutputStream os) throws IOException{   
        Workbook book = new HSSFWorkbook();   
        Sheet sheet = book.createSheet("������Ϣ");   
        Row row = sheet.createRow(0);   
        row.createCell(0).setCellValue("ѧ��");   
        row.createCell(1).setCellValue("����");   
        row.createCell(2).setCellValue("�Ա�");       
        CellStyle sty = book.createCellStyle();   
        List<Student> list = studentDao.findAll();   
        for (int i = 1; i < list.size(); i++) {   
        	Student user = list.get(i);   
            row = sheet.createRow(i);   
            row.createCell(0).setCellValue(user.getId());   
            row.createCell(1).setCellValue(user.getName());   
            row.createCell(2).setCellValue(user.getSex());        
        }   
        try{   
            book.write(os);   
        }catch(Exception ex){   
            ex.printStackTrace();   
        }   
    }    
    
    public void setFormat(String format) {   
        this.format = format;   
        this.fileName = "ѧ��������.xls";   
    }   
    
    public String getFormat() {   
        return format;   
    }   
    
    public String getFileName() {   
        return fileName;   
    }   
    public void setFileName(String fileName) {   
        this.fileName = fileName;   
    }   
    /**��סһ���и����Ե�set����*/   
    public void setServletResponse(HttpServletResponse response) {   
        this.response = response;   
    }   
}
