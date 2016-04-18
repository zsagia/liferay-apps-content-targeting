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

package com.liferay.content.targeting.report.campaign.tracking.action.service.base;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionService;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionFinder;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionPersistence;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionTotalFinder;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionTotalPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the c t action remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CTActionServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CTActionServiceImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionServiceUtil
 * @generated
 */
public abstract class CTActionServiceBaseImpl extends BaseServiceImpl
	implements CTActionService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionServiceUtil} to access the c t action remote service.
	 */

	/**
	 * Returns the c t action local service.
	 *
	 * @return the c t action local service
	 */
	public com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService getCTActionLocalService() {
		return ctActionLocalService;
	}

	/**
	 * Sets the c t action local service.
	 *
	 * @param ctActionLocalService the c t action local service
	 */
	public void setCTActionLocalService(
		com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService ctActionLocalService) {
		this.ctActionLocalService = ctActionLocalService;
	}

	/**
	 * Returns the c t action remote service.
	 *
	 * @return the c t action remote service
	 */
	public CTActionService getCTActionService() {
		return ctActionService;
	}

	/**
	 * Sets the c t action remote service.
	 *
	 * @param ctActionService the c t action remote service
	 */
	public void setCTActionService(CTActionService ctActionService) {
		this.ctActionService = ctActionService;
	}

	/**
	 * Returns the c t action persistence.
	 *
	 * @return the c t action persistence
	 */
	public CTActionPersistence getCTActionPersistence() {
		return ctActionPersistence;
	}

	/**
	 * Sets the c t action persistence.
	 *
	 * @param ctActionPersistence the c t action persistence
	 */
	public void setCTActionPersistence(CTActionPersistence ctActionPersistence) {
		this.ctActionPersistence = ctActionPersistence;
	}

	/**
	 * Returns the c t action finder.
	 *
	 * @return the c t action finder
	 */
	public CTActionFinder getCTActionFinder() {
		return ctActionFinder;
	}

	/**
	 * Sets the c t action finder.
	 *
	 * @param ctActionFinder the c t action finder
	 */
	public void setCTActionFinder(CTActionFinder ctActionFinder) {
		this.ctActionFinder = ctActionFinder;
	}

	/**
	 * Returns the c t action total local service.
	 *
	 * @return the c t action total local service
	 */
	public com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService getCTActionTotalLocalService() {
		return ctActionTotalLocalService;
	}

	/**
	 * Sets the c t action total local service.
	 *
	 * @param ctActionTotalLocalService the c t action total local service
	 */
	public void setCTActionTotalLocalService(
		com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService ctActionTotalLocalService) {
		this.ctActionTotalLocalService = ctActionTotalLocalService;
	}

	/**
	 * Returns the c t action total remote service.
	 *
	 * @return the c t action total remote service
	 */
	public com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalService getCTActionTotalService() {
		return ctActionTotalService;
	}

	/**
	 * Sets the c t action total remote service.
	 *
	 * @param ctActionTotalService the c t action total remote service
	 */
	public void setCTActionTotalService(
		com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalService ctActionTotalService) {
		this.ctActionTotalService = ctActionTotalService;
	}

	/**
	 * Returns the c t action total persistence.
	 *
	 * @return the c t action total persistence
	 */
	public CTActionTotalPersistence getCTActionTotalPersistence() {
		return ctActionTotalPersistence;
	}

	/**
	 * Sets the c t action total persistence.
	 *
	 * @param ctActionTotalPersistence the c t action total persistence
	 */
	public void setCTActionTotalPersistence(
		CTActionTotalPersistence ctActionTotalPersistence) {
		this.ctActionTotalPersistence = ctActionTotalPersistence;
	}

	/**
	 * Returns the c t action total finder.
	 *
	 * @return the c t action total finder
	 */
	public CTActionTotalFinder getCTActionTotalFinder() {
		return ctActionTotalFinder;
	}

	/**
	 * Sets the c t action total finder.
	 *
	 * @param ctActionTotalFinder the c t action total finder
	 */
	public void setCTActionTotalFinder(CTActionTotalFinder ctActionTotalFinder) {
		this.ctActionTotalFinder = ctActionTotalFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CTActionService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CTAction.class;
	}

	protected String getModelClassName() {
		return CTAction.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ctActionPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService.class)
	protected com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService ctActionLocalService;
	@BeanReference(type = com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionService.class)
	protected CTActionService ctActionService;
	@BeanReference(type = CTActionPersistence.class)
	protected CTActionPersistence ctActionPersistence;
	@BeanReference(type = CTActionFinder.class)
	protected CTActionFinder ctActionFinder;
	@BeanReference(type = com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService.class)
	protected com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService ctActionTotalLocalService;
	@BeanReference(type = com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalService.class)
	protected com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalService ctActionTotalService;
	@BeanReference(type = CTActionTotalPersistence.class)
	protected CTActionTotalPersistence ctActionTotalPersistence;
	@BeanReference(type = CTActionTotalFinder.class)
	protected CTActionTotalFinder ctActionTotalFinder;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}