<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Customer customer = (Customer) row.getObject();
	long groupId = customer.getGroupId();
	String name = Customer.class.getName();
	long customerId = customer.getCustomerId();
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/editCustomer.jsp" />
		<portlet:param name="customerId" value="<%= String.valueOf(customerId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />
<%
	// Get the current logged in userId
	Long userId = Long.parseLong(request.getRemoteUser());
	
	// Get the User object by ID
    User u = UserLocalServiceUtil.getUserById(userId);

    // Get the admin role
    Role adminRole = RoleLocalServiceUtil.getRole(u.getCompanyId(), "Administrator");

    // Check if the user has the admin role
    boolean isAdmin = u.getRoles().contains(adminRole);

    if (isAdmin) {
%>
	<portlet:actionURL name="deleteCustomer" var="deleteURL">
		<portlet:param name="customerId" value="<%= String.valueOf(customerId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>

	<liferay-ui:icon image="delete" url="<%= deleteURL.toString() %>" />
<%
   }
%>
</liferay-ui:icon-menu>