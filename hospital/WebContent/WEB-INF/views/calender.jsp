<%@ page language="java"
	import="com.models.DoctorSlots,java.util.ArrayList"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

.header {
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 10px;
}

.product-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	max-width: 900px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.product {
	width: 30%;
	margin-bottom: 20px;
	padding: 10px;
	border: 1px solid #ccc;
	text-align: center;
	background-color: #fff;
	transition: transform 0.2s, box-shadow 0.2s;
}

.product:hover {
	transform: translateY(-5px);
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.product img {
	max-width: 100%;
	height: auto;
}

.product h3 {
	margin-top: 10px;
	font-size: 18px;
	color: #333;
}

.product p {
	color: #777;
}
</style>
<meta charset="ISO-8859-1">
<title>Aadhya Hospital</title>
</head>
<body>

	<div class="header">
		<h1>Aadhya Hospital</h1>
	</div>
	<center>
		<%
			ArrayList<DoctorSlots> sa = (ArrayList<DoctorSlots>) request.getAttribute("doctorslots");
		%><table border="1">
			<tr>
				<th>slot id</th>
				<th>doc id</th>
				<th>date</th>
				<th>ftime</th>
				<th>ttime</th>
			<tbody>
				<%
					for (int i = 0; i < sa.size(); i++) {
					DoctorSlots s1 = sa.get(i);
				%><tr>
					<td><%=s1.getS_id()%></td>
					<td><%=s1.getS_docid()%></td>
					<td><%=s1.getS_date()%></td>
					<td><%=s1.getS_ftime()%></td>
					<td><%=s1.getS_ttime()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
			</tr>
		</table>
	</center>

</body>
</html>
