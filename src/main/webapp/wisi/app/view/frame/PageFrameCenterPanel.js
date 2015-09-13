Ext.define('wisi.view.frame.PageFrameCenterPanel', {
	extend: 'Ext.container.Container',
	alias: 'widget.framePageFrameCenterContainer',
	id: 'pageFrameBodyContainer',
	
	items: [
		{
			xtype: 'panel',
			region: 'west',
			layout: 'fit',
			width: 210,
			collapseMode: 'mini',
			collapseDirection: 'left',
			collapsible: true,
			floatable: false,
			collapsed: false,
			split: true,
			header: false,
			items: [
				{
					xtype: 'panel',
					region: 'center',
					layout: 'fit',
					id: 'pageBodyLeftMenuPanel',
					margins: '5 5 5 5',
					border: false,
					titleAlign: 'center',
					title: '个人主页',
					items: [
						{
							xtype: 'panel',
							layout: 'fit',
							id: 'leftMenuTreePanel',
							border: true
						}
					]
				}
			]
		},
		{
			xtype: 'panel',
			region: 'center',
			layout: 'fit',
			border: false,
			bodyPadding: '5 5 5 5',
			items: [
		        {
		        	xtype: 'tabpanel',
		        	ui: 'tabbar-background',
		        	id: 'bodyMainTabPanel'
		        }
			]
		}
	]
});