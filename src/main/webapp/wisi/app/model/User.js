var me;
Ext.define('wisi.model.User', {
    extend: 'wisi.common.core.WisiModel',
	constructor: function() {
		me = this;
		me.callParent(arguments);
	},
	fields: [
 		'name',
 		{name: 'email', convert: function(v, r){
    		return me.formatLoad(v, r);
    	}}
 	]
});
 
