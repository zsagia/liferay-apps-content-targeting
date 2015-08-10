<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_portlet = PortletJspTagLibs["/META-INF/liferay-portlet-ext.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<#setting number_format="computer">

<#if !trackingContentEnabled >
	<div class="alert alert-error">
		<strong><@liferay_ui["message"] key="this-tracking-action-will-not-work-properly-because-content-tracking-is-not-enabled" /></strong>

		<#assign enableLocationPortalLabel = languageUtil.get(locale, "portal-settings-content-targeting-analytics") />

		<#if portalSettingsURL??>
			<#assign enableLocationPortalLabel = "<a href=\"" + portalSettingsURL + "\">" + enableLocationPortalLabel + "</a>" />
		</#if>

		<#assign enableLocationSiteLabel = languageUtil.get(locale, "site-settings-content-targeting-analytics") />

		<#if siteSettingsURL??>
			<#assign enableLocationSiteLabel = "<a href=\"" + siteSettingsURL + "\">" + enableLocationSiteLabel + "</a>" />
		</#if>

		<#assign enableLocationLabels = [enableLocationPortalLabel, enableLocationSiteLabel] />

		${languageUtil.format(locale, "it-can-be-enabled-in-x-or-in-x", enableLocationLabels)}
	</div>
</#if>

<@aui["input"] helpMessage="alias-help" label="alias" name="{ct_field_guid}alias" type="text" value=alias>
	<@aui["validator"] name="required" />
</@>

<@aui["layout"]>
    <@aui["column"]>
        <div class="rules-panel" style="background-color:transparent; margin:0px;">
            <div class="control-group select-asset-selector">
                <#assign cssClass = "">

                <#if (assetEntryId <= 0)>
                    <#assign cssClass = "hide">
                </#if>

                <@aui["input"] name="{ct_field_guid}assetEntryId" type="hidden" value=assetEntryId />

                <label class="control-label"><@liferay_ui["message"] key="select-the-content-to-be-tracked" /></label>

                <div class="asset-preview table ${cssClass}" id="<@portlet["namespace"] />{ct_field_guid}selectedContentPreview">
                    <@aui["layout"]>
                        <@aui["column"]>
                            <img class="asset-image" src="${assetImagePreview}" id="<@portlet["namespace"] />{ct_field_guid}assetImage" />
                        </@>
                        <@aui["column"]>
                            <div class="asset-title" id="<@portlet["namespace"] />{ct_field_guid}assetTitlePreview">${assetTitlePreview}</div>
                            <div class="asset-type" id="<@portlet["namespace"] />{ct_field_guid}assetTypePreview"><@liferay_ui["message"] key="type" />: ${assetTypePreview}</div>
                        </@>
                    </@>
                </div>

                <div class="edit-controls lfr-meta-actions">
                    <@liferay_ui["icon-menu"] cssClass="select-existing-selector" direction="right" icon="${themeDisplay.getPathThemeImages()}/common/add.png" id="{ct_field_guid}assetSelector" message=languageUtil.get(locale, "select-content") showWhenSingleIcon=true>
                        <#list assetRendererFactories as assetRendererFactory>
                            <@liferay_ui["icon"]
                                cssClass="asset-selector"
                                data=contentTargetingUtilClass.getAssetSelectorIconData(request, assetRendererFactory, '', true)
                                id="_{ct_field_guid}groupId_${assetRendererFactory.getTypeName(locale, false)}"
                                message=assetRendererFactory.getTypeName(locale, false)
                                src=assetRendererFactory.getIconPath(renderRequest)
                                url="javascript:;"
                            />
                        </#list>
                    </@>
                </div>
            </div>
        </div>
    </@>
</@>

<#if eventTypes?has_content && (eventTypes?size > 1)>
	<@aui["select"] label="tracking-action" name="{ct_field_guid}eventType">
		<#list eventTypes as curEventType>
			<@aui["option"] label="${curEventType}" selected=(eventType == curEventType) value=curEventType />
		</#list>
	</@>
<#else>
	<#list eventTypes as curEventType>
		<@aui["input"] disabled=true label="tracking-action" name="{ct_field_guid}eventType" type="text" value=curEventType />
	</#list>
</#if>

<@aui["script"] use="aui-base">
	var onAssetSelectorClick = function(event) {
		event.preventDefault();

		var currentTarget = event.currentTarget;

		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true
				},
				eventName: '{ct_field_guid}selectContent',
				id: 'selectContent' + currentTarget.attr('id'),
				title: currentTarget.attr('data-title'),
				uri: currentTarget.attr('data-href')
			},
            function(event) {
                A.one('#<@portlet["namespace"] />{ct_field_guid}assetEntryId').attr('value', event.assetentryid);
                A.one('#<@portlet["namespace"] />{ct_field_guid}assetImage').attr('src', '');

                A.one('#<@portlet["namespace"] />{ct_field_guid}assetTitlePreview').html(event.assettitle);
                A.one('#<@portlet["namespace"] />{ct_field_guid}assetTypePreview').html('<@liferay_ui["message"] key="type" />: ' + event.assettype);

                A.one('#<@portlet["namespace"] />{ct_field_guid}selectedContentPreview').show();
            }
		);
	};

	A.getBody().delegate(
		'click',
		function(event) {
			onAssetSelectorClick(event);
		},
		'.asset-selector a'
	);
</@>