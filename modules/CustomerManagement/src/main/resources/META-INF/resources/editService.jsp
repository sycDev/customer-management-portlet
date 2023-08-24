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
	Services service = null;
	long serviceId = ParamUtil.getLong(request, "serviceId");

	if (serviceId > 0) {
		service = ServicesLocalServiceUtil.getServices(serviceId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= service %>" model="<%= Services.class %>" />
<portlet:renderURL var="viewServicesURL" />
<liferay-ui:header
	backURL="<%= viewServicesURL %>"
	title='<%= service.getServiceName() %>'
/>

<portlet:actionURL name="updateService" var="editServiceURL" windowState="normal" />
<aui:form action="<%= editServiceURL %>" method="post" name="serviceEditForm" id="serviceEditForm">
	<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

	<aui:input type="hidden" name="serviceId" value='<%= service == null ? "" : service.getServiceId() %>' />

	<!-- Name Field (Required) -->
	<aui:input type="text" name="serviceName" label="Name" value='<%= service == null ? "" : service.getServiceName() %>' required="true" />

	<!-- Type Field (Required) -->
	<aui:select name="serviceType" label="Service Type" required="true">
		<aui:option value="Domain Name" label="Domain Name" selected="<%= service.getServiceType().contains("Domain Name") ? true : false %>"></aui:option>
		<aui:option value="Shared Hosting" label="Shared Hosting" selected="<%= service.getServiceType().contains("Shared Hosting") ? true : false %>"></aui:option>
		<aui:option value="Reseller Hosting" label="Reseller Hosting" selected="<%= service.getServiceType().contains("Reseller Hosting") ? true : false %>"></aui:option>
		<aui:option value="Cloud Hosting" label="Cloud Hosting" selected="<%= service.getServiceType().contains("Cloud Hosting") ? true : false %>"></aui:option>
		<aui:option value="VPS Hosting" label="VPS Hosting" selected="<%= service.getServiceType().contains("VPS Hosting") ? true : false %>"></aui:option>
		<aui:option value="Dedicated Hosting" label="Dedicated Hosting" selected="<%= service.getServiceType().contains("Dedicated Hosting") ? true : false %>"></aui:option>
		<aui:option value="Colocation" label="Colocation" selected="<%= service.getServiceType().contains("Colocation") ? true : false %>"></aui:option>
	</aui:select>
	
	<!-- Specification Field (Required, Max 500 characters) -->
	<aui:input type="textarea" name="serviceSpecification" label="Specification" value='<%= service == null ? "" : service.getServiceSpecification() %>' required="true" />
	<p><span id="counter"></span> character(s) remaining</p>
	
	<!-- Plan Field (Required) -->
	<aui:select name="servicePlan" label="Service Plan" required="true" >
		<aui:option value="3 Months" label="3 Months" selected="<%= service.getServicePlan().contains("3 Months") ? true : false %>"></aui:option>
		<aui:option value="6 Months" label="6 Months" selected="<%= service.getServicePlan().contains("6 Months") ? true : false %>"></aui:option>
		<aui:option value="1 Year" label="1 Year" selected="<%= service.getServicePlan().contains("1 Year") ? true : false %>"></aui:option>
		<aui:option value="2 Years" label="2 Years" selected="<%= service.getServicePlan().contains("2 Years") ? true : false %>"></aui:option>
		<aui:option value="3 Years" label="3 Years" selected="<%= service.getServicePlan().contains("3 Years") ? true : false %>"></aui:option>
	</aui:select>
	
	<!-- Price Field (Required) -->
	<aui:input type="number" step="0.01" decimalPrecision="2" name="servicePrice" label="Price (per month)" value='<%= service == null ? "" : service.getServicePrice() %>' required="true" />

	<aui:button-row>
		<aui:button type="button" cssClass="save-btn" name="saveEditedService" id="saveEditedService" value="Save" />
		
		<aui:button onClick="<%= viewServicesURL %>"  type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-char-counter">
AUI().use(
  function(A) {
    new A.CharCounter(
      {
        counter: '#counter',
        input: '#<portlet:namespace />serviceSpecification',
        maxLength: 500
      }
    );
  }
);

AUI().use('aui-base', function(A){
	A.one("#<portlet:namespace/>saveEditedService").on('click',function(){
		document.<portlet:namespace />serviceEditForm.submit();
	});
});
</aui:script> 