$(document).ready(function(){

	
	
	$("#updateID").click(function() {
		
		$("ul.entryAdded").hide(3000);
				
//		setTimeout(function () {
//			$("p.entryAdded").css("diplay": "show");
//		}, 5000);
	});
	
	$("tr.courseTable").click(function() {
		$(this).toggleClass('selected');
		
	});
	
//	var Row = document.getElementById("courseTable");
//	var Cells = Row.getElementsByTagName("td");
//	alert(Cells[0].innerText);
//	alert(Cells[1].innerText);
	
	
});	