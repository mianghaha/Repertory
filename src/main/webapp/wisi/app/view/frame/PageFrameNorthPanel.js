Ext.define('wisi.view.frame.PageFrameNorthPanel', {
	extend: 'Ext.container.Container',
	alias: 'widget.framePageFrameNorthPanel',
	
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
		        },
		        {
		        	xtype: 'panel',
		        	cls: 'body-frame-top-middle-background',
		        	layout: 'fit',
		        	bodyStyle: 'background: transparent;',
		        	flex: 1,
		        	border: false
		        },
		        {
		        	xtype: 'panel',
		        	id: 'systemMenuAndLoginInfoContainer',
		        	name: 'menuRootContainer',
		        	layout: 'border',
		        	//cls: 'body-frame-top-right-background',
		        	border: false,
		        	width: 620,
		        	items: [
		        	    {
		        	    	xtype: 'toolbar',
		        	    	region: 'center',
			        		cls: 'body-frame-top-right-background',
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