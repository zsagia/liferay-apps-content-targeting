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

package com.liferay.content.targeting.report.campaign.newsletter.service.impl;

import com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion;
import com.liferay.content.targeting.report.campaign.newsletter.service.base.ABVersionLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;

/**
 * The implementation of the a b version local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.report.campaign.newsletter.service.ABVersionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.newsletter.service.base.ABVersionLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.newsletter.service.ABVersionLocalServiceUtil
 */
public class ABVersionLocalServiceImpl extends ABVersionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.content.targeting.report.campaign.newsletter.service.ABVersionLocalServiceUtil} to access the a b version local service.
	 */

	@Override
	public ABVersion addABversion(
			long campaignId, String alias, int viewsCount, int goalCount)
		throws PortalException, SystemException {

		ABVersion abVersion = abVersionPersistence.fetchByC_D(campaignId, alias);

		if (abVersion == null) {
			long abVersionId = CounterLocalServiceUtil.increment();

			abVersion = abVersionPersistence.create(abVersionId);

			abVersion.setCampaignId(campaignId);
			abVersion.setAlias(alias);
		}

		abVersion.setViewsCount(
			abVersion.getViewsCount() + viewsCount);
		abVersion.setGoalCount(
			abVersion.getGoalCount() + goalCount);
		abVersion.setModifiedDate(new Date());

		abVersionPersistence.update(abVersion);

		return abVersion;
	}
}