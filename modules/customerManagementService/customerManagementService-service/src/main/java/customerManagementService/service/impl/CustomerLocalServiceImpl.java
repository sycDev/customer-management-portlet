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

package customerManagementService.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import customerManagementService.model.Customer;
import customerManagementService.service.base.CustomerLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sin Yi
 */
@Component(property = "model.class.name=customerManagementService.model.Customer", service = AopService.class)
public class CustomerLocalServiceImpl extends CustomerLocalServiceBaseImpl {
	public Customer addCustomer(String customerName, String customerIdentityNo, String customerEmail,
			String customerAddress, String customerContactNo, long userId, long groupId, String userName)
			throws PortalException, SystemException {
		
		long customerId = counterLocalService.increment(Customer.class.getName());
		Customer customer = customerPersistence.create(customerId);
		customer.setCustomerName(customerName);
		customer.setCustomerIdentityNo(customerIdentityNo);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerAddress(customerAddress);
		customer.setCustomerContactNo(customerContactNo);
		customer.setUserId(userId);
		customer.setGroupId(groupId);
		customer.setUserName(userName);

		super.addCustomer(customer);
		return customer;
	}

	public Customer updateCustomer(long customerId, String customerName, String customerIdentityNo,
			String customerEmail, String customerAddress, String customerContactNo)
			throws PortalException, SystemException {
		
		Customer customer = customerPersistence.findByPrimaryKey(customerId);
		customer.setCustomerName(customerName);
		customer.setCustomerIdentityNo(customerIdentityNo);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerAddress(customerAddress);
		customer.setCustomerContactNo(customerContactNo);

		super.updateCustomer(customer);
		return customer;
	}

	public Customer deleteCustomer(long customerId) throws PortalException, SystemException {
		Customer customer = customerPersistence.fetchByPrimaryKey(customerId);

		return deleteCustomer(customer);
	}
}