Ext.define('wisi.store.dynamicColumn.DynamicColumn', {
	extend: 'Ext.data.Store',
	model: 'wisi.model.dynamicColumn.DynamicColumn',
	autoload: true,
	
	proxy: {
		type: 'ajax',
		actionMethods: {
			read: 'POST'
		},
		api: {
			read: 'wisi/data/dynamicColumn/GridData.json'
		},
		reader: {
			type: 'json',
			root: 'gridData'		
		}
	}
});