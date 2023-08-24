<%@ include file="init.jsp" %>

<!-- Add New Customer Link -->
<portlet:renderURL var="addCustomerForm">
	<portlet:param name="jspPage" value="/addCustomer.jsp"/>
</portlet:renderURL>

<a class="btn btn-primary mb-2" href="${addCustomerForm}" role="button">Add New Customer</a>
<br/>

<!-- List of Customers -->
<liferay-ui:search-container 
	total="<%= CustomerLocalServiceUtil.getCustomersCount() %>"
	emptyResultsMessage="No Customer Records Available"
	>

	<liferay-ui:search-container-results
		results="<%= CustomerLocalServiceUtil.getCustomers(searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="customerManagementService.model.Customer"
		modelVar="customer"
	>

		<liferay-ui:search-container-column-text property="customerId" name="ID" />
		<liferay-ui:search-container-column-text property="customerName" name="Name" />
		<liferay-ui:search-container-column-text property="customerIdentityNo" name="Identity Number" />
		<liferay-ui:search-container-column-text property="customerEmail" name="Email" />
		<liferay-ui:search-container-column-text property="customerAddress" name="Address" />
		<liferay-ui:search-container-column-text property="customerContactNo" name="Contact Number" />
		<liferay-ui:search-container-column-jsp path="/showServicesPurchased.jsp" name="Services Purchased"/>
		
		<liferay-ui:search-container-column-text property="userName" name="Added By" />
		
		<%
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		%>

		<liferay-ui:search-container-column-text
			name="Joined At"
			value="<%= sdf.format(customer.getCreateDate()) %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Last Update"
			value="<%= sdf.format(customer.getModifiedDate()) %>"
		/>

<%
		// If user is logged in
		if (request.getRemoteUser() != null) {	
%>
			<liferay-ui:search-container-column-jsp
				align="center"
				path="/actionCustomer.jsp"
			/>
		<%
		}
		%>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>