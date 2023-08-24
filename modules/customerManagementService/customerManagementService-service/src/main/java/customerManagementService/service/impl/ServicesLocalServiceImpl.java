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

import customerManagementService.model.Services;
import customerManagementService.service.base.ServicesLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sin Yi
 */
@Component(property = "model.class.name=customerManagementService.model.Services", service = AopService.class)
public class ServicesLocalServiceImpl extends ServicesLocalServiceBaseImpl {
	public Services addService(String serviceName, String serviceType, String serviceSpecification, String servicePlan,
			double servicePrice, long userId, long groupId, String userName) throws PortalException, SystemException {

		long serviceId = counterLocalService.increment(Services.class.getName());
		Services service = servicesPersistence.create(serviceId);
		service.setServiceName(serviceName);
		service.setServiceType(serviceType);
		service.setServiceSpecification(serviceSpecification);
		service.setServicePlan(servicePlan);
		service.setServicePrice(servicePrice);
		service.setUserId(userId);
		service.setGroupId(groupId);
		service.setUserName(userName);

		super.addServices(service);
		return service;
	}

	public Services updateService(long serviceId, String serviceName, String serviceType, String serviceSpecification,
			String servicePlan, double servicePrice) throws PortalException, SystemException {

		Services service = servicesPersistence.findByPrimaryKey(serviceId);
		service.setServiceName(serviceName);
		service.setServiceType(serviceType);
		service.setServiceSpecification(serviceSpecification);
		service.setServicePlan(servicePlan);
		service.setServicePrice(servicePrice);

		super.updateServices(service);
		return service;
	}

	public Services deleteService(long serviceId) throws PortalException, SystemException {
		Services service = servicesPersistence.fetchByPrimaryKey(serviceId);

		return deleteServices(service);
	}
}