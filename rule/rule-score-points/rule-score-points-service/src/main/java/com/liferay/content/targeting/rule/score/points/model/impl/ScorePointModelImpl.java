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

package com.liferay.content.targeting.rule.score.points.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.score.points.model.ScorePoint;
import com.liferay.content.targeting.rule.score.points.model.ScorePointModel;
import com.liferay.content.targeting.rule.score.points.model.ScorePointSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ScorePoint service. Represents a row in the &quot;CT_ScorePoints_ScorePoint&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ScorePointModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ScorePointImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointImpl
 * @see ScorePoint
 * @see ScorePointModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ScorePointModelImpl extends BaseModelImpl<ScorePoint>
	implements ScorePointModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a score point model instance should use the {@link ScorePoint} interface instead.
	 */
	public static final String TABLE_NAME = "CT_ScorePoints_ScorePoint";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "scorePointId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "anonymousUserId", Types.BIGINT },
			{ "userSegmentId", Types.BIGINT },
			{ "points", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("scorePointId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("anonymousUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userSegmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("points", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table CT_ScorePoints_ScorePoint (uuid_ VARCHAR(75) null,scorePointId LONG not null primary key,companyId LONG,anonymousUserId LONG,userSegmentId LONG,points LONG)";
	public static final String TABLE_SQL_DROP = "drop table CT_ScorePoints_ScorePoint";
	public static final String ORDER_BY_JPQL = " ORDER BY scorePoint.anonymousUserId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CT_ScorePoints_ScorePoint.anonymousUserId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.content.targeting.rule.score.points.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.content.targeting.rule.score.points.model.ScorePoint"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.content.targeting.rule.score.points.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.content.targeting.rule.score.points.model.ScorePoint"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.content.targeting.rule.score.points.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.content.targeting.rule.score.points.model.ScorePoint"),
			true);
	public static final long ANONYMOUSUSERID_COLUMN_BITMASK = 1L;
	public static final long COMPANYID_COLUMN_BITMASK = 2L;
	public static final long USERSEGMENTID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ScorePoint toModel(ScorePointSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ScorePoint model = new ScorePointImpl();

		model.setUuid(soapModel.getUuid());
		model.setScorePointId(soapModel.getScorePointId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setAnonymousUserId(soapModel.getAnonymousUserId());
		model.setUserSegmentId(soapModel.getUserSegmentId());
		model.setPoints(soapModel.getPoints());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ScorePoint> toModels(ScorePointSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ScorePoint> models = new ArrayList<ScorePoint>(soapModels.length);

		for (ScorePointSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.content.targeting.rule.score.points.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.content.targeting.rule.score.points.model.ScorePoint"));

	public ScorePointModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _scorePointId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScorePointId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scorePointId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ScorePoint.class;
	}

	@Override
	public String getModelClassName() {
		return ScorePoint.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("scorePointId", getScorePointId());
		attributes.put("companyId", getCompanyId());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("points", getPoints());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long scorePointId = (Long)attributes.get("scorePointId");

		if (scorePointId != null) {
			setScorePointId(scorePointId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		Long points = (Long)attributes.get("points");

		if (points != null) {
			setPoints(points);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getScorePointId() {
		return _scorePointId;
	}

	@Override
	public void setScorePointId(long scorePointId) {
		_scorePointId = scorePointId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_columnBitmask = -1L;

		if (!_setOriginalAnonymousUserId) {
			_setOriginalAnonymousUserId = true;

			_originalAnonymousUserId = _anonymousUserId;
		}

		_anonymousUserId = anonymousUserId;
	}

	@Override
	public String getAnonymousUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getAnonymousUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setAnonymousUserUuid(String anonymousUserUuid) {
	}

	public long getOriginalAnonymousUserId() {
		return _originalAnonymousUserId;
	}

	@JSON
	@Override
	public long getUserSegmentId() {
		return _userSegmentId;
	}

	@Override
	public void setUserSegmentId(long userSegmentId) {
		_columnBitmask |= USERSEGMENTID_COLUMN_BITMASK;

		if (!_setOriginalUserSegmentId) {
			_setOriginalUserSegmentId = true;

			_originalUserSegmentId = _userSegmentId;
		}

		_userSegmentId = userSegmentId;
	}

	public long getOriginalUserSegmentId() {
		return _originalUserSegmentId;
	}

	@JSON
	@Override
	public long getPoints() {
		return _points;
	}

	@Override
	public void setPoints(long points) {
		_points = points;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ScorePoint.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ScorePoint toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ScorePoint)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ScorePointImpl scorePointImpl = new ScorePointImpl();

		scorePointImpl.setUuid(getUuid());
		scorePointImpl.setScorePointId(getScorePointId());
		scorePointImpl.setCompanyId(getCompanyId());
		scorePointImpl.setAnonymousUserId(getAnonymousUserId());
		scorePointImpl.setUserSegmentId(getUserSegmentId());
		scorePointImpl.setPoints(getPoints());

		scorePointImpl.resetOriginalValues();

		return scorePointImpl;
	}

	@Override
	public int compareTo(ScorePoint scorePoint) {
		int value = 0;

		if (getAnonymousUserId() < scorePoint.getAnonymousUserId()) {
			value = -1;
		}
		else if (getAnonymousUserId() > scorePoint.getAnonymousUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScorePoint)) {
			return false;
		}

		ScorePoint scorePoint = (ScorePoint)obj;

		long primaryKey = scorePoint.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ScorePointModelImpl scorePointModelImpl = this;

		scorePointModelImpl._originalUuid = scorePointModelImpl._uuid;

		scorePointModelImpl._originalCompanyId = scorePointModelImpl._companyId;

		scorePointModelImpl._setOriginalCompanyId = false;

		scorePointModelImpl._originalAnonymousUserId = scorePointModelImpl._anonymousUserId;

		scorePointModelImpl._setOriginalAnonymousUserId = false;

		scorePointModelImpl._originalUserSegmentId = scorePointModelImpl._userSegmentId;

		scorePointModelImpl._setOriginalUserSegmentId = false;

		scorePointModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ScorePoint> toCacheModel() {
		ScorePointCacheModel scorePointCacheModel = new ScorePointCacheModel();

		scorePointCacheModel.uuid = getUuid();

		String uuid = scorePointCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			scorePointCacheModel.uuid = null;
		}

		scorePointCacheModel.scorePointId = getScorePointId();

		scorePointCacheModel.companyId = getCompanyId();

		scorePointCacheModel.anonymousUserId = getAnonymousUserId();

		scorePointCacheModel.userSegmentId = getUserSegmentId();

		scorePointCacheModel.points = getPoints();

		return scorePointCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", scorePointId=");
		sb.append(getScorePointId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", anonymousUserId=");
		sb.append(getAnonymousUserId());
		sb.append(", userSegmentId=");
		sb.append(getUserSegmentId());
		sb.append(", points=");
		sb.append(getPoints());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.content.targeting.rule.score.points.model.ScorePoint");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scorePointId</column-name><column-value><![CDATA[");
		sb.append(getScorePointId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anonymousUserId</column-name><column-value><![CDATA[");
		sb.append(getAnonymousUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userSegmentId</column-name><column-value><![CDATA[");
		sb.append(getUserSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>points</column-name><column-value><![CDATA[");
		sb.append(getPoints());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ScorePoint.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ScorePoint.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _scorePointId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _anonymousUserId;
	private long _originalAnonymousUserId;
	private boolean _setOriginalAnonymousUserId;
	private long _userSegmentId;
	private long _originalUserSegmentId;
	private boolean _setOriginalUserSegmentId;
	private long _points;
	private long _columnBitmask;
	private ScorePoint _escapedModel;
}