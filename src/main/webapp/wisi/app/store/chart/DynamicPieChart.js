Ext.define('wisi.store.chart.DynamicPieChart', {
	extend: 'Ext.data.Store',
	model: 'wisi.model.chart.DynamicPieChart',
	autoLoad: true,
	
	proxy: {
		type: 'ajax',
		actionMethods: {
			read: 'POST'
		},
		api: {
			read: 'wisi/data/chart/PieChart.json'
		},
		reader: {
			type: 'json',
			root: 'chart',
			successProperty: 'success'
		}
	}
});