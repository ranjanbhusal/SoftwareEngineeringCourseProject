$(document).ready(function(){

	
	var index = 0;
	var courses = {};
	var first = [];
	var second = [];
	var third = [];
	var fourth = [];

	$("#updateID").click(function() {
		
		$("ul.entryAdded").hide(3000);
				
//		setTimeout(function () {
//			$("p.entryAdded").css("diplay": "show");
//		}, 5000);
	});
	
	$('table tr.courseTable').on('click', function() {
		
		$(this).toggleClass('selected');
		
		var $tds = $(this).find('td');
		

		
		myfunc();  
		
		function myfunc() {
			index++;
			
			if (index === 1) {
				var firstCourse = {
						courseTitle: $tds[0].innerHTML,
						courseCode: $tds[1].innerHTML,
						professor: $tds[2].innerHTML,
						seatCapacity: $tds[3].innerHTML
				}
				console.log(firstCourse);
				courses.first = firstCourse;
//			    $.each($tds, function(i, item) {
//			    	console.log(item.innerHTML);
//			    	first.push(item.innerHTML);
//			    });				
			}
		
			else if (index === 2) {
				
				var secondCourse = {
						courseTitle: $tds[0].innerHTML,
						courseCode: $tds[1].innerHTML,
						professor: $tds[2].innerHTML,
						seatCapacity: $tds[3].innerHTML
				}
				console.log(secondCourse);
				courses.second = secondCourse;
				
//			    $.each($tds, function(i, item) {
//			    	console.log(item.innerHTML);
//			    	second.push(item.innerHTML);
//			    });				
			}
		
			else if (index === 3) {
				
				var thirdCourse = {
						courseTitle: $tds[0].innerHTML,
						courseCode: $tds[1].innerHTML,
						professor: $tds[2].innerHTML,
						seatCapacity: $tds[3].innerHTML
				}
				console.log(thirdCourse);
				courses.third =  thirdCourse;
				
//			    $.each($tds, function(i, item) {
//			    	console.log(item.innerHTML);
//			    	third.push(item.innerHTML);
//			    });				
			}
			
			else {
				
				var fourthCourse = {
						courseTitle: $tds[0].innerHTML,
						courseCode: $tds[1].innerHTML,
						professor: $tds[2].innerHTML,
						seatCapacity: $tds[3].innerHTML
				}
				console.log(fourthCourse);
				courses.fourth = fourthCourse;
				
//				 $.each($tds, function(i, item) {
//				    	console.log(item.innerHTML);
//				    	fourth.push(item.innerHTML);
//				 });	
			}
		
		}
	    

//		var courses = {
//		    	"firstCourse": first,	
//		    	"secondCourse": second, 	
//		    	"thirdCourse": third,
//		    	"fourthCourse": fourth
//		 };	    
//		console.log("finally" + courses.fourthCourse[1]);
//	    console.log("first"  +courses.firstCourse[1]);
//		
		    
		
		
		
//	    for (var key in courses) {
//	    	courses[key] = values; 
//		    console.log(courses[key]);
//		}
//	    
	    

	    
	});
	
//	var dataForAjax = {
//			courses: courses
//	}

	$("#jsBtn").click(function() {
		console.log("button clicked");
		 $.ajax({
	         url: 'save-enrolled-courses',
	         type: 'POST',
	         contentType : 'application/json; charset=utf-8',
	         dataType: 'json',
	         data: JSON.stringify(courses),
	         success: function (data) {
	             var $dispResult = $("#displayResult");
	             $dispResult.html("");
	             var result = data.result;
	             $dispResult.append(result + "<br><br>");
	         }
	     });
		 return false;

	});
	
//	$("tr.courseTable").click(function() {
//		$(this).toggleClass('selected');
//		
//	});
	
//	var Row = document.getElementById("courseTable");
//	var Cells = Row.getElementsByTagName("td");
//	alert(Cells[0].innerText);
//	alert(Cells[1].innerText);
	
	
});	