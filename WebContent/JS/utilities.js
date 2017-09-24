$(document).ready(function() {
	$(".datepickerField").datepicker({
		dateFormat : 'mm/dd/yy'
	});
	$("#dateOfBirth").datepicker('setDate', '09/22/1989');
});

$(document).ready(function() {
	$.ajax({
		url : "getDepartmentDetails.htm",
		type : 'GET',
		dataType : 'json',
		contentType : 'application/json',
		success : function(data) {

			$.each(data, function(key, value) {
				$("#deptId").append(new Option(value, key));
			});

		},
		error : function() {

		}

	});
});

function getSubjects() {
	if ($("#semester").val() == "") {
		alert("Select Semester");
	} else {
		$("#subjectCodeDiv").html("<select id='subjectCode' name='subjectCode'> <option value=''>Select</option></select>");
		$.ajax({
			url : "getSubjects.htm" + "?semester=" + $("#semester").val()+"&deptId="+$("#deptId").val(),
			type : 'GET',
			dataType : 'json',
			contentType : 'application/json',
			success : function(data) {

				$.each(data, function(key, value) {
					$("#subjectCode").append(new Option(value, key));
				});
			},
			error : function() {

			}

		});
	}

}