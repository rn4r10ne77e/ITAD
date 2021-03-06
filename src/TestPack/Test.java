package TestPack;

import java.util.*;

import ITAD.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;




public class Test {
	
	String RealRootPath = null;
	String ReportName = null;
	String seqNo = null;
	String OutputPath = null;
	
	Map<String, Object> parameters = null;

    JasperReport jasperReport = null;
    JasperPrint print = null;
    DBConn conn = null;
    
    public Test()
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

        DBConn conn = new DBConn(false);
        
		try 
		{
			conn.Connect();
			jasperReport = JasperCompileManager.compileReport(reportSrcFile);

			print = JasperFillManager.fillReport(jasperReport, parameters, conn.getConnection());

			conn.Disconnect();
			
	        JRPdfExporter exporter = new JRPdfExporter();
	
	        ExporterInput EI = new SimpleExporterInput(print);
	        
	        exporter.setExporterInput(EI);

	        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput( reportDstFile );

	        exporter.setExporterOutput(exporterOutput);

	        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
	        
	        exporter.setConfiguration(configuration);
	        
	        exporter.exportReport();


		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
