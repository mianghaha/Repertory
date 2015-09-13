Ext.define('wisi.store.localStorage.UserLocalStorage', {
	extend: 'Ext.data.Store',
	model: 'wisi.model.localStorage.UserLocalStorage',
	autoLoad: true,
	proxy: {
		type: 'localstorage',
		id: 'userLocalStorage'
	}	
});