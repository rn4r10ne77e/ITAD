<%@ page language="java" contentType="text/html; charset=EUC-KR" import="org.apache.poi.xssf.usermodel.*, java.util.*,java.io.*,java.sql.*,ITAD.*,ITAD.DataStructure.*,java.text.*" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
//������ VO�� ���ִ� MAP ��ü
Map<String,Object>map=null;
//���� DB��ȸ�� ����� ���� LIST��ü
ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
ArrayList<String> columnList=new ArrayList<String>();
//DB��ȸ�� �����͸� ��Ҵٴ� ������ ������
for(int i=0;i<10;i++){
    map=new HashMap<String,Object>();
    map.put("seq", i+1);
    map.put("title", "�����̴�"+i);
    map.put("content", "�����Դϴ�"+i);
    list.add(map);
}
//MAP�� KEY���� ������� 
if(list !=null &&list.size() >0){
    //LIST�� ù��° �������� KEY���� �˸� �ǹǷ� 
    Map<String,Object>m=list.get(0);
    //MAP�� KEY���� columnList��ü�� ADD 
    for(String k : m.keySet()){
        columnList.add(k);
    }
}
//1���� workbook�� ���� 
XSSFWorkbook workbook=new XSSFWorkbook();
//2���� sheet���� 
XSSFSheet sheet=workbook.createSheet("��Ʈ��");
//������ �� 
XSSFRow row=null;
//������ �� 
XSSFCell cell=null;
//������ DB������ ��ȸ 
if(list !=null &&list.size() >0){
    int i=0;
    for(Map<String,Object>mapobject : list){
        // ��Ʈ�� �ϳ��� ���� �����Ѵ�(i ���� 0�̸� ù��° �ٿ� �ش�) 
        row=sheet.createRow((short)i);
        i++;
        if(columnList !=null &&columnList.size() >0){
            for(int j=0;j<columnList.size();j++){
                //������ row�� �÷��� �����Ѵ� 
                cell=row.createCell(j);
                //map�� ��� �����͸� ������ cell�� add�Ѵ� 
                cell.setCellValue(String.valueOf(mapobject.get(columnList.get(j))));
            }
        }
    }
}
FileOutputStream fileoutputstream=new FileOutputStream("D:\\roqkffhwk2.xlsx");
//������ ����
workbook.write(fileoutputstream);
//�ʼ��� �ݾ��־���� 

workbook.close();
fileoutputstream.close();
System.out.println("�������ϻ�������");
%>
</body>
</html>