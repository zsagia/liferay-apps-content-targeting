package com.liferay.content.targeting.analytics.messaging;

import com.liferay.content.targeting.analytics.model.AnalyticsEvent;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;
import com.liferay.portlet.journal.model.JournalArticle;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import sun.util.resources.CalendarData_be;

/**
 * @author Pavel Savinov
 */
@RunWith(Arquillian.class)
public class AnalyticsMessageListenerTest {

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
		_analyticsReferrerLocalService = ServiceTrackerUtil.getService(
			AnalyticsReferrerLocalService.class, _bundle.getBundleContext());
	}

	@Test
	public void testAnalyticsMessageListenerReceiveMessage() throws Exception {

		int initAnalyticsEventsCount =
			_analyticsEventLocalService.getAnalyticsEventsCount();

		Message message = new Message();
		message.put("companyId", TestPropsValues.getCompanyId());
		message.put("userId", TestPropsValues.getUserId());
		message.put("anonymousUserId", 1);
		message.put("elementId", "");
		message.put("event", "view");
		message.put("className", JournalArticle.class.getName());
		message.put("classPK", 1);
		message.put("referrerClassName", Layout.class.getName());
		message.put("referrerClassPK", 1);
		message.put("clientIP", "127.0.0.1");
		message.put("userAgent", "User Agent");
		message.put("languageId", LanguageUtil.getLanguageId(Locale.ENGLISH));
		message.put("layoutURL", "http://localhost");
		message.put("additionalInfo", "");

		MessageBusUtil.sendMessage(_LISTENER_DESTINATION, message);

		AnalyticsEvent analyticsEvent =
			_analyticsEventLocalService.addAnalyticsEvent(
				TestPropsValues.getUserId(), 1, JournalArticle.class.getName(),
				1, Layout.class.getName(), new long[] {1, 2}, null, "view",
				"127.0.0.1", "User Agent", "ES", "http://localhost",
				StringPool.BLANK, ServiceTestUtil.getServiceContext());

		Assert.assertEquals(
			initAnalyticsEventsCount + 2,
			_analyticsEventLocalService.getAnalyticsEventsCount());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);

		_analyticsEventLocalService.deleteAnalyticsEvents(
			TestPropsValues.getCompanyId(), calendar.getTime());

		Assert.assertEquals(
			0, _analyticsEventLocalService.getAnalyticsEventsCount());
	}

    private static final String _LISTENER_DESTINATION = "liferay/analytics";

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private AnalyticsReferrerLocalService _analyticsReferrerLocalService;

	@ArquillianResource
	private Bundle _bundle;

}