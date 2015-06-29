<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@portlet["defineObjects"] />

<#setting number_format="computer">

<#assign nowTime = now?time />

<div class="alert alert-info">
	<@liferay_ui["message"] arguments=nowTime?string.short key="this-rule-checks-the-server-time-which-currently-is-x" />
</div>

<div class="alert alert-error hide" id='<@portlet["namespace"] />incorrectTime'>
    <@liferay_ui["message"] key="End time must be greater than start time" />
</div>

<@aui["fieldset"] cssClass="time-selector" label="start-time">
	<@liferay_ui["input-time"]
		amPmParam="startTimeAmPm"
		amPmValue=startTimeAmPm
		hourParam="startTimeHour"
		hourValue=startTimeHour
		minuteParam="startTimeMinute"
		minuteValue=startTimeMinute
		name="startTime"
	/>
</@>

<@aui["fieldset"] cssClass="time-selector" label="end-time">
	<@liferay_ui["input-time"]
		amPmParam="endTimeAmPm"
		amPmValue=endTimeAmPm
		hourParam="endTimeHour"
		hourValue=endTimeHour
		minuteParam="endTimeMinute"
		minuteValue=endTimeMinute
		name="endTime"
	/>
</@>

<@aui["script"] use="aui-base">
    var A = new AUI();

    var ADate = A.Date;

    var startTimePicker = Liferay.component('<@portlet["namespace"] />startTimeTimePicker');
    var endTimePicker = Liferay.component('<@portlet["namespace"] />endTimeTimePicker');

    var <@portlet["namespace"] />checkTimePicker = function() {

        var startTime = startTimePicker.getTime();
        var endTime = endTimePicker.getTime();

        var endsLater = ADate.isGreater(startTime, endTime);

        var notice = A.one('#<@portlet["namespace"] />incorrectTime');

        if (endsLater) {
            notice.show();
        }
        else {
            notice.hide();
        }

    };

    startTimePicker.on(
        'selectionChange',
        function() {
            <@portlet["namespace"] />checkTimePicker();
        }
    );

    endTimePicker.on(
        'selectionChange',
        function() {
            <@portlet["namespace"] />checkTimePicker();
        }
    );
</@>

<style>
	 .time-selector legend {
		border: none;
		font-weight: bold;
		font-size: 15px;
		line-height: 30px;
		margin-bottom: 0;
	 }
</style>