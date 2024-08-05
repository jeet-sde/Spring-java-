<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<body>

	<f:form action="stateinsert.html" post="Post" modelAttribute="StateVO">
	
COUNTRY:<f:select path="countryVO.id">
			<c:forEach items="${countrylist}" var="i">
				<f:option value="${i.id}">${i.countryname}</f:option>
			</c:forEach>
		</f:select>
			
	
ADD_STATE:<f:input path="statename" />
		<br />	<br />
		<f:hidden path="id" />
		<input type="submit">
	</f:form>

</body>
</html>
