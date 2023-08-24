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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Services service. Represents a row in the &quot;CM_Services&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>customerManagementService.model.impl.ServicesModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>customerManagementService.model.impl.ServicesImpl</code>.
 * </p>
 *
 * @author Sin Yi
 * @see Services
 * @generated
 */
@ProviderType
public interface ServicesModel
	extends BaseModel<Services>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a services model instance should use the {@link Services} interface instead.
	 */

	/**
	 * Returns the primary key of this services.
	 *
	 * @return the primary key of this services
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this services.
	 *
	 * @param primaryKey the primary key of this services
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the service ID of this services.
	 *
	 * @return the service ID of this services
	 */
	public long getServiceId();

	/**
	 * Sets the service ID of this services.
	 *
	 * @param serviceId the service ID of this services
	 */
	public void setServiceId(long serviceId);

	/**
	 * Returns the service name of this services.
	 *
	 * @return the service name of this services
	 */
	@AutoEscape
	public String getServiceName();

	/**
	 * Sets the service name of this services.
	 *
	 * @param serviceName the service name of this services
	 */
	public void setServiceName(String serviceName);

	/**
	 * Returns the service type of this services.
	 *
	 * @return the service type of this services
	 */
	@AutoEscape
	public String getServiceType();

	/**
	 * Sets the service type of this services.
	 *
	 * @param serviceType the service type of this services
	 */
	public void setServiceType(String serviceType);

	/**
	 * Returns the service specification of this services.
	 *
	 * @return the service specification of this services
	 */
	@AutoEscape
	public String getServiceSpecification();

	/**
	 * Sets the service specification of this services.
	 *
	 * @param serviceSpecification the service specification of this services
	 */
	public void setServiceSpecification(String serviceSpecification);

	/**
	 * Returns the service plan of this services.
	 *
	 * @return the service plan of this services
	 */
	@AutoEscape
	public String getServicePlan();

	/**
	 * Sets the service plan of this services.
	 *
	 * @param servicePlan the service plan of this services
	 */
	public void setServicePlan(String servicePlan);

	/**
	 * Returns the service price of this services.
	 *
	 * @return the service price of this services
	 */
	public double getServicePrice();

	/**
	 * Sets the service price of this services.
	 *
	 * @param servicePrice the service price of this services
	 */
	public void setServicePrice(double servicePrice);

	/**
	 * Returns the group ID of this services.
	 *
	 * @return the group ID of this services
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this services.
	 *
	 * @param groupId the group ID of this services
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this services.
	 *
	 * @return the company ID of this services
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this services.
	 *
	 * @param companyId the company ID of this services
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this services.
	 *
	 * @return the user ID of this services
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this services.
	 *
	 * @param userId the user ID of this services
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this services.
	 *
	 * @return the user uuid of this services
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this services.
	 *
	 * @param userUuid the user uuid of this services
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this services.
	 *
	 * @return the user name of this services
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this services.
	 *
	 * @param userName the user name of this services
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this services.
	 *
	 * @return the create date of this services
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this services.
	 *
	 * @param createDate the create date of this services
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this services.
	 *
	 * @return the modified date of this services
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this services.
	 *
	 * @param modifiedDate the modified date of this services
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	@Override
	public Services cloneWithOriginalValues();

}