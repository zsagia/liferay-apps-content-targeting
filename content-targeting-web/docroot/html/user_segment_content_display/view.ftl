<#--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
-->

<#include "../init.ftl" />
<#include "../macros.ftl" />

<#assign containerCssClass = "" />

<#if portletDisplay.isShowConfigurationIcon()>
	<#assign containerCssClass = "show-configuration" />
</#if>

<div class="content-container ${containerCssClass}">
	<div class="full-content" id="<@portlet["namespace"] />FullContent${selectedIndex}">
		<#if isNotConfigured>
			<div class="alert alert-info">
				<@liferay_ui["message"] key="configure-this-app-to-display-different-content-to-each-user-segment" />
			</div>
		<#elseif queryRule.hasAssetEntry()>
			<#if portletDisplayTemplateHtml??>
				${portletDisplayTemplateHtml}
			<#else>
				<@renderAssetEntry />
			</#if>
		<#else>
			<div class="alert alert-info">
				<@liferay_ui["message"] key="there-are-no-matching-rules" />
			</div>
		</#if>
	</div>

	<#if showPreview>
		<@renderThumbnailsPreview queryRules=userSegmentQueryRules selectedIndex=selectedIndex />
	</#if>
</div>

<@getEditIconLinks queryRules=userSegmentQueryRules />

<@liferay_portlet["renderURL"] windowState="pop_up" plid=portalUtil.getControlPanelPlid(themeDisplay.getCompanyId()) portletName="ctadmin_WAR_contenttargetingweb" varImpl="viewReportURL">
	<@portlet["param"] name="mvcPath" value="html/content_targeting/view_report.ftl" />
	<@portlet["param"] name="className" value="com.liferay.content.targeting.model.Campaign" />
	<@portlet["param"] name="classPK" value="18756" />
	<@portlet["param"] name="reportKey" value="CTActionReport" />
</@>

<span id="<@portlet["namespace"] />viewReports">
	<@liferay_ui["icon"]
		cssClass="lfr-icon-action lfr-icon-action-edit"
		image="view"
		label=true
		message="view-report"
		url="javascript:Liferay.Util.openWindow({dialog: {width: 960}, id:'" + renderResponse.getNamespace() + "viewReport', title: 'Reports', uri:'" + htmlUtil.escapeURL(viewReportURL.toString()) + "'});"
	/>
</span>