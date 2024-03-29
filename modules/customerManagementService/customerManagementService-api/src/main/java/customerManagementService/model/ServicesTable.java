/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package customerManagementService.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;CM_Services&quot; database table.
 *
 * @author Sin Yi
 * @see Services
 * @generated
 */
public class ServicesTable extends BaseTable<ServicesTable> {

	public static final ServicesTable INSTANCE = new ServicesTable();

	public final Column<ServicesTable, Long> serviceId = createColumn(
		"serviceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ServicesTable, String> serviceName = createColumn(
		"serviceName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServicesTable, String> serviceType = createColumn(
		"serviceType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServicesTable, String> serviceSpecification =
		createColumn(
			"serviceSpecification", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ServicesTable, String> servicePlan = createColumn(
		"servicePlan", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServicesTable, Double> servicePrice = createColumn(
		"servicePrice", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<ServicesTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServicesTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServicesTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServicesTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServicesTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ServicesTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ServicesTable() {
		super("CM_Services", ServicesTable::new);
	}

}