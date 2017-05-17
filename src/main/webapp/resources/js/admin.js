$(document)
		.ready(
				function() {
					$.ajax({
						url : '/Nexus/products',
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						success : function(result) {
							console.log(result);
							$.each(result, function(i, data) {
								console.log(data);
								var postContent = "";
								postContent += "ID= " + data.id;
								postContent += "Name= " + data.name;
								postContent += "Description= "
										+ data.description;
								postContent += "avialiability= "
										+ data.avialiability;
								postContent += "releaseDate= "
										+ data.releaseDate;
								postContent += "category= " + data.category
										+ "</br>";

								$("#post").append(postContent);
							});

						},
						error : function(exception) {
							console.log(exception);
						}
					});

					$
							.ajax({
								url : '/Nexus/users',
								type : 'GET',
								headers : {
									Accept : "application/json; charset=utf-8",
									"Content-Type" : "application/json; charset=utf-8"
								},
								success : function(result) {
									console.log(result);
									$
											.each(
													result,
													function(i, data) {
														console.log(data);
														var postContent = "";
														postContent += "name= "
																+ data.name
																+ "</br>";
														postContent += "email= "
																+ data.email
																+ "</br>";
														postContent += "password= "
																+ data.password
																+ " id"
																+ data.id
																+ "</br>";
														postContent += "<button value='"
																+ data.id
																+ "' onClick='userRemove("
																+ data.id
																+ ")' class='btnmarginleft btn btn-info'>Delete user</button></br>";
														
														postContent += "<button onClick='userEdit("+data.id+")' value='"+ data.id+ "' class='btn btn-info'  data-toggle='modal' data-target='#myModal'>Edit user</button></br>";
														
														postContent +="<div class='modal fade' id='myModal' role='dialog'>"
																+ "<div class='modal-dialog'>"
																+ "<div class='modal-content'>"
																+ "<div class='modal-header'>"
																+ "<button type='button' class='close' data-dismiss='modal'>&times;</button>"
																+ "<h4 class='modal-title'>Update User Information</h4>"
																+ "</div>"
																+ "<div class='modal-body'>"
																+ "<div class='main-login main-center'>"
																+ "<form id='updateuserform' method='post'>"
																
																+ "<input type='hidden' name='id' id='updateuserid' value='' />"
																
																+ "<div class='form-group'>"
																+ "<label for='name' class='cols-sm-2 control-label'>Your Name</label>"
																+ "<div class='cols-sm-10'>"
																+ "<div class='input-group'>"
																+ "<span class='input-group-addon'>"
																+ "<i class='fa fa-envelope fa' aria-hidden='true'></i></span>"
																+ "<input type='text' class='form-control' name='name' id='updateusername' placeholder='Enter your name' value='' />"
																+ "</div>"
																+ "</div>"
																
																+ "<div class='form-group'>"
																+ "<label for='email' class='cols-sm-2 control-label'>Your email</label>"
																+ "<div class='cols-sm-10'>"
																+ "<div class='input-group'>"
																+ "<span class='input-group-addon'>"
																+ "<i class='fa fa-envelope fa' aria-hidden='true'></i></span>"
																+ "<input type='text' class='form-control' name='email' id='updateuseremail' placeholder='Enter your email' value='' />"
																+ "</div>"
																+ "</div>"
																
																+ "<div class='form-group'>"
																+ "<label for='password' class='cols-sm-2 control-label'>Your password</label>"
																+ "<div class='cols-sm-10'>"
																+ "<div class='input-group'>"
																+ "<span class='input-group-addon'>"
																+ "<i class='fa fa-envelope fa' aria-hidden='true'></i></span>"
																+ "<input type='text' class='form-control' name='password' id='updateuserpassword' placeholder='Enter your password' value='' />"
																+ "</div>"
																+ "</div>"
																
																+ "<div class='form-group'>"
																+ "<label for='confirmpass' class='cols-sm-2 control-label'>Your Password Again</label>"
																+ "<div class='cols-sm-10'>"
																+ "<div class='input-group'>"
																+ "<span class='input-group-addon'>"
																+ "<i class='fa fa-envelope fa' aria-hidden='true'></i></span>"
																+ "<input type='text' class='form-control' name='confirmpass' id='updateuserconfirmpass' placeholder='confirm password' value='' />"
																+ "</div>"
																+ "</div>"
																
																+ "<div class='form-group '>"
																+ "<button onClick='updateNow()' id='updateuserbutton' class='btn btn-primary btn-lg btn-block login-button'>Update User</button>"
																+ "</div>"
																
																+ "</form>"
																+ "</div>"
																+ "</div>"
																+ "<div class='modal-footer'>"
																+ "<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>"
																+ "</div>"
																+ "</div>"
																+ "</div>"
																+ "</div>"
														$("#userpost").append(
																postContent);
													});

								},
								error : function(exception) {
									console.log(exception);
								}
							});

				});

$("#adduserbutton").click(function() {

	var dataToSend = JSON.stringify(serializeObject($('#adduserform')));
	alert("hello" + dataToSend);
	$.ajax({
		type : 'POST',
		url : '/Nexus/users',
		dataType : "json", // Accept header
		data : dataToSend,
		contentType : 'application/json', // Sends - Content-type
		success : function() {
			console.log("hello");
			location.reload(true);
		},

		error : function(errorObject) {
			console.log("error while adding user");
		}
	});
});

function userRemove(id) {
	var dataToSend = JSON.stringify(id);

	$.ajax({
		type : 'DELETE',
		url : '/Nexus/users/' + id,
		dataType : "json",
		data : dataToSend,
		contentType : 'application/json', // Sends - Content-type
		success : function() {
			alert("hello");
			/* location.reload(true); */
		},

		error : function(errorObject) {
			location.reload(true);
		}
	});
}

function userEdit(id) {
	$.ajax({
		url : '/Nexus/updateuser',
		type : 'GET',
		async : false,
		dataType : "json",
		data : 'id=' + id,
		success : function(response) {

			$("#updateuserid").val(response.id);
			$("#updateusername").val(response.name);
			$("#updateuseremail").val(response.email);
			$("#updateuserpassword").val(response.password);
			$("#updateuserconfirmpass").val(response.password);
		},
		error : function(data) {
			alert("fail");
		}
	});
}


function updateNow() {
	var dataToSend = JSON.stringify(serializeObject($('#updateuserform')));
	alert(dataToSend);
	$.ajax({
		type : 'PUT',
		url : '/Nexus/users',
		dataType : "json", // Accept header
		data : dataToSend,
		contentType : 'application/json', // Sends - Content-type
		success : function() {
			window.location = "/Nexus/admin/listUsers/"
		},

		error : function(errorObject) {
			console.log("error while adding user");
		}
	});
}

$("#updateuserbutton").click(function() {

	var dataToSend = JSON.stringify(serializeObject($('#updateuserform')));

	alert("hello" + dataToSend);
	$.ajax({
		type : 'PUT',
		url : '/Nexus/users',
		dataType : "json", // Accept header
		data : dataToSend,
		contentType : 'application/json', // Sends - Content-type
		success : function() {
			alert("success");
		},

		error : function(errorObject) {
			alert("error");
			console.log("error while adding user");
		}
	});
});

// Then put in JSON format
function serializeObject(form) {

	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

}
