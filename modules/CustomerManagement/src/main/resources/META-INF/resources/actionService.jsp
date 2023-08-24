<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Services service = (Services) row.getObject();
	long groupId = service.getGroupId();
	String name = Services.class.getName();
	long serviceId = service.getServiceId();
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/editService.jsp" />
		<portlet:param name="serviceId" value="<%= String.valueOf(serviceId) %>" />
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
		<portlet:actionURL name="deleteService" var="deleteURL">
			<portlet:param name="serviceId" value="<%= String.valueOf(serviceId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>
	
		<liferay-ui:icon image="delete" url="<%= deleteURL.toString() %>" />
<%
	}
%>
</liferay-ui:icon-menu>