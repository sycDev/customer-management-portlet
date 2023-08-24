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

import customerManagementService.model.Services;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the services service. This utility wraps <code>customerManagementService.service.persistence.impl.ServicesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sin Yi
 * @see ServicesPersistence
 * @generated
 */
public class ServicesUtil {

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
	public static void clearCache(Services services) {
		getPersistence().clearCache(services);
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
	public static Map<Serializable, Services> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Services> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Services> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Services> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Services> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Services update(Services services) {
		return getPersistence().update(services);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Services update(
		Services services, ServiceContext serviceContext) {

		return getPersistence().update(services, serviceContext);
	}

	/**
	 * Returns all the serviceses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching serviceses
	 */
	public static List<Services> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<Services> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<Services> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Services> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<Services> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Services> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	public static Services findByGroupId_First(
			long groupId, OrderByComparator<Services> orderByComparator)
		throws customerManagementService.exception.NoSuchServicesException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services, or <code>null</code> if a matching services could not be found
	 */
	public static Services fetchByGroupId_First(
		long groupId, OrderByComparator<Services> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	public static Services findByGroupId_Last(
			long groupId, OrderByComparator<Services> orderByComparator)
		throws customerManagementService.exception.NoSuchServicesException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services, or <code>null</code> if a matching services could not be found
	 */
	public static Services fetchByGroupId_Last(
		long groupId, OrderByComparator<Services> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the serviceses before and after the current services in the ordered set where groupId = &#63;.
	 *
	 * @param serviceId the primary key of the current services
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next services
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	public static Services[] findByGroupId_PrevAndNext(
			long serviceId, long groupId,
			OrderByComparator<Services> orderByComparator)
		throws customerManagementService.exception.NoSuchServicesException {

		return getPersistence().findByGroupId_PrevAndNext(
			serviceId, groupId, orderByComparator);
	}

	/**
	 * Removes all the serviceses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of serviceses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching serviceses
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the serviceses where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @return the matching serviceses
	 */
	public static List<Services> findByServiceType(String serviceType) {
		return getPersistence().findByServiceType(serviceType);
	}

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
	public static List<Services> findByServiceType(
		String serviceType, int start, int end) {

		return getPersistence().findByServiceType(serviceType, start, end);
	}

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
	public static List<Services> findByServiceType(
		String serviceType, int start, int end,
		OrderByComparator<Services> orderByComparator) {

		return getPersistence().findByServiceType(
			serviceType, start, end, orderByComparator);
	}

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
	public static List<Services> findByServiceType(
		String serviceType, int start, int end,
		OrderByComparator<Services> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByServiceType(
			serviceType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	public static Services findByServiceType_First(
			String serviceType, OrderByComparator<Services> orderByComparator)
		throws customerManagementService.exception.NoSuchServicesException {

		return getPersistence().findByServiceType_First(
			serviceType, orderByComparator);
	}

	/**
	 * Returns the first services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services, or <code>null</code> if a matching services could not be found
	 */
	public static Services fetchByServiceType_First(
		String serviceType, OrderByComparator<Services> orderByComparator) {

		return getPersistence().fetchByServiceType_First(
			serviceType, orderByComparator);
	}

	/**
	 * Returns the last services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	public static Services findByServiceType_Last(
			String serviceType, OrderByComparator<Services> orderByComparator)
		throws customerManagementService.exception.NoSuchServicesException {

		return getPersistence().findByServiceType_Last(
			serviceType, orderByComparator);
	}

	/**
	 * Returns the last services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services, or <code>null</code> if a matching services could not be found
	 */
	public static Services fetchByServiceType_Last(
		String serviceType, OrderByComparator<Services> orderByComparator) {

		return getPersistence().fetchByServiceType_Last(
			serviceType, orderByComparator);
	}

	/**
	 * Returns the serviceses before and after the current services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceId the primary key of the current services
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next services
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	public static Services[] findByServiceType_PrevAndNext(
			long serviceId, String serviceType,
			OrderByComparator<Services> orderByComparator)
		throws customerManagementService.exception.NoSuchServicesException {

		return getPersistence().findByServiceType_PrevAndNext(
			serviceId, serviceType, orderByComparator);
	}

	/**
	 * Removes all the serviceses where serviceType = &#63; from the database.
	 *
	 * @param serviceType the service type
	 */
	public static void removeByServiceType(String serviceType) {
		getPersistence().removeByServiceType(serviceType);
	}

	/**
	 * Returns the number of serviceses where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @return the number of matching serviceses
	 */
	public static int countByServiceType(String serviceType) {
		return getPersistence().countByServiceType(serviceType);
	}

	/**
	 * Caches the services in the entity cache if it is enabled.
	 *
	 * @param services the services
	 */
	public static void cacheResult(Services services) {
		getPersistence().cacheResult(services);
	}

	/**
	 * Caches the serviceses in the entity cache if it is enabled.
	 *
	 * @param serviceses the serviceses
	 */
	public static void cacheResult(List<Services> serviceses) {
		getPersistence().cacheResult(serviceses);
	}

	/**
	 * Creates a new services with the primary key. Does not add the services to the database.
	 *
	 * @param serviceId the primary key for the new services
	 * @return the new services
	 */
	public static Services create(long serviceId) {
		return getPersistence().create(serviceId);
	}

	/**
	 * Removes the services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services that was removed
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	public static Services remove(long serviceId)
		throws customerManagementService.exception.NoSuchServicesException {

		return getPersistence().remove(serviceId);
	}

	public static Services updateImpl(Services services) {
		return getPersistence().updateImpl(services);
	}

	/**
	 * Returns the services with the primary key or throws a <code>NoSuchServicesException</code> if it could not be found.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	public static Services findByPrimaryKey(long serviceId)
		throws customerManagementService.exception.NoSuchServicesException {

		return getPersistence().findByPrimaryKey(serviceId);
	}

	/**
	 * Returns the services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services, or <code>null</code> if a services with the primary key could not be found
	 */
	public static Services fetchByPrimaryKey(long serviceId) {
		return getPersistence().fetchByPrimaryKey(serviceId);
	}

	/**
	 * Returns all the serviceses.
	 *
	 * @return the serviceses
	 */
	public static List<Services> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Services> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Services> findAll(
		int start, int end, OrderByComparator<Services> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Services> findAll(
		int start, int end, OrderByComparator<Services> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the serviceses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of serviceses.
	 *
	 * @return the number of serviceses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of customers associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @return long[] of the primaryKeys of customers associated with the services
	 */
	public static long[] getCustomerPrimaryKeys(long pk) {
		return getPersistence().getCustomerPrimaryKeys(pk);
	}

	/**
	 * Returns all the services associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @return the serviceses associated with the customer
	 */
	public static List<Services> getCustomerServiceses(long pk) {
		return getPersistence().getCustomerServiceses(pk);
	}

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
	public static List<Services> getCustomerServiceses(
		long pk, int start, int end) {

		return getPersistence().getCustomerServiceses(pk, start, end);
	}

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
	public static List<Services> getCustomerServiceses(
		long pk, int start, int end,
		OrderByComparator<Services> orderByComparator) {

		return getPersistence().getCustomerServiceses(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of customers associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @return the number of customers associated with the services
	 */
	public static int getCustomersSize(long pk) {
		return getPersistence().getCustomersSize(pk);
	}

	/**
	 * Returns <code>true</code> if the customer is associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @param customerPK the primary key of the customer
	 * @return <code>true</code> if the customer is associated with the services; <code>false</code> otherwise
	 */
	public static boolean containsCustomer(long pk, long customerPK) {
		return getPersistence().containsCustomer(pk, customerPK);
	}

	/**
	 * Returns <code>true</code> if the services has any customers associated with it.
	 *
	 * @param pk the primary key of the services to check for associations with customers
	 * @return <code>true</code> if the services has any customers associated with it; <code>false</code> otherwise
	 */
	public static boolean containsCustomers(long pk) {
		return getPersistence().containsCustomers(pk);
	}

	/**
	 * Adds an association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPK the primary key of the customer
	 */
	public static void addCustomer(long pk, long customerPK) {
		getPersistence().addCustomer(pk, customerPK);
	}

	/**
	 * Adds an association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customer the customer
	 */
	public static void addCustomer(
		long pk, customerManagementService.model.Customer customer) {

		getPersistence().addCustomer(pk, customer);
	}

	/**
	 * Adds an association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPKs the primary keys of the customers
	 */
	public static void addCustomers(long pk, long[] customerPKs) {
		getPersistence().addCustomers(pk, customerPKs);
	}

	/**
	 * Adds an association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customers the customers
	 */
	public static void addCustomers(
		long pk, List<customerManagementService.model.Customer> customers) {

		getPersistence().addCustomers(pk, customers);
	}

	/**
	 * Clears all associations between the services and its customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services to clear the associated customers from
	 */
	public static void clearCustomers(long pk) {
		getPersistence().clearCustomers(pk);
	}

	/**
	 * Removes the association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPK the primary key of the customer
	 */
	public static void removeCustomer(long pk, long customerPK) {
		getPersistence().removeCustomer(pk, customerPK);
	}

	/**
	 * Removes the association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customer the customer
	 */
	public static void removeCustomer(
		long pk, customerManagementService.model.Customer customer) {

		getPersistence().removeCustomer(pk, customer);
	}

	/**
	 * Removes the association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPKs the primary keys of the customers
	 */
	public static void removeCustomers(long pk, long[] customerPKs) {
		getPersistence().removeCustomers(pk, customerPKs);
	}

	/**
	 * Removes the association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customers the customers
	 */
	public static void removeCustomers(
		long pk, List<customerManagementService.model.Customer> customers) {

		getPersistence().removeCustomers(pk, customers);
	}

	/**
	 * Sets the customers associated with the services, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPKs the primary keys of the customers to be associated with the services
	 */
	public static void setCustomers(long pk, long[] customerPKs) {
		getPersistence().setCustomers(pk, customerPKs);
	}

	/**
	 * Sets the customers associated with the services, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customers the customers to be associated with the services
	 */
	public static void setCustomers(
		long pk, List<customerManagementService.model.Customer> customers) {

		getPersistence().setCustomers(pk, customers);
	}

	public static ServicesPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ServicesPersistence _persistence;

}