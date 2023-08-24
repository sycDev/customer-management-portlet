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
 * Provides a wrapper for {@link ServicesLocalService}.
 *
 * @author Sin Yi
 * @see ServicesLocalService
 * @generated
 */
public class ServicesLocalServiceWrapper
	implements ServicesLocalService, ServiceWrapper<ServicesLocalService> {

	public ServicesLocalServiceWrapper() {
		this(null);
	}

	public ServicesLocalServiceWrapper(
		ServicesLocalService servicesLocalService) {

		_servicesLocalService = servicesLocalService;
	}

	@Override
	public void addCustomerServices(long customerId, long serviceId) {
		_servicesLocalService.addCustomerServices(customerId, serviceId);
	}

	@Override
	public void addCustomerServices(
		long customerId, customerManagementService.model.Services services) {

		_servicesLocalService.addCustomerServices(customerId, services);
	}

	@Override
	public void addCustomerServiceses(
		long customerId,
		java.util.List<customerManagementService.model.Services> serviceses) {

		_servicesLocalService.addCustomerServiceses(customerId, serviceses);
	}

	@Override
	public void addCustomerServiceses(long customerId, long[] serviceIds) {
		_servicesLocalService.addCustomerServiceses(customerId, serviceIds);
	}

	@Override
	public customerManagementService.model.Services addService(
			String serviceName, String serviceType, String serviceSpecification,
			String servicePlan, double servicePrice, long userId, long groupId,
			String userName)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _servicesLocalService.addService(
			serviceName, serviceType, serviceSpecification, servicePlan,
			servicePrice, userId, groupId, userName);
	}

	/**
	 * Adds the services to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServicesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param services the services
	 * @return the services that was added
	 */
	@Override
	public customerManagementService.model.Services addServices(
		customerManagementService.model.Services services) {

		return _servicesLocalService.addServices(services);
	}

	@Override
	public void clearCustomerServiceses(long customerId) {
		_servicesLocalService.clearCustomerServiceses(customerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servicesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new services with the primary key. Does not add the services to the database.
	 *
	 * @param serviceId the primary key for the new services
	 * @return the new services
	 */
	@Override
	public customerManagementService.model.Services createServices(
		long serviceId) {

		return _servicesLocalService.createServices(serviceId);
	}

	@Override
	public void deleteCustomerServices(long customerId, long serviceId) {
		_servicesLocalService.deleteCustomerServices(customerId, serviceId);
	}

	@Override
	public void deleteCustomerServices(
		long customerId, customerManagementService.model.Services services) {

		_servicesLocalService.deleteCustomerServices(customerId, services);
	}

	@Override
	public void deleteCustomerServiceses(
		long customerId,
		java.util.List<customerManagementService.model.Services> serviceses) {

		_servicesLocalService.deleteCustomerServiceses(customerId, serviceses);
	}

	@Override
	public void deleteCustomerServiceses(long customerId, long[] serviceIds) {
		_servicesLocalService.deleteCustomerServiceses(customerId, serviceIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servicesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public customerManagementService.model.Services deleteService(
			long serviceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _servicesLocalService.deleteService(serviceId);
	}

	/**
	 * Deletes the services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServicesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceId the primary key of the services
	 * @return the services that was removed
	 * @throws PortalException if a services with the primary key could not be found
	 */
	@Override
	public customerManagementService.model.Services deleteServices(
			long serviceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servicesLocalService.deleteServices(serviceId);
	}

	/**
	 * Deletes the services from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServicesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param services the services
	 * @return the services that was removed
	 */
	@Override
	public customerManagementService.model.Services deleteServices(
		customerManagementService.model.Services services) {

		return _servicesLocalService.deleteServices(services);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _servicesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _servicesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _servicesLocalService.dynamicQuery();
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

		return _servicesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customerManagementService.model.impl.ServicesModelImpl</code>.
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

		return _servicesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customerManagementService.model.impl.ServicesModelImpl</code>.
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

		return _servicesLocalService.dynamicQuery(
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

		return _servicesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _servicesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public customerManagementService.model.Services fetchServices(
		long serviceId) {

		return _servicesLocalService.fetchServices(serviceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _servicesLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the customerIds of the customers associated with the services.
	 *
	 * @param serviceId the serviceId of the services
	 * @return long[] the customerIds of customers associated with the services
	 */
	@Override
	public long[] getCustomerPrimaryKeys(long serviceId) {
		return _servicesLocalService.getCustomerPrimaryKeys(serviceId);
	}

	@Override
	public java.util.List<customerManagementService.model.Services>
		getCustomerServiceses(long customerId) {

		return _servicesLocalService.getCustomerServiceses(customerId);
	}

	@Override
	public java.util.List<customerManagementService.model.Services>
		getCustomerServiceses(long customerId, int start, int end) {

		return _servicesLocalService.getCustomerServiceses(
			customerId, start, end);
	}

	@Override
	public java.util.List<customerManagementService.model.Services>
		getCustomerServiceses(
			long customerId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<customerManagementService.model.Services> orderByComparator) {

		return _servicesLocalService.getCustomerServiceses(
			customerId, start, end, orderByComparator);
	}

	@Override
	public int getCustomerServicesesCount(long customerId) {
		return _servicesLocalService.getCustomerServicesesCount(customerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _servicesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _servicesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servicesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the services with the primary key.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services
	 * @throws PortalException if a services with the primary key could not be found
	 */
	@Override
	public customerManagementService.model.Services getServices(long serviceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _servicesLocalService.getServices(serviceId);
	}

	/**
	 * Returns a range of all the serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customerManagementService.model.impl.ServicesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of serviceses
	 * @param end the upper bound of the range of serviceses (not inclusive)
	 * @return the range of serviceses
	 */
	@Override
	public java.util.List<customerManagementService.model.Services>
		getServiceses(int start, int end) {

		return _servicesLocalService.getServiceses(start, end);
	}

	/**
	 * Returns the number of serviceses.
	 *
	 * @return the number of serviceses
	 */
	@Override
	public int getServicesesCount() {
		return _servicesLocalService.getServicesesCount();
	}

	@Override
	public boolean hasCustomerServices(long customerId, long serviceId) {
		return _servicesLocalService.hasCustomerServices(customerId, serviceId);
	}

	@Override
	public boolean hasCustomerServiceses(long customerId) {
		return _servicesLocalService.hasCustomerServiceses(customerId);
	}

	@Override
	public void setCustomerServiceses(long customerId, long[] serviceIds) {
		_servicesLocalService.setCustomerServiceses(customerId, serviceIds);
	}

	@Override
	public customerManagementService.model.Services updateService(
			long serviceId, String serviceName, String serviceType,
			String serviceSpecification, String servicePlan,
			double servicePrice)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _servicesLocalService.updateService(
			serviceId, serviceName, serviceType, serviceSpecification,
			servicePlan, servicePrice);
	}

	/**
	 * Updates the services in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServicesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param services the services
	 * @return the services that was updated
	 */
	@Override
	public customerManagementService.model.Services updateServices(
		customerManagementService.model.Services services) {

		return _servicesLocalService.updateServices(services);
	}

	@Override
	public ServicesLocalService getWrappedService() {
		return _servicesLocalService;
	}

	@Override
	public void setWrappedService(ServicesLocalService servicesLocalService) {
		_servicesLocalService = servicesLocalService;
	}

	private ServicesLocalService _servicesLocalService;

}