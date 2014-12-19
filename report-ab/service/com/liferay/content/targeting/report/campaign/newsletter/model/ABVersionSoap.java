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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.report.campaign.newsletter.service.http.ABVersionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.newsletter.service.http.ABVersionServiceSoap
 * @generated
 */
public class ABVersionSoap implements Serializable {
	public static ABVersionSoap toSoapModel(ABVersion model) {
		ABVersionSoap soapModel = new ABVersionSoap();

		soapModel.setAbversionId(model.getAbversionId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setAlias(model.getAlias());
		soapModel.setViewsCount(model.getViewsCount());
		soapModel.setGoalCount(model.getGoalCount());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ABVersionSoap[] toSoapModels(ABVersion[] models) {
		ABVersionSoap[] soapModels = new ABVersionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ABVersionSoap[][] toSoapModels(ABVersion[][] models) {
		ABVersionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ABVersionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ABVersionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ABVersionSoap[] toSoapModels(List<ABVersion> models) {
		List<ABVersionSoap> soapModels = new ArrayList<ABVersionSoap>(models.size());

		for (ABVersion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ABVersionSoap[soapModels.size()]);
	}

	public ABVersionSoap() {
	}

	public long getPrimaryKey() {
		return _abversionId;
	}

	public void setPrimaryKey(long pk) {
		setAbversionId(pk);
	}

	public long getAbversionId() {
		return _abversionId;
	}

	public void setAbversionId(long abversionId) {
		_abversionId = abversionId;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public String getAlias() {
		return _alias;
	}

	public void setAlias(String alias) {
		_alias = alias;
	}

	public int getViewsCount() {
		return _viewsCount;
	}

	public void setViewsCount(int viewsCount) {
		_viewsCount = viewsCount;
	}

	public int getGoalCount() {
		return _goalCount;
	}

	public void setGoalCount(int goalCount) {
		_goalCount = goalCount;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _abversionId;
	private long _campaignId;
	private String _alias;
	private int _viewsCount;
	private int _goalCount;
	private Date _modifiedDate;
}