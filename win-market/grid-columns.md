## 网格布局

[原网页在此](http://msdn.microsoft.com/zh-cn/library/windows/apps/hh673533.aspx)，需要注意的是，本页面样式需要用ie10/10+的浏览器方能正常显示。  
__当前的网格布局，w3c还处于[草案阶段](http://www.w3.org/TR/2012/WD-css3-grid-layout-20120322/)。__  

#### 网格元素
放在display里面:

	-ms-grid
	-ms-inline-grid

#### 轨道(列 行)

	-ms-grid-columns
	-ms-grid-rows

_单位：_
[标准长度单位](http://msdn.microsoft.com/zh-CN/library/ms537660.aspx), auto, min-content, max-content, minmax(a, b), 分数单位(fr)  
_重复：_ 	

	<style type="text/css">
	  #grid {
	    display: -ms-grid;
	    -ms-grid-columns: 10px 250px 10px 250px 10px 250px 10px 250px 10px;
	    -ms-grid-rows: 1fr;
	  }	
	
	  /* Equivalent definition. */
	  #grid {
	    display: -ms-grid;
	    -ms-grid-columns: 10px (250px 10px)[4];
	    -ms-grid-rows: 1fr;
	  }
	</style>

#### 网格项

	-ms-grid-column
	-ms-grid-row

_对齐：_

	-ms-grid-column-align 
	-ms-grid-row-align

可选的值包括:  center、end、start 和 stretch。  

_跨越网格项：_  
	
	-ms-grid-column-span
	-ms-grid-row-span

指定网格项跨越的网格列数。默认值为 "1"。
