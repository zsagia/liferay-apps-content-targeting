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

package com.liferay.content.targeting.report.campaign.newsletter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ABVersionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ABVersionLocalService
 * @generated
 */
public class ABVersionLocalServiceWrapper implements ABVersionLocalService,
	ServiceWrapper<ABVersionLocalService> {
	public ABVersionLocalServiceWrapper(
		ABVersionLocalService abVersionLocalService) {
		_abVersionLocalService = abVersionLocalService;
	}

	/**
	* Adds the a b version to the database. Also notifies the appropriate model listeners.
	*
	* @param abVersion the a b version
	* @return the a b version that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion addABVersion(
		com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion abVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.addABVersion(abVersion);
	}

	/**
	* Creates a new a b version with the primary key. Does not add the a b version to the database.
	*
	* @param abversionId the primary key for the new a b version
	* @return the new a b version
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion createABVersion(
		long abversionId) {
		return _abVersionLocalService.createABVersion(abversionId);
	}

	/**
	* Deletes the a b version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param abversionId the primary key of the a b version
	* @return the a b version that was removed
	* @throws PortalException if a a b version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion deleteABVersion(
		long abversionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.deleteABVersion(abversionId);
	}

	/**
	* Deletes the a b version from the database. Also notifies the appropriate model listeners.
	*
	* @param abVersion the a b version
	* @return the a b version that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion deleteABVersion(
		com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion abVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.deleteABVersion(abVersion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _abVersionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion fetchABVersion(
		long abversionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.fetchABVersion(abversionId);
	}

	/**
	* Returns the a b version with the primary key.
	*
	* @param abversionId the primary key of the a b version
	* @return the a b version
	* @throws PortalException if a a b version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion getABVersion(
		long abversionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.getABVersion(abversionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the a b versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of a b versions
	* @param end the upper bound of the range of a b versions (not inclusive)
	* @return the range of a b versions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion> getABVersions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.getABVersions(start, end);
	}

	/**
	* Returns the number of a b versions.
	*
	* @return the number of a b versions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getABVersionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.getABVersionsCount();
	}

	/**
	* Updates the a b version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param abVersion the a b version
	* @return the a b version that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion updateABVersion(
		com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion abVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.updateABVersion(abVersion);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _abVersionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_abVersionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _abVersionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion addABversion(
		long campaignId, java.lang.String alias, int viewsCount, int goalCount)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _abVersionLocalService.addABversion(campaignId, alias,
			viewsCount, goalCount);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ABVersionLocalService getWrappedABVersionLocalService() {
		return _abVersionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedABVersionLocalService(
		ABVersionLocalService abVersionLocalService) {
		_abVersionLocalService = abVersionLocalService;
	}

	@Override
	public ABVersionLocalService getWrappedService() {
		return _abVersionLocalService;
	}

	@Override
	public void setWrappedService(ABVersionLocalService abVersionLocalService) {
		_abVersionLocalService = abVersionLocalService;
	}

	private ABVersionLocalService _abVersionLocalService;
}