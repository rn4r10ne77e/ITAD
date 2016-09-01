function Move(obj, url) 
{
	node = obj.parentNode;
	while( node.nodeName.toLowerCase() != 'form' )
	{
		node = node.parentNode;
	}

	node.action = url;
	node.submit();
}
function MovePage(obj, url)
{
	document.getElementsByName("selectpage")[0].value = obj.value
	Move(obj, url)
}
function PCList_Select_PC( obj, url )
{
	document.getElementsByName("useridx")[0].value
	Move(obj, url)
}
function Change_User( loc, filename, param )
{
	var httpRequest;
	
	makeRequest( filename )
	
	function makeRequest(url)
	{
	    if (window.XMLHttpRequest) 
	    { // Mozilla, Safari, ...
			httpRequest = new XMLHttpRequest();
	    }
	    else if (window.ActiveXObject)
	    { // IE
			try
	    	{
				httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} 
			catch (e) 
			{
				try
				{
					httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	        	}
	        	catch(e){}
			}
		}
	
	    if (!httpRequest)
	    {
			alert('Giving up :( Cannot create an XMLHTTP instance');
			return false;
		}
		
		httpRequest.open('POST', url, false);
		
		httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		httpRequest.setRequestHeader("Content-length", params.length);
		httpRequest.setRequestHeader("Connection", "close");
		
		httpRequest.onreadystatechange = alertContents;
		
		httpRequest.send(params);
		
	}

	function alertContents()
	{
		if (httpRequest.readyState === 4)
		{
			if (httpRequest.status === 200)
			{
				document.getElementById(loc).innerHTML = httpRequest.responseText
			}
			else
			{
				alert('There was a problem with the request.');
			}
		}
	}
	
}
function Search_User()
{
	var column = document.getElementById("siba").value;
	var searchkey = document.getElementById("searchbox").value;
	
	Change_User('popuplayer', 'ppUsrList.jsp', column, searchkey, 1 )
}
function Search_Vendor()
{
	var column = document.getElementById("siba").value;
	var key = document.getElementById("searchbox").value;
	
	innerajax('pop', 'ppVendors.jsp','column='+column+'&key='+key );
}
function Change_Page( loc, pageno )
{
	var column = document.getElementById("siba").value;
	var searchkey = document.getElementById("searchbox").value;
	
	Change_User( loc , 'ppUsrList.jsp', column, searchkey, pageno )
}
function Selected_User( tds )
{
	var cellArray = tds
	
	for(i = 0; i < cellArray.length ; i++)
	{
		if( cellArray[i].id == "ulidx") document.getElementsByName("useridx")[0].value = cellArray[i].innerHTML;
		if( cellArray[i].id == "ulid") document.getElementsByName("ID")[0].value = cellArray[i].innerHTML;
		if( cellArray[i].id == "ulname") document.getElementsByName("name")[0].value = cellArray[i].innerHTML;
		if( cellArray[i].id == "uldept") document.getElementsByName("usrDept")[0].value = cellArray[i].innerHTML;
		if( cellArray[i].id == "ulposition") document.getElementsByName("usrPosition")[0].value = cellArray[i].innerHTML;
		
		// <TD>안의 요소들(태그인 경우 object이고 아니면 null)에 대한 배열 ulposition
	}
	
	document.main.action = "PCEdit_OK.jsp";
	document.main.submit();
	
}

function popup( loc, filename, param )
{
	buttonflag = true;
	var popupl = document.getElementById(loc);
	
	popupl.style.display = "none";
	document.body.onclick = null;
	
	
	
	innerajax( loc, filename, param );
	
	popupl.style.display = "block";

	popupl.style.left = (document.body.scrollLeft + (document.body.clientWidth / 2)) - (popupl.offsetWidth / 2)+'px';
	popupl.style.top = (document.body.scrollTop + (document.body.clientHeight / 2)) - ( popupl.offsetHeight / 2)+'px';

	//popupl.style.display = "block";

	//alert("스크롤 레프트 : "+document.body.scrollLeft+" , 클라이언트 위드쓰 나누기 이 "+ (document.body.clientWidth / 2) +" - 객체 위드쓰 나누기 이"+ (popupl.offsetWidth / 2) )
	
	document.body.onclick = function( loc )
	{
		var Dleft = popupl.offsetLeft;
		var Dtop = popupl.offsetTop;
		var Dright = Dleft + popupl.offsetWidth
		var Dbottom = Dtop + popupl.offsetHeight

		var mspox = event.clientX + document.body.scrollLeft;
		var mspoy = event.clientY + document.body.scrollTop;
		
		if( buttonflag ) buttonflag = false;
		else
		{
			if(( Dleft <= mspox && mspox <= Dright && Dtop <= mspoy && mspoy <= Dbottom ) == false )
			{
				popupl.style.display = "none";
				document.body.onclick = null;				
			}
		}
	}
}

function popup2( loc, filename, param )
{
	var popupl = document.getElementById(loc);
	

	innerajax( loc, filename, param );
	
	popupl.style.display = "block";

	popupl.style.left = (document.body.scrollLeft + (document.body.clientWidth / 2)) - (popupl.offsetWidth / 2)+'px';
	popupl.style.top = (document.body.scrollTop + (document.body.clientHeight / 2)) - ( popupl.offsetHeight / 2)+'px';

	//popupl.style.display = "block";

	//alert("스크롤 레프트 : "+document.body.scrollLeft+" , 클라이언트 위드쓰 나누기 이 "+ (document.body.clientWidth / 2) +" - 객체 위드쓰 나누기 이"+ (popupl.offsetWidth / 2) )
	
	document.body.onclick = function( loc )
	{
		var Dleft = popupl.offsetLeft;
		var Dtop = popupl.offsetTop;
		var Dright = Dleft + popupl.offsetWidth
		var Dbottom = Dtop + popupl.offsetHeight

		var mspox = event.clientX + document.body.scrollLeft;
		var mspoy = event.clientY + document.body.scrollTop;
		
		if( buttonflag ) buttonflag = false;
		else
		{
			if(( Dleft <= mspox && mspox <= Dright && Dtop <= mspoy && mspoy <= Dbottom ) == false )
			{
				popupl.style.display = "none";
				document.body.onclick = null;				
			}
		}
	}
}
function innerajax( loc, filename, params )
{
	var httpRequest;
	makeRequest( filename )
	
	function makeRequest(url)
	{
	    if (window.XMLHttpRequest) 
	    { // Mozilla, Safari, ...
			httpRequest = new XMLHttpRequest();
	    }
	    else if (window.ActiveXObject)
	    { // IE
			try
	    	{
				httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} 
			catch (e) 
			{
				try
				{
					httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	        	}
	        	catch(e){}
			}
		}
	
	    if (!httpRequest)
	    {
			alert('Giving up :( Cannot create an XMLHTTP instance');
			return false;
		}
		
		httpRequest.open('POST', url, false);
		
		httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		httpRequest.setRequestHeader("Content-length", params.length);
		httpRequest.setRequestHeader("Connection", "close");
		
		httpRequest.onreadystatechange = alertContents;
		
		httpRequest.send(params+"&timestamp="+new Date().getTime());
		
	}

	function alertContents()
	{
		if (httpRequest.readyState === 4)
		{
			if (httpRequest.status === 200)
			{
				document.body.onclick = null;
								
				document.getElementById(loc).innerHTML = "";
				document.getElementById(loc).innerHTML = httpRequest.responseText;
			}
			else
			{
				alert('There was a problem with the request.');
			}
		}
	}	
}
function uploadajax( filename, fileformname, idx, no  )
{
	var formdata = new FormData();
	var file = document.getElementById(fileformname).files[0];

	formdata.append( "uploadFile", file );
	formdata.append( "idx", idx );
	formdata.append( "imgnumber",  no );

	var httpRequest;
	
	makeRequest( filename, formdata );
	
	function makeRequest( url, formdata, idx )
	{
	    if (window.XMLHttpRequest) 
	    { // Mozilla, Safari, ...
			httpRequest = new XMLHttpRequest();
	    }
	    else if (window.ActiveXObject)
	    { // IE
			try
	    	{
				httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} 
			catch (e) 
			{
				try
				{
					httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	        	}
	        	catch(e){}
			}
		}
	
	    if (!httpRequest)
	    {
			alert('Giving up :( Cannot create an XMLHTTP instance');
			return false;
		}

		httpRequest.open('POST', url, false);
		
		httpRequest.setRequestHeader("Content-type", "multipart/form-data");
		httpRequest.setRequestHeader("Content-length", formdata.length);
		httpRequest.setRequestHeader("Connection", "close");
		
		httpRequest.onreadystatechange = alertContents();
		
		httpRequest.send(formdata);
		

	}

	function alertContents()
	{
		if (httpRequest.readyState === 4)
		{
			
			if (httpRequest.status === 200)
			{
				
			}
			else
			{
				alert('There was a problem with the request.');
			}
		}
	}	
}

function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}
function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}
function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}

function VendorAdd( filename )
{
	var descr = document.getElementById("descr").value;
	var corpno = document.getElementById("corpno").value;
	var manager = document.getElementById("manager").value;

	var param = "descr="+descr+"&corpno="+corpno+"&manager="+manager;
	
	popup('pop', 'ppVendorsAdd_OK.jsp', param );
	popup('pop', 'ppVendors.jsp', '' );
	
	innerajax('vendorplace',filename,''); // filename 워래 ppChangevendor.jsp 파일이 하드코딩 되어 있었음..
}
function VendorEdit( filename )
{
	var vidx = document.getElementById("vidx").value;
	var descr = document.getElementById("descr").value;
	var corpno = document.getElementById("corpno").value;
	var manager = document.getElementById("manager").value;
	
	var param = "idx="+vidx+"&descr="+descr+"&corpno="+corpno+"&manager="+manager;
	
	popup('pop', 'ppVendorsEdit_OK.jsp', param );
	popup('pop', filename, '' ); // filename 워래 ppChangevendor.jsp 파일이 하드코딩 되어 있었음..
	
	innerajax('vendorplace', filename ,'');
}
function VendorSelect( tds )
{
	var cellArray = tds
	var idx;
	
	for(i = 0; i < cellArray.length ; i++)
	{
		if( cellArray[i].id == "ulidx") idx = cellArray[i].innerHTML;
	}

	var param = "IDX="+idx;
	popup('pop','ppVendorsEdit.jsp',param);
}

function Logout()
{
	location.href='Login.jsp';
}

function ViewDetail(trElement, cells)
{
	var cellArray = cells;
	var CurrentCellArray;
	var loc;

	for(k=0 ; k<trElement.parentNode.children.length; k++)
	{
		var CurrentTr = trElement.parentNode.children[k];
		var idx = CurrentTr.getAttribute('ID');
		
		if( String(idx).indexOf("detail") != -1 ) CurrentTr.innerHTML = "";
	}
	
	for( var i=0 ; i < cellArray.length ; i++ )
	{
		if( cellArray[i].getAttribute('ID') == "hstridx" ) loc = cellArray[i].innerHTML;
	}
	
	innerajax(loc+"detail", "ppHistoryDetail.jsp","IDX="+loc);
}
function SetValuetoRadio( name, val )
{
	var radiobutton = document.getElementsByName(name);
	var lowlength = radiobutton.length;
	
	for( var i=0 ; i<lowlength ; i++ )
	{
		if( radiobutton[i].value == val ) radiobutton[i].checked = true;
	}
}