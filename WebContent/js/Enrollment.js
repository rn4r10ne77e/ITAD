function Ready()
{
	document.main.eqpcateg.value = 0
	document.main.location.value = 0
	
	innerajax( "subcate", "/ITAD/PeacePages/ppCodeLookup.jsp", "TableName=EQPCATEG&parent="+document.main.eqpcateg.value );
	document.main.subcate.value = 0

	innerajax( "MNDept", "/ITAD/PeacePages/ppCodeLookup.jsp", "TableName=LOCXDEPT&parent="+document.main.location.value );
	document.main.MNDept.value = 0
	
	document.main.eqpcateg.onchange = function()
	{
		var param = "TableName=EQPCATEG&parent="+document.main.eqpcateg.value;
		innerajax( "subcate", "/ITAD/PeacePages/ppCodeLookup.jsp", param );
	}
	
	document.main.location.onchange = function()
	{
		var param2 = "TableName=LOCXDEPT&parent="+document.main.location.value;
		innerajax( "MNDept", "/ITAD/PeacePages/ppCodeLookup.jsp", param2 );
	}

	
	
	
	
	var obj = document.getElementsByClassName('price');
	for( var i=0 ; i<obj.length ; i++ )
	{
		obj[i].innerHTML = comma(obj[i].innerHTML);
	}

	innerajax( "photoframe", "../PeacePages/ppPicture.jsp","idx=0" );
}