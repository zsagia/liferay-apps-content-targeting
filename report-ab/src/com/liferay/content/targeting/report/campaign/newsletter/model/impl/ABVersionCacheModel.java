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

package com.liferay.content.targeting.report.campaign.newsletter.model.impl;

import com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ABVersion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ABVersion
 * @generated
 */
public class ABVersionCacheModel implements CacheModel<ABVersion>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{abversionId=");
		sb.append(abversionId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", alias=");
		sb.append(alias);
		sb.append(", viewsCount=");
		sb.append(viewsCount);
		sb.append(", goalCount=");
		sb.append(goalCount);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ABVersion toEntityModel() {
		ABVersionImpl abVersionImpl = new ABVersionImpl();

		abVersionImpl.setAbversionId(abversionId);
		abVersionImpl.setCampaignId(campaignId);

		if (alias == null) {
			abVersionImpl.setAlias(StringPool.BLANK);
		}
		else {
			abVersionImpl.setAlias(alias);
		}

		abVersionImpl.setViewsCount(viewsCount);
		abVersionImpl.setGoalCount(goalCount);

		if (modifiedDate == Long.MIN_VALUE) {
			abVersionImpl.setModifiedDate(null);
		}
		else {
			abVersionImpl.setModifiedDate(new Date(modifiedDate));
		}

		abVersionImpl.resetOriginalValues();

		return abVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		abversionId = objectInput.readLong();
		campaignId = objectInput.readLong();
		alias = objectInput.readUTF();
		viewsCount = objectInput.readInt();
		goalCount = objectInput.readInt();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(abversionId);
		objectOutput.writeLong(campaignId);

		if (alias == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(alias);
		}

		objectOutput.writeInt(viewsCount);
		objectOutput.writeInt(goalCount);
		objectOutput.writeLong(modifiedDate);
	}

	public long abversionId;
	public long campaignId;
	public String alias;
	public int viewsCount;
	public int goalCount;
	public long modifiedDate;
}