var baseUrl = baseUrl || '../resources';

require.config({
	urlArgs : 'cache=' + new Date().getTime(),
	baseUrl : baseUrl,
	paths : {
		'json3' : '/js/json3.min',
		'jquery' : '/js/jquery-1.11.2/jquery.min',
		'jqueryui' : '/js/jquery-ui-1.11.4.custom/jquery-ui.min',
		'jqgrid-i18n' : '/js/jqgrid-4.8.2/i18n/grid.locale-tw',
		'jqgrid' : '/js/jqgrid-4.8.2/jquery.jqGrid.min',
		'validate-i18n' : 'js/formValidator/languages/jquery.validationEngine-zh_TW',
        'validate' : 'js/formValidator/jquery.validationEngine',
        'blockui' : 'js/blockUI/jquery.blockUI',
		'bootstrap' : 'js/bootstrap/bootstrap.min.js'
	},
	shim : {
		'blockui' : ['jquery'],
		'jquery-ui' : [ 'jquery' ],
		'jqgrid-i18n' : [ 'jquery' ],
		'jqgrid' : [ 'jquery-ui', 'jqgrid-i18n' ],
		'validate-i18n' : [ 'jquery' ],
		'validate' : [ 'jquery', 'validate-i18n' ],
		'bootstrap' : [ 'jquery' ]
	}
});

(function(_jQuery, window) {	
	_jQuery.ajaxSettings.traditional = true;
	_jQuery.ajaxSetup({
		jsonp : null,
		jsonpCallback : null,
		cache : false,
		dataType : 'json',
		type : "POST",
		data : {
			_isAjax : true
		},
		timeout : 60 * 1000 , // 60 sec
	});

	_jQuery.datepicker.setDefaults({
		dateFormat : 'yy-mm-dd',
		buttonImageOnly : true,
		showButtonPanel : true,
		changeMonth : true,
		changeYear : true,
		buttonImage : baseUrl + '/css/images/icon_date.png',
		showOn : 'both'
	});
	// 設定blockUI
	if ($.blockUI) {
		$.blockUI.showBG = true;
		$.extend({
			startBlockUI : function(event, xhr) {
				$.blockUI({
					fadeIn : 0,
					fadeOut : 0,
					message : '  <img src="'
							+ url("resources/css/images/ajax-loader.gif")
							+ '" style="width: 16px;hight:11px;"/>',
					css : {
						'z-index' : 10010,
						top : '0',
						left : '40%',
						backgroundColor : '#E0ECFF',
						border : '#000 1px solid',
						'-webkit-border-radius' : '5px',
						'-moz-border-radius' : '5px',
						'font-size' : '0.8em',
						padding : '2px',
						fontWeight : 'bolder',
						height : '18px',
						width : '20%',
						color : '#000',
						cursor : 'default'
					},
					overlayCSS : {
						'z-index' : 10010,
						backgroundColor : '#CCC',
						opacity : $.blockUI.showBG ? 0.3 : 0,
						cursor : 'default'
					}
				});
			}
		});
		$(document).bind("ajaxStart", $.startBlockUI);
		$(document).bind("ajaxStop", $.unblockUI);
	}
})