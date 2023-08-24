create table CM_Customer (
	customerId LONG not null primary key,
	customerName VARCHAR(75) null,
	customerIdentityNo VARCHAR(75) null,
	customerEmail VARCHAR(75) null,
	customerAddress STRING null,
	customerContactNo VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table CM_Customers_Services (
	companyId LONG not null,
	customerId LONG not null,
	serviceId LONG not null,
	primary key (customerId, serviceId)
);

create table CM_Services (
	serviceId LONG not null primary key,
	serviceName VARCHAR(75) null,
	serviceType VARCHAR(75) null,
	serviceSpecification STRING null,
	servicePlan VARCHAR(75) null,
	servicePrice DOUBLE,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);