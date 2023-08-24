create index IX_BC780AB6 on CM_Customer (customerName[$COLUMN_LENGTH:75$]);
create index IX_28C0DD91 on CM_Customer (groupId);

create index IX_E68A7C85 on CM_Customers_Services (companyId);
create index IX_91E72ABD on CM_Customers_Services (serviceId);

create index IX_46A5FD11 on CM_Services (groupId);
create index IX_D849BCE6 on CM_Services (serviceType[$COLUMN_LENGTH:75$]);