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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Services}.
 * </p>
 *
 * @author Sin Yi
 * @see Services
 * @generated
 */
public class ServicesWrapper
	extends BaseModelWrapper<Services>
	implements ModelWrapper<Services>, Services {

	public ServicesWrapper(Services services) {
		super(services);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceId", getServiceId());
		attributes.put("serviceName", getServiceName());
		attributes.put("serviceType", getServiceType());
		attributes.put("serviceSpecification", getServiceSpecification());
		attributes.put("servicePlan", getServicePlan());
		attributes.put("servicePrice", getServicePrice());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceId = (Long)attributes.get("serviceId");

		if (serviceId != null) {
			setServiceId(serviceId);
		}

		String serviceName = (String)attributes.get("serviceName");

		if (serviceName != null) {
			setServiceName(serviceName);
		}

		String serviceType = (String)attributes.get("serviceType");

		if (serviceType != null) {
			setServiceType(serviceType);
		}

		String serviceSpecification = (String)attributes.get(
			"serviceSpecification");

		if (serviceSpecification != null) {
			setServiceSpecification(serviceSpecification);
		}

		String servicePlan = (String)attributes.get("servicePlan");

		if (servicePlan != null) {
			setServicePlan(servicePlan);
		}

		Double servicePrice = (Double)attributes.get("servicePrice");

		if (servicePrice != null) {
			setServicePrice(servicePrice);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Services cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this services.
	 *
	 * @return the company ID of this services
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this services.
	 *
	 * @return the create date of this services
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this services.
	 *
	 * @return the group ID of this services
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this services.
	 *
	 * @return the modified date of this services
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this services.
	 *
	 * @return the primary key of this services
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the service ID of this services.
	 *
	 * @return the service ID of this services
	 */
	@Override
	public long getServiceId() {
		return model.getServiceId();
	}

	/**
	 * Returns the service name of this services.
	 *
	 * @return the service name of this services
	 */
	@Override
	public String getServiceName() {
		return model.getServiceName();
	}

	/**
	 * Returns the service plan of this services.
	 *
	 * @return the service plan of this services
	 */
	@Override
	public String getServicePlan() {
		return model.getServicePlan();
	}

	/**
	 * Returns the service price of this services.
	 *
	 * @return the service price of this services
	 */
	@Override
	public double getServicePrice() {
		return model.getServicePrice();
	}

	/**
	 * Returns the service specification of this services.
	 *
	 * @return the service specification of this services
	 */
	@Override
	public String getServiceSpecification() {
		return model.getServiceSpecification();
	}

	/**
	 * Returns the service type of this services.
	 *
	 * @return the service type of this services
	 */
	@Override
	public String getServiceType() {
		return model.getServiceType();
	}

	/**
	 * Returns the user ID of this services.
	 *
	 * @return the user ID of this services
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this services.
	 *
	 * @return the user name of this services
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this services.
	 *
	 * @return the user uuid of this services
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this services.
	 *
	 * @param companyId the company ID of this services
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this services.
	 *
	 * @param createDate the create date of this services
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this services.
	 *
	 * @param groupId the group ID of this services
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this services.
	 *
	 * @param modifiedDate the modified date of this services
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this services.
	 *
	 * @param primaryKey the primary key of this services
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the service ID of this services.
	 *
	 * @param serviceId the service ID of this services
	 */
	@Override
	public void setServiceId(long serviceId) {
		model.setServiceId(serviceId);
	}

	/**
	 * Sets the service name of this services.
	 *
	 * @param serviceName the service name of this services
	 */
	@Override
	public void setServiceName(String serviceName) {
		model.setServiceName(serviceName);
	}

	/**
	 * Sets the service plan of this services.
	 *
	 * @param servicePlan the service plan of this services
	 */
	@Override
	public void setServicePlan(String servicePlan) {
		model.setServicePlan(servicePlan);
	}

	/**
	 * Sets the service price of this services.
	 *
	 * @param servicePrice the service price of this services
	 */
	@Override
	public void setServicePrice(double servicePrice) {
		model.setServicePrice(servicePrice);
	}

	/**
	 * Sets the service specification of this services.
	 *
	 * @param serviceSpecification the service specification of this services
	 */
	@Override
	public void setServiceSpecification(String serviceSpecification) {
		model.setServiceSpecification(serviceSpecification);
	}

	/**
	 * Sets the service type of this services.
	 *
	 * @param serviceType the service type of this services
	 */
	@Override
	public void setServiceType(String serviceType) {
		model.setServiceType(serviceType);
	}

	/**
	 * Sets the user ID of this services.
	 *
	 * @param userId the user ID of this services
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this services.
	 *
	 * @param userName the user name of this services
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this services.
	 *
	 * @param userUuid the user uuid of this services
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ServicesWrapper wrap(Services services) {
		return new ServicesWrapper(services);
	}

}