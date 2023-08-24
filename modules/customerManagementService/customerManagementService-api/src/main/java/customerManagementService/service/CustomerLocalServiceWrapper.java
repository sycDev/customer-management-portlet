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

package customerManagementService.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomerLocalService}.
 *
 * @author Sin Yi
 * @see CustomerLocalService
 * @generated
 */
public class CustomerLocalServiceWrapper
	implements CustomerLocalService, ServiceWrapper<CustomerLocalService> {

	public CustomerLocalServiceWrapper() {
		this(null);
	}

	public CustomerLocalServiceWrapper(
		CustomerLocalService customerLocalService) {

		_customerLocalService = customerLocalService;
	}

	/**
	 * Adds the customer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer the customer
	 * @return the customer that was added
	 */
	@Override
	public customerManagementService.model.Customer addCustomer(
		customerManagementService.model.Customer customer) {

		return _customerLocalService.addCustomer(customer);
	}

	@Override
	public customerManagementService.model.Customer addCustomer(
			String customerName, String customerIdentityNo,
			String customerEmail, String customerAddress,
			String customerContactNo, long userId, long groupId,
			String userName)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _customerLocalService.addCustomer(
			customerName, customerIdentityNo, customerEmail, customerAddress,
			customerContactNo, userId, groupId, userName);
	}

	@Override
	public void addServicesCustomer(
		long serviceId, customerManagementService.model.Customer customer) {

		_customerLocalService.addServicesCustomer(serviceId, customer);
	}

	@Override
	public void addServicesCustomer(long serviceId, long customerId) {
		_customerLocalService.addServicesCustomer(serviceId, customerId);
	}

	@Override
	public void addServicesCustomers(
		long serviceId,
		java.util.List<customerManagementService.model.Customer> customers) {

		_customerLocalService.addServicesCustomers(serviceId, customers);
	}

	@Override
	public void addServicesCustomers(long serviceId, long[] customerIds) {
		_customerLocalService.addServicesCustomers(serviceId, customerIds);
	}

	@Override
	public void clearServicesCustomers(long serviceId) {
		_customerLocalService.clearServicesCustomers(serviceId);
	}

	/**
	 * Creates a new customer with the primary key. Does not add the customer to the database.
	 *
	 * @param customerId the primary key for the new customer
	 * @return the new customer
	 */
	@Override
	public customerManagementService.model.Customer createCustomer(
		long customerId) {

		return _customerLocalService.createCustomer(customerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the customer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer the customer
	 * @return the customer that was removed
	 */
	@Override
	public customerManagementService.model.Customer deleteCustomer(
		customerManagementService.model.Customer customer) {

		return _customerLocalService.deleteCustomer(customer);
	}

	/**
	 * Deletes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer that was removed
	 * @throws PortalException if a customer with the primary key could not be found
	 * @throws SystemException
	 */
	@Override
	public customerManagementService.model.Customer deleteCustomer(
			long customerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _customerLocalService.deleteCustomer(customerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteServicesCustomer(
		long serviceId, customerManagementService.model.Customer customer) {

		_customerLocalService.deleteServicesCustomer(serviceId, customer);
	}

	@Override
	public void deleteServicesCustomer(long serviceId, long customerId) {
		_customerLocalService.deleteServicesCustomer(serviceId, customerId);
	}

	@Override
	public void deleteServicesCustomers(
		long serviceId,
		java.util.List<customerManagementService.model.Customer> customers) {

		_customerLocalService.deleteServicesCustomers(serviceId, customers);
	}

	@Override
	public void deleteServicesCustomers(long serviceId, long[] customerIds) {
		_customerLocalService.deleteServicesCustomers(serviceId, customerIds);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _customerLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _customerLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customerLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _customerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customerManagementService.model.impl.CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _customerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customerManagementService.model.impl.CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _customerLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _customerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _customerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public customerManagementService.model.Customer fetchCustomer(
		long customerId) {

		return _customerLocalService.fetchCustomer(customerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _customerLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the customer with the primary key.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer
	 * @throws PortalException if a customer with the primary key could not be found
	 */
	@Override
	public customerManagementService.model.Customer getCustomer(long customerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerLocalService.getCustomer(customerId);
	}

	/**
	 * Returns a range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customerManagementService.model.impl.CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of customers
	 */
	@Override
	public java.util.List<customerManagementService.model.Customer>
		getCustomers(int start, int end) {

		return _customerLocalService.getCustomers(start, end);
	}

	/**
	 * Returns the number of customers.
	 *
	 * @return the number of customers
	 */
	@Override
	public int getCustomersCount() {
		return _customerLocalService.getCustomersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _customerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customerLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<customerManagementService.model.Customer>
		getServicesCustomers(long serviceId) {

		return _customerLocalService.getServicesCustomers(serviceId);
	}

	@Override
	public java.util.List<customerManagementService.model.Customer>
		getServicesCustomers(long serviceId, int start, int end) {

		return _customerLocalService.getServicesCustomers(
			serviceId, start, end);
	}

	@Override
	public java.util.List<customerManagementService.model.Customer>
		getServicesCustomers(
			long serviceId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<customerManagementService.model.Customer> orderByComparator) {

		return _customerLocalService.getServicesCustomers(
			serviceId, start, end, orderByComparator);
	}

	@Override
	public int getServicesCustomersCount(long serviceId) {
		return _customerLocalService.getServicesCustomersCount(serviceId);
	}

	/**
	 * Returns the serviceIds of the serviceses associated with the customer.
	 *
	 * @param customerId the customerId of the customer
	 * @return long[] the serviceIds of serviceses associated with the customer
	 */
	@Override
	public long[] getServicesPrimaryKeys(long customerId) {
		return _customerLocalService.getServicesPrimaryKeys(customerId);
	}

	@Override
	public boolean hasServicesCustomer(long serviceId, long customerId) {
		return _customerLocalService.hasServicesCustomer(serviceId, customerId);
	}

	@Override
	public boolean hasServicesCustomers(long serviceId) {
		return _customerLocalService.hasServicesCustomers(serviceId);
	}

	@Override
	public void setServicesCustomers(long serviceId, long[] customerIds) {
		_customerLocalService.setServicesCustomers(serviceId, customerIds);
	}

	/**
	 * Updates the customer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer the customer
	 * @return the customer that was updated
	 */
	@Override
	public customerManagementService.model.Customer updateCustomer(
		customerManagementService.model.Customer customer) {

		return _customerLocalService.updateCustomer(customer);
	}

	@Override
	public customerManagementService.model.Customer updateCustomer(
			long customerId, String customerName, String customerIdentityNo,
			String customerEmail, String customerAddress,
			String customerContactNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _customerLocalService.updateCustomer(
			customerId, customerName, customerIdentityNo, customerEmail,
			customerAddress, customerContactNo);
	}

	@Override
	public CustomerLocalService getWrappedService() {
		return _customerLocalService;
	}

	@Override
	public void setWrappedService(CustomerLocalService customerLocalService) {
		_customerLocalService = customerLocalService;
	}

	private CustomerLocalService _customerLocalService;

}