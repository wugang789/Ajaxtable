<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="jquery/jquery-1.4.2.min.js">
	
</script>
<script type="text/javascript">
	function show() {
		$(document).ready(function() {
			document.getElementById("city").length = 0;
			var obj = document.getElementById("ss");
			var index = obj.selectedIndex;
			var value = obj.options[index].value;
			$.ajax({
				url : "findcity?provinceName=" + value,
				type : "post",
				dataType : "json",
				cache : false,
				async : false,
				data : {

				},
				success : function(data) {
					var se = document.getElementById("city").options;
					for ( var i = 0; i < data.length; i++) {
						var op = new Option(data[i], data[i]);
						se.add(op);
					}
				},
				error : function() {

				}
			});

		});
	}
</script>
<script type="text/javascript">
	window.onload = function show2() {
		$(document).ready(function() {
			$.ajax({
				url : "findProvinces",
				type : "post",
				dataType : "json",
				cache : false,
				async : false,
				data : {},
				success : function(data) {
					var se = document.getElementById("ss").options;
					for ( var i = 0; i < data.length; i++) {
						var op = new Option(data[i], data[i]);
						se.add(op);
					}
				},
				error : function() {

				}
			});

		});
	};
</script>
<body>
	<div>
		<select name="province" onchange="show()" id="ss">
			<option>请选择省份</option>
		</select>
		 <select id="city">
		</select>
	</div>
</body>
</html>