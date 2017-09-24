function saveOrUpdateResult(row) {

	if (document.getElementById("chkBox" + row).checked) {
		var flg = true;
		if ($("#semester").val() == "") {
			$("#semester").css("background", 'red');
			flg = flg && false;
		} else {
			$("#semester").css("background", 'white');
		}
		if ($("#exam").val() == "") {
			$("#exam").css("background", 'red');
			flg = flg && false;
		} else {
			$("#exam").css("background", 'white');
		}
		if ($("#examDate").val() == "" || $("#examDate").val() == "MM/DD/YYYY") {
			$("#examDate").css("background", 'red');
			flg = flg && false;
		} else {
			$("#examDate").css("background", 'white');
		}
		if ($("#subjectCode").val() == "") {
			$("#subjectCode").css("background", 'red');
			flg = flg && false;
		} else {
			$("#subjectCode").css("background", 'white');
		}
		if ($("#studentId" + row).val() == "") {
			$("#studentId" + row).css("background", 'red');
			flg = flg && false;
		} else {
			$("#studentId" + row).css("background", 'white');
		}
		if ($("#marks" + row).val() == "" || $("#marks" + row).val() > 25) {
			$("#marks" + row).css("background", 'red');
			flg = flg && false;
		} else {
			$("#marks" + row).css("background", 'white');
		}
		if ($("#deptId").val() == "") {
			$("#deptId").css("background", 'red');
			flg = flg && false;
		} else {
			$("#deptId").css("background", 'white');
		}
		if (flg) {

			var tmpUrl = "?semester=" + $("#semester").val();
			tmpUrl = tmpUrl + "&exam=" + $("#exam").val() + "&examDate="
					+ $("#examDate").val() + "&subjectCode="
					+ $("#subjectCode").val() + "&studentId="
					+ $("#studentId" + row).val() + "&marks="
					+ $("#marks" + row).val() + "&saveOrUpdate="
					+ $("#saveOrUpdate").val() + "&resultId="
					+ $("#resultId").val()+"&deptId="+$("#deptId").val();

			$.ajax({
				url : "saveOrUpdateResult.htm" + tmpUrl,
				type : 'GET',
				dataType : 'text',
				contentType : 'application/text',
				success : function(data) {
					$("#row" + row).html("<label>" + data + "</label>");
				},
				error : function() {

				}

			});

		} else {
			alert("Please choose valid data for the fields highlighted with red mark");
			resetDetails();
			return;
		}

	}
}

function resetDetails(){
	for(var i=1;i<=5;i++){
		document.getElementById("chkBox" + i).checked=false;
		$("#row"+i).html("");
	}
}

function searchResult() {

	var flg = true;
	if ($("#semester").val() == "") {
		$("#semester").css("background", 'red');
		flg = flg && false;
	} else {
		$("#semester").css("background", 'white');
	}
	if ($("#exam").val() == "") {
		$("#exam").css("background", 'red');
		flg = flg && false;
	} else {
		$("#exam").css("background", 'white');
	}
	if ($("#examDate").val() == "" || $("#examDate").val() == "MM/DD/YYYY") {
		$("#examDate").css("background", 'red');
		flg = flg && false;
	} else {
		$("#examDate").css("background", 'white');
	}
	if ($("#subjectCode").val() == "") {
		$("#subjectCode").css("background", 'red');
		flg = flg && false;
	} else {
		$("#subjectCode").css("background", 'white');
	}
	if ($("#studentId").val() == "") {
		$("#studentId").css("background", 'red');
		flg = flg && false;
	} else {
		$("#studentId").css("background", 'white');
	}
	if (flg) {
		var tmpUrl = "?semester=" + $("#semester").val();
		tmpUrl = tmpUrl + "&exam=" + $("#exam").val() + "&subjectCode="
				+ $("#subjectCode").val() + "&studentId="
				+ $("#studentId").val();
		$.ajax({
			url : "searchResult.htm" + tmpUrl,
			type : 'GET',
			dataType : 'text',
			contentType : 'application/text',
			success : function(data) {
				if (data == "NOT") {
					$("#noRecordsSpan").css("display", "block");
					$("#marksTable").css("display", "none");
				} else {
					var resp = data.split("|");
					$("#marks").val(resp[1]);
					$("#resultId").val(resp[0]);
					$("#marksTable").css("display", "block");
					$("#noRecordsSpan").css("display", "none");
				}
			},
			error : function() {

			}

		});
	} else {
		alert("Please choose valid data for the fields highlighted with red mark");
		return;
	}

}

function enableUpdateButton() {
	$("#updateResultButton").removeAttr("disabled");
}

function UpdateResult() {

	var flg = true;
	if ($("#semester").val() == "") {
		$("#semester").css("background", 'red');
		flg = flg && false;
	} else {
		$("#semester").css("background", 'white');
	}
	if ($("#exam").val() == "") {
		$("#exam").css("background", 'red');
		flg = flg && false;
	} else {
		$("#exam").css("background", 'white');
	}
	if ($("#examDate").val() == "" || $("#examDate").val() == "MM/DD/YYYY") {
		$("#examDate").css("background", 'red');
		flg = flg && false;
	} else {
		$("#examDate").css("background", 'white');
	}
	if ($("#subjectCode").val() == "") {
		$("#subjectCode").css("background", 'red');
		flg = flg && false;
	} else {
		$("#subjectCode").css("background", 'white');
	}
	if ($("#studentId").val() == "") {
		$("#studentId").css("background", 'red');
		flg = flg && false;
	} else {
		$("#studentId").css("background", 'white');
	}
	if ($("#marks").val() == "" || $("#marks").val() > 25) {
		$("#marks").css("background", 'red');
		flg = flg && false;
	} else {
		$("#marks").css("background", 'white');
	}
	if ($("#deptId").val() == "") {
		$("#deptId").css("background", 'red');
		flg = flg && false;
	} else {
		$("#deptId").css("background", 'white');
	}
	if (flg) {

		var tmpUrl = "?semester=" + $("#semester").val();
		tmpUrl = tmpUrl + "&exam=" + $("#exam").val() + "&examDate="
				+ $("#examDate").val() + "&subjectCode="
				+ $("#subjectCode").val() + "&studentId="
				+ $("#studentId").val() + "&marks="
				+ $("#marks").val() + "&saveOrUpdate="
				+ $("#saveOrUpdate").val() + "&resultId="
				+ $("#resultId").val()+"&deptId="+$("#deptId").val();

		$.ajax({
			url : "saveOrUpdateResult.htm" + tmpUrl,
			type : 'GET',
			dataType : 'text',
			contentType : 'application/text',
			success : function(data) {
				$("#row").html("<label>" + data + "</label>");
			},
			error : function() {

			}

		});

	} else {
		alert("Please choose valid data for the fields highlighted with red mark");
		return;
	}

}