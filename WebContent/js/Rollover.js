
function showProp(trElement, cells)
{
	var cellArray = cells;
	var CurrentCellArray;// <TD>태그들의 배열 

	for(k=0 ; k<trElement.parentNode.children.length; k++)
	{
		var CurrentTr = trElement.parentNode.children[k];

		//CurrentTr.style.backgroundColor="#FFFFFF";

		var CurrentCellArray =  trElement.parentNode.children[k].cells
		for(i = 0; i < CurrentCellArray.length ; i++)
		{
			if( CurrentCellArray[i].nodeName !== "TH" )CurrentCellArray[i].style.backgroundColor = "#FFFFFF";
			//alert( CurrentCellArray[i].nodeName )
			
			var innerElement = CurrentCellArray[i].childNodes; 
			for(j = 0 ; j < innerElement.length; j++)
			{
				if(innerElement[j] != null)
					if(innerElement[j].nodeName == "TD") // && innerElement[j].type == "radio")
						innerElement[j].style.backgroundColor = "#FFFFFF";
			}                        
		}
	}
	
	for(i = 0; i < cellArray.length ; i++)
	{
		cellArray[i].style.backgroundColor = "#DDDDDD";
		
		var innerElement = cellArray[i].childNodes; 
		// <TD>안의 요소들(태그인 경우 object이고 아니면 null)에 대한 배열

		for(j = 0 ; j < innerElement.length; j++)
		{
			if(innerElement[j] != null) // 각 요소들이 태그 엘레먼트인지 검사
			{
				// info += "\t" + innerElement[j].nodeName + "\n";
				if(innerElement[j].nodeName == "INPUT" && innerElement[j].type == "radio")
				{ // 그 태그의 이름이 INPUT 이고 type이 checkbox이면 즉 체크박스 태그라면
					innerElement[j].checked = true;
					trElement.style.backgroundColor = "#DDDDDD";
					innerElement[j].style.backgroundColor = "#DDDDDD";
				}
			}
		} 
		
	}
}