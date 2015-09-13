Ext.define('wisi.view.frame.PageFrameNorthContainer', {
	extend: 'Ext.container.Container',
	alias: 'widget.framePageFrameNorthContainer',
	
	items: [
		{
			xtype: 'container',
			layout: {
				type: 'hbox',
				align: 'stretch',
				pack: 'left'
			},
			height: 75,
			items: [
		        {
		        	xtype: 'panel',
		        	cls: 'body-frame-top-left-background',
		        	layout: 'absolute',
		        	bodyStyle: 'background: transparent;',
		        	border: false,
		        	width: 400,
		        	items: [
	        	        {
	        	        	xtype: 'image',
	        	        	x: 20,
	        	        	y: 0,
	        	        	height: 65,
	        	        	src: 'wisi/resource/images/frame/logo1.png'
	        	        },
	        	        {
	        	        	xtype: 'label',
	        	        	x: 80,
	        	        	y: 30,
	        	        	height: 25,
	        	        	style: 'font-size: 20px; font-weight: 600; font-family: \'微软雅黑\' !important;',
	        	        	width: 220,
	        	        	text: '英福美信息科技'	        	        		
	        	        }
        	        ]
		        		
		        },
		        //{
		        //	xtype: 'panel',
		        //	cls: 'body-frame-top-middle-background',
		        //	layout: 'fit',
		        //	bodyStyle: 'background: transparent;',
		        //	flex: 1,
		        //	border: false
		        //},
		        {
		        	xtype: 'container',
		        	layout: 'fit',
		        	name: 'menuRootContainer',
		        	cls: 'body-frame-top-middle-background',
		        	border: false,
		        	flex: 1,
		        	items: [
		        	    {
		        	    	xtype: 'toolbar',
			        		dock: 'top',
			        		style: 'background: transparent;',
			        		id: 'systemMenuRootToolbar',
			        		padding: '0 0 0 0',
			        		layout: {
			        			type: 'hbox',
			        			pack: 'end'
			        		},
			        		border: false,
			        		height: 75
		        	    }
		        	]
		        }
			]
		},
		{
			xtype: 'container',
			layout: 'hbox',
			cls: 'body-frame-top-bottom-background',
			height: 30,
			items: [
				{
					xtype: 'toolbar',
					cls: 'login-info-toolbar-background',
					style: 'background: transparent;',
					id: 'pageFrameTopSouthLeftToolbar',
					padding: '2 0 6 8',
					border: false,
					flex: 1,
					height: 30,
					layout: {
						type: 'hbox'
					},
					items: [
						{
							xtype: 'label',
							text: '姓名：'
						},
						{
							xtype: 'label',
							name: 'loginName',
							text: 'XXXXXXXXX'
						},
						{
							xtype: 'tbseparator',
							margins: '0 2 0 2'
						},
						{
							xtype: 'label',
							text: '部门：'
						},
						{
							xtype: 'label',
							name: 'loginDepartment',
							text: 'XXXXXXXXX'
						},
						{
							xtype: 'tbseparator',
							margins: '0 2 0 2'
						},
						{
							xtype: 'label',
							text: '角色：'
						},
						{
							xtype: 'label',
							name: 'loginRole',
							text: 'XXXXXXXXX'
						}
					]
				},
				{
					xtype: 'toolbar',
					dock: 'top',
					style: 'background: transparent;',
					id: 'pageFrameTopSouthRightToolbar',
					padding: '2 0 6 8',
					border: false,
					flex: 1,
					height: 30,
					layout: {
						type: 'hbox',
						pack: 'end'
					},
					items: [
				        {
				        	xtype: 'button',
				        	ui: 'system-set-button-background',
				        	icon: 'wisi/resource/images/common/detail.png',
				        	text: '密码变更',
				        	height: 25,
				        	width: 90
				        },
				        {
				        	xtype: 'button',
				        	ui: 'system-set-button-background',
				        	icon: 'wisi/resource/images/common/logout.png',
				        	text: '退                     出',
				        	textAlign: 'left',
				        	height: 25,
				        	width: 70
				        }
					]
				}
			]
		}
	]
});