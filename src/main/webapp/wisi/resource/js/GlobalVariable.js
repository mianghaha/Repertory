Ext.define('MainApp.common.GlobalVariable', {
	init:function(){
		var me = this;

        Ext.applyIf(me,{
			windowHeight:Ext.getBody().getSize().height,
			windowWidth:Ext.getBody().getSize().width,
			getStoreUrl:function(page,action){
				return 'data/'+page+'/'+action+'.txt';
				//reutrn '/'+page+'/'+action
			}
		})
	}
});