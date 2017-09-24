function validateStudentDetails(){
	
	var flg=true;
	
	if($('#studentId').val()==""){
		$('#studentId').css('background','red');
		flg=flg&&false;
	}
	else{
		$('#studentId').css('background','white');
	}
	if($('#firstName').val()==""){
		$('#firstName').css('background','red');
		flg=flg&&false;
	}
	else{
		$('#firstName').css('background','white');
	}
	if($('#lastName').val()==""){
		$('#lastName').css('background','red');
		flg=flg&&false;
	}
	else{
		$('#lastName').css('background','white');
	}
	if($('#semester').val()==""){
		$('#semester').css('background','red');
		flg=flg&&false;
	}
	else{
		$('#semester').css('background','white');
	}
	if($('#deptId').val()==""){
		$('#deptId').css('background','red');
		flg=flg&&false;
	}
	else{
		$('#deptId').css('background','white');
	}
	if($('#fatherName').val()==""){
		$('#fatherName').css('background','red');
		flg=flg&&false;
	}
	else{
		$('#fatherName').css('background','white');
	}
	if($('#motherName').val()==""){
		$('#motherName').css('background','red');
		flg=flg&&false;
	}
	else{
		$('#motherName').css('background','white');
	}
	if($('#dateOfBirth').val()=="MM/DD/YYYY" || $('#dateOfBirth').val()==""){
		$('#dateOfBirth').css('background','red');
		flg=flg&&false;
	}
	else{
		$('#dateOfBirth').css('background','white');
	}
	if($('#dateOfAdmission').val()=="MM/DD/YYYY" || $('#dateOfAdmission').val()==""){
		$('#dateOfAdmission').css('background','red');
		flg=flg&&false;
	}
	else{
		$('#dateOfAdmission').css('background','white');
	}
	if($('#dateOfBirth').val() > $('#dateOfAdmission').val()){
		alert("Date of admission should be greater than Date of birth");
		$('#dateOfAdmission').css('background','red');
		$('#dateOfBirth').css('background','red');
		flg=flg&&false;
	}
	if(flg){
		$('#registerStudent').submit();
	}else{
		alert("Please enter the valid data in all fields highlighted with red mark");
	}
}

function searchStudentDetails() {

	if ($('#searchStudentId').val() == "") {
		$('#searchStudentId').css('background', 'red');
		alert("Please enter student Id");
	}
	else {
		
		$('#searchStudentId').css('background', 'white');
		
		var tempUrl = "?studentId=" + $('#searchStudentId').val();
		
		$.ajax({
			url : "searchStudent.htm" + tempUrl,
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


function editStudentDetails() {
	$("#firstName").removeAttr('readonly');
	$("#lastName").removeAttr('readonly');
	$("#fatherName").removeAttr('readonly');
	$("#motherName").removeAttr('readonly');
	$("#semester").removeAttr('readonly');
	$("#dateOfBirth").removeAttr('readonly');
}


function updateStudentDetails() {
	var flg = true;
	
	if ($('#studentId').val() == "") {
		$('#studentId').css('background', 'red');
		flg = flg && false;
	} else {
		$('#studentId').css('background', 'white');
	}
	if ($('#firstName').val() == "") {
		$('#firstName').css('background', 'red');
		flg = flg && false;
	} else {
		$('#firstName').css('background', 'white');
	}
	if ($('#lastName').val() == "") {
		$('#lastName').css('background', 'red');
		flg = flg && false;
	} else {
		$('#lastName').css('background', 'white');
	}
	if ($('#semester').val() == "") {
		$('#semester').css('background', 'red');
		flg = flg && false;
	} else {
		$('#semester').css('background', 'white');
	}
	if ($('#deptId').val() == "") {
		$('#deptId').css('background', 'red');
		flg = flg && false;
	} else {
		$('#deptId').css('background', 'white');
	}
	if ($('#fatherName').val() == "") {
		$('#fatherName').css('background', 'red');
		flg = flg && false;
	} else {
		$('#fatherName').css('background', 'white');
	}
	if ($('#motherName').val() == "") {
		$('#motherName').css('background', 'red');
		flg = flg && false;
	} else {
		$('#motherName').css('background', 'white');
	}
	if ($('#dateOfBirth').val() == "MM/DD/YYYY"
			|| $('#dateOfBirth').val() == "") {
		$('#dateOfBirth').css('background', 'red');
		flg = flg && false;
	} else {
		$('#dateOfBirth').css('background', 'white');
	}
	if ($('#dateOfAdmission').val() == "MM/DD/YYYY"
			|| $('#dateOfAdmission').val() == "") {
		$('#dateOfAdmission').css('background', 'red');
		flg = flg && false;
	} else {
		$('#dateOfAdmission').css('background', 'white');
	}
	if ($('#dateOfBirth').val() > $('#dateOfAdmission').val()) {
		alert("Date of admission should be greater than Date of birth");
		$('#dateOfAdmission').css('background', 'red');
		$('#dateOfBirth').css('background', 'red');
		flg = flg && false;
	}
	if (flg) {
		$('#updateStudentId').submit();
	} else {
		alert("Please enter the valid data in all fields highlighted with red mark");
	}
}
