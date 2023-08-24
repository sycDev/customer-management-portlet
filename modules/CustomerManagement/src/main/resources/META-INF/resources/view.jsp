<%@ include file="init.jsp" %>

<%@ include file="/viewServices.jsp" %>

<br/>

<%
	// If user is logged in, show the customers table
	if (request.getRemoteUser() != null) {	
%>
		<%@ include file="/viewCustomers.jsp" %>
<%
	}
%>