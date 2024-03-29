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

package customerManagementService.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import customerManagementService.model.Customer;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the customer service. This utility wraps <code>customerManagementService.service.persistence.impl.CustomerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sin Yi
 * @see CustomerPersistence
 * @generated
 */
public class CustomerUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Customer customer) {
		getPersistence().clearCache(customer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Customer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Customer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Customer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Customer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Customer update(Customer customer) {
		return getPersistence().update(customer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Customer update(
		Customer customer, ServiceContext serviceContext) {

		return getPersistence().update(customer, serviceContext);
	}

	/**
	 * Returns all the customers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching customers
	 */
	public static List<Customer> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the customers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of matching customers
	 */
	public static List<Customer> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the customers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customers
	 */
	public static List<Customer> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customers
	 */
	public static List<Customer> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Customer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public static Customer findByGroupId_First(
			long groupId, OrderByComparator<Customer> orderByComparator)
		throws customerManagementService.exception.NoSuchCustomerException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public static Customer fetchByGroupId_First(
		long groupId, OrderByComparator<Customer> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public static Customer findByGroupId_Last(
			long groupId, OrderByComparator<Customer> orderByComparator)
		throws customerManagementService.exception.NoSuchCustomerException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public static Customer fetchByGroupId_Last(
		long groupId, OrderByComparator<Customer> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the customers before and after the current customer in the ordered set where groupId = &#63;.
	 *
	 * @param customerId the primary key of the current customer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public static Customer[] findByGroupId_PrevAndNext(
			long customerId, long groupId,
			OrderByComparator<Customer> orderByComparator)
		throws customerManagementService.exception.NoSuchCustomerException {

		return getPersistence().findByGroupId_PrevAndNext(
			customerId, groupId, orderByComparator);
	}

	/**
	 * Removes all the customers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of customers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching customers
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the customers where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @return the matching customers
	 */
	public static List<Customer> findByCustomerName(String customerName) {
		return getPersistence().findByCustomerName(customerName);
	}

	/**
	 * Returns a range of all the customers where customerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param customerName the customer name
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of matching customers
	 */
	public static List<Customer> findByCustomerName(
		String customerName, int start, int end) {

		return getPersistence().findByCustomerName(customerName, start, end);
	}

	/**
	 * Returns an ordered range of all the customers where customerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param customerName the customer name
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customers
	 */
	public static List<Customer> findByCustomerName(
		String customerName, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return getPersistence().findByCustomerName(
			customerName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customers where customerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param customerName the customer name
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customers
	 */
	public static List<Customer> findByCustomerName(
		String customerName, int start, int end,
		OrderByComparator<Customer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCustomerName(
			customerName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public static Customer findByCustomerName_First(
			String customerName, OrderByComparator<Customer> orderByComparator)
		throws customerManagementService.exception.NoSuchCustomerException {

		return getPersistence().findByCustomerName_First(
			customerName, orderByComparator);
	}

	/**
	 * Returns the first customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public static Customer fetchByCustomerName_First(
		String customerName, OrderByComparator<Customer> orderByComparator) {

		return getPersistence().fetchByCustomerName_First(
			customerName, orderByComparator);
	}

	/**
	 * Returns the last customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public static Customer findByCustomerName_Last(
			String customerName, OrderByComparator<Customer> orderByComparator)
		throws customerManagementService.exception.NoSuchCustomerException {

		return getPersistence().findByCustomerName_Last(
			customerName, orderByComparator);
	}

	/**
	 * Returns the last customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public static Customer fetchByCustomerName_Last(
		String customerName, OrderByComparator<Customer> orderByComparator) {

		return getPersistence().fetchByCustomerName_Last(
			customerName, orderByComparator);
	}

	/**
	 * Returns the customers before and after the current customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerId the primary key of the current customer
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public static Customer[] findByCustomerName_PrevAndNext(
			long customerId, String customerName,
			OrderByComparator<Customer> orderByComparator)
		throws customerManagementService.exception.NoSuchCustomerException {

		return getPersistence().findByCustomerName_PrevAndNext(
			customerId, customerName, orderByComparator);
	}

	/**
	 * Removes all the customers where customerName = &#63; from the database.
	 *
	 * @param customerName the customer name
	 */
	public static void removeByCustomerName(String customerName) {
		getPersistence().removeByCustomerName(customerName);
	}

	/**
	 * Returns the number of customers where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @return the number of matching customers
	 */
	public static int countByCustomerName(String customerName) {
		return getPersistence().countByCustomerName(customerName);
	}

	/**
	 * Caches the customer in the entity cache if it is enabled.
	 *
	 * @param customer the customer
	 */
	public static void cacheResult(Customer customer) {
		getPersistence().cacheResult(customer);
	}

	/**
	 * Caches the customers in the entity cache if it is enabled.
	 *
	 * @param customers the customers
	 */
	public static void cacheResult(List<Customer> customers) {
		getPersistence().cacheResult(customers);
	}

	/**
	 * Creates a new customer with the primary key. Does not add the customer to the database.
	 *
	 * @param customerId the primary key for the new customer
	 * @return the new customer
	 */
	public static Customer create(long customerId) {
		return getPersistence().create(customerId);
	}

	/**
	 * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer that was removed
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public static Customer remove(long customerId)
		throws customerManagementService.exception.NoSuchCustomerException {

		return getPersistence().remove(customerId);
	}

	public static Customer updateImpl(Customer customer) {
		return getPersistence().updateImpl(customer);
	}

	/**
	 * Returns the customer with the primary key or throws a <code>NoSuchCustomerException</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public static Customer findByPrimaryKey(long customerId)
		throws customerManagementService.exception.NoSuchCustomerException {

		return getPersistence().findByPrimaryKey(customerId);
	}

	/**
	 * Returns the customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer, or <code>null</code> if a customer with the primary key could not be found
	 */
	public static Customer fetchByPrimaryKey(long customerId) {
		return getPersistence().fetchByPrimaryKey(customerId);
	}

	/**
	 * Returns all the customers.
	 *
	 * @return the customers
	 */
	public static List<Customer> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of customers
	 */
	public static List<Customer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customers
	 */
	public static List<Customer> findAll(
		int start, int end, OrderByComparator<Customer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of customers
	 */
	public static List<Customer> findAll(
		int start, int end, OrderByComparator<Customer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the customers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of customers.
	 *
	 * @return the number of customers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of serviceses associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @return long[] of the primaryKeys of serviceses associated with the customer
	 */
	public static long[] getServicesPrimaryKeys(long pk) {
		return getPersistence().getServicesPrimaryKeys(pk);
	}

	/**
	 * Returns all the customer associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @return the customers associated with the services
	 */
	public static List<Customer> getServicesCustomers(long pk) {
		return getPersistence().getServicesCustomers(pk);
	}

	/**
	 * Returns all the customer associated with the services.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the services
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @return the range of customers associated with the services
	 */
	public static List<Customer> getServicesCustomers(
		long pk, int start, int end) {

		return getPersistence().getServicesCustomers(pk, start, end);
	}

	/**
	 * Returns all the customer associated with the services.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the services
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customers associated with the services
	 */
	public static List<Customer> getServicesCustomers(
		long pk, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return getPersistence().getServicesCustomers(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of serviceses associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @return the number of serviceses associated with the customer
	 */
	public static int getServicesesSize(long pk) {
		return getPersistence().getServicesesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the services is associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPK the primary key of the services
	 * @return <code>true</code> if the services is associated with the customer; <code>false</code> otherwise
	 */
	public static boolean containsServices(long pk, long servicesPK) {
		return getPersistence().containsServices(pk, servicesPK);
	}

	/**
	 * Returns <code>true</code> if the customer has any serviceses associated with it.
	 *
	 * @param pk the primary key of the customer to check for associations with serviceses
	 * @return <code>true</code> if the customer has any serviceses associated with it; <code>false</code> otherwise
	 */
	public static boolean containsServiceses(long pk) {
		return getPersistence().containsServiceses(pk);
	}

	/**
	 * Adds an association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPK the primary key of the services
	 */
	public static void addServices(long pk, long servicesPK) {
		getPersistence().addServices(pk, servicesPK);
	}

	/**
	 * Adds an association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param services the services
	 */
	public static void addServices(
		long pk, customerManagementService.model.Services services) {

		getPersistence().addServices(pk, services);
	}

	/**
	 * Adds an association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPKs the primary keys of the serviceses
	 */
	public static void addServiceses(long pk, long[] servicesPKs) {
		getPersistence().addServiceses(pk, servicesPKs);
	}

	/**
	 * Adds an association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param serviceses the serviceses
	 */
	public static void addServiceses(
		long pk, List<customerManagementService.model.Services> serviceses) {

		getPersistence().addServiceses(pk, serviceses);
	}

	/**
	 * Clears all associations between the customer and its serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer to clear the associated serviceses from
	 */
	public static void clearServiceses(long pk) {
		getPersistence().clearServiceses(pk);
	}

	/**
	 * Removes the association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPK the primary key of the services
	 */
	public static void removeServices(long pk, long servicesPK) {
		getPersistence().removeServices(pk, servicesPK);
	}

	/**
	 * Removes the association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param services the services
	 */
	public static void removeServices(
		long pk, customerManagementService.model.Services services) {

		getPersistence().removeServices(pk, services);
	}

	/**
	 * Removes the association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPKs the primary keys of the serviceses
	 */
	public static void removeServiceses(long pk, long[] servicesPKs) {
		getPersistence().removeServiceses(pk, servicesPKs);
	}

	/**
	 * Removes the association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param serviceses the serviceses
	 */
	public static void removeServiceses(
		long pk, List<customerManagementService.model.Services> serviceses) {

		getPersistence().removeServiceses(pk, serviceses);
	}

	/**
	 * Sets the serviceses associated with the customer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPKs the primary keys of the serviceses to be associated with the customer
	 */
	public static void setServiceses(long pk, long[] servicesPKs) {
		getPersistence().setServiceses(pk, servicesPKs);
	}

	/**
	 * Sets the serviceses associated with the customer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param serviceses the serviceses to be associated with the customer
	 */
	public static void setServiceses(
		long pk, List<customerManagementService.model.Services> serviceses) {

		getPersistence().setServiceses(pk, serviceses);
	}

	public static CustomerPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CustomerPersistence _persistence;

}