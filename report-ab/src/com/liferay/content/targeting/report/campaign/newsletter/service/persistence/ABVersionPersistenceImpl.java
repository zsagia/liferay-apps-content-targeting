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

package com.liferay.content.targeting.report.campaign.newsletter.service.persistence;

import com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException;
import com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion;
import com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionImpl;
import com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the a b version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ABVersionPersistence
 * @see ABVersionUtil
 * @generated
 */
public class ABVersionPersistenceImpl extends BasePersistenceImpl<ABVersion>
	implements ABVersionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ABVersionUtil} to access the a b version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ABVersionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionModelImpl.FINDER_CACHE_ENABLED, ABVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionModelImpl.FINDER_CACHE_ENABLED, ABVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionModelImpl.FINDER_CACHE_ENABLED, ABVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionModelImpl.FINDER_CACHE_ENABLED, ABVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			ABVersionModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			ABVersionModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the a b versions where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching a b versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ABVersion> findByCampaignId(long campaignId)
		throws SystemException {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a b versions where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of a b versions
	 * @param end the upper bound of the range of a b versions (not inclusive)
	 * @return the range of matching a b versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ABVersion> findByCampaignId(long campaignId, int start, int end)
		throws SystemException {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a b versions where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of a b versions
	 * @param end the upper bound of the range of a b versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a b versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ABVersion> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID;
			finderArgs = new Object[] { campaignId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID;
			finderArgs = new Object[] { campaignId, start, end, orderByComparator };
		}

		List<ABVersion> list = (List<ABVersion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ABVersion abVersion : list) {
				if ((campaignId != abVersion.getCampaignId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ABVERSION_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ABVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<ABVersion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ABVersion>(list);
				}
				else {
					list = (List<ABVersion>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first a b version in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a b version
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a matching a b version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion findByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchABVersionException, SystemException {
		ABVersion abVersion = fetchByCampaignId_First(campaignId,
				orderByComparator);

		if (abVersion != null) {
			return abVersion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchABVersionException(msg.toString());
	}

	/**
	 * Returns the first a b version in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a b version, or <code>null</code> if a matching a b version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion fetchByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ABVersion> list = findByCampaignId(campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a b version in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a b version
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a matching a b version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion findByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchABVersionException, SystemException {
		ABVersion abVersion = fetchByCampaignId_Last(campaignId,
				orderByComparator);

		if (abVersion != null) {
			return abVersion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchABVersionException(msg.toString());
	}

	/**
	 * Returns the last a b version in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a b version, or <code>null</code> if a matching a b version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion fetchByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<ABVersion> list = findByCampaignId(campaignId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a b versions before and after the current a b version in the ordered set where campaignId = &#63;.
	 *
	 * @param abversionId the primary key of the current a b version
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a b version
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a a b version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion[] findByCampaignId_PrevAndNext(long abversionId,
		long campaignId, OrderByComparator orderByComparator)
		throws NoSuchABVersionException, SystemException {
		ABVersion abVersion = findByPrimaryKey(abversionId);

		Session session = null;

		try {
			session = openSession();

			ABVersion[] array = new ABVersionImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, abVersion,
					campaignId, orderByComparator, true);

			array[1] = abVersion;

			array[2] = getByCampaignId_PrevAndNext(session, abVersion,
					campaignId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ABVersion getByCampaignId_PrevAndNext(Session session,
		ABVersion abVersion, long campaignId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ABVERSION_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ABVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(abVersion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ABVersion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a b versions where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long campaignId) throws SystemException {
		for (ABVersion abVersion : findByCampaignId(campaignId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(abVersion);
		}
	}

	/**
	 * Returns the number of a b versions where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching a b versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignId(long campaignId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNID;

		Object[] finderArgs = new Object[] { campaignId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ABVERSION_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "abVersion.campaignId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_D = new FinderPath(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionModelImpl.FINDER_CACHE_ENABLED, ABVersionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_D",
			new String[] { Long.class.getName(), String.class.getName() },
			ABVersionModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			ABVersionModelImpl.ALIAS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_D = new FinderPath(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_D",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the a b version where campaignId = &#63; and alias = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException} if it could not be found.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @return the matching a b version
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a matching a b version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion findByC_D(long campaignId, String alias)
		throws NoSuchABVersionException, SystemException {
		ABVersion abVersion = fetchByC_D(campaignId, alias);

		if (abVersion == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

			msg.append(", alias=");
			msg.append(alias);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchABVersionException(msg.toString());
		}

		return abVersion;
	}

	/**
	 * Returns the a b version where campaignId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @return the matching a b version, or <code>null</code> if a matching a b version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion fetchByC_D(long campaignId, String alias)
		throws SystemException {
		return fetchByC_D(campaignId, alias, true);
	}

	/**
	 * Returns the a b version where campaignId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching a b version, or <code>null</code> if a matching a b version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion fetchByC_D(long campaignId, String alias,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { campaignId, alias };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_D,
					finderArgs, this);
		}

		if (result instanceof ABVersion) {
			ABVersion abVersion = (ABVersion)result;

			if ((campaignId != abVersion.getCampaignId()) ||
					!Validator.equals(alias, abVersion.getAlias())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ABVERSION_WHERE);

			query.append(_FINDER_COLUMN_C_D_CAMPAIGNID_2);

			boolean bindAlias = false;

			if (alias == null) {
				query.append(_FINDER_COLUMN_C_D_ALIAS_1);
			}
			else if (alias.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_D_ALIAS_3);
			}
			else {
				bindAlias = true;

				query.append(_FINDER_COLUMN_C_D_ALIAS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindAlias) {
					qPos.add(alias);
				}

				List<ABVersion> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_D,
						finderArgs, list);
				}
				else {
					ABVersion abVersion = list.get(0);

					result = abVersion;

					cacheResult(abVersion);

					if ((abVersion.getCampaignId() != campaignId) ||
							(abVersion.getAlias() == null) ||
							!abVersion.getAlias().equals(alias)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_D,
							finderArgs, abVersion);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_D,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ABVersion)result;
		}
	}

	/**
	 * Removes the a b version where campaignId = &#63; and alias = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @return the a b version that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion removeByC_D(long campaignId, String alias)
		throws NoSuchABVersionException, SystemException {
		ABVersion abVersion = findByC_D(campaignId, alias);

		return remove(abVersion);
	}

	/**
	 * Returns the number of a b versions where campaignId = &#63; and alias = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @return the number of matching a b versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_D(long campaignId, String alias)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_D;

		Object[] finderArgs = new Object[] { campaignId, alias };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ABVERSION_WHERE);

			query.append(_FINDER_COLUMN_C_D_CAMPAIGNID_2);

			boolean bindAlias = false;

			if (alias == null) {
				query.append(_FINDER_COLUMN_C_D_ALIAS_1);
			}
			else if (alias.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_D_ALIAS_3);
			}
			else {
				bindAlias = true;

				query.append(_FINDER_COLUMN_C_D_ALIAS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindAlias) {
					qPos.add(alias);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_D_CAMPAIGNID_2 = "abVersion.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_D_ALIAS_1 = "abVersion.alias IS NULL";
	private static final String _FINDER_COLUMN_C_D_ALIAS_2 = "abVersion.alias = ?";
	private static final String _FINDER_COLUMN_C_D_ALIAS_3 = "(abVersion.alias IS NULL OR abVersion.alias = '')";

	public ABVersionPersistenceImpl() {
		setModelClass(ABVersion.class);
	}

	/**
	 * Caches the a b version in the entity cache if it is enabled.
	 *
	 * @param abVersion the a b version
	 */
	@Override
	public void cacheResult(ABVersion abVersion) {
		EntityCacheUtil.putResult(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionImpl.class, abVersion.getPrimaryKey(), abVersion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_D,
			new Object[] { abVersion.getCampaignId(), abVersion.getAlias() },
			abVersion);

		abVersion.resetOriginalValues();
	}

	/**
	 * Caches the a b versions in the entity cache if it is enabled.
	 *
	 * @param abVersions the a b versions
	 */
	@Override
	public void cacheResult(List<ABVersion> abVersions) {
		for (ABVersion abVersion : abVersions) {
			if (EntityCacheUtil.getResult(
						ABVersionModelImpl.ENTITY_CACHE_ENABLED,
						ABVersionImpl.class, abVersion.getPrimaryKey()) == null) {
				cacheResult(abVersion);
			}
			else {
				abVersion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all a b versions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ABVersionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ABVersionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the a b version.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ABVersion abVersion) {
		EntityCacheUtil.removeResult(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionImpl.class, abVersion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(abVersion);
	}

	@Override
	public void clearCache(List<ABVersion> abVersions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ABVersion abVersion : abVersions) {
			EntityCacheUtil.removeResult(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
				ABVersionImpl.class, abVersion.getPrimaryKey());

			clearUniqueFindersCache(abVersion);
		}
	}

	protected void cacheUniqueFindersCache(ABVersion abVersion) {
		if (abVersion.isNew()) {
			Object[] args = new Object[] {
					abVersion.getCampaignId(), abVersion.getAlias()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_D, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_D, args, abVersion);
		}
		else {
			ABVersionModelImpl abVersionModelImpl = (ABVersionModelImpl)abVersion;

			if ((abVersionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						abVersion.getCampaignId(), abVersion.getAlias()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_D, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_D, args,
					abVersion);
			}
		}
	}

	protected void clearUniqueFindersCache(ABVersion abVersion) {
		ABVersionModelImpl abVersionModelImpl = (ABVersionModelImpl)abVersion;

		Object[] args = new Object[] {
				abVersion.getCampaignId(), abVersion.getAlias()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_D, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_D, args);

		if ((abVersionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_D.getColumnBitmask()) != 0) {
			args = new Object[] {
					abVersionModelImpl.getOriginalCampaignId(),
					abVersionModelImpl.getOriginalAlias()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_D, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_D, args);
		}
	}

	/**
	 * Creates a new a b version with the primary key. Does not add the a b version to the database.
	 *
	 * @param abversionId the primary key for the new a b version
	 * @return the new a b version
	 */
	@Override
	public ABVersion create(long abversionId) {
		ABVersion abVersion = new ABVersionImpl();

		abVersion.setNew(true);
		abVersion.setPrimaryKey(abversionId);

		return abVersion;
	}

	/**
	 * Removes the a b version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param abversionId the primary key of the a b version
	 * @return the a b version that was removed
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a a b version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion remove(long abversionId)
		throws NoSuchABVersionException, SystemException {
		return remove((Serializable)abversionId);
	}

	/**
	 * Removes the a b version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the a b version
	 * @return the a b version that was removed
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a a b version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion remove(Serializable primaryKey)
		throws NoSuchABVersionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ABVersion abVersion = (ABVersion)session.get(ABVersionImpl.class,
					primaryKey);

			if (abVersion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchABVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(abVersion);
		}
		catch (NoSuchABVersionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ABVersion removeImpl(ABVersion abVersion)
		throws SystemException {
		abVersion = toUnwrappedModel(abVersion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(abVersion)) {
				abVersion = (ABVersion)session.get(ABVersionImpl.class,
						abVersion.getPrimaryKeyObj());
			}

			if (abVersion != null) {
				session.delete(abVersion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (abVersion != null) {
			clearCache(abVersion);
		}

		return abVersion;
	}

	@Override
	public ABVersion updateImpl(
		com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion abVersion)
		throws SystemException {
		abVersion = toUnwrappedModel(abVersion);

		boolean isNew = abVersion.isNew();

		ABVersionModelImpl abVersionModelImpl = (ABVersionModelImpl)abVersion;

		Session session = null;

		try {
			session = openSession();

			if (abVersion.isNew()) {
				session.save(abVersion);

				abVersion.setNew(false);
			}
			else {
				session.merge(abVersion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ABVersionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((abVersionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						abVersionModelImpl.getOriginalCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { abVersionModelImpl.getCampaignId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}
		}

		EntityCacheUtil.putResult(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
			ABVersionImpl.class, abVersion.getPrimaryKey(), abVersion);

		clearUniqueFindersCache(abVersion);
		cacheUniqueFindersCache(abVersion);

		return abVersion;
	}

	protected ABVersion toUnwrappedModel(ABVersion abVersion) {
		if (abVersion instanceof ABVersionImpl) {
			return abVersion;
		}

		ABVersionImpl abVersionImpl = new ABVersionImpl();

		abVersionImpl.setNew(abVersion.isNew());
		abVersionImpl.setPrimaryKey(abVersion.getPrimaryKey());

		abVersionImpl.setAbversionId(abVersion.getAbversionId());
		abVersionImpl.setCampaignId(abVersion.getCampaignId());
		abVersionImpl.setAlias(abVersion.getAlias());
		abVersionImpl.setViewsCount(abVersion.getViewsCount());
		abVersionImpl.setGoalCount(abVersion.getGoalCount());
		abVersionImpl.setModifiedDate(abVersion.getModifiedDate());

		return abVersionImpl;
	}

	/**
	 * Returns the a b version with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the a b version
	 * @return the a b version
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a a b version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchABVersionException, SystemException {
		ABVersion abVersion = fetchByPrimaryKey(primaryKey);

		if (abVersion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchABVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return abVersion;
	}

	/**
	 * Returns the a b version with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException} if it could not be found.
	 *
	 * @param abversionId the primary key of the a b version
	 * @return the a b version
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a a b version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion findByPrimaryKey(long abversionId)
		throws NoSuchABVersionException, SystemException {
		return findByPrimaryKey((Serializable)abversionId);
	}

	/**
	 * Returns the a b version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the a b version
	 * @return the a b version, or <code>null</code> if a a b version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ABVersion abVersion = (ABVersion)EntityCacheUtil.getResult(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
				ABVersionImpl.class, primaryKey);

		if (abVersion == _nullABVersion) {
			return null;
		}

		if (abVersion == null) {
			Session session = null;

			try {
				session = openSession();

				abVersion = (ABVersion)session.get(ABVersionImpl.class,
						primaryKey);

				if (abVersion != null) {
					cacheResult(abVersion);
				}
				else {
					EntityCacheUtil.putResult(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
						ABVersionImpl.class, primaryKey, _nullABVersion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ABVersionModelImpl.ENTITY_CACHE_ENABLED,
					ABVersionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return abVersion;
	}

	/**
	 * Returns the a b version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param abversionId the primary key of the a b version
	 * @return the a b version, or <code>null</code> if a a b version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ABVersion fetchByPrimaryKey(long abversionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)abversionId);
	}

	/**
	 * Returns all the a b versions.
	 *
	 * @return the a b versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ABVersion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a b versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a b versions
	 * @param end the upper bound of the range of a b versions (not inclusive)
	 * @return the range of a b versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ABVersion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the a b versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a b versions
	 * @param end the upper bound of the range of a b versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a b versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ABVersion> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ABVersion> list = (List<ABVersion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ABVERSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ABVERSION;

				if (pagination) {
					sql = sql.concat(ABVersionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ABVersion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ABVersion>(list);
				}
				else {
					list = (List<ABVersion>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the a b versions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ABVersion abVersion : findAll()) {
			remove(abVersion);
		}
	}

	/**
	 * Returns the number of a b versions.
	 *
	 * @return the number of a b versions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ABVERSION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the a b version persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ABVersion>> listenersList = new ArrayList<ModelListener<ABVersion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ABVersion>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ABVersionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ABVERSION = "SELECT abVersion FROM ABVersion abVersion";
	private static final String _SQL_SELECT_ABVERSION_WHERE = "SELECT abVersion FROM ABVersion abVersion WHERE ";
	private static final String _SQL_COUNT_ABVERSION = "SELECT COUNT(abVersion) FROM ABVersion abVersion";
	private static final String _SQL_COUNT_ABVERSION_WHERE = "SELECT COUNT(abVersion) FROM ABVersion abVersion WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "abVersion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ABVersion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ABVersion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ABVersionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"alias"
			});
	private static ABVersion _nullABVersion = new ABVersionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ABVersion> toCacheModel() {
				return _nullABVersionCacheModel;
			}
		};

	private static CacheModel<ABVersion> _nullABVersionCacheModel = new CacheModel<ABVersion>() {
			@Override
			public ABVersion toEntityModel() {
				return _nullABVersion;
			}
		};
}