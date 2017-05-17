$(document).ready(function() {
	$.ajax({
		url : 'http://localhost:8080/Nexus/products',
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
				postContent += "Description= " + data.description;
				postContent += "avialiability= " + data.avialiability;
				postContent += "releaseDate= " + data.releaseDate;
				postContent += "category= " + data.category + "</br>";

				$("#post").append(postContent);
			});

		},
		error : function(exception) {
			console.log(exception);
		}
	});

	$.ajax({
		url : 'http://localhost:8080/Nexus/users',
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
				postContent += "name= " + data.name + "</br>";
				postContent += "email= " + data.email + "</br>";
				postContent += "password= " + data.password + "</br>";
				postContent +="<a href='#' class='btn btn-info'>Edit user</a></br>";
				postContent +="<a href='#' class='btn btn-info'>Delete user</a></br><hr>";
				$("#userpost").append(postContent);
			});

		},
		error : function(exception) {
			console.log(exception);
		}
	});

});