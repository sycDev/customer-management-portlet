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

package customerManagementService.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import customerManagementService.exception.NoSuchServicesException;

import customerManagementService.model.Customer;
import customerManagementService.model.Services;
import customerManagementService.model.ServicesTable;
import customerManagementService.model.impl.ServicesImpl;
import customerManagementService.model.impl.ServicesModelImpl;

import customerManagementService.service.persistence.ServicesPersistence;
import customerManagementService.service.persistence.ServicesUtil;
import customerManagementService.service.persistence.impl.constants.CMPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sin Yi
 * @generated
 */
@Component(service = {ServicesPersistence.class, BasePersistence.class})
public class ServicesPersistenceImpl
	extends BasePersistenceImpl<Services> implements ServicesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServicesUtil</code> to access the services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServicesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the serviceses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching serviceses
	 */
	@Override
	public List<Services> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Services> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Services> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Services> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Services> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Services> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Services> list = null;

		if (useFinderCache) {
			list = (List<Services>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Services services : list) {
					if (groupId != services.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SERVICES_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Services>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	@Override
	public Services findByGroupId_First(
			long groupId, OrderByComparator<Services> orderByComparator)
		throws NoSuchServicesException {

		Services services = fetchByGroupId_First(groupId, orderByComparator);

		if (services != null) {
			return services;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchServicesException(sb.toString());
	}

	/**
	 * Returns the first services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services, or <code>null</code> if a matching services could not be found
	 */
	@Override
	public Services fetchByGroupId_First(
		long groupId, OrderByComparator<Services> orderByComparator) {

		List<Services> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	@Override
	public Services findByGroupId_Last(
			long groupId, OrderByComparator<Services> orderByComparator)
		throws NoSuchServicesException {

		Services services = fetchByGroupId_Last(groupId, orderByComparator);

		if (services != null) {
			return services;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchServicesException(sb.toString());
	}

	/**
	 * Returns the last services in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services, or <code>null</code> if a matching services could not be found
	 */
	@Override
	public Services fetchByGroupId_Last(
		long groupId, OrderByComparator<Services> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Services> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Services[] findByGroupId_PrevAndNext(
			long serviceId, long groupId,
			OrderByComparator<Services> orderByComparator)
		throws NoSuchServicesException {

		Services services = findByPrimaryKey(serviceId);

		Session session = null;

		try {
			session = openSession();

			Services[] array = new ServicesImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, services, groupId, orderByComparator, true);

			array[1] = services;

			array[2] = getByGroupId_PrevAndNext(
				session, services, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Services getByGroupId_PrevAndNext(
		Session session, Services services, long groupId,
		OrderByComparator<Services> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVICES_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(services)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Services> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the serviceses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Services services :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(services);
		}
	}

	/**
	 * Returns the number of serviceses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching serviceses
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICES_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"services.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByServiceType;
	private FinderPath _finderPathWithoutPaginationFindByServiceType;
	private FinderPath _finderPathCountByServiceType;

	/**
	 * Returns all the serviceses where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @return the matching serviceses
	 */
	@Override
	public List<Services> findByServiceType(String serviceType) {
		return findByServiceType(
			serviceType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Services> findByServiceType(
		String serviceType, int start, int end) {

		return findByServiceType(serviceType, start, end, null);
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
	@Override
	public List<Services> findByServiceType(
		String serviceType, int start, int end,
		OrderByComparator<Services> orderByComparator) {

		return findByServiceType(
			serviceType, start, end, orderByComparator, true);
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
	@Override
	public List<Services> findByServiceType(
		String serviceType, int start, int end,
		OrderByComparator<Services> orderByComparator, boolean useFinderCache) {

		serviceType = Objects.toString(serviceType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByServiceType;
				finderArgs = new Object[] {serviceType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByServiceType;
			finderArgs = new Object[] {
				serviceType, start, end, orderByComparator
			};
		}

		List<Services> list = null;

		if (useFinderCache) {
			list = (List<Services>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Services services : list) {
					if (!serviceType.equals(services.getServiceType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SERVICES_WHERE);

			boolean bindServiceType = false;

			if (serviceType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SERVICETYPE_SERVICETYPE_3);
			}
			else {
				bindServiceType = true;

				sb.append(_FINDER_COLUMN_SERVICETYPE_SERVICETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindServiceType) {
					queryPos.add(serviceType);
				}

				list = (List<Services>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	@Override
	public Services findByServiceType_First(
			String serviceType, OrderByComparator<Services> orderByComparator)
		throws NoSuchServicesException {

		Services services = fetchByServiceType_First(
			serviceType, orderByComparator);

		if (services != null) {
			return services;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("serviceType=");
		sb.append(serviceType);

		sb.append("}");

		throw new NoSuchServicesException(sb.toString());
	}

	/**
	 * Returns the first services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching services, or <code>null</code> if a matching services could not be found
	 */
	@Override
	public Services fetchByServiceType_First(
		String serviceType, OrderByComparator<Services> orderByComparator) {

		List<Services> list = findByServiceType(
			serviceType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services
	 * @throws NoSuchServicesException if a matching services could not be found
	 */
	@Override
	public Services findByServiceType_Last(
			String serviceType, OrderByComparator<Services> orderByComparator)
		throws NoSuchServicesException {

		Services services = fetchByServiceType_Last(
			serviceType, orderByComparator);

		if (services != null) {
			return services;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("serviceType=");
		sb.append(serviceType);

		sb.append("}");

		throw new NoSuchServicesException(sb.toString());
	}

	/**
	 * Returns the last services in the ordered set where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching services, or <code>null</code> if a matching services could not be found
	 */
	@Override
	public Services fetchByServiceType_Last(
		String serviceType, OrderByComparator<Services> orderByComparator) {

		int count = countByServiceType(serviceType);

		if (count == 0) {
			return null;
		}

		List<Services> list = findByServiceType(
			serviceType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Services[] findByServiceType_PrevAndNext(
			long serviceId, String serviceType,
			OrderByComparator<Services> orderByComparator)
		throws NoSuchServicesException {

		serviceType = Objects.toString(serviceType, "");

		Services services = findByPrimaryKey(serviceId);

		Session session = null;

		try {
			session = openSession();

			Services[] array = new ServicesImpl[3];

			array[0] = getByServiceType_PrevAndNext(
				session, services, serviceType, orderByComparator, true);

			array[1] = services;

			array[2] = getByServiceType_PrevAndNext(
				session, services, serviceType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Services getByServiceType_PrevAndNext(
		Session session, Services services, String serviceType,
		OrderByComparator<Services> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVICES_WHERE);

		boolean bindServiceType = false;

		if (serviceType.isEmpty()) {
			sb.append(_FINDER_COLUMN_SERVICETYPE_SERVICETYPE_3);
		}
		else {
			bindServiceType = true;

			sb.append(_FINDER_COLUMN_SERVICETYPE_SERVICETYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindServiceType) {
			queryPos.add(serviceType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(services)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Services> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the serviceses where serviceType = &#63; from the database.
	 *
	 * @param serviceType the service type
	 */
	@Override
	public void removeByServiceType(String serviceType) {
		for (Services services :
				findByServiceType(
					serviceType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(services);
		}
	}

	/**
	 * Returns the number of serviceses where serviceType = &#63;.
	 *
	 * @param serviceType the service type
	 * @return the number of matching serviceses
	 */
	@Override
	public int countByServiceType(String serviceType) {
		serviceType = Objects.toString(serviceType, "");

		FinderPath finderPath = _finderPathCountByServiceType;

		Object[] finderArgs = new Object[] {serviceType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICES_WHERE);

			boolean bindServiceType = false;

			if (serviceType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SERVICETYPE_SERVICETYPE_3);
			}
			else {
				bindServiceType = true;

				sb.append(_FINDER_COLUMN_SERVICETYPE_SERVICETYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindServiceType) {
					queryPos.add(serviceType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SERVICETYPE_SERVICETYPE_2 =
		"services.serviceType = ?";

	private static final String _FINDER_COLUMN_SERVICETYPE_SERVICETYPE_3 =
		"(services.serviceType IS NULL OR services.serviceType = '')";

	public ServicesPersistenceImpl() {
		setModelClass(Services.class);

		setModelImplClass(ServicesImpl.class);
		setModelPKClass(long.class);

		setTable(ServicesTable.INSTANCE);
	}

	/**
	 * Caches the services in the entity cache if it is enabled.
	 *
	 * @param services the services
	 */
	@Override
	public void cacheResult(Services services) {
		entityCache.putResult(
			ServicesImpl.class, services.getPrimaryKey(), services);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the serviceses in the entity cache if it is enabled.
	 *
	 * @param serviceses the serviceses
	 */
	@Override
	public void cacheResult(List<Services> serviceses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (serviceses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Services services : serviceses) {
			if (entityCache.getResult(
					ServicesImpl.class, services.getPrimaryKey()) == null) {

				cacheResult(services);
			}
		}
	}

	/**
	 * Clears the cache for all serviceses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServicesImpl.class);

		finderCache.clearCache(ServicesImpl.class);
	}

	/**
	 * Clears the cache for the services.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Services services) {
		entityCache.removeResult(ServicesImpl.class, services);
	}

	@Override
	public void clearCache(List<Services> serviceses) {
		for (Services services : serviceses) {
			entityCache.removeResult(ServicesImpl.class, services);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ServicesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ServicesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new services with the primary key. Does not add the services to the database.
	 *
	 * @param serviceId the primary key for the new services
	 * @return the new services
	 */
	@Override
	public Services create(long serviceId) {
		Services services = new ServicesImpl();

		services.setNew(true);
		services.setPrimaryKey(serviceId);

		services.setCompanyId(CompanyThreadLocal.getCompanyId());

		return services;
	}

	/**
	 * Removes the services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services that was removed
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	@Override
	public Services remove(long serviceId) throws NoSuchServicesException {
		return remove((Serializable)serviceId);
	}

	/**
	 * Removes the services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the services
	 * @return the services that was removed
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	@Override
	public Services remove(Serializable primaryKey)
		throws NoSuchServicesException {

		Session session = null;

		try {
			session = openSession();

			Services services = (Services)session.get(
				ServicesImpl.class, primaryKey);

			if (services == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServicesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(services);
		}
		catch (NoSuchServicesException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Services removeImpl(Services services) {
		servicesToCustomerTableMapper.deleteLeftPrimaryKeyTableMappings(
			services.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(services)) {
				services = (Services)session.get(
					ServicesImpl.class, services.getPrimaryKeyObj());
			}

			if (services != null) {
				session.delete(services);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (services != null) {
			clearCache(services);
		}

		return services;
	}

	@Override
	public Services updateImpl(Services services) {
		boolean isNew = services.isNew();

		if (!(services instanceof ServicesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(services.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(services);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in services proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Services implementation " +
					services.getClass());
		}

		ServicesModelImpl servicesModelImpl = (ServicesModelImpl)services;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (services.getCreateDate() == null)) {
			if (serviceContext == null) {
				services.setCreateDate(date);
			}
			else {
				services.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!servicesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				services.setModifiedDate(date);
			}
			else {
				services.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(services);
			}
			else {
				services = (Services)session.merge(services);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ServicesImpl.class, servicesModelImpl, false, true);

		if (isNew) {
			services.setNew(false);
		}

		services.resetOriginalValues();

		return services;
	}

	/**
	 * Returns the services with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the services
	 * @return the services
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	@Override
	public Services findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServicesException {

		Services services = fetchByPrimaryKey(primaryKey);

		if (services == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServicesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return services;
	}

	/**
	 * Returns the services with the primary key or throws a <code>NoSuchServicesException</code> if it could not be found.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services
	 * @throws NoSuchServicesException if a services with the primary key could not be found
	 */
	@Override
	public Services findByPrimaryKey(long serviceId)
		throws NoSuchServicesException {

		return findByPrimaryKey((Serializable)serviceId);
	}

	/**
	 * Returns the services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceId the primary key of the services
	 * @return the services, or <code>null</code> if a services with the primary key could not be found
	 */
	@Override
	public Services fetchByPrimaryKey(long serviceId) {
		return fetchByPrimaryKey((Serializable)serviceId);
	}

	/**
	 * Returns all the serviceses.
	 *
	 * @return the serviceses
	 */
	@Override
	public List<Services> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Services> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Services> findAll(
		int start, int end, OrderByComparator<Services> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Services> findAll(
		int start, int end, OrderByComparator<Services> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Services> list = null;

		if (useFinderCache) {
			list = (List<Services>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SERVICES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICES;

				sql = sql.concat(ServicesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Services>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the serviceses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Services services : findAll()) {
			remove(services);
		}
	}

	/**
	 * Returns the number of serviceses.
	 *
	 * @return the number of serviceses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SERVICES);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of customers associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @return long[] of the primaryKeys of customers associated with the services
	 */
	@Override
	public long[] getCustomerPrimaryKeys(long pk) {
		long[] pks = servicesToCustomerTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the services associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @return the serviceses associated with the customer
	 */
	@Override
	public List<Services> getCustomerServiceses(long pk) {
		return getCustomerServiceses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<Services> getCustomerServiceses(long pk, int start, int end) {
		return getCustomerServiceses(pk, start, end, null);
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
	@Override
	public List<Services> getCustomerServiceses(
		long pk, int start, int end,
		OrderByComparator<Services> orderByComparator) {

		return servicesToCustomerTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of customers associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @return the number of customers associated with the services
	 */
	@Override
	public int getCustomersSize(long pk) {
		long[] pks = servicesToCustomerTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the customer is associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @param customerPK the primary key of the customer
	 * @return <code>true</code> if the customer is associated with the services; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCustomer(long pk, long customerPK) {
		return servicesToCustomerTableMapper.containsTableMapping(
			pk, customerPK);
	}

	/**
	 * Returns <code>true</code> if the services has any customers associated with it.
	 *
	 * @param pk the primary key of the services to check for associations with customers
	 * @return <code>true</code> if the services has any customers associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCustomers(long pk) {
		if (getCustomersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPK the primary key of the customer
	 */
	@Override
	public void addCustomer(long pk, long customerPK) {
		Services services = fetchByPrimaryKey(pk);

		if (services == null) {
			servicesToCustomerTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, customerPK);
		}
		else {
			servicesToCustomerTableMapper.addTableMapping(
				services.getCompanyId(), pk, customerPK);
		}
	}

	/**
	 * Adds an association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customer the customer
	 */
	@Override
	public void addCustomer(long pk, Customer customer) {
		Services services = fetchByPrimaryKey(pk);

		if (services == null) {
			servicesToCustomerTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				customer.getPrimaryKey());
		}
		else {
			servicesToCustomerTableMapper.addTableMapping(
				services.getCompanyId(), pk, customer.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPKs the primary keys of the customers
	 */
	@Override
	public void addCustomers(long pk, long[] customerPKs) {
		long companyId = 0;

		Services services = fetchByPrimaryKey(pk);

		if (services == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = services.getCompanyId();
		}

		servicesToCustomerTableMapper.addTableMappings(
			companyId, pk, customerPKs);
	}

	/**
	 * Adds an association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customers the customers
	 */
	@Override
	public void addCustomers(long pk, List<Customer> customers) {
		addCustomers(
			pk, ListUtil.toLongArray(customers, Customer.CUSTOMER_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the services and its customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services to clear the associated customers from
	 */
	@Override
	public void clearCustomers(long pk) {
		servicesToCustomerTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPK the primary key of the customer
	 */
	@Override
	public void removeCustomer(long pk, long customerPK) {
		servicesToCustomerTableMapper.deleteTableMapping(pk, customerPK);
	}

	/**
	 * Removes the association between the services and the customer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customer the customer
	 */
	@Override
	public void removeCustomer(long pk, Customer customer) {
		servicesToCustomerTableMapper.deleteTableMapping(
			pk, customer.getPrimaryKey());
	}

	/**
	 * Removes the association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPKs the primary keys of the customers
	 */
	@Override
	public void removeCustomers(long pk, long[] customerPKs) {
		servicesToCustomerTableMapper.deleteTableMappings(pk, customerPKs);
	}

	/**
	 * Removes the association between the services and the customers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customers the customers
	 */
	@Override
	public void removeCustomers(long pk, List<Customer> customers) {
		removeCustomers(
			pk, ListUtil.toLongArray(customers, Customer.CUSTOMER_ID_ACCESSOR));
	}

	/**
	 * Sets the customers associated with the services, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customerPKs the primary keys of the customers to be associated with the services
	 */
	@Override
	public void setCustomers(long pk, long[] customerPKs) {
		Set<Long> newCustomerPKsSet = SetUtil.fromArray(customerPKs);
		Set<Long> oldCustomerPKsSet = SetUtil.fromArray(
			servicesToCustomerTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeCustomerPKsSet = new HashSet<Long>(oldCustomerPKsSet);

		removeCustomerPKsSet.removeAll(newCustomerPKsSet);

		servicesToCustomerTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeCustomerPKsSet));

		newCustomerPKsSet.removeAll(oldCustomerPKsSet);

		long companyId = 0;

		Services services = fetchByPrimaryKey(pk);

		if (services == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = services.getCompanyId();
		}

		servicesToCustomerTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newCustomerPKsSet));
	}

	/**
	 * Sets the customers associated with the services, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the services
	 * @param customers the customers to be associated with the services
	 */
	@Override
	public void setCustomers(long pk, List<Customer> customers) {
		try {
			long[] customerPKs = new long[customers.size()];

			for (int i = 0; i < customers.size(); i++) {
				Customer customer = customers.get(i);

				customerPKs[i] = customer.getPrimaryKey();
			}

			setCustomers(pk, customerPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "serviceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SERVICES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServicesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the services persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		servicesToCustomerTableMapper = TableMapperFactory.getTableMapper(
			"CM_Customers_Services#serviceId", "CM_Customers_Services",
			"companyId", "serviceId", "customerId", this, Customer.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByServiceType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"serviceType"}, true);

		_finderPathWithoutPaginationFindByServiceType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceType",
			new String[] {String.class.getName()}, new String[] {"serviceType"},
			true);

		_finderPathCountByServiceType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByServiceType",
			new String[] {String.class.getName()}, new String[] {"serviceType"},
			false);

		_setServicesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setServicesUtilPersistence(null);

		entityCache.removeCache(ServicesImpl.class.getName());

		TableMapperFactory.removeTableMapper("CM_Customers_Services#serviceId");
	}

	private void _setServicesUtilPersistence(
		ServicesPersistence servicesPersistence) {

		try {
			Field field = ServicesUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, servicesPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = CMPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	protected TableMapper<Services, Customer> servicesToCustomerTableMapper;

	private static final String _SQL_SELECT_SERVICES =
		"SELECT services FROM Services services";

	private static final String _SQL_SELECT_SERVICES_WHERE =
		"SELECT services FROM Services services WHERE ";

	private static final String _SQL_COUNT_SERVICES =
		"SELECT COUNT(services) FROM Services services";

	private static final String _SQL_COUNT_SERVICES_WHERE =
		"SELECT COUNT(services) FROM Services services WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "services.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Services exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Services exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ServicesPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ServicesModelArgumentsResolver _servicesModelArgumentsResolver;

}