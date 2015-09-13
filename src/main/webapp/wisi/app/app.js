var selectedMenuButton = "";
Ext.Loader.setConfig({
//	disableCaching: false,//为true每次都重新加载js
	enabled : true
});
Ext.Loader.setPath({
    Ext: [
    	'wisi/common/core',
    	'wisi/common/util'
    ]
});

Ext.onReady(function(){
	Ext.wisi = {
		// page body object
		documentBody : Ext.getBody(),
		bodyHeight: document.body.clientHeight-10,
		bodyWidth : function(w){
			return w < 996 || w > 1024 ? 1024 : w;
		}(document.body.clientWidth-10),
		// body mask/
		mask : function(msg){
			Ext.wisi.documentBody.mask(msg);
		},
		// body unmask
		unmask : function(time,fn){
			setTimeout(function(){
				Ext.wisi.documentBody.unmask();
				if(fn){fn();};
			}, Ext.isNumber(time) ? time : 1000);
		}
	};
	
	Ext.require([
		'wisi.common.core.WisiModel',
		'wisi.common.core.WisiStore',
		'wisi.common.core.WisiController'
	]);
	//Ext.require("wisi.common.core.WisiStore");
	//Ext.require("wisi.common.core.WisiController");
	
	
	// init quick tips
	Ext.QuickTips.init();
	
	// disable for backspace
	var key = new Ext.KeyMap(document, {
		key : 8,
		fn : function(o, e) {
			var t = e.target.type;
			if (t != 'text' && t != 'textarea'&& t != 'password' && !e.target.readOnly) {
				return e.preventDefault();
			};
		}
	});
	
	// page loadding
	//Ext.wisi.mask("页面加载中……");
	alert(1); 
	//获取系统 code
	Ext.Ajax.request({
		skip: true,
		url: 'systemCode/getSystemCode.html',
		success: function(response){
			var store = {},
				msg = {},
				json = Ext.decode(response.responseText);
			/*
			Ext.each(json.list, function(o){
				msg[o.type_code + o.id] = o.name;
				if(!store[o.type_code]){
					store[o.type_code] = [];
				}
				store[o.type_code].push({
					id: o.id,
					name: o.name,
					sort: o.sort
				});
			});
			*/
			/*
			window.$Store = function(name){
				return store[name]
			};
			window.$Msg = function(name){
				return msg[name]
			};
			// alert($Msg('ORDER_TYPE01'))
			// alert(Ext.encode($Store('ORDER_TYPE')))

			window.$RequiredItem = json.data||{};
			
			// alert(Ext.encode($RequiredItem))
			*/
		}
	});
	
	Ext.application({
	    requires: ['Ext.container.Viewport'],
	    name: 'wisi',
	    appFolder: 'wisi/app',
	    controllers: [
	    	'PageFrame'
	    ],
	    launch: function() {
	        Ext.create('Ext.container.Viewport', {
	           layout: 'fit',
	           items: [
	               {
	                   xtype: 'framePageFrameContainer'
	               }
	           ]
	        });
	        
	        window.$application = this;
			
			Ext.wisi.getController = function(url){
				var controller = $application.controllers.get(url);
				if (!controller){
					controller = $application.getController(url);
				}
				return controller;
			};
	    }
	});
});
 
