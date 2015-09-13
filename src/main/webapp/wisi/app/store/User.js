Ext.define('wisi.store.User', {
    extend: 'wisi.common.core.WisiStore',
    model: 'wisi.model.User',
    autoLoad: true,

    proxy: { 

        type: 'ajax',
        actionMethods:{
        	read:'POST',
        	update:'POST'
        },
        api: { 

            read: 'wisi/data/User.json',
            update: 'wisi/data/UpdateUser.json'
        }, 
        reader: { 

           type: 'json',
           root: 'users',
           successProperty: 'success'
        } 

    } 

 

});
 
