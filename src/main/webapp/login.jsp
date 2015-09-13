<%@ page language="java" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%> 
<!DOCTYPE HTML>
<html>
<head>
    <title>Account Manager</title>
	<meta http-equiv=Content-Type content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="wisi/resource/login/css/style.css">
    <link rel="stylesheet" type="text/css" href="wisi/extapi/resources1/my-custom-theme-all.css">
	<link rel="stylesheet" type="text/css" href="wisi/resource/login/css/login.css">
	<script type="text/javascript"src="wisi/extapi/ext-all-dev.js"></script>
	<script type="text/javascript"src="wisi/extapi/locale/ext-lang-zh_CN.js"></script>	
</head>

<body class="body">
	<div class="wrapper">
		<div class="content">
        	<div class="logo" >XXXXXX系统管理系统</div>
			<div id="form_wrapper" class="form_wrapper">
				<div id="fm">
 
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
    Ext.onReady(function () {
        var form = Ext.create('Ext.form.Panel', {
            defaultType: 'textfield',
            renderTo: 'fm',
            layout: 'absolute',
            border: 0,
            width: 390,
            height: 400,
            bodyStyle: {
                'background': 'none'
            },
            defaults: {
                labelAlign: 'top',
                allowBlank: false,
                height: 55
            },
            items: [{
                name: 'loginUser',
                x: 60,
                y: 140,
                width: 260,
                maxLength: 20,
                fieldLabel: '用户名',
                blankText: '用户名不能为空',
                maxLengthText: '用户名不能超过{0}位。'
                
            }, {
                name: 'loginPwd',
                x: 60,
                y: 200,
                width: 260,
                maxLength: 10,
                inputType: 'password',
                fieldLabel: '密  码',
                blankText: '密码不能为空',
                maxLengthText: '密码不能超过{0}位。'
            }, {
                name: 'validateCode',
                x: 60,
                y: 260,
                width: 130,
                maxLength: 4,
                fieldLabel: '验证码'
            },{
                xtype: 'image',
                id: 'validateCodeImage',
                x: 198,
                y: 282,
                height: 32,
                width: 120,
                src: 'login/getValidateCode.html?t='+(new Date()).getTime()
            },{
                xtype: 'button',
                x: 198,
                y: 282,
                height: 32,
                width: 120,
                id: 'ChekcCodeButton',
                style: 'background: transparent;',
                handler: function() {
                	Ext.getCmp('validateCodeImage').setSrc('login/getValidateCode.html?t='+(new Date()).getTime());
                }
            }, {
                margin: '40 0 0 30',
                xtype: 'button',
                ui: 'menu-custom',
                x: 30,
                y: 290,
                height: 45,
                width: 266,
                handler: function () {
                    if(form.isValid()) {
                        Ext.Ajax.request({
                            url: "login/loginCheck.html",
                            method: "POST",
                            params: {
                                "loginUser": form.findField('loginUser').getValue(),
                                "loginPwd": form.findField('loginPwd').getValue()
                            },
                            success: function (response, options) {
                                var reValue = Ext.decode(response.responseText);
                                if (reValue.success == true) {
                                    window.location.href = "../Scripts/main.html";
                                } else {
                                    Ext.Msg.alert('提示', reValue.msg);
                                }
                            },
                            failure: function(response, opotions){
                            	var reValue = Ext.decode(response.responseText);
                            }
                        });
                       
                    }else{
                    	if(!form.findField('loginUser').isValid()){
                    		form.findField('loginUser').focusInput();
                    	}else if(!form.findField('loginPwd').isValid()){
                    		form.findField('loginPwd').focusInput();
                    	}else{
                    		form.findField('validateCode').focusInput();
                    	}
                    }
                }
            }]
        }).form;
        form.findField('loginUser').focusInput();
    });
</script>
</html>