<%@ include file="init.jsp" %>

<%
	// If user is logged in, show the Add New Service button
	if (request.getRemoteUser() != null) {	
%>
		<!-- Add New Service Button -->
		<portlet:renderURL var="addServiceForm">
			<portlet:param name="jspPage" value="/addService.jsp"/>
		</portlet:renderURL>
		
		<a class="btn btn-primary mb-2" href="${addServiceForm}" role="button">Add New Service</a>
<%
	}
%>

<!-- List of Services -->
<liferay-ui:search-container 
	total="<%= ServicesLocalServiceUtil.getServicesesCount() %>" 
	emptyResultsMessage="No Service Records Available"
	>

	<liferay-ui:search-container-results
		results="<%= ServicesLocalServiceUtil.getServiceses(searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="customerManagementService.model.Services"
		modelVar="service"
	>
		<%
			// If user is logged in, show the services table
			if (request.getRemoteUser() != null) {	
		%>
				<liferay-ui:search-container-column-text property="serviceId" name="ID" />
		<%
			}
		%>
				<liferay-ui:search-container-column-text property="serviceName" name="Name" />
				<liferay-ui:search-container-column-text property="serviceType" name="Type" />
				<liferay-ui:search-container-column-text property="serviceSpecification" name="Specification" />
				<liferay-ui:search-container-column-text property="servicePlan" name="Plan" />
				<liferay-ui:search-container-column-text property="servicePrice" name="Price (RM)" />
		<%
			// If user is logged in, show the services table
			if (request.getRemoteUser() != null) {	
		%>
				<liferay-ui:search-container-column-jsp
					align="center"
					path="/actionService.jsp"
				/>
		<%
			}
		%>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>