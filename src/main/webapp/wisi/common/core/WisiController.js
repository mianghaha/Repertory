Ext.define("wisi.common.core.WisiController", {
    extend: 'Ext.app.Controller',
    storeLoad: function(formPanel, store){
		var form = formPanel.getForm();
		if(form.isValid()){
    		var ss = store.getProxy().extraParams;
    		Ext.apply(ss, form.getValues());
    		var combos = formPanel.query('combo');
    		Ext.each(combos, function(o){
    			var v = o.getValue();
    			if(v){
    				ss[o.name] = Ext.isArray(v)?v.join(','):v;
    			}else{
    				ss[o.name] = '';
    			}
    		});
    		store.loadPage(1, {
    			params: ss
    		});
		};
	},
	initLoad: function(formPanel){
		alert(1);
	}
});
