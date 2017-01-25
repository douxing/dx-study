## React中的事件

- React中的事件不等于真实事件
- React中的事件是CamelCase的
- 注意bind在React事件中的使用

## 深入讨论JSX

### JSX vs. HTML

1. 标签属性必须为CamelCase
2. 所有元素都必须有"显示关闭", 如`<br>`必须为`<br />`, `<img src="...">`必须为`<img src="..." />`
3. 属性名是基于DOM接口的, 但因为JSX也是JS, 所以有些属性如class不能使用, 需要用className替代

### JSX 规范

- 只能渲染单一的根节点
- 因为属性中的表达式是内联的, 所以无法使用if等条件判断子句, 需要用三目运算法来做, 实在要用if之类的条件判断子句, 需要将其拿到外面做, 如:

  ``` javascript
  <div className={if (condition) { "salutation" }}>Hello JSX</div>
  
  // 会被渲染成
  React.createElement("div", {className: if (condition) { "salutation"}}, "Hello JSX");
  ```

- 空格问题, JSX不会为空格, 制表符, 换行等加入空格, 所以需要手动添加: `{" "}`
- 注释问题, 注意在元素的Chinldren区域加注释, 使用`{/* 注释 */}`这样的格式
- 动态渲染HTML, 使用dangerouslySetInnerHTML来取消默认的XSS保护

## React并不一定需要JSX

可以通过纯Javascript, 元素工厂以及自定义工厂的形式来实现

## 内联样式

定义一个简单的内联样式对象, 有些属性不需要加单位, React会自动帮你加好.
对象中的属性可以动态改变, 这样可以通过数据传递来完成样式的动态显示.

## 表单

这是React中比较重要的概念, 因为表单中的元素, 都带有用户输入, 所以内部自己维护一个状态.
有两种方式可以和这类元素的内容互动:

1. uncontrolled component: 通过绑定父元素的state到子元素的value值的方式来显示, 通过事件来互动, 这个时候, 通过使用defaultValue来设置初始值
2. controlled component: 不显式绑定value值, 使用ref来取得元素内容

> 注意: value="hello" 这样的写法, 将无法改变元素的value
> 注意: TextArea和Select这类元素, 用法和普通HTML元素稍有不同
