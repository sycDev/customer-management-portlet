<%@ include file="init.jsp" %>

<%
	ResultRow currentRow = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Customer customer = (Customer) currentRow.getObject();
	List<Services> purchasedServiceList = ServicesLocalServiceUtil.getCustomerServiceses(customer.getCustomerId());
	if (purchasedServiceList.isEmpty()) {
		out.println("No Services");
	} else {
		for(int i = 0; i < purchasedServiceList.size(); i++){
			Object curService = purchasedServiceList.get(i);
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(curService.toString());
			out.println(i+1 + ". " + jsonObj.getString("serviceName"));
			out.println("<br/>");
		}
	}
%>
