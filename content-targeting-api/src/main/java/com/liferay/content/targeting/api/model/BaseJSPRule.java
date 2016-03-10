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

package com.liferay.content.targeting.api.model;

import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.servlet.BufferCacheServletResponse;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.taglib.util.ThemeUtil;

import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eduardo Garcia
 */
public abstract class BaseJSPRule implements Rule {

	@Override
	public void activate() {
		if (_log.isDebugEnabled()) {
			_log.debug("Rule activate: " + getClass().getSimpleName());
		}
	}

	@Override
	public void deActivate() {
		if (_log.isDebugEnabled()) {
			_log.debug("Rule deactivate: " + getClass().getSimpleName());
		}
	}

	@Override
	public void deleteData(RuleInstance ruleInstance) throws PortalException {
	}

	@Override
	public void exportData(
			PortletDataContext portletDataContext, Element userSegmentElement,
			UserSegment userSegment, Element ruleInstanceElement,
			RuleInstance ruleInstance)
		throws Exception {
	}

	@Override
	public String getDescription(Locale locale) {
		String key = getClass().getName().concat(".description");

		String description = ContentTargetingUtil.getModelResource(
			locale, getClass(), key);

		if (description.endsWith(key)) {
			description = getShortDescription(locale);
		}

		return description;
	}

	@Override
	public String getFormHTML(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		String content = StringPool.BLANK;

		try {
			populateContext(ruleInstance, context, values);

			HttpServletRequest request = (HttpServletRequest)context.get(
				"request");

			HttpServletResponse response = (HttpServletResponse)context.get(
				"response");

			Theme theme = (Theme)context.get(WebKeys.THEME);

			BufferCacheServletResponse bufferResponse =
				new BufferCacheServletResponse(response);

			request.setAttribute("displayContext", context);

			ThemeUtil.includeJSP(
				_servletContext, request, bufferResponse, getTemplatePath(),
				theme);

			content = bufferResponse.getString();
		}
		catch (Exception e) {
			_log.error(
				"Error while processing rule form template " +
					getTemplatePath(),
				e);
		}

		return content;
	}

	@Override
	public String getIcon() {
		return "icon-retweet";
	}

	@Override
	public String getName(Locale locale) {
		return ContentTargetingUtil.getModelResource(
			locale, getClass(), getClass().getName());
	}

	@Override
	public String getRuleCategoryKey() {
		return StringPool.BLANK;
	}

	@Override
	public String getRuleKey() {
		return getClass().getSimpleName();
	}

	@Override
	public String getShortDescription(Locale locale) {
		String key = getClass().getName().concat(".shortDescription");

		String shortDescription = ResourceActionsUtil.getModelResource(
			locale, key);

		if (shortDescription.endsWith(key)) {
			shortDescription = StringPool.BLANK;
		}

		return shortDescription;
	}

	@Override
	public void importData(
			PortletDataContext portletDataContext, UserSegment userSegment,
			RuleInstance ruleInstance)
		throws Exception {
	}

	@Override
	public boolean isInstantiable() {
		return false;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	protected String getExportImportErrorMessage(
		UserSegment userSegment, RuleInstance ruleInstance,
		String missingReferenceClassName, String missingReferenceId,
		String action) {

		StringBundler sb = new StringBundler(9);

		if (action.equals(Constants.EXPORT)) {
			sb.append("Cannot export rule ");
		}
		else {
			sb.append("Cannot import rule ");
		}

		sb.append(getName(LocaleUtil.getDefault()));
		sb.append(" from user segment ");
		sb.append(userSegment.getName(LocaleUtil.getDefault()));
		sb.append(" because it refers to a missing ");
		sb.append(
			ResourceActionsUtil.getModelResource(
				LocaleUtil.getDefault(), missingReferenceClassName));
		sb.append(" with id ");
		sb.append(missingReferenceId);
		sb.append(".");

		return sb.toString();
	}

	protected String getTemplatePath() {
		return _FORM_TEMPLATE_PATH;
	}

	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {
	}

	private static final String _FORM_TEMPLATE_PATH =
		"/templates/ct_fields.jsp";

	private static final Log _log = LogFactoryUtil.getLog(BaseJSPRule.class);

	private ServletContext _servletContext;

}