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

package com.liferay.content.targeting.report.campaign.tracking.action;

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.ServiceContext;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import java.util.Calendar;
import java.util.List;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class CTActionReportTest {

	@Before
	public void setUp() {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, _bundle.getBundleContext());
		_ctActionLocalService = ServiceTrackerUtil.getService(
			CTActionLocalService.class, _bundle.getBundleContext());
		_reportsRegistry = ServiceTrackerUtil.getService(
			ReportsRegistry.class, _bundle.getBundleContext());
		_trackingActionInstanceLocalService = ServiceTrackerUtil.getService(
			TrackingActionInstanceLocalService.class,
			_bundle.getBundleContext());
	}

	@Test
	public void testCTActionReport() throws Exception {
		ServiceContext serviceContext = ServiceTestUtil.getServiceContext();

		long userId = TestPropsValues.getUserId();

		long campaignId = 1;
		String className = Layout.class.getName();
		long classPK = 2;
		String elementId = "form_id";
		String eventType = "view";

		int initialCTActionCount = _ctActionLocalService.getCTActionsCount(
			campaignId);

		// Add tracking actions

		TrackingActionInstance trackingActionInstanceForm =
            _trackingActionInstanceLocalService.addTrackingActionInstance(
                userId, "FormTrackingAction", campaignId,
                StringUtil.randomString(), null, -1, elementId, eventType, null,
                serviceContext);

		TrackingActionInstance trackingActionInstancePage =
            _trackingActionInstanceLocalService.addTrackingActionInstance(
                userId, "PageTrackingAction", campaignId,
                StringUtil.randomString(), className, classPK, null, eventType,
                StringPool.BLANK, serviceContext);

		// Obtain report from registry

		Report report = _reportsRegistry.getReport("CTActionReport");

		// Test update report without analytics

		report.updateReport(campaignId);

		Assert.assertEquals(
			initialCTActionCount,
			_ctActionLocalService.getCTActionsCount(campaignId));

		// Add analytics

		_analyticsEventLocalService.addAnalyticsEvent(
			userId, 1, null, -1, UserSegment.class.getName(), new long[]{1},
			elementId, eventType, "127.0.0.1", "ES", "User Agent",
			"http://localhost", null, serviceContext);

		_analyticsEventLocalService.addAnalyticsEvent(
			userId, 1, className, classPK, UserSegment.class.getName(),
			new long[]{1}, null, eventType, "127.0.0.1", "ES", "User Agent",
			"http://localhost", null, serviceContext);

		// Test update report with analytics

		report.updateReport(campaignId);

		Assert.assertEquals(
			initialCTActionCount + 2,
			_ctActionLocalService.getCTActionsCount(campaignId));

        _trackingActionInstanceLocalService.deleteTrackingActionInstance(
            trackingActionInstanceForm);
        _trackingActionInstanceLocalService.deleteTrackingActionInstance(
            trackingActionInstancePage);

        List<CTAction> ctActions =
            _ctActionLocalService.getCTActions(campaignId);

        for (CTAction ctAction : ctActions) {
            _ctActionLocalService.deleteCTAction(ctAction);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);

        _analyticsEventLocalService.deleteAnalyticsEvents(
            serviceContext.getCompanyId(), calendar.getTime());
	}

	@Test
	public void testRenameTrackingActionCTAReport() throws Exception {

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext();

		long userId = TestPropsValues.getUserId();

		long campaignId = 2;
		String className = Layout.class.getName();
		long classPK = 3;
		String elementId = "form_id2";
		String eventType = "view";

		int initialCTActionCount = _ctActionLocalService.getCTActionsCount(
			campaignId);

		TrackingActionInstance trackingActionInstanceForm =
			_trackingActionInstanceLocalService.addTrackingActionInstance(
				userId, "FormTrackingAction", campaignId,
                StringUtil.randomString(), null, -1, elementId, eventType, null,
                serviceContext);

		TrackingActionInstance trackingActionInstancePage =
			_trackingActionInstanceLocalService.addTrackingActionInstance(
				userId, "PageTrackingAction", campaignId,
                StringUtil.randomString(), className, classPK, null, eventType,
                StringPool.BLANK, serviceContext);

		Report report = _reportsRegistry.getReport("CTActionReport");

		report.updateReport(campaignId);

		Assert.assertEquals(
			initialCTActionCount,
			_ctActionLocalService.getCTActionsCount(campaignId));

		_analyticsEventLocalService.addAnalyticsEvent(
			userId, 1, null, -1, UserSegment.class.getName(), new long[]{1},
			elementId, eventType, "127.0.0.1", "ES", "User Agent",
			"http://www.liferay.com", null, serviceContext);

		_analyticsEventLocalService.addAnalyticsEvent(
			userId, 1, className, classPK, UserSegment.class.getName(),
			new long[]{2}, null, eventType, "127.0.0.1", "ES", "User Agent",
			"http://www.liferay.com", null, serviceContext);

		report.updateReport(campaignId);

		Assert.assertEquals(
			initialCTActionCount + 2,
			_ctActionLocalService.getCTActionsCount(campaignId));

		trackingActionInstanceForm.setAlias(StringUtil.randomString());
		trackingActionInstancePage.setAlias(StringUtil.randomString());

		_trackingActionInstanceLocalService.updateTrackingActionInstance(
			trackingActionInstanceForm);
		_trackingActionInstanceLocalService.updateTrackingActionInstance(
			trackingActionInstancePage);

		_analyticsEventLocalService.addAnalyticsEvent(
			userId, 1, null, -1, UserSegment.class.getName(), new long[]{1},
			elementId, eventType, "127.0.0.1", "ES", "User Agent",
			"http://www.liferay.com", null, serviceContext);

		_analyticsEventLocalService.addAnalyticsEvent(
			userId, 1, className, classPK, UserSegment.class.getName(),
			new long[]{2}, null, eventType, "127.0.0.1", "ES", "User Agent",
			"http://www.liferay.com", null, serviceContext);

		report.updateReport(campaignId);

        // TA alias changed, but report still has the old one

		Assert.assertEquals(
			initialCTActionCount + 2,
			_ctActionLocalService.getCTActionsCount(campaignId));

        _trackingActionInstanceLocalService.deleteTrackingActionInstance(
            trackingActionInstanceForm.getTrackingActionInstanceId());
        _trackingActionInstanceLocalService.deleteTrackingActionInstance(
            trackingActionInstancePage);

        List<CTAction> ctActions =
            _ctActionLocalService.getCTActions(campaignId);

        for (CTAction ctAction : ctActions) {
            _ctActionLocalService.deleteCTAction(ctAction);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);

        _analyticsEventLocalService.deleteAnalyticsEvents(
            serviceContext.getCompanyId(), calendar.getTime());

	}

	private AnalyticsEventLocalService _analyticsEventLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private CTActionLocalService _ctActionLocalService;
	private ReportsRegistry _reportsRegistry;
	private TrackingActionInstanceLocalService
		_trackingActionInstanceLocalService;

}