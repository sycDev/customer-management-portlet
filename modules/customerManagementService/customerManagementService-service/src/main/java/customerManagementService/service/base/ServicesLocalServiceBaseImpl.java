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

package customerManagementService.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import customerManagementService.model.Services;

import customerManagementService.service.ServicesLocalService;
import customerManagementService.service.ServicesLocalServiceUtil;
import customerManagementService.service.persistence.CustomerPersistence;
import customerManagementService.service.persistence.ServicesPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the services local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link customerManagementService.service.impl.ServicesLocalServiceImpl}.
 * </p>
 *
 * @author Sin Yi
 * @see customerManagementService.service.impl.ServicesLocalServiceImpl
 * @generated
 */
public abstract class ServicesLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, ServicesLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ServicesLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ServicesLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Services addServices(Services services) {
		services.setNew(true);

		return servicesPersistence.update(services);
	}

	/**
	 * Creates a new services with the primary key. Does not add the services to the database.
	 *
	 * @param serviceId the primary key for the new services
	 * @return the new services
	 */
	@Override
	@Transactional(enabled = false)
	public Services createServices(long serviceId) {
		return servicesPersistence.create(serviceId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Services deleteServices(long serviceId) throws PortalException {
		return servicesPersistence.remove(serviceId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Services deleteServices(Services services) {
		return servicesPersistence.remove(services);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return servicesPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Services.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return servicesPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return servicesPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return servicesPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return servicesPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return servicesPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Services fetchServices(long serviceId) {
		return servicesPersistence.fetchByPrimaryKey(serviceId);
	}

	/**
	 * Returns the services with the primary key.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services
	 * @throws PortalException if a services with the primary key could not be found
	 */
	@Override
	public Services getServices(long serviceId) throws PortalException {
		return servicesPersistence.findByPrimaryKey(serviceId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(servicesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Services.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("serviceId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			servicesLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Services.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("serviceId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(servicesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Services.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("serviceId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return servicesPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return servicesLocalService.deleteServices((Services)persistedModel);
	}

	@Override
	public BasePersistence<Services> getBasePersistence() {
		return servicesPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return servicesPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Services> getServiceses(int start, int end) {
		return servicesPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of serviceses.
	 *
	 * @return the number of serviceses
	 */
	@Override
	public int getServicesesCount() {
		return servicesPersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Services updateServices(Services services) {
		return servicesPersistence.update(services);
	}

	/**
	 */
	@Override
	public void addCustomerServices(long customerId, long serviceId) {
		customerPersistence.addServices(customerId, serviceId);
	}

	/**
	 */
	@Override
	public void addCustomerServices(long customerId, Services services) {
		customerPersistence.addServices(customerId, services);
	}

	/**
	 */
	@Override
	public void addCustomerServiceses(long customerId, long[] serviceIds) {
		customerPersistence.addServiceses(customerId, serviceIds);
	}

	/**
	 */
	@Override
	public void addCustomerServiceses(
		long customerId, List<Services> serviceses) {

		customerPersistence.addServiceses(customerId, serviceses);
	}

	/**
	 */
	@Override
	public void clearCustomerServiceses(long customerId) {
		customerPersistence.clearServiceses(customerId);
	}

	/**
	 */
	@Override
	public void deleteCustomerServices(long customerId, long serviceId) {
		customerPersistence.removeServices(customerId, serviceId);
	}

	/**
	 */
	@Override
	public void deleteCustomerServices(long customerId, Services services) {
		customerPersistence.removeServices(customerId, services);
	}

	/**
	 */
	@Override
	public void deleteCustomerServiceses(long customerId, long[] serviceIds) {
		customerPersistence.removeServiceses(customerId, serviceIds);
	}

	/**
	 */
	@Override
	public void deleteCustomerServiceses(
		long customerId, List<Services> serviceses) {

		customerPersistence.removeServiceses(customerId, serviceses);
	}

	/**
	 * Returns the customerIds of the customers associated with the services.
	 *
	 * @param serviceId the serviceId of the services
	 * @return long[] the customerIds of customers associated with the services
	 */
	@Override
	public long[] getCustomerPrimaryKeys(long serviceId) {
		return servicesPersistence.getCustomerPrimaryKeys(serviceId);
	}

	/**
	 */
	@Override
	public List<Services> getCustomerServiceses(long customerId) {
		return servicesPersistence.getCustomerServiceses(customerId);
	}

	/**
	 */
	@Override
	public List<Services> getCustomerServiceses(
		long customerId, int start, int end) {

		return servicesPersistence.getCustomerServiceses(
			customerId, start, end);
	}

	/**
	 */
	@Override
	public List<Services> getCustomerServiceses(
		long customerId, int start, int end,
		OrderByComparator<Services> orderByComparator) {

		return servicesPersistence.getCustomerServiceses(
			customerId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getCustomerServicesesCount(long customerId) {
		return customerPersistence.getServicesesSize(customerId);
	}

	/**
	 */
	@Override
	public boolean hasCustomerServices(long customerId, long serviceId) {
		return customerPersistence.containsServices(customerId, serviceId);
	}

	/**
	 */
	@Override
	public boolean hasCustomerServiceses(long customerId) {
		return customerPersistence.containsServiceses(customerId);
	}

	/**
	 */
	@Override
	public void setCustomerServiceses(long customerId, long[] serviceIds) {
		customerPersistence.setServiceses(customerId, serviceIds);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ServicesLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		servicesLocalService = (ServicesLocalService)aopProxy;

		_setLocalServiceUtilService(servicesLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ServicesLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Services.class;
	}

	protected String getModelClassName() {
		return Services.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = servicesPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		ServicesLocalService servicesLocalService) {

		try {
			Field field = ServicesLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, servicesLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected CustomerPersistence customerPersistence;

	protected ServicesLocalService servicesLocalService;

	@Reference
	protected ServicesPersistence servicesPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}