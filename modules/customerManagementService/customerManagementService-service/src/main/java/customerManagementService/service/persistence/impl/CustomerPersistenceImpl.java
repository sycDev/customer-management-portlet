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

import customerManagementService.exception.NoSuchCustomerException;

import customerManagementService.model.Customer;
import customerManagementService.model.CustomerTable;
import customerManagementService.model.Services;
import customerManagementService.model.impl.CustomerImpl;
import customerManagementService.model.impl.CustomerModelImpl;

import customerManagementService.service.persistence.CustomerPersistence;
import customerManagementService.service.persistence.CustomerUtil;
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
 * The persistence implementation for the customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sin Yi
 * @generated
 */
@Component(service = {CustomerPersistence.class, BasePersistence.class})
public class CustomerPersistenceImpl
	extends BasePersistenceImpl<Customer> implements CustomerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CustomerUtil</code> to access the customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CustomerImpl.class.getName();

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
	 * Returns all the customers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching customers
	 */
	@Override
	public List<Customer> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Customer> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Customer> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Customer> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Customer> orderByComparator, boolean useFinderCache) {

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

		List<Customer> list = null;

		if (useFinderCache) {
			list = (List<Customer>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Customer customer : list) {
					if (groupId != customer.getGroupId()) {
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

			sb.append(_SQL_SELECT_CUSTOMER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Customer>)QueryUtil.list(
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
	 * Returns the first customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	@Override
	public Customer findByGroupId_First(
			long groupId, OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		Customer customer = fetchByGroupId_First(groupId, orderByComparator);

		if (customer != null) {
			return customer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCustomerException(sb.toString());
	}

	/**
	 * Returns the first customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	@Override
	public Customer fetchByGroupId_First(
		long groupId, OrderByComparator<Customer> orderByComparator) {

		List<Customer> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	@Override
	public Customer findByGroupId_Last(
			long groupId, OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		Customer customer = fetchByGroupId_Last(groupId, orderByComparator);

		if (customer != null) {
			return customer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCustomerException(sb.toString());
	}

	/**
	 * Returns the last customer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	@Override
	public Customer fetchByGroupId_Last(
		long groupId, OrderByComparator<Customer> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Customer> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Customer[] findByGroupId_PrevAndNext(
			long customerId, long groupId,
			OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		Customer customer = findByPrimaryKey(customerId);

		Session session = null;

		try {
			session = openSession();

			Customer[] array = new CustomerImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, customer, groupId, orderByComparator, true);

			array[1] = customer;

			array[2] = getByGroupId_PrevAndNext(
				session, customer, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Customer getByGroupId_PrevAndNext(
		Session session, Customer customer, long groupId,
		OrderByComparator<Customer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CUSTOMER_WHERE);

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
			sb.append(CustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(customer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Customer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the customers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Customer customer :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(customer);
		}
	}

	/**
	 * Returns the number of customers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching customers
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTOMER_WHERE);

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
		"customer.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCustomerName;
	private FinderPath _finderPathWithoutPaginationFindByCustomerName;
	private FinderPath _finderPathCountByCustomerName;

	/**
	 * Returns all the customers where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @return the matching customers
	 */
	@Override
	public List<Customer> findByCustomerName(String customerName) {
		return findByCustomerName(
			customerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Customer> findByCustomerName(
		String customerName, int start, int end) {

		return findByCustomerName(customerName, start, end, null);
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
	@Override
	public List<Customer> findByCustomerName(
		String customerName, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return findByCustomerName(
			customerName, start, end, orderByComparator, true);
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
	@Override
	public List<Customer> findByCustomerName(
		String customerName, int start, int end,
		OrderByComparator<Customer> orderByComparator, boolean useFinderCache) {

		customerName = Objects.toString(customerName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCustomerName;
				finderArgs = new Object[] {customerName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCustomerName;
			finderArgs = new Object[] {
				customerName, start, end, orderByComparator
			};
		}

		List<Customer> list = null;

		if (useFinderCache) {
			list = (List<Customer>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Customer customer : list) {
					if (!customerName.equals(customer.getCustomerName())) {
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

			sb.append(_SQL_SELECT_CUSTOMER_WHERE);

			boolean bindCustomerName = false;

			if (customerName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_3);
			}
			else {
				bindCustomerName = true;

				sb.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustomerName) {
					queryPos.add(customerName);
				}

				list = (List<Customer>)QueryUtil.list(
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
	 * Returns the first customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	@Override
	public Customer findByCustomerName_First(
			String customerName, OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		Customer customer = fetchByCustomerName_First(
			customerName, orderByComparator);

		if (customer != null) {
			return customer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerName=");
		sb.append(customerName);

		sb.append("}");

		throw new NoSuchCustomerException(sb.toString());
	}

	/**
	 * Returns the first customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	@Override
	public Customer fetchByCustomerName_First(
		String customerName, OrderByComparator<Customer> orderByComparator) {

		List<Customer> list = findByCustomerName(
			customerName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	@Override
	public Customer findByCustomerName_Last(
			String customerName, OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		Customer customer = fetchByCustomerName_Last(
			customerName, orderByComparator);

		if (customer != null) {
			return customer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerName=");
		sb.append(customerName);

		sb.append("}");

		throw new NoSuchCustomerException(sb.toString());
	}

	/**
	 * Returns the last customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	@Override
	public Customer fetchByCustomerName_Last(
		String customerName, OrderByComparator<Customer> orderByComparator) {

		int count = countByCustomerName(customerName);

		if (count == 0) {
			return null;
		}

		List<Customer> list = findByCustomerName(
			customerName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Customer[] findByCustomerName_PrevAndNext(
			long customerId, String customerName,
			OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		customerName = Objects.toString(customerName, "");

		Customer customer = findByPrimaryKey(customerId);

		Session session = null;

		try {
			session = openSession();

			Customer[] array = new CustomerImpl[3];

			array[0] = getByCustomerName_PrevAndNext(
				session, customer, customerName, orderByComparator, true);

			array[1] = customer;

			array[2] = getByCustomerName_PrevAndNext(
				session, customer, customerName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Customer getByCustomerName_PrevAndNext(
		Session session, Customer customer, String customerName,
		OrderByComparator<Customer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CUSTOMER_WHERE);

		boolean bindCustomerName = false;

		if (customerName.isEmpty()) {
			sb.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_3);
		}
		else {
			bindCustomerName = true;

			sb.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_2);
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
			sb.append(CustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCustomerName) {
			queryPos.add(customerName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(customer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Customer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the customers where customerName = &#63; from the database.
	 *
	 * @param customerName the customer name
	 */
	@Override
	public void removeByCustomerName(String customerName) {
		for (Customer customer :
				findByCustomerName(
					customerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(customer);
		}
	}

	/**
	 * Returns the number of customers where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @return the number of matching customers
	 */
	@Override
	public int countByCustomerName(String customerName) {
		customerName = Objects.toString(customerName, "");

		FinderPath finderPath = _finderPathCountByCustomerName;

		Object[] finderArgs = new Object[] {customerName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTOMER_WHERE);

			boolean bindCustomerName = false;

			if (customerName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_3);
			}
			else {
				bindCustomerName = true;

				sb.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustomerName) {
					queryPos.add(customerName);
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

	private static final String _FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_2 =
		"customer.customerName = ?";

	private static final String _FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_3 =
		"(customer.customerName IS NULL OR customer.customerName = '')";

	public CustomerPersistenceImpl() {
		setModelClass(Customer.class);

		setModelImplClass(CustomerImpl.class);
		setModelPKClass(long.class);

		setTable(CustomerTable.INSTANCE);
	}

	/**
	 * Caches the customer in the entity cache if it is enabled.
	 *
	 * @param customer the customer
	 */
	@Override
	public void cacheResult(Customer customer) {
		entityCache.putResult(
			CustomerImpl.class, customer.getPrimaryKey(), customer);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the customers in the entity cache if it is enabled.
	 *
	 * @param customers the customers
	 */
	@Override
	public void cacheResult(List<Customer> customers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (customers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Customer customer : customers) {
			if (entityCache.getResult(
					CustomerImpl.class, customer.getPrimaryKey()) == null) {

				cacheResult(customer);
			}
		}
	}

	/**
	 * Clears the cache for all customers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomerImpl.class);

		finderCache.clearCache(CustomerImpl.class);
	}

	/**
	 * Clears the cache for the customer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Customer customer) {
		entityCache.removeResult(CustomerImpl.class, customer);
	}

	@Override
	public void clearCache(List<Customer> customers) {
		for (Customer customer : customers) {
			entityCache.removeResult(CustomerImpl.class, customer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CustomerImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CustomerImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new customer with the primary key. Does not add the customer to the database.
	 *
	 * @param customerId the primary key for the new customer
	 * @return the new customer
	 */
	@Override
	public Customer create(long customerId) {
		Customer customer = new CustomerImpl();

		customer.setNew(true);
		customer.setPrimaryKey(customerId);

		customer.setCompanyId(CompanyThreadLocal.getCompanyId());

		return customer;
	}

	/**
	 * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer that was removed
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	@Override
	public Customer remove(long customerId) throws NoSuchCustomerException {
		return remove((Serializable)customerId);
	}

	/**
	 * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the customer
	 * @return the customer that was removed
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	@Override
	public Customer remove(Serializable primaryKey)
		throws NoSuchCustomerException {

		Session session = null;

		try {
			session = openSession();

			Customer customer = (Customer)session.get(
				CustomerImpl.class, primaryKey);

			if (customer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(customer);
		}
		catch (NoSuchCustomerException noSuchEntityException) {
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
	protected Customer removeImpl(Customer customer) {
		customerToServicesTableMapper.deleteLeftPrimaryKeyTableMappings(
			customer.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customer)) {
				customer = (Customer)session.get(
					CustomerImpl.class, customer.getPrimaryKeyObj());
			}

			if (customer != null) {
				session.delete(customer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (customer != null) {
			clearCache(customer);
		}

		return customer;
	}

	@Override
	public Customer updateImpl(Customer customer) {
		boolean isNew = customer.isNew();

		if (!(customer instanceof CustomerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(customer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(customer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in customer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Customer implementation " +
					customer.getClass());
		}

		CustomerModelImpl customerModelImpl = (CustomerModelImpl)customer;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (customer.getCreateDate() == null)) {
			if (serviceContext == null) {
				customer.setCreateDate(date);
			}
			else {
				customer.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!customerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				customer.setModifiedDate(date);
			}
			else {
				customer.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(customer);
			}
			else {
				customer = (Customer)session.merge(customer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CustomerImpl.class, customerModelImpl, false, true);

		if (isNew) {
			customer.setNew(false);
		}

		customer.resetOriginalValues();

		return customer;
	}

	/**
	 * Returns the customer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer
	 * @return the customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	@Override
	public Customer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomerException {

		Customer customer = fetchByPrimaryKey(primaryKey);

		if (customer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return customer;
	}

	/**
	 * Returns the customer with the primary key or throws a <code>NoSuchCustomerException</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	@Override
	public Customer findByPrimaryKey(long customerId)
		throws NoSuchCustomerException {

		return findByPrimaryKey((Serializable)customerId);
	}

	/**
	 * Returns the customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer, or <code>null</code> if a customer with the primary key could not be found
	 */
	@Override
	public Customer fetchByPrimaryKey(long customerId) {
		return fetchByPrimaryKey((Serializable)customerId);
	}

	/**
	 * Returns all the customers.
	 *
	 * @return the customers
	 */
	@Override
	public List<Customer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Customer> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Customer> findAll(
		int start, int end, OrderByComparator<Customer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Customer> findAll(
		int start, int end, OrderByComparator<Customer> orderByComparator,
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

		List<Customer> list = null;

		if (useFinderCache) {
			list = (List<Customer>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CUSTOMER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMER;

				sql = sql.concat(CustomerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Customer>)QueryUtil.list(
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
	 * Removes all the customers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Customer customer : findAll()) {
			remove(customer);
		}
	}

	/**
	 * Returns the number of customers.
	 *
	 * @return the number of customers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CUSTOMER);

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
	 * Returns the primaryKeys of serviceses associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @return long[] of the primaryKeys of serviceses associated with the customer
	 */
	@Override
	public long[] getServicesPrimaryKeys(long pk) {
		long[] pks = customerToServicesTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the customer associated with the services.
	 *
	 * @param pk the primary key of the services
	 * @return the customers associated with the services
	 */
	@Override
	public List<Customer> getServicesCustomers(long pk) {
		return getServicesCustomers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<Customer> getServicesCustomers(long pk, int start, int end) {
		return getServicesCustomers(pk, start, end, null);
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
	@Override
	public List<Customer> getServicesCustomers(
		long pk, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return customerToServicesTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of serviceses associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @return the number of serviceses associated with the customer
	 */
	@Override
	public int getServicesesSize(long pk) {
		long[] pks = customerToServicesTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the services is associated with the customer.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPK the primary key of the services
	 * @return <code>true</code> if the services is associated with the customer; <code>false</code> otherwise
	 */
	@Override
	public boolean containsServices(long pk, long servicesPK) {
		return customerToServicesTableMapper.containsTableMapping(
			pk, servicesPK);
	}

	/**
	 * Returns <code>true</code> if the customer has any serviceses associated with it.
	 *
	 * @param pk the primary key of the customer to check for associations with serviceses
	 * @return <code>true</code> if the customer has any serviceses associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsServiceses(long pk) {
		if (getServicesesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPK the primary key of the services
	 */
	@Override
	public void addServices(long pk, long servicesPK) {
		Customer customer = fetchByPrimaryKey(pk);

		if (customer == null) {
			customerToServicesTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, servicesPK);
		}
		else {
			customerToServicesTableMapper.addTableMapping(
				customer.getCompanyId(), pk, servicesPK);
		}
	}

	/**
	 * Adds an association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param services the services
	 */
	@Override
	public void addServices(long pk, Services services) {
		Customer customer = fetchByPrimaryKey(pk);

		if (customer == null) {
			customerToServicesTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				services.getPrimaryKey());
		}
		else {
			customerToServicesTableMapper.addTableMapping(
				customer.getCompanyId(), pk, services.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPKs the primary keys of the serviceses
	 */
	@Override
	public void addServiceses(long pk, long[] servicesPKs) {
		long companyId = 0;

		Customer customer = fetchByPrimaryKey(pk);

		if (customer == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = customer.getCompanyId();
		}

		customerToServicesTableMapper.addTableMappings(
			companyId, pk, servicesPKs);
	}

	/**
	 * Adds an association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param serviceses the serviceses
	 */
	@Override
	public void addServiceses(long pk, List<Services> serviceses) {
		addServiceses(
			pk, ListUtil.toLongArray(serviceses, Services.SERVICE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the customer and its serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer to clear the associated serviceses from
	 */
	@Override
	public void clearServiceses(long pk) {
		customerToServicesTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPK the primary key of the services
	 */
	@Override
	public void removeServices(long pk, long servicesPK) {
		customerToServicesTableMapper.deleteTableMapping(pk, servicesPK);
	}

	/**
	 * Removes the association between the customer and the services. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param services the services
	 */
	@Override
	public void removeServices(long pk, Services services) {
		customerToServicesTableMapper.deleteTableMapping(
			pk, services.getPrimaryKey());
	}

	/**
	 * Removes the association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPKs the primary keys of the serviceses
	 */
	@Override
	public void removeServiceses(long pk, long[] servicesPKs) {
		customerToServicesTableMapper.deleteTableMappings(pk, servicesPKs);
	}

	/**
	 * Removes the association between the customer and the serviceses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param serviceses the serviceses
	 */
	@Override
	public void removeServiceses(long pk, List<Services> serviceses) {
		removeServiceses(
			pk, ListUtil.toLongArray(serviceses, Services.SERVICE_ID_ACCESSOR));
	}

	/**
	 * Sets the serviceses associated with the customer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param servicesPKs the primary keys of the serviceses to be associated with the customer
	 */
	@Override
	public void setServiceses(long pk, long[] servicesPKs) {
		Set<Long> newServicesPKsSet = SetUtil.fromArray(servicesPKs);
		Set<Long> oldServicesPKsSet = SetUtil.fromArray(
			customerToServicesTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeServicesPKsSet = new HashSet<Long>(oldServicesPKsSet);

		removeServicesPKsSet.removeAll(newServicesPKsSet);

		customerToServicesTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeServicesPKsSet));

		newServicesPKsSet.removeAll(oldServicesPKsSet);

		long companyId = 0;

		Customer customer = fetchByPrimaryKey(pk);

		if (customer == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = customer.getCompanyId();
		}

		customerToServicesTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newServicesPKsSet));
	}

	/**
	 * Sets the serviceses associated with the customer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the customer
	 * @param serviceses the serviceses to be associated with the customer
	 */
	@Override
	public void setServiceses(long pk, List<Services> serviceses) {
		try {
			long[] servicesPKs = new long[serviceses.size()];

			for (int i = 0; i < serviceses.size(); i++) {
				Services services = serviceses.get(i);

				servicesPKs[i] = services.getPrimaryKey();
			}

			setServiceses(pk, servicesPKs);
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
		return "customerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTOMER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the customer persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		customerToServicesTableMapper = TableMapperFactory.getTableMapper(
			"CM_Customers_Services#customerId", "CM_Customers_Services",
			"companyId", "customerId", "serviceId", this, Services.class);

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

		_finderPathWithPaginationFindByCustomerName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomerName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"customerName"}, true);

		_finderPathWithoutPaginationFindByCustomerName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCustomerName",
			new String[] {String.class.getName()},
			new String[] {"customerName"}, true);

		_finderPathCountByCustomerName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCustomerName",
			new String[] {String.class.getName()},
			new String[] {"customerName"}, false);

		_setCustomerUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCustomerUtilPersistence(null);

		entityCache.removeCache(CustomerImpl.class.getName());

		TableMapperFactory.removeTableMapper(
			"CM_Customers_Services#customerId");
	}

	private void _setCustomerUtilPersistence(
		CustomerPersistence customerPersistence) {

		try {
			Field field = CustomerUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, customerPersistence);
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

	protected TableMapper<Customer, Services> customerToServicesTableMapper;

	private static final String _SQL_SELECT_CUSTOMER =
		"SELECT customer FROM Customer customer";

	private static final String _SQL_SELECT_CUSTOMER_WHERE =
		"SELECT customer FROM Customer customer WHERE ";

	private static final String _SQL_COUNT_CUSTOMER =
		"SELECT COUNT(customer) FROM Customer customer";

	private static final String _SQL_COUNT_CUSTOMER_WHERE =
		"SELECT COUNT(customer) FROM Customer customer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "customer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Customer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Customer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CustomerPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CustomerModelArgumentsResolver _customerModelArgumentsResolver;

}