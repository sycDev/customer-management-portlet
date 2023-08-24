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

import customerManagementService.model.Customer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Customer in entity cache.
 *
 * @author Sin Yi
 * @generated
 */
public class CustomerCacheModel
	implements CacheModel<Customer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomerCacheModel)) {
			return false;
		}

		CustomerCacheModel customerCacheModel = (CustomerCacheModel)object;

		if (customerId == customerCacheModel.customerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, customerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{customerId=");
		sb.append(customerId);
		sb.append(", customerName=");
		sb.append(customerName);
		sb.append(", customerIdentityNo=");
		sb.append(customerIdentityNo);
		sb.append(", customerEmail=");
		sb.append(customerEmail);
		sb.append(", customerAddress=");
		sb.append(customerAddress);
		sb.append(", customerContactNo=");
		sb.append(customerContactNo);
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
	public Customer toEntityModel() {
		CustomerImpl customerImpl = new CustomerImpl();

		customerImpl.setCustomerId(customerId);

		if (customerName == null) {
			customerImpl.setCustomerName("");
		}
		else {
			customerImpl.setCustomerName(customerName);
		}

		if (customerIdentityNo == null) {
			customerImpl.setCustomerIdentityNo("");
		}
		else {
			customerImpl.setCustomerIdentityNo(customerIdentityNo);
		}

		if (customerEmail == null) {
			customerImpl.setCustomerEmail("");
		}
		else {
			customerImpl.setCustomerEmail(customerEmail);
		}

		if (customerAddress == null) {
			customerImpl.setCustomerAddress("");
		}
		else {
			customerImpl.setCustomerAddress(customerAddress);
		}

		if (customerContactNo == null) {
			customerImpl.setCustomerContactNo("");
		}
		else {
			customerImpl.setCustomerContactNo(customerContactNo);
		}

		customerImpl.setGroupId(groupId);
		customerImpl.setCompanyId(companyId);
		customerImpl.setUserId(userId);

		if (userName == null) {
			customerImpl.setUserName("");
		}
		else {
			customerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			customerImpl.setCreateDate(null);
		}
		else {
			customerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			customerImpl.setModifiedDate(null);
		}
		else {
			customerImpl.setModifiedDate(new Date(modifiedDate));
		}

		customerImpl.resetOriginalValues();

		return customerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		customerId = objectInput.readLong();
		customerName = objectInput.readUTF();
		customerIdentityNo = objectInput.readUTF();
		customerEmail = objectInput.readUTF();
		customerAddress = objectInput.readUTF();
		customerContactNo = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(customerId);

		if (customerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerName);
		}

		if (customerIdentityNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerIdentityNo);
		}

		if (customerEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerEmail);
		}

		if (customerAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerAddress);
		}

		if (customerContactNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerContactNo);
		}

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

	public long customerId;
	public String customerName;
	public String customerIdentityNo;
	public String customerEmail;
	public String customerAddress;
	public String customerContactNo;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}