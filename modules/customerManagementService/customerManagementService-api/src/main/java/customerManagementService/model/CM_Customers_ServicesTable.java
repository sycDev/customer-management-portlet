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

/**
 * The table class for the &quot;CM_Customers_Services&quot; database table.
 *
 * @author Sin Yi
 * @see Customer
 * @see Services
 * @generated
 */
public class CM_Customers_ServicesTable
	extends BaseTable<CM_Customers_ServicesTable> {

	public static final CM_Customers_ServicesTable INSTANCE =
		new CM_Customers_ServicesTable();

	public final Column<CM_Customers_ServicesTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CM_Customers_ServicesTable, Long> customerId =
		createColumn(
			"customerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CM_Customers_ServicesTable, Long> serviceId =
		createColumn(
			"serviceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private CM_Customers_ServicesTable() {
		super("CM_Customers_Services", CM_Customers_ServicesTable::new);
	}

}