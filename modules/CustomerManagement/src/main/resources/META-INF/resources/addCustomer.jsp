<%@ include file="init.jsp" %>

<portlet:renderURL var="viewCustomerURL" />

<liferay-ui:header
	backURL="<%= viewCustomerURL %>"
	title='Add New Customer'
/>

<portlet:actionURL name="addCustomer" var="addCustomerURL">
	<portlet:param name="redirectURL" value="<%= viewCustomerURL %>" />
</portlet:actionURL>

<aui:form action="<%= addCustomerURL %>" method="post">
	<!-- Name Field (Required) -->
	<aui:input type="text" name="customerName" label="Name" required="true" />
	
	<!-- Identity Number Field (Required) -->
	<aui:input type="text" name="customerIdentityNo" label="Identity Number" required="true"/>
	
	<!-- Email Field (Required) -->
	<aui:input type="email" name="customerEmail" label="Email" required="true"/>
	
	<!-- Address Field (Required) -->
	<aui:input type="textarea" name="customerAddress" label="Address" required="true" />
	
	<!-- Contact Number Field (Required) -->
	<aui:input type="text" name="customerContactNo" label="Contact Number" required="true" />

	<aui:button type="submit" value="Add" />
</aui:form>