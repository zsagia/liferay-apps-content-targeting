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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ABVersion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ABVersion
 * @generated
 */
public class ABVersionWrapper implements ABVersion, ModelWrapper<ABVersion> {
	public ABVersionWrapper(ABVersion abVersion) {
		_abVersion = abVersion;
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

	/**
	* Returns the primary key of this a b version.
	*
	* @return the primary key of this a b version
	*/
	@Override
	public long getPrimaryKey() {
		return _abVersion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this a b version.
	*
	* @param primaryKey the primary key of this a b version
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_abVersion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the abversion ID of this a b version.
	*
	* @return the abversion ID of this a b version
	*/
	@Override
	public long getAbversionId() {
		return _abVersion.getAbversionId();
	}

	/**
	* Sets the abversion ID of this a b version.
	*
	* @param abversionId the abversion ID of this a b version
	*/
	@Override
	public void setAbversionId(long abversionId) {
		_abVersion.setAbversionId(abversionId);
	}

	/**
	* Returns the campaign ID of this a b version.
	*
	* @return the campaign ID of this a b version
	*/
	@Override
	public long getCampaignId() {
		return _abVersion.getCampaignId();
	}

	/**
	* Sets the campaign ID of this a b version.
	*
	* @param campaignId the campaign ID of this a b version
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_abVersion.setCampaignId(campaignId);
	}

	/**
	* Returns the alias of this a b version.
	*
	* @return the alias of this a b version
	*/
	@Override
	public java.lang.String getAlias() {
		return _abVersion.getAlias();
	}

	/**
	* Sets the alias of this a b version.
	*
	* @param alias the alias of this a b version
	*/
	@Override
	public void setAlias(java.lang.String alias) {
		_abVersion.setAlias(alias);
	}

	/**
	* Returns the views count of this a b version.
	*
	* @return the views count of this a b version
	*/
	@Override
	public int getViewsCount() {
		return _abVersion.getViewsCount();
	}

	/**
	* Sets the views count of this a b version.
	*
	* @param viewsCount the views count of this a b version
	*/
	@Override
	public void setViewsCount(int viewsCount) {
		_abVersion.setViewsCount(viewsCount);
	}

	/**
	* Returns the goal count of this a b version.
	*
	* @return the goal count of this a b version
	*/
	@Override
	public int getGoalCount() {
		return _abVersion.getGoalCount();
	}

	/**
	* Sets the goal count of this a b version.
	*
	* @param goalCount the goal count of this a b version
	*/
	@Override
	public void setGoalCount(int goalCount) {
		_abVersion.setGoalCount(goalCount);
	}

	/**
	* Returns the modified date of this a b version.
	*
	* @return the modified date of this a b version
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _abVersion.getModifiedDate();
	}

	/**
	* Sets the modified date of this a b version.
	*
	* @param modifiedDate the modified date of this a b version
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_abVersion.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _abVersion.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_abVersion.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _abVersion.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_abVersion.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _abVersion.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _abVersion.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_abVersion.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _abVersion.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_abVersion.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_abVersion.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_abVersion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ABVersionWrapper((ABVersion)_abVersion.clone());
	}

	@Override
	public int compareTo(ABVersion abVersion) {
		return _abVersion.compareTo(abVersion);
	}

	@Override
	public int hashCode() {
		return _abVersion.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ABVersion> toCacheModel() {
		return _abVersion.toCacheModel();
	}

	@Override
	public ABVersion toEscapedModel() {
		return new ABVersionWrapper(_abVersion.toEscapedModel());
	}

	@Override
	public ABVersion toUnescapedModel() {
		return new ABVersionWrapper(_abVersion.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _abVersion.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _abVersion.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_abVersion.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ABVersionWrapper)) {
			return false;
		}

		ABVersionWrapper abVersionWrapper = (ABVersionWrapper)obj;

		if (Validator.equals(_abVersion, abVersionWrapper._abVersion)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ABVersion getWrappedABVersion() {
		return _abVersion;
	}

	@Override
	public ABVersion getWrappedModel() {
		return _abVersion;
	}

	@Override
	public void resetOriginalValues() {
		_abVersion.resetOriginalValues();
	}

	private ABVersion _abVersion;
}