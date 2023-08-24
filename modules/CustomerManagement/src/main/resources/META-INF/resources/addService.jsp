<%@ include file="init.jsp" %>

<portlet:renderURL var="viewServiceURL" />

<liferay-ui:header
	backURL="<%= viewServiceURL %>"
	title='Add New Service'
/>

<portlet:actionURL name="addService" var="addServiceURL">
	<portlet:param name="redirectURL" value="<%= viewServiceURL %>" />
</portlet:actionURL>

<aui:form action="<%= addServiceURL %>" method="post">
	<!-- Name Field (Required) -->
	<aui:input type="text" name="serviceName" label="Name" required="true" />

	<!-- Type Field (Required) -->
	<aui:select name="serviceType" label="Service Type" required="true">
		<aui:option value="Domain Name" label="Domain Name"></aui:option>
		<aui:option value="Shared Hosting" label="Shared Hosting"></aui:option>
		<aui:option value="Reseller Hosting" label="Reseller Hosting"></aui:option>
		<aui:option value="Cloud Hosting" label="Cloud Hosting"></aui:option>
		<aui:option value="VPS Hosting" label="VPS Hosting"></aui:option>
		<aui:option value="Dedicated Hosting" label="Dedicated Hosting"></aui:option>
		<aui:option value="Colocation" label="Colocation"></aui:option>
	</aui:select>
	
	<!-- Specification Field (Required, Max 500 characters) -->
	<aui:input type="textarea" name="serviceSpecification" label="Specification" required="true" />
	<!-- Characters Counter -->
	<p><span id="counter"></span> character(s) remaining</p>
	
	<!-- Plan Field (Required) -->
	<aui:select name="servicePlan" label="Service Plan" required="true">
		<aui:option value="3 Months" label="3 Months"></aui:option>
		<aui:option value="6 Months" label="6 Months"></aui:option>
		<aui:option value="1 Year" label="1 Year"></aui:option>
		<aui:option value="2 Years" label="2 Years"></aui:option>
		<aui:option value="3 Years" label="3 Years"></aui:option>
	</aui:select>

	<!-- Price Field (Required) -->
	<aui:input type="number" step="0.01" decimalPrecision="2" name="servicePrice" label="Price (per month)" required="true" />

	<aui:button-row>
		<aui:button type="submit" value="Add" />
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
</aui:script> 