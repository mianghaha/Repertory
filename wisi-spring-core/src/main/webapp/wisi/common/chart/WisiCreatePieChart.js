Ext.define('wisi.common.chart.WisiCreatePieChart', {
	donut: false,
	fields: [],
	legends: [],
	dataStore: {},
	create: function(){
		var me = this,
		store1 = me.dataStore;
		return Ext.create('Ext.chart.Chart', {
            xtype: 'chart',
            animate: true,
            store: me.dataStore,
            shadow: true,
            legend: {
                position: 'right'
            },
            insetPadding: 60,
            theme: 'Base:gradients',
            series: [{
                type: 'pie',
                field: me.fields,
                showInLegend: true,
                donut: me.donut,
                tips: {
            		trackMouse: true,
        			width: 140,
        			height: 28,
        			renderer: function(storeItem, item) {
        				//calculate percentage.
        				var total = 0;
        				store1.each(function(rec) {
        					total += rec.get(me.fields);
        				});
        				this.setTitle(storeItem.get(me.legends) + ': ' + Math.round(storeItem.get(me.fields) / total * 100) + '%');
        			}
                },
                highlight: {
                	segment: {
                		margin: 20
                	}
                },
                label: {
                    field: me.legends,
                    display: 'rotate',
                    contrast: true,
                    font: '18px 微软雅黑'
                }
            }]
        });
	}
});