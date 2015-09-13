Ext.define('wisi.store.chart.DynamicLineChart', {
	extend: 'Ext.data.Store',
	model: 'wisi.model.chart.DynamicLineChart',
	autoLoad: true,
	
	proxy: {
		type: 'ajax',
		actionMethods: {
			read: 'POST'
		},
		api: {
			read: 'wisi/data/chart/LineChart.json'
		},
		reader: {
			type: 'json',
			root: 'chart',
			successProperty: 'success'
		}
	}
});