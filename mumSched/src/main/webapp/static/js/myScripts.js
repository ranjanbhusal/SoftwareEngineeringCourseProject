$(document).ready(function(){

	var index = 0;
	var courses = {};
	var first = [];
	var second = [];
	var third = [];
	var fourth = [];

	$("#updateID").click(function() {
		$("ul.entryAdded").hide(3000);
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
			}
		}
	});
	

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
});	