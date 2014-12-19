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

package com.liferay.content.targeting.report.campaign.newsletter.model;

import com.liferay.content.targeting.report.campaign.newsletter.service.ABVersionLocalServiceUtil;
import com.liferay.content.targeting.report.campaign.newsletter.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class ABVersionClp extends BaseModelImpl<ABVersion> implements ABVersion {
	public ABVersionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ABVersion.class;
	}

	@Override
	public String getModelClassName() {
		return ABVersion.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _abversionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAbversionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _abversionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("abversionId", getAbversionId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("alias", getAlias());
		attributes.put("viewsCount", getViewsCount());
		attributes.put("goalCount", getGoalCount());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long abversionId = (Long)attributes.get("abversionId");

		if (abversionId != null) {
			setAbversionId(abversionId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
		}

		Integer viewsCount = (Integer)attributes.get("viewsCount");

		if (viewsCount != null) {
			setViewsCount(viewsCount);
		}

		Integer goalCount = (Integer)attributes.get("goalCount");

		if (goalCount != null) {
			setGoalCount(goalCount);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getAbversionId() {
		return _abversionId;
	}

	@Override
	public void setAbversionId(long abversionId) {
		_abversionId = abversionId;

		if (_abVersionRemoteModel != null) {
			try {
				Class<?> clazz = _abVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setAbversionId", long.class);

				method.invoke(_abVersionRemoteModel, abversionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCampaignId() {
		return _campaignId;
	}

	@Override
	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;

		if (_abVersionRemoteModel != null) {
			try {
				Class<?> clazz = _abVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignId", long.class);

				method.invoke(_abVersionRemoteModel, campaignId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAlias() {
		return _alias;
	}

	@Override
	public void setAlias(String alias) {
		_alias = alias;

		if (_abVersionRemoteModel != null) {
			try {
				Class<?> clazz = _abVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setAlias", String.class);

				method.invoke(_abVersionRemoteModel, alias);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getViewsCount() {
		return _viewsCount;
	}

	@Override
	public void setViewsCount(int viewsCount) {
		_viewsCount = viewsCount;

		if (_abVersionRemoteModel != null) {
			try {
				Class<?> clazz = _abVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setViewsCount", int.class);

				method.invoke(_abVersionRemoteModel, viewsCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGoalCount() {
		return _goalCount;
	}

	@Override
	public void setGoalCount(int goalCount) {
		_goalCount = goalCount;

		if (_abVersionRemoteModel != null) {
			try {
				Class<?> clazz = _abVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setGoalCount", int.class);

				method.invoke(_abVersionRemoteModel, goalCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_abVersionRemoteModel != null) {
			try {
				Class<?> clazz = _abVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_abVersionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getABVersionRemoteModel() {
		return _abVersionRemoteModel;
	}

	public void setABVersionRemoteModel(BaseModel<?> abVersionRemoteModel) {
		_abVersionRemoteModel = abVersionRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _abVersionRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_abVersionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ABVersionLocalServiceUtil.addABVersion(this);
		}
		else {
			ABVersionLocalServiceUtil.updateABVersion(this);
		}
	}

	@Override
	public ABVersion toEscapedModel() {
		return (ABVersion)ProxyUtil.newProxyInstance(ABVersion.class.getClassLoader(),
			new Class[] { ABVersion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ABVersionClp clone = new ABVersionClp();

		clone.setAbversionId(getAbversionId());
		clone.setCampaignId(getCampaignId());
		clone.setAlias(getAlias());
		clone.setViewsCount(getViewsCount());
		clone.setGoalCount(getGoalCount());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(ABVersion abVersion) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				abVersion.getModifiedDate());

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

		if (!(obj instanceof ABVersionClp)) {
			return false;
		}

		ABVersionClp abVersion = (ABVersionClp)obj;

		long primaryKey = abVersion.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{abversionId=");
		sb.append(getAbversionId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", alias=");
		sb.append(getAlias());
		sb.append(", viewsCount=");
		sb.append(getViewsCount());
		sb.append(", goalCount=");
		sb.append(getGoalCount());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>abversionId</column-name><column-value><![CDATA[");
		sb.append(getAbversionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>alias</column-name><column-value><![CDATA[");
		sb.append(getAlias());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewsCount</column-name><column-value><![CDATA[");
		sb.append(getViewsCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>goalCount</column-name><column-value><![CDATA[");
		sb.append(getGoalCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _abversionId;
	private long _campaignId;
	private String _alias;
	private int _viewsCount;
	private int _goalCount;
	private Date _modifiedDate;
	private BaseModel<?> _abVersionRemoteModel;
}