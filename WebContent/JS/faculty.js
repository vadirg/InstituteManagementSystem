function facultyDataValidation(){
	var flg=true;
	
	if($("#facultyName").val()==""){
		$("#facultyName").css('background','red');
		flg=flg&&false;
	}else{
		$("#facultyName").css('background','white');
	}
	if($("#qualification").val()==""){
		$("#qualification").css('background','red');
		flg=flg&&false;
	}else{
		$("#qualification").css('background','white');
	}
	if($("#designation").val()==""){
		$("#designation").css('background','red');
		flg=flg&&false;
	}else{
		$("#designation").css('background','white');
	}
	if($("#facultyDOB").val()=="MM/DD/YYYY" || $("#facultyDOB").val()==""){
		$("#facultyDOB").css('background','red');
		flg=flg&&false;
	}else{
		$("#facultyDOB").css('background','white');
	}
	if($("#facultyDateOfJoining").val()=="MM/DD/YYYY" || $("#facultyDOB").val()==""){
		$("#facultyDateOfJoining").css('background','red');
		flg=flg&&false;
	}else{
		$("#facultyDateOfJoining").css('background','white');
	}
	if($("#deptId").val()==""){
		$("#deptId").css('background','red');
		flg=flg&&false;
	}else{
		$("#deptId").css('background','white');
	}
	if(flg){
		$("#registerFaculty").submit();
	}else{
		alert("Please enter the valid data in all fields highlighted with red mark");
	}
}


function searchFacultyDetails() {

	if ($('#searchFacultyId').val() == "") {
		$('#searchFacultyId').css('background', 'red');
	}
	else {
		
		$('#searchFacultyId').css('background', 'white');
		
		var tempUrl = "?facultyId=" + $('#searchFacultyId').val();
		
		$.ajax({
			url : "searchFaculty.htm" + tempUrl,
			type : 'GET',
			dataType : 'json',
			contentType : 'application/json',
			success : function(data) {
				
				$("#showDetails").show();
				
				$.each(data, function(key, value) {
					$("#"+key).val(value);
				});

			},
			error : function() {
				
			}
		});
	}
}


function editFacultyDetails() {
	$("#facultyName").removeAttr('readonly');
	$("#qualification").removeAttr('readonly');
	$("#designation").removeAttr('readonly');
	$("#dateOfBirth").removeAttr('readonly');
}


function updateFacultyDetails() {
	var flg = true;
	
	if ($('#facultyId').val() == "") {
		$('#facultyId').css('background', 'red');
		flg = flg && false;
	} else {
		$('#facultyId').css('background', 'white');
	}
	if ($('#facultyName').val() == "") {
		$('#facultyName').css('background', 'red');
		flg = flg && false;
	} else {
		$('#facultyName').css('background', 'white');
	}
	if ($('#deptId').val() == "") {
		$('#deptId').css('background', 'red');
		flg = flg && false;
	} else {
		$('#deptId').css('background', 'white');
	}
	if ($('#qualification').val() == "") {
		$('#qualification').css('background', 'red');
		flg = flg && false;
	} else {
		$('#qualification').css('background', 'white');
	}
	if ($('#designation').val() == "") {
		$('#designation').css('background', 'red');
		flg = flg && false;
	} else {
		$('#designation').css('background', 'white');
	}
	if ($('#dateOfBirth').val() == "MM/DD/YYYY"
			|| $('#dateOfBirth').val() == "") {
		$('#dateOfBirth').css('background', 'red');
		flg = flg && false;
	} else {
		$('#dateOfBirth').css('background', 'white');
	}
	if ($('#dateOfJoining').val() == "MM/DD/YYYY"
			|| $('#dateOfJoining').val() == "") {
		$('#dateOfJoining').css('background', 'red');
		flg = flg && false;
	} else {
		$('#dateOfJoining').css('background', 'white');
	}
	if ($('#dateOfBirth').val() > $('#dateOfJoining').val()) {
		alert("Date of admission should be greater than Date of birth");
		$('#dateOfJoining').css('background', 'red');
		$('#dateOfBirth').css('background', 'red');
		flg = flg && false;
	}
	if (flg) {
		$('#updateFaculty').submit();
	} else {
		alert("Please enter the valid data in all fields highlighted with red mark");
	}
}
