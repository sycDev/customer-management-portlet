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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import customerManagementService.exception.NoSuchCustomerException;

import customerManagementService.model.Customer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sin Yi
 * @see CustomerUtil
 * @generated
 */
@ProviderType
public interface CustomerPersistence extends BasePersistence<Customer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomerUtil} to access the customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the customers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching customers
	 */
	public java.util.List<Customer> findByGroupId(long groupId);

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
	public java.util.List<Customer> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Customer> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

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
	public java.util.List<Customer> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public Customer findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Returns the first customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public Customer fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns the last customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public Customer findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Returns the last customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public Customer fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns the customers before and after the current customer in the ordered set where groupId = &#63;.
	 *
	 * @param customerId the primary key of the current customer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public Customer[] findByGroupId_PrevAndNext(
			long customerId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Removes all the customers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of customers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching customers
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the customers where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @return the matching customers
	 */
	public java.util.List<Customer> findByCustomerName(String customerName);

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
	public java.util.List<Customer> findByCustomerName(
		String customerName, int start, int end);

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
	public java.util.List<Customer> findByCustomerName(
		String customerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

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
	public java.util.List<Customer> findByCustomerName(
		String customerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public Customer findByCustomerName_First(
			String customerName,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Returns the first customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public Customer fetchByCustomerName_First(
		String customerName,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns the last customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	public Customer findByCustomerName_Last(
			String customerName,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Returns the last customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	public Customer fetchByCustomerName_Last(
		String customerName,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns the customers before and after the current customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerId the primary key of the current customer
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public Customer[] findByCustomerName_PrevAndNext(
			long customerId, String customerName,
			com.liferay.portal.kernel.util.OrderByComparator<Customer>
				orderByComparator)
		throws NoSuchCustomerException;

	/**
	 * Removes all the customers where customerName = &#63; from the database.
	 *
	 * @param customerName the customer name
	 */
	public void removeByCustomerName(String customerName);

	/**
	 * Returns the number of customers where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @return the number of matching customers
	 */
	public int countByCustomerName(String customerName);

	/**
	 * Caches the customer in the entity cache if it is enabled.
	 *
	 * @param customer the customer
	 */
	public void cacheResult(Customer customer);

	/**
	 * Caches the customers in the entity cache if it is enabled.
	 *
	 * @param customers the customers
	 */
	public void cacheResult(java.util.List<Customer> customers);

	/**
	 * Creates a new customer with the primary key. Does not add the customer to the database.
	 *
	 * @param customerId the primary key for the new customer
	 * @return the new customer
	 */
	public Customer create(long customerId);

	/**
	 * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer that was removed
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public Customer remove(long customerId) throws NoSuchCustomerException;

	public Customer updateImpl(Customer customer);

	/**
	 * Returns the customer with the primary key or throws a <code>NoSuchCustomerException</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	public Customer findByPrimaryKey(long customerId)
		throws NoSuchCustomerException;

	/**
	 * Returns the customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer, or <code>null</code> if a customer with the primary key could not be found
	 */
	public Customer fetchByPrimaryKey(long customerId);

	/**
	 * Returns all the customers.
	 *
	 * @return the customers
	 */
	public java.util.List<Customer> findAll();

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
	public java.util.List<Customer> findAll(int start, int end);

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
	public java.util.List<Customer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

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
	public java.util.List<Customer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the customers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of customers.
	 *
	 * @return the number of customers
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of serviceses associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @return long[] of the primaryKeys of serviceses associated with the customer
	 */
	public long[] getServicesPrimaryKeys(long pk);

	/**
	 * Returns all the customer associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @return the customers associated with the services
	 */
	public java.util.List<Customer> getServicesCustomers(long pk);

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
	public java.util.List<Customer> getServicesCustomers(
		long pk, int start, int end);

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
	public java.util.List<Customer> getServicesCustomers(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Customer>
			orderByComparator);

	/**
	 * Returns the number of serviceses associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @return the number of serviceses associated with the customer
	 */
	public int getServicesesSize(long pk);

	/**
	 * Returns <code>true</code> if the services is associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPK the primary key of the services
	 * @return <code>true</code> if the services is associated with the customer; <code>false</code> otherwise
	 */
	public boolean containsServices(long pk, long servicesPK);

	/**
	 * Returns <code>true</code> if the customer has any serviceses associated with it.
	 *
	 * @param pk the primary key of the customer to check for associations with serviceses
	 * @return <code>true</code> if the customer has any serviceses associated with it; <code>false</code> otherwise
	 */
	public boolean containsServiceses(long pk);

	/**
	 * Adds an association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPK the primary key of the services
	 */
	public void addServices(long pk, long servicesPK);

	/**
	 * Adds an association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param services the services
	 */
	public void addServices(
		long pk, customerManagementService.model.Services services);

	/**
	 * Adds an association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPKs the primary keys of the serviceses
	 */
	public void addServiceses(long pk, long[] servicesPKs);

	/**
	 * Adds an association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param serviceses the serviceses
	 */
	public void addServiceses(
		long pk,
		java.util.List<customerManagementService.model.Services> serviceses);

	/**
	 * Clears all associations between the customer and its serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer to clear the associated serviceses from
	 */
	public void clearServiceses(long pk);

	/**
	 * Removes the association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPK the primary key of the services
	 */
	public void removeServices(long pk, long servicesPK);

	/**
	 * Removes the association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param services the services
	 */
	public void removeServices(
		long pk, customerManagementService.model.Services services);

	/**
	 * Removes the association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPKs the primary keys of the serviceses
	 */
	public void removeServiceses(long pk, long[] servicesPKs);

	/**
	 * Removes the association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param serviceses the serviceses
	 */
	public void removeServiceses(
		long pk,
		java.util.List<customerManagementService.model.Services> serviceses);

	/**
	 * Sets the serviceses associated with the customer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPKs the primary keys of the serviceses to be associated with the customer
	 */
	public void setServiceses(long pk, long[] servicesPKs);

	/**
	 * Sets the serviceses associated with the customer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param serviceses the serviceses to be associated with the customer
	 */
	public void setServiceses(
		long pk,
		java.util.List<customerManagementService.model.Services> serviceses);

}