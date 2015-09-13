Ext.define('wisi.controller.localStorage.LocalStorage', {
	extend: 'wisi.common.core.WisiController',
	models: [
		'localStorage.UserLocalStorage',
		'localStorage.UserDetailLocalStorage'
	],
	stores: [
		'localStorage.UserLocalStorage',
		'localStorage.UserDetailLocalStorage'
	],
	views: [
		'localStorage.LocalStorage'
	],
	
	init: function(){
		var me = this;
		me.control({
			"localStorage button[name='addUserBtn']": {
				click: this.onAddUserButtonClick
			},
			"localStorage button[name='searchUserBtn']": {
				click: this.onSearchUserButtonClick
			}
		});
	},
	
	onAddUserButtonClick: function(button, e, eOpts){
		var userStore = Ext.getStore('localStorage.UserLocalStorage');
		userStore.add({userName: '张三', userId: '140501'});
		userStore.add({userName: '李四', userId: '150201'});
		userStore.add({userName: '王五', userId: '150501'});
		userStore.sync();
	},
	onSearchUserButtonClick: function(button, e, eOpts){
		var userDetailStore = Ext.getStore('localStorage.UserDetailLocalStorage');
		userDetailStore.add({userName: '张三', userId: '150501', userDep: '解决方案事业部', userJob: '项目经理', userInDate: '2014-05-01', userSex: '男', userAge: '30', userRemark: ''});
		userDetailStore.add({userName: '李四', userId: '150502', userDep: '解决方案事业部', userJob: '高级工程师', userInDate: '2015-02-01', userSex: '男', userAge: '27', userRemark: ''});
		userDetailStore.add({userName: '王五', userId: '150503', userDep: '解决方案事业部', userJob: '初级工程师', userInDate: '2015-05-01', userSex: '女', userAge: '25', userRemark: ''});
		userDetailStore.sync();
	}
});