<%@ page pageEncoding="UTF-8" %>
<%@ include file="toppage.jsp"%>
<script>
window.onload = function()
{
	document.main.MAtab.value = Apl.GetMacAddr();
	document.main.IPtab.value = Apl.GetIPAddr();
	document.main.HNtab.value = Apl.GetHostName();
	document.main.Account.value =Apl.GetAccount();
	document.main.HDDsn.value = Apl.GetHDDserial();
	document.main.MBoardSN.value = Apl.GetMBoardSN();
	document.main.CPUname.value = Apl.GetCPUname();
	document.main.LAMcapa.value = Apl.GetLAMcapa();
	document.main.OSinfo.value = Apl.GetOSinfo();

	document.main.Vender.value = Apl.GetManufacturer();
	document.main.PCmodel.value = Apl.GetPCmodel();

	document.main.action="Enrollment.jsp"
	document.main.submit();
}
</script>


<input type="hidden" name="MAtab"><br>
<input type="hidden" name="IPtab"><br>
<input type="hidden" name="HNtab"><br>
<input type="hidden" name="MBoardSN"><br>
<input type="hidden" name="OSinfo"><br>
<input type="hidden" name="CPUname"><br>
<input type="hidden" name="Account"><br>
<input type="hidden" name="LAMcapa"><br>
<input type="hidden" name="PCmodel"><br>
<input type="hidden" name="Vender"><br>
<input type="hidden" name="HDDsn"><br>

<table width=100%><tr><td align=center>
<applet code = "ClientInfo.class" archive="ClientInfo.jar" name="Apl"></applet>
</td></tr></table>
<%@ include file="bottompage.jsp"%>
