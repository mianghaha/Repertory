Ext.define('wisi.controller.User', {
    extend: 'wisi.common.core.WisiController',
    views: [ 

            'user.List',
            'user.Edit',
            'frame.PageFrameContainer',
            'frame.PageFrameNorthContainer',
            'frame.PageFrameCenterPanel'
        ],
    models: ['User'],
    stores: [ 

             'User'
         ], 
    init: function() {
    	this.control({
            'userlist': {
            	itemdblclick: this.editUser
            },
            'useredit button[action=save]': {
                click: this.updateUser
            }

         }); 
    },
    onPanelRendered: function() {
        console.log('The panel was rendered');
    },
    editUser: function(grid, record) {
    	this.initLoad("");
    	
        console.log('Double clicked on ' + record.get('name'));
        var view = Ext.widget('useredit');

        view.down('form').loadRecord(record);

    },
    updateUser: function(button) {
    	var win   = button.up('window'),
        form   = win.down('form'),
        record = form.getRecord(),
        values = form.getValues();

    	record.set(values);
    	win.close();
    	this.getUserStore().sync();
    }
});
 
