Ext.define('wisi.store.chart.DynamicChart', {
	extend: 'Ext.data.Store',
	model: 'wisi.model.chart.DynamicChart',
	autoload: true,
	
	proxy: {
		type: 'ajax',
		actionMethods: {
			read: 'POST'
		},
		api: {
			read: 'wisi/data/chart/Chart.json'
		},
		reader: {
			type: 'json',
			root: 'chart',
			successProperty: 'success'			
		}
	}
});