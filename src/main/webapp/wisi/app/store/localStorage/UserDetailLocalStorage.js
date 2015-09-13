Ext.define('wisi.store.localStorage.UserDetailLocalStorage', {
	extend: 'Ext.data.Store',
	model: 'wisi.model.localStorage.UserDetailLocalStorage',
	autoLoad: true,
	proxy: {
		type: 'localstorage',
		id: 'userDetailLocalStorage'
	}
});