Ext.define("wisi.common.core.WisiModel", {
    extend: 'Ext.data.Model',
	formatLoad: function(v,r){
		return (r.data.name + v);
	}
});
