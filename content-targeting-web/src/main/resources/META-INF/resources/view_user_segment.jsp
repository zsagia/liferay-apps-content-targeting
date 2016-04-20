<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
ContentTargetingViewUserSegmentDisplayContext contentTargetingViewUserSegmentDisplayContext = new ContentTargetingViewUserSegmentDisplayContext(liferayPortletRequest, liferayPortletResponse);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(contentTargetingViewUserSegmentDisplayContext.getBackURL());

renderResponse.setTitle(contentTargetingViewUserSegmentDisplayContext.getUserSegmentTitle());
%>

<c:choose>
	<c:when test="<%= contentTargetingViewUserSegmentDisplayContext.isShowSummary() %>">
		<liferay-util:include page="/user_segment_summary.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test="<%= contentTargetingViewUserSegmentDisplayContext.isShowReports() %>">
		<liferay-util:include page="/view_user_segment_reports.jsp" servletContext="<%= application %>" />
	</c:when>
</c:choose>