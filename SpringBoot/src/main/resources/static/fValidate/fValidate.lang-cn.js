/*********************************************************
*
*--	fValidate US-English language file.
*
*	Translation by: Peter Bailey
*	Email: me@peterbailey.net
*
*	Visit http://www.peterbailey.net/fValidate/api/i18n/
*	for additional translations and instructions on
*	making your own translation.
*
*	!!! WARNING !!! Changing anything but the literal 
*	strings will likely cause script failure!
*
*	Note: This document most easily read/edited with tab-
*	spacing set to 4
*
*********************************************************/

if ( typeof fvalidate == 'undefined' )
{
	var fvalidate = new Object();
}

fvalidate.i18n =
{
	//	Validation errors
	errors:
	{
		blank:		[
			["请输入 ", 0]
			],
		length:		[
			["请输入 ", 0],
			[0, " 至少为 ", 1, " 个字符长"],
			[0, " 不能超过 ", 1, " 个字符长.\n当前输入了 ", 2, " 个字符"]
			],
		equalto:	[
			[0, " must be equal to ", 1]
			],
		number:		[
			[0, " 输入的数字无效", ",该数字必须是整数，而且在", 1, "和", 2, "之间"]
			],
		numeric:	[
			[0, " 只允许输入数字" ],
			[0, " 至少输入", 1, "位数字"]
			],
		alnum:		[
			["The data you entered, \"", 0, "\", does not match the requested format for ", 1,  
			"\nMinimum Length: ", 2,
			"\nCase: ", 3,
			"\nNumbers allowed: ", 4,
			"\nSpaces allowed: ", 5,
			"\nPunctuation characters allowed: ", 6, "\n"]
			],
		decimal:	[
			["The data you entered,", 0, " is not valid.  Please re-enter the ", 1]
			],
		decimalr:	[
			[0, " is not a valid. Please re-enter."]
			],
		ip:		[
			[" 请给 ", 0, " 字段输入一个有效的IP地址"],
			[0, "\n输入的端口号, ", 1, ",  超出范围.\n端口号必须在 ", 2, " 和 ", 3, "之间"]
			],
		mip:		[
			[" 请给 ", 0, " 字段输入多个有效IP地址(以逗号','号分隔)"]
			],		
		mipport:		[
			[" 请给 ", 0, " 字段输入多个有效“IP:端口”(以逗号','号分隔)，如：127.0.0.1:8080,192.168.1.100:9090"]
			],		
		ssn:		[
			["You need to enter a valid Social Security Number.\nYour SSN must be entered in 'XXX-XX-XXXX' format."]
			],
		money:		[
			[0, " does not match the required format of ", 1]
			],
		cc:			[
			["The ", 0, " you entered is not valid. Please check again and re-enter."]
			],
		ccDate:		[
			["You credit card has expired! Please use a different card."]
			],
		zip:		[
			["Please enter a valid 5 or 9 digit Zip code."]
			],
		phone:		[
			["Please enter a valid phone number plus Area Code."],
			["Please enter a valid phone number - seven or ten digits."]
			],
		email:		[
			[0, " 不是一个有效的email地址"],
			[0, " 不能为空"]
			],
		url:		[
			[0, " 不是一个有效的url"]
			],
		date:		[
			[0, "  日期格式错误!\n请输入正确的日期格式: ", 1],
			["Date must be before ", 0],
			["Date must be on or before ", 0],
			["Date must be after ", 0],
			["Date must be on or after ", 0]
			],
		select:		[
			["Please select a valid option for ", 0]
			],
		selectm:	[
			["Please select between ", 0, " and ", 1, " options for ", 2, ".\nYou currently have ", 3, " selected"]
			],
		selecti:	[
			["Please select a valid option for ", 0]
			],
		checkbox:	[
			["Please check ", 0, " before continuing"],
			["Please select between ", 0, " and ", 1, " options for ", 2, ".\nYou currently have ", 3, " selected"]
			],
		radio:		[
			["Please check ", 0, " before continuing"],
			["Please select an option for ", 0 ]
			],
		comparison:	[
			[0, " must be ", 1, " ", 2]
			],
		eitheror:	[
			["One and only one of the following fields must be entered:\n\t-", 0, "\n"]
			],
		atleast:	[
			["At least ", 0, " of the following fields must be entered:\n\t-", 1, "\n\nYou have only ", 2, " filled in.\n"]
			],
		allornone:	[
			["All or none of the following fields must be entered and accurate:\n\t-", 0, "\nYou have only ", 1, " accurate field entered.\n"]
			],
		file:		[
			["The file must be one of the following types:\n", 0, "\nNote: File extension may be case-sensitive."]
			],
		custom:		[
			[0, " is invalid."]
			],
		cazip:		[
			["Please enter a valid postal code."]
			],
		ukpost:		[
			["Please enter a valid postcode."]
			],
		germanpost:	[
			["Please enter a valid postcode."]
			],
		swisspost:	[
			["Please enter a valid postcode."]
			],
		chinapost:	[
			[0, " 不是一个有效的邮政编码"],
			[0, " 不能为空"]
			],	
		chinaIdCard:	[
			[0, " 不是一个有效的证件号码"],
			[0, " 不能为空"],
			[0, " 不是一个有效的身份证号，必须为15位数字或18位数字(末位可含x)"],
			[0, " 不是一个有效的军官证号，请采用'X字第X号'格式,如'沈字第02-56032号'"],
			[0, " 不是一个有效的回乡证号，总长为11位，第1位为香港或澳门代码，后10位为数字"]
			],
		chinaMobilePhone:	[
			[0, " 不是一个有效的手机号码, 手机号码为11位数字且以13、14、15、18开头"],
			[0, " 不能为空"]
			],
		chinaPhoneFax:	[
			[0, " 不是一个有效的电话/传真号码,采用的形式为'[区号-]电话号码[-分机号]',其中区号为3到4位数字，分机号为1-4位数字"],
			[0, " 不能为空"]
			],	
		chinaOuCode:	[
			[0, " 不是一个有效的证件号码"],
			[0, " 不能为空"],
			[0, " 不是一个有效的组织机构代码，必须为八位数字(或大写拉丁字母)本体代码和一位数字(或大写拉丁字母)校验码组成"],
			[0, " 不是一个有效的工商注册号，工商注册号长为15位"],
			[0, " 不是一个有效的税务登记证号，机构的税务登记证号长为15位(由行政区划码加组织机构代码组成)，个人的税务登记证号长为20位"]
			],	
		chinacity:	[
			[0, " 不是一个有效的城市名称"],
			[0, " 不能为空"],
			[0, " 不是江苏省的正确城市名称，请在以下列表中选择:\r\n南京市|徐州市|连云港市|淮安市|宿迁市|盐城市|扬州市|\r\n泰州市|南通市|镇江市|常州市|无锡市|苏州市"],
			[0, " 不是一个有效的工商注册号，工商注册号长为15位"],
			[0, " 不是一个有效的税务登记证号，机构的税务登记证号长为15位(由行政区划码加组织机构代码组成)，个人的税务登记证号长为20位"]
			]			
	},

	comparison:
	{
		gt:		"greater than",
		lt:		"less than",
		gte:	"greater than or equal to",
		lte:	"less than or equal to",
		eq:		"equal to",
		neq:	"not equal to"
	},

	//	Developer assist errors
	devErrors:
	{
		number:		["The lower-bound (", 0, ") is greater than the upper-bound (", 1, ") on this element: ", 2],
		length:		["The minimum length (", 0, ") is greater than the maxiumum legnth (", 1, ") on this element: ", 2],
		cc:			["Credit Card type (", 0, ") not found."],

		lines:		["! WARNING ! -- fValidate developer-assist error\n", "\nIf you are not the developer, please contact the website administrator regarding this error."],
		paramError: ["You must include the '", 0, "' parameter for the '", 1, "' validator type on this field: ", 2],
		notFound:	["The validator '", 0, "' was not found.\nRequested by: ", 1],
		noLabel:	["No element found for label: ", 0],
		noBox:		["An element with the requested id '", 0, "' was not found for the 'boxError' config value."],
		missingName:["The hidden input calling the following logical validator must have a valid name\nattribute when used in conjunction with the 'box' error-type.\n\t", 0],
		mismatch:	["Validator/Element type mismatch.\n\nElement: ", 0, "\nElement type: ", 1, "\nType required by validator: ", 2],
		noCCType:	["You must include a SELECT item with Credit Card type choices!"]
	},

	//	Config values
	config :
	{
		confirmMsg :		"Your data is about to be sent.\nPlease click 'Ok' to proceed or 'Cancel' to abort.",
		confirmAbortMsg :	"Submission cancelled.  Data has not been sent."
	},

	//	Tooltip attached to Box-item errors
	boxToolTip:	"Click to target field",

	//	Message displayed at top of alert error in group mode
	groupAlert:	"The following errors occured:\n\n- ",

	//	Literal translation of the English 'or', include padding spaces.
	or:			" or "
}
