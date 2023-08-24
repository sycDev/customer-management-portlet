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

import customerManagementService.exception.NoSuchServicesException;

import customerManagementService.model.Services;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sin Yi
 * @see ServicesUtil
 * @generated
 */
@ProviderType
public interface ServicesPersistence extends BasePersistence<Services> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServicesUtil} to access the services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the serviceses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching serviceses
	 */
	public java.util.List<Services> findByGroupId(long groupId);

	/**
	 * Returns a range of all the serviceses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @return the range of matching serviceses
	 */
	public java.util.List<Services> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the serviceses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching serviceses
	 */
	public java.util.List<Services> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator);

	/**
	 * Returns an ordered range of all the serviceses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching serviceses
	 */
	public java.util.List<Services> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	public Services findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Services>
				orderByComparator)
		throws NoSuchServicesException;

	/**
	 * Returns the first services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services, or <code>null</code> if a matching services could not be found
	 */
	public Services fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator);

	/**
	 * Returns the last services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	public Services findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Services>
				orderByComparator)
		throws NoSuchServicesException;

	/**
	 * Returns the last services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services, or <code>null</code> if a matching services could not be found
	 */
	public Services fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator);

	/**
	 * Returns the serviceses before and after the current services in the ordered set where groupId = &#63;.
	 *
	 * @param serviceId the primary key of the current services
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next services
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	public Services[] findByGroupId_PrevAndNext(
			long serviceId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Services>
				orderByComparator)
		throws NoSuchServicesException;

	/**
	 * Removes all the serviceses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of serviceses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching serviceses
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the serviceses where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @return the matching serviceses
	 */
	public java.util.List<Services> findByServiceType(String serviceType);

	/**
	 * Returns a range of all the serviceses where serviceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param serviceType the service type
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @return the range of matching serviceses
	 */
	public java.util.List<Services> findByServiceType(
		String serviceType, int start, int end);

	/**
	 * Returns an ordered range of all the serviceses where serviceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param serviceType the service type
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching serviceses
	 */
	public java.util.List<Services> findByServiceType(
		String serviceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator);

	/**
	 * Returns an ordered range of all the serviceses where serviceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param serviceType the service type
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching serviceses
	 */
	public java.util.List<Services> findByServiceType(
		String serviceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	public Services findByServiceType_First(
			String serviceType,
			com.liferay.portal.kernel.util.OrderByComparator<Services>
				orderByComparator)
		throws NoSuchServicesException;

	/**
	 * Returns the first services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services, or <code>null</code> if a matching services could not be found
	 */
	public Services fetchByServiceType_First(
		String serviceType,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator);

	/**
	 * Returns the last services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	public Services findByServiceType_Last(
			String serviceType,
			com.liferay.portal.kernel.util.OrderByComparator<Services>
				orderByComparator)
		throws NoSuchServicesException;

	/**
	 * Returns the last services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services, or <code>null</code> if a matching services could not be found
	 */
	public Services fetchByServiceType_Last(
		String serviceType,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator);

	/**
	 * Returns the serviceses before and after the current services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceId the primary key of the current services
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next services
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	public Services[] findByServiceType_PrevAndNext(
			long serviceId, String serviceType,
			com.liferay.portal.kernel.util.OrderByComparator<Services>
				orderByComparator)
		throws NoSuchServicesException;

	/**
	 * Removes all the serviceses where serviceType = &#63; from the database.
	 *
	 * @param serviceType the service type
	 */
	public void removeByServiceType(String serviceType);

	/**
	 * Returns the number of serviceses where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @return the number of matching serviceses
	 */
	public int countByServiceType(String serviceType);

	/**
	 * Caches the services in the entity cache if it is enabled.
	 *
	 * @param services the services
	 */
	public void cacheResult(Services services);

	/**
	 * Caches the serviceses in the entity cache if it is enabled.
	 *
	 * @param serviceses the serviceses
	 */
	public void cacheResult(java.util.List<Services> serviceses);

	/**
	 * Creates a new services with the primary key. Does not add the services to the database.
	 *
	 * @param serviceId the primary key for the new services
	 * @return the new services
	 */
	public Services create(long serviceId);

	/**
	 * Removes the services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services that was removed
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	public Services remove(long serviceId) throws NoSuchServicesException;

	public Services updateImpl(Services services);

	/**
	 * Returns the services with the primary key or throws a <code>NoSuchServicesException</code> if it could not be found.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	public Services findByPrimaryKey(long serviceId)
		throws NoSuchServicesException;

	/**
	 * Returns the services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services, or <code>null</code> if a services with the primary key could not be found
	 */
	public Services fetchByPrimaryKey(long serviceId);

	/**
	 * Returns all the serviceses.
	 *
	 * @return the serviceses
	 */
	public java.util.List<Services> findAll();

	/**
	 * Returns a range of all the serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @return the range of serviceses
	 */
	public java.util.List<Services> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of serviceses
	 */
	public java.util.List<Services> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator);

	/**
	 * Returns an ordered range of all the serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of serviceses
	 */
	public java.util.List<Services> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the serviceses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of serviceses.
	 *
	 * @return the number of serviceses
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of customers associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @return long[] of the primaryKeys of customers associated with the services
	 */
	public long[] getCustomerPrimaryKeys(long pk);

	/**
	 * Returns all the services associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @return the serviceses associated with the customer
	 */
	public java.util.List<Services> getCustomerServiceses(long pk);

	/**
	 * Returns all the services associated with the customer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the customer
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of serviceses associated with the customer
	 */
	public java.util.List<Services> getCustomerServiceses(
		long pk, int start, int end);

	/**
	 * Returns all the services associated with the customer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the customer
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of serviceses associated with the customer
	 */
	public java.util.List<Services> getCustomerServiceses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Services>
			orderByComparator);

	/**
	 * Returns the number of customers associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @return the number of customers associated with the services
	 */
	public int getCustomersSize(long pk);

	/**
	 * Returns <code>true</code> if the customer is associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @param customerPK the primary key of the customer
	 * @return <code>true</code> if the customer is associated with the services; <code>false</code> otherwise
	 */
	public boolean containsCustomer(long pk, long customerPK);

	/**
	 * Returns <code>true</code> if the services has any customers associated with it.
	 *
	 * @param pk the primary key of the services to check for associations with customers
	 * @return <code>true</code> if the services has any customers associated with it; <code>false</code> otherwise
	 */
	public boolean containsCustomers(long pk);

	/**
	 * Adds an association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPK the primary key of the customer
	 */
	public void addCustomer(long pk, long customerPK);

	/**
	 * Adds an association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customer the customer
	 */
	public void addCustomer(
		long pk, customerManagementService.model.Customer customer);

	/**
	 * Adds an association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPKs the primary keys of the customers
	 */
	public void addCustomers(long pk, long[] customerPKs);

	/**
	 * Adds an association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customers the customers
	 */
	public void addCustomers(
		long pk,
		java.util.List<customerManagementService.model.Customer> customers);

	/**
	 * Clears all associations between the services and its customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services to clear the associated customers from
	 */
	public void clearCustomers(long pk);

	/**
	 * Removes the association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPK the primary key of the customer
	 */
	public void removeCustomer(long pk, long customerPK);

	/**
	 * Removes the association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customer the customer
	 */
	public void removeCustomer(
		long pk, customerManagementService.model.Customer customer);

	/**
	 * Removes the association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPKs the primary keys of the customers
	 */
	public void removeCustomers(long pk, long[] customerPKs);

	/**
	 * Removes the association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customers the customers
	 */
	public void removeCustomers(
		long pk,
		java.util.List<customerManagementService.model.Customer> customers);

	/**
	 * Sets the customers associated with the services, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPKs the primary keys of the customers to be associated with the services
	 */
	public void setCustomers(long pk, long[] customerPKs);

	/**
	 * Sets the customers associated with the services, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customers the customers to be associated with the services
	 */
	public void setCustomers(
		long pk,
		java.util.List<customerManagementService.model.Customer> customers);

}