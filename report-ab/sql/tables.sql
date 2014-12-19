create table CT_ABReport_ABVersion (
	abversionId LONG not null primary key,
	campaignId LONG,
	alias_ VARCHAR(75) null,
	viewsCount INTEGER,
	goalCount INTEGER,
	modifiedDate DATE null
);