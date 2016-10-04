package JASPERREPORT; 

import java.util.*;

import ITAD.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.*;


public class Jreport {
	
	String RealRootPath = null;
	String ReportName = null;
	String seqNo = null;
	String OutputPath = null;
	
	Map<String, Object> parameters = null;
    
    JasperReport jasperReport = null;
    JasperPrint print = null;
    DBConn conn = null;
    
    public Jreport()
    {
    	
    }
    
	
	
	public void setRealRootPath( String path )
	{
		this.RealRootPath = path;		
	}
	public void setReportName( String name )
	{
		this.ReportName = name;
	}
	public void setUserID( String ID )
	{
		this.seqNo = ID;
	}
	public void setParameter( Map<String, Object> parameters )
	{
		if( this.parameters == null )
		{
			this.parameters = new HashMap<String, Object>();
			this.parameters = parameters;
		}
	}

	
	
	
	
	public void ProgressConvert()
	{
		String reportSrcFile = RealRootPath + "Reports/" + ReportName + "/" + ReportName + ".jrxml";
		String reportDstFile = RealRootPath + "Reports/Output/" + seqNo + ReportName + ".pdf";
        
        JasperReport jasperReport = null;
        JasperPrint print = null;
        
        
        DBConn conn = new DBConn(false);
        
        Jreport jrprt = new Jreport();
        
		try 
		{
			conn.Connect();
			jasperReport = JasperCompileManager.compileReport(reportSrcFile);

			print = JasperFillManager.fillReport(jasperReport, parameters, conn.getConnection());

			conn.Disconnect();
        
	        JRPdfExporter exporter = new JRPdfExporter();
	
	        ExporterInput exporterInput = new SimpleExporterInput(print);

	        exporter.setExporterInput(exporterInput);

	        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput( reportDstFile );

	        exporter.setExporterOutput(exporterOutput);

	        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();

	        exporter.setConfiguration(configuration);
	        
	        exporter.exportReport();

		}
		catch (JRException e) 
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
