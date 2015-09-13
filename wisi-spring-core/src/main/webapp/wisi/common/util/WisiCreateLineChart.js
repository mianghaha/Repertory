Ext.define('wisi.common.util.WisiCreateLineChart', {
	xFields: '',
	yFields: [],
	legends: [],
	dataStore: {},
	create: function(){
		return Ext.create('Ext.chart.Chart', {
	        style: 'background:#fff',
	        animate: true,
	        store: this.dataStore,
	        shadow: true,
	        theme: 'Category1',
	        legend: {
	            position: 'right'
	        },
	        axes: [{
	            type: 'Numeric',
	            minimum: 0,
	            position: 'left',
	            fields: this.yFields,
	            title: '数量',
	            minorTickSteps: 1,
	            grid: {
	                odd: {
	                    opacity: 1,
	                    fill: '#ddd',
	                    stroke: '#bbb',
	                    'stroke-width': 0.5
	                }
	            }
	        },{
	            type: 'Category',
	            position: 'bottom',
	            fields: [this.xFields],
	            title: '月份'
	        }],
	        series: function(arrs, titles){
	            var arr = [];
	            var i = 0;
	            Ext.each(arrs, function(itm){
	                arr.push({
	                    smooth: true,//弯曲线
	                    title:titles[i],
	                    type: 'line',
	                    xField: this.xFields,
	                    yField: itm
	                });
	                i++;
	            });
	            return arr;
	        }(this.yFields, this.legends)
	    });
	}
});