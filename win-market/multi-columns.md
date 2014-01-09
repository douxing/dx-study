## 多列布局

[原网页在此](http://msdn.microsoft.com/zh-cn/library/windows/apps/hh673534.aspx)，w3c[候选的推荐标准](http://www.w3.org/TR/css3-multicol/)。

#### 属性

	column-width: 长度值
	column-count: 整数
	columns: 可以是auto，整数或长度值

_间距 间隔线_
	
	column-gap
	column-rule-color
	column-rule-style
	column-rule-width
	column-rule: <column-rule-width> <column-rule-style> <column-rule-color>

_指定分列_

	break-before: page|column|avoid-page|avoid-column
	break-after: page|column|avoid-page|avoid-column
	break-inside: avoid-page|avoid-column

_指定列跨越_
	
	column-span: all|数字 1是默认

_平衡列内容_
	
	column-fill: balace|auto
