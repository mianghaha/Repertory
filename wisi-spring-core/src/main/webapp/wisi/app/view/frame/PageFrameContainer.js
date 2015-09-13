Ext.define('wisi.view.frame.PageFrameContainer', {
	extend: 'Ext.container.Container',
	alias: 'widget.framePageFrameContainer',
	
	id: 'framePageFramePanelId',
	layout: {
		type: 'vbox',
		align: 'stretch'
	},
	border: 0,
	
	initComponent: function(){
		var me = this;
		me.items = [
			{
				xtype: 'framePageFrameNorthContainer',
				layout: {
					type: 'vbox',
					align: 'stretch'
				},
				height: 105
			},
			{
				xtype: 'framePageFrameCenterContainer',
				layout: 'border',
				flex: 1,
				style: 'background-color: #FFFFFF;'
			},
			{
				xtype: 'container',
				border: false,
				height: 30,
				items: [
					{
						xtype: 'toolbar',
						dock: 'top',
						cls: 'body-frame-bottom-background login-info-toolbar-background',
						border: false,
						height: 30,
						layout: {
							type: 'hbox',
							pack: 'center'
						},
						items: [
					        {
					        	xtype: 'label',
					        	text: 'Copyright@ 2015-2016 WISI SOFT.'
					        }
				        ]
					}
				]
			},
		];
		me.callParent(arguments);
	}
});