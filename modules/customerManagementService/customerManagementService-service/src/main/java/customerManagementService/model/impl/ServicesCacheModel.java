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

package customerManagementService.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import customerManagementService.model.Services;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Services in entity cache.
 *
 * @author Sin Yi
 * @generated
 */
public class ServicesCacheModel
	implements CacheModel<Services>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServicesCacheModel)) {
			return false;
		}

		ServicesCacheModel servicesCacheModel = (ServicesCacheModel)object;

		if (serviceId == servicesCacheModel.serviceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, serviceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{serviceId=");
		sb.append(serviceId);
		sb.append(", serviceName=");
		sb.append(serviceName);
		sb.append(", serviceType=");
		sb.append(serviceType);
		sb.append(", serviceSpecification=");
		sb.append(serviceSpecification);
		sb.append(", servicePlan=");
		sb.append(servicePlan);
		sb.append(", servicePrice=");
		sb.append(servicePrice);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Services toEntityModel() {
		ServicesImpl servicesImpl = new ServicesImpl();

		servicesImpl.setServiceId(serviceId);

		if (serviceName == null) {
			servicesImpl.setServiceName("");
		}
		else {
			servicesImpl.setServiceName(serviceName);
		}

		if (serviceType == null) {
			servicesImpl.setServiceType("");
		}
		else {
			servicesImpl.setServiceType(serviceType);
		}

		if (serviceSpecification == null) {
			servicesImpl.setServiceSpecification("");
		}
		else {
			servicesImpl.setServiceSpecification(serviceSpecification);
		}

		if (servicePlan == null) {
			servicesImpl.setServicePlan("");
		}
		else {
			servicesImpl.setServicePlan(servicePlan);
		}

		servicesImpl.setServicePrice(servicePrice);
		servicesImpl.setGroupId(groupId);
		servicesImpl.setCompanyId(companyId);
		servicesImpl.setUserId(userId);

		if (userName == null) {
			servicesImpl.setUserName("");
		}
		else {
			servicesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			servicesImpl.setCreateDate(null);
		}
		else {
			servicesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			servicesImpl.setModifiedDate(null);
		}
		else {
			servicesImpl.setModifiedDate(new Date(modifiedDate));
		}

		servicesImpl.resetOriginalValues();

		return servicesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serviceId = objectInput.readLong();
		serviceName = objectInput.readUTF();
		serviceType = objectInput.readUTF();
		serviceSpecification = objectInput.readUTF();
		servicePlan = objectInput.readUTF();

		servicePrice = objectInput.readDouble();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(serviceId);

		if (serviceName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceName);
		}

		if (serviceType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceType);
		}

		if (serviceSpecification == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceSpecification);
		}

		if (servicePlan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(servicePlan);
		}

		objectOutput.writeDouble(servicePrice);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long serviceId;
	public String serviceName;
	public String serviceType;
	public String serviceSpecification;
	public String servicePlan;
	public double servicePrice;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}