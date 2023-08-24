<%@include file="init.jsp" %>

<style>
.save-btn {
	background-color: #5924eb;
	color: #fff;
}

.save-btn:active {
	background-color: #3c249e;
	color: #fff;
}

.save-btn:hover {
	background-color: #4429b3;
	color: #fff;
}
</style>

<%
	Customer customer = null;
	long customerId = ParamUtil.getLong(request, "customerId");

	if (customerId > 0) {
		customer = CustomerLocalServiceUtil.getCustomer(customerId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= customer %>" model="<%= Customer.class %>" />
<portlet:renderURL var="viewCustomerURL" />

<liferay-ui:header
	backURL="<%= viewCustomerURL %>"
	title='<%= customer.getCustomerName() %>'
/>

<portlet:actionURL name="updateCustomer" var="editCustomerURL" windowState="normal" />
<aui:form action="<%= editCustomerURL %>" method="post" name="customerEditForm" id="customerEditForm">
	<aui:fieldset label="Basic Information">
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

		<aui:input name="customerId" type="hidden" value='<%= customer == null ? "" : customer.getCustomerId() %>' />

		<!-- Name Field (Required) -->
		<aui:input name="customerName" type="text" label="Name" value='<%= customer == null ? "" : customer.getCustomerName() %>' required="true" />

		<!-- Identity Number Field (Required) -->
		<aui:input type="text" name="customerIdentityNo" label="Identity Number" value='<%= customer == null ? "" : customer.getCustomerIdentityNo() %>' required="true"/>
		
		<!-- Email Field (Required) -->
		<aui:input type="email" name="customerEmail" label="Email" value='<%= customer == null ? "" : customer.getCustomerEmail() %>' required="true"/>
		
		<!-- Address Field (Required) -->
		<aui:input type="textarea" name="customerAddress" label="Address" value='<%= customer == null ? "" : customer.getCustomerAddress() %>' required="true" />
		
		<!-- ContactNo Field (Required) -->
		<aui:input type="text" name="customerContactNo" label="Contact Number" value='<%= customer == null ? "" : customer.getCustomerContactNo() %>' required="true" />

	</aui:fieldset>
	
	<!-- Purchased Service List -->
	<aui:fieldset label="Purchased Services">
		    <%
			    List<Services> purchasedServices = ServicesLocalServiceUtil.getCustomerServiceses(customerId);
			    List<Services> serviceList = ServicesLocalServiceUtil.getServiceses(0, ServicesLocalServiceUtil.getServicesesCount());
			    for (int i = 0; i < serviceList.size(); i++) {
			    	Services service = serviceList.get(i);
			        String checkboxName = "service_" + service.getServiceId();
		    %>
				    <div>
				        <aui:input type="checkbox" name="<%= checkboxName %>" value="<%= service.getServiceId() %>" label="<%= service.getServiceName() %>" checked="<%= purchasedServices.contains(service) ? true : false %>" />
				    </div>
			<%
			    }
			%>
		<aui:input type="hidden" name="selectedServicesHidden" id="selectedServicesHidden" />
	</aui:fieldset>	

	<aui:button-row>
		<aui:button type="button" cssClass="save-btn" name="saveEditedCustomer" id="saveEditedCustomer" value="Save" />

		<aui:button onClick="<%= viewCustomerURL %>"  type="cancel" />
	</aui:button-row>
	
	<aui:script>
            AUI().use('aui-base', function(A){
				A.one("#<portlet:namespace/>saveEditedCustomer").on('click',function(){
					var selectedServicesIds = "";
					A.one('form').all('input[type=checkbox]').each(function() {
					    if (this.get('checked')) {
					 		selectedServicesIds =  this.get('value') + ";" + selectedServicesIds;
						}
					 });
					if (selectedServicesIds === "") {
						A.one('#<portlet:namespace />selectedServicesHidden').set("value", "deleteAll");
					} else {
						A.one('#<portlet:namespace />selectedServicesHidden').set("value", selectedServicesIds.trim());
					}
					document.<portlet:namespace />customerEditForm.submit();
				});
			});
        </aui:script>
</aui:form>
