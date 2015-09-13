Ext.define('wisi.view.chart.DynamicChart', {
	extend: 'Ext.container.Container',
	alias: 'widget.chartDynamicChartContainer',
	layout: {
		type: 'vbox',
		align: 'stretch'
	},
	
	items: [
        {
        	xtype: 'container',
        	layout: 'fit',
        	height: 100,
        	items: [
	        	{
	        		xtype: 'form',
	        		layout: 'absolute',
	        		bodyStyle: 'border-bottom: 0px;',
	        		height: 50,
	        		items: [
						{
							xtype: 'combobox',
							x: 10,
							y: 20,
							id: 'createChartType',
		        			fieldLabel: '图表类型',
		        			labelWidth: 60,
		        			displayField: 'chartName',
		        			valueField: 'chartValue',
		        			store: 'chart.DynamicChart'    			
						},
		        		{
		        			xtype: 'button',
		        			x: 260,
		        			y: 20,
		        			name: 'createChartButton',
		        			id: 'createChartButton',
		        			width: 100,
		        			text: '创建图表'
		        		}
	        		]
	        	}     
        	]
        },
        {
        	xtype: 'container',
        	layout: 'fit',
        	flex: 1,
        	items: [
	        	{
	        		xtype: 'panel',
	        		layout: {
	        			type: 'hbox',
	        			align: 'stretch'
	        		},
	        		items: [
		        		{
		        			xtype: 'panel',
		        			layout: 'fit',
		        			id: 'daynamicChartLeftPanel',
		        			margins: '8 8 8 8',
		        			flex: 1
		        		},
		        		{
		        			xtype: 'panel',
		        			layout: 'fit',
		        			id: 'daynamicChartRightPanel',
		        			margins: '8 8 8 8',
		        			flex: 1
		        		}
	        		]
	        	}
        	]
        }
	]
});