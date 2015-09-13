Ext.define('MainApp.common.ClientCheck', {
    init: function () {
        Ext.apply(Ext.form.VTypes,
        {
            age: function (val, field) {
                try {
                    if (parseInt(val) >= 18 && parseInt(val) <= 100)
                        return true;
                    return false;
                }
                catch (err) {
                    return false;
                }
            },
            ageText: '年龄输入有误'//
        });
    }
});